package Naoscape.io.packets;


import Naoscape.Engine;
import Naoscape.players.Player;
import Naoscape.players.items.PlayerItems;
import Naoscape.util.Misc;
public class Shopbuyconfig implements Packet {
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
		PlayerItems pi = new PlayerItems();
		NPCOption1 N1 = new NPCOption1();
        int junk = p.stream.readDWord();
        int itemId = p.stream.readUnsignedWordA();
        int itemSlot = p.stream.readUnsignedWordBigEndianA();      

//if (itemSlot < 0 || itemSlot >= p.equipment.length || p.equipment[itemSlot] != itemId) {
        //    return;
	//}



		if (p.shopid == 2 && Engine.playerItems.HasItemAmount(p, 995, p.shop2p[itemSlot]))
		 {
			pi.deleteItem(p, 995, pi.getItemSlot(p, 995), p.shop2p[itemSlot]);
			pi.addItem(p, p.shop2[itemSlot], 1);
		}
		else if (p.shopid == 3 && Engine.playerItems.HasItemAmount(p, 995, p.shop3p[itemSlot]))
		 {
			pi.deleteItem(p, 995, pi.getItemSlot(p, 995), p.shop3p[itemSlot]);
			pi.addItem(p, p.shop3[itemSlot], 1);
		}
		else if (p.shopid == 4 && Engine.playerItems.HasItemAmount(p, 995, p.shop4p[itemSlot]))
		 {
			pi.deleteItem(p, 995, pi.getItemSlot(p, 995), p.shop4p[itemSlot]);
			pi.addItem(p, p.shop4[itemSlot], 1);
		}
		else if (p.shopid == 5 && Engine.playerItems.HasItemAmount(p, 995, p.shop5p[itemSlot]))
		 {
			pi.deleteItem(p, 995, pi.getItemSlot(p, 995), p.shop5p[itemSlot]);
			pi.addItem(p, p.shop5[itemSlot], 1);
		}
		else if (p.shopid == 6 && Engine.playerItems.HasItemAmount(p, 995, p.shop6p[itemSlot]))
		 {
			pi.deleteItem(p, 995, pi.getItemSlot(p, 995), p.shop6p[itemSlot]);
			pi.addItem(p, p.shop6[itemSlot], 1);
		}
		else if (p.shopid == 7 && Engine.playerItems.HasItemAmount(p, 995, p.shop7p[itemSlot]))
		 {
			pi.deleteItem(p, 995, pi.getItemSlot(p, 995), p.shop7p[itemSlot]);
			pi.addItem(p, p.shop7[itemSlot], 1);
		}
		else if (p.shopid == 8 && Engine.playerItems.HasItemAmount(p, 995, p.shop8p[itemSlot]))
		 {
			pi.deleteItem(p, 995, pi.getItemSlot(p, 995), p.shop8p[itemSlot]);
			pi.addItem(p, p.shop8[itemSlot], 1);
		}
	else if (p.shopid == 9 && Engine.playerItems.HasItemAmount(p, 995, p.shop9p[itemSlot]))
		 {
			pi.deleteItem(p, 995, pi.getItemSlot(p, 995), p.shop9p[itemSlot]);
			pi.addItem(p, p.shop9[itemSlot], 1);
		}
	else if (p.shopid == 10 && Engine.playerItems.HasItemAmount(p, 995, p.shop10p[itemSlot]))
		 {
			pi.deleteItem(p, 995, pi.getItemSlot(p, 995), p.shop10p[itemSlot]);
			pi.addItem(p, p.shop10[itemSlot], 1);
		}
	else if (p.shopid == 11 && Engine.playerItems.HasItemAmount(p, 995, p.shop11p[itemSlot]))
		 {
			pi.deleteItem(p, 995, pi.getItemSlot(p, 995), p.shop11p[itemSlot]);
			pi.addItem(p, p.shop11[itemSlot], 1);
		}
	else if (p.shopid == 12 && Engine.playerItems.HasItemAmount(p, 995, p.shop12p[itemSlot]))
		 {
			pi.deleteItem(p, 995, pi.getItemSlot(p, 995), p.shop12p[itemSlot]);
			pi.addItem(p, p.shop12[itemSlot], 1);
		}



			
		else 
		{
			p.frames.sendMessage(p,"You dont have enough coins.");
		}


}
}