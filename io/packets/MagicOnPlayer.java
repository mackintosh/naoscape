
package Naoscape.io.packets;


import Naoscape.Engine;
import Naoscape.players.Player;
import Naoscape.util.Misc;
import Naoscape.Server;


public class MagicOnPlayer implements Packet {

    /**
     * Handles magic on players.
     * @param p The Player which the frame should be handled for.
     * @param packetId The packet id this belongs to.
     * @param packetSize The amount of bytes being recieved for this packet.
     */
    public void handlePacket(Player p, int packetId, int packetSize) {
     
        p.attackPlayer = p.stream.readSignedWordA();
        int playerId = p.stream.readSignedWordBigEndian();
        int interfaceId = p.stream.readUnsignedWord();

        p.clickId = p.stream.readUnsignedWord();
        Player p2 = Server.engine.players[playerId];

if(p.AtDuel() && p.DuelPartner != p2.playerId)
{
p.frames.sendMessage(p,"This is not your opponent");
}

else if(p.DuelCan == false && p.AtDuel() == true)
{
p.frames.sendMessage(p,"You cannot fight just yet.");
}

else if(p.AtClanField() && p2.clanchat == p.clanchat)
{
p.frames.sendMessage(p,"This is your team mate.");
}
else if(p.AtClanField() && p.ClanTimer > 0)
{
p.frames.sendMessage(p,"The game has not begun yet.");
}
else if(p.AtJail() || p.AtClanLobby())
{
p.frames.sendMessage(p,"You cannot attack some one here.");
}
else
{

        switch (interfaceId) {
        case 193:     
if (p.magicDelay == 0 && Engine.wildernessArea(p.absX, p.absY) && Engine.wildernessArea(p2.absX, p2.absY)) {
                if (p.clickId == 3 && p.skillLvl[6] >= 94) {
                    if (Engine.playerItems.invItemCount(p, 560) > 4
                            && Engine.playerItems.invItemCount(p, 555) > 6
                            && Engine.playerItems.invItemCount(p, 565) > 2) {
                        if (p2.freezeDelay > 0) {
                        p.stopMovement(p);
                        p.magicDelay = 5;
                        p.requestAnim(1979, 0);
                        p2.requestGFX(1677, 100);
                        p2.appendHit(Misc.random(30), 0);
                        p.requestFaceTo(p2.playerId + 32768);
                        p.combatDelay += p.attackDelay;
                      } else if (p2.freezeDelay < 0) {
                        p.stopMovement(p);
                        p.magicDelay = 5;
                        p.requestAnim(1979, 0);
                        p2.requestGFX(369, 0);
                        p2.appendHit(Misc.random(30), 0);
                        p.requestFaceTo(p2.playerId + 32768);
                        p2.freezeDelay = 20;
                        p.combatDelay += p.attackDelay;
                        Engine.playerItems.deleteItem(p, 560,
                                Engine.playerItems.getItemSlot(p, 560), 4);
                        Engine.playerItems.deleteItem(p, 555,
                                Engine.playerItems.getItemSlot(p, 555), 6);
                        Engine.playerItems.deleteItem(p, 565,
                                Engine.playerItems.getItemSlot(p, 565), 2);
                    } else {
                        p.frames.sendMessage(p,
                                "You don't have enough runes to cast this spell.");
                    }
                } else if(p.skillLvl[6] < 94) {
		    p.frames.sendMessage(p, "You need a magic level of 94 to cast this spell."); 
                }
            } else {
                p.stopMovement(p);
            }
            }
            break;

        default:
            Misc.println(
                    "PlayerID " + playerId + " - InterfaceID " + interfaceId
                    + " - ButtonID " + p.clickId + ".");
            break;
        }
}
    } 
}
