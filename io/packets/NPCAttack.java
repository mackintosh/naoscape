

package Naoscape.io.packets;


import Naoscape.players.Player;
import Naoscape.Engine;
import Naoscape.util.Misc;
import Naoscape.npcs.*;
import Naoscape.npcs.update.NPCUpdateMasks;


public class NPCAttack implements Packet {

    /**
     * Handles selecting the attack option on NPCs.
     * @param p The Player which the frame should be handled for.
     * @param packetId The packet id this belongs to.
     * @param packetSize The amount of bytes being recieved for this packet.
     */
    public void handlePacket(Player p, int packetId, int packetSize) {
        if (p == null || p.stream == null) {
            return;
        }
        int npcId = p.stream.readUnsignedWord();
        NPC n = Engine.npcs[npcId];

        p.attackNPC = npcId;
        p.attackingNPC = true;
        p.requestFaceTo(npcId);
    }
}
