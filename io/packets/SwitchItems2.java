

package Naoscape.io.packets;


import Naoscape.util.Misc;
import Naoscape.players.Player;


public class SwitchItems2 implements Packet {

    /**
     * Handles rotating items on interfaces.
     * @param p The Player which the frame should be handled for.
     * @param packetId The packet id this belongs to.
     * @param packetSize The amount of bytes being recieved for this packet.
     */
    public void handlePacket(Player p, int packetId, int packetSize) {
        if (p == null || p.stream == null) {
            return;
        }
        int interface1 = p.stream.readDWord();
        int interfaceId = interface1 >> 16;
        int interface2 = p.stream.readDWord();
        int fromId = p.stream.readUnsignedWord();
        int toId = p.stream.readUnsignedWordBigEndian();

        switch (interfaceId) {
        case 762:

            /*
             * Bank interface.
             */
            if (fromId < 0 || fromId >= 500 || toId < 0 || toId >= 500) {
                break;
            }
            int tempI = p.bankItems[fromId];
            int tempN = p.bankItemsN[fromId];

            p.bankItems[fromId] = p.bankItems[toId];
            p.bankItemsN[fromId] = p.bankItemsN[toId];
            p.bankItems[toId] = tempI;
            p.bankItemsN[toId] = tempN;
            p.frames.setItems(p, -1, 64207, 95, p.bankItems, p.bankItemsN);
            break;

        case 763:

            /*
             * Switch items in your inventory.
             */
            if (fromId < 0 || fromId >= p.items.length || toId < 0
                    || toId >= p.items.length) {
                break;
            }
            tempI = p.items[fromId];
            tempN = p.itemsN[fromId];
            p.items[fromId] = p.items[toId];
            p.itemsN[fromId] = p.itemsN[toId];
            p.items[toId] = tempI;
            p.itemsN[toId] = tempN;
            p.frames.setItems(p, -1, 64209, 93, p.items, p.itemsN);
            p.frames.setItems(p, 149, 0, 93, p.items, p.itemsN);
            break;

        default:
            Misc.println(
                    "[" + p.username + "] Unhandled Switch Items interface: "
                    + interfaceId);
            break;
        }
    }
}
