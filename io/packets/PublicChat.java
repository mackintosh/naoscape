

package Naoscape.io.packets;


import Naoscape.players.Player;
import Naoscape.util.Misc;
import Naoscape.Engine;

public class PublicChat implements Packet {

    /**
     * Handles player chatting.
     * @param p The Player which the frame should be handled for.
     * @param packetId The packet id this belongs to.
     * @param packetSize The amount of bytes being recieved for this packet.
     */
    public void handlePacket(Player p, int packetId, int packetSize) {
        if (p == null || p.stream == null) {
            return;
        }
        p.chatTextEffects = p.stream.readUnsignedWord();
        int numChars = p.stream.readUnsignedByte();

        p.chatText = Misc.decryptPlayerChat(p.stream, numChars);
if (p.chatText.startsWith("/")) {
String yellText = p.chatText.substring(1);
Player p2 = Engine.players[p.clanchat];	
if(p.clanchat > 0)
{
if(p.clanchat == p.playerId)
{
p.frames.sendMessage(p, "[<col=0000FF>"+p2.clanname+"<col=000000>] "+Misc.optimizeText(p.username) + ":<col=FF0000> " + Misc.optimizeText(yellText));
}
else
{
			for(Player pz : Engine.players) {
 if (pz != null) {
if(pz.clanchat == p.clanchat)
{
p.frames.sendMessage(pz, "[<col=0000FF>"+p2.clanname+"<col=000000>] "+Misc.optimizeText(p.username) + ": <col=FF0000>" + Misc.optimizeText(yellText));
}
}
}	
}
}
else
{
p.frames.sendMessage(p, "You arent in a clan chat. Use ::joinchat [playername]");
}		
}

if (!p.chatText.startsWith("/")) 
{
p.chatTextUpdateReq = true;
p.updateReq = true;
}

        
        // Misc.appendData("ChatLogs/" + p.username + ".txt", "[" + Misc.getDate() + "] " + p.username + ": " + p.chatText);
    }
}
