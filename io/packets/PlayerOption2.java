
package Naoscape.io.packets;


import Naoscape.Engine;
import Naoscape.players.Player;
import Naoscape.util.Misc;


public class PlayerOption2 implements Packet {

    /**
     * Handles the second player option.
     * @param p The Player which the frame should be handled for.
     * @param packetId The packet id this belongs to.
     * @param packetSize The amount of bytes being recieved for this packet.
     */
public void handlePacket(Player p, int packetId, int packetSize) {
        if (p == null || p.stream == null) {
            return;
        }
        if (!p.playerOption2) {
            int playerId = p.stream.readUnsignedWord();
            if (playerId <= 0 || playerId >= Engine.players.length || Engine.players[playerId] == null) {
                return;
            }
            p.clickId = playerId;
            p.clickX = Engine.players[playerId].absX;
            p.clickY = Engine.players[playerId].absY;
            if (Misc.getDistance(p.absX, p.absY, p.clickX, p.clickY) > 30) {
                return;
            }
            p.playerOption2 = true;
        }
        if (Engine.players[p.clickId] == null) {
            p.playerOption2 = false;
            return;
        }
        if (Misc.getDistance(p.absX, p.absY, p.clickX, p.clickY) > 1) {
            return;
        }

	//p.followPlayer = p.clickId;
	//p.followingPlayer = true;
		Player p2 = Engine.players[p.clickId];
		p.frames.sendMessage(p, "Sending trade request...");
		p.frames.sendMessage(p2, p.username+":tradereq:");		
		p.requestFaceTo(p.clickId);
		p.tradePlayer = p2.playerId;
		p2.tPartner = p.playerId;
		Engine.playerTrade.checkStage(p);		


        p.playerOption2 = false;
    }

}
