
package Naoscape.io.packets;


import Naoscape.players.Player;
import Naoscape.util.Misc;


public class ItemOperate implements Packet {

    /**
     * Handles operating equipped items.
     * @param p The Player which the frame should be handled for.
     * @param packetId The packet id this belongs to.
     * @param packetSize The amount of bytes being recieved for this packet.
     */
    public void handlePacket(Player p, int packetId, int packetSize) {
        if (p == null || p.stream == null) {
            return;
        }
        int junk = p.stream.readDWord();
        int itemId = p.stream.readUnsignedWordA();
        int itemSlot = p.stream.readUnsignedWordBigEndianA();

        if (itemSlot < 0 || itemSlot >= p.equipment.length
                || p.equipment[itemSlot] != itemId) {
            return;
        }
        switch (itemId) {


case 1704:
p.Choice = 3;
p.Dialogue = 0;
p.frames.setString(p, "Fight Pits", 458, 1);
p.frames.setString(p, "Caslte Wars", 458, 2);
p.frames.setString(p, "Port Sarim", 458, 3);
p.frames.showChatboxInterface(p, 458);
p.Smithing = false;
p.Cooking = false;
p.TalkAgent = false;
p.DecorChange = false;
break;


        default:
            Misc.println("[" + p.username + "] Operate item: " + itemId);
            break;
        }
    }
}
