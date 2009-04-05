
package Naoscape.io.packets;


import Naoscape.Engine;

import Naoscape.players.Player;
import Naoscape.util.Misc;


public class ItemOption1 implements Packet {
    public ItemOption2 itemOption2 = new ItemOption2();

    /**
     * Handles first item options, excluding things such as eating and drinking.
     * @param p The Player which the frame should be handled for.
     * @param packetId The packet id this belongs to.
     * @param packetSize The amount of bytes being recieved for this packet.
     */
    public void handlePacket(Player p, int packetId, int packetSize) {
        if (p == null || p.stream == null) {
            return;
        }
        int itemSlot = p.stream.readUnsignedWordBigEndianA();
        int interfaceId = p.stream.readUnsignedWord();
        int junk = p.stream.readUnsignedWord();
        int itemId = p.stream.readUnsignedWord();
 int item = p.stream.readUnsignedWordA();
 int items = p.stream.readUnsignedWordBigEndian();



        if (itemSlot < 0 || itemId < 0) {
            return;
        }

        switch (interfaceId) {
case 1576:
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

case 12175://Spirit Wolf
if(p.FamiliarID > 0)
{
p.frames.sendMessage(p, "You cannot summon more than one familiar at a time.");	
}
else
{
Engine.playerItems.deleteItem(p, 12047, itemSlot, 1); // Summoning: Spirt Wolf
p.frames.sendMessage(p, "You summon a Spirit Wolf.");
p.frames.setTab(p, 80, 663);
p.frames.animateInterfaceId(p, 9850, 663, 3);
p.frames.setNPCId(p, 6829, 663, 3);
Engine.newSummonNPC(6829, p.absX, p.absY+1, p.heightLevel, p.absX + 1, p.absY + 1, p.absX + -1, p.absY + -1, false, p.playerId);
p.addSkillXP(1600, 23);

}
break;
case 12171://DreadFowl
if (p.skillLvl[23] > 3) {
if(p.FamiliarID > 0)
{
p.frames.sendMessage(p, "You cannot summon more than one familiar at a time.");	
}
else
{
Engine.playerItems.deleteItem(p, 12043, itemSlot, 1); 
p.frames.sendMessage(p, "You summon a Dread Fowl");
p.frames.setTab(p, 80, 663);
p.frames.animateInterfaceId(p, 9850, 663, 3);
p.frames.setNPCId(p, 6825, 663, 3);
Engine.newSummonNPC(6825, p.absX, p.absY+1, p.heightLevel, p.absX + 1, p.absY + 1, p.absX + -1, p.absY + -1, false, p.playerId);
p.addSkillXP(3000, 23);

}
}
else
{
p.frames.sendMessage(p, "You need at least level 4 summoning to summon that.");	
}
break;
case 12187://Spirit Spider
if (p.skillLvl[23] > 9) {
if(p.FamiliarID > 0)
{
p.frames.sendMessage(p, "You cannot summon more than one familiar at a time.");	
}
else
{
Engine.playerItems.deleteItem(p, 12059, itemSlot, 1); 
p.frames.sendMessage(p, "You summon a Spirit Spider");
p.frames.setTab(p, 80, 663);
p.frames.animateInterfaceId(p, 9850, 663, 3);
p.frames.setNPCId(p, 6841, 663, 3);
Engine.newSummonNPC(6841, p.absX, p.absY+1, p.heightLevel, p.absX + 1, p.absY + 1, p.absX + -1, p.absY + -1, false, p.playerId);
p.addSkillXP(5000, 23);

}
}
else
{
p.frames.sendMessage(p, "You need at least level 10 summoning to summon that.");	
}
break;

case 11891://Thorny Snail
if (p.skillLvl[23] > 12) {
if(p.FamiliarID > 0)
{
p.frames.sendMessage(p, "You cannot summon more than one familiar at a time.");	
}
else
{
Engine.playerItems.deleteItem(p, 12019, itemSlot, 1); 
p.frames.sendMessage(p, "You summon a Thorny snail.");
p.frames.setTab(p, 80, 663);
p.frames.animateInterfaceId(p, 9850, 663, 3);
p.frames.setNPCId(p, 6806, 663, 3);
Engine.newSummonNPC(6806, p.absX, p.absY+1, p.heightLevel, p.absX + 1, p.absY + 1, p.absX + -1, p.absY + -1, false, p.playerId);
p.addSkillXP(6000, 23);

}
}
else
{
p.frames.sendMessage(p, "You need at least level 13 summoning to summon that.");	
}
break;

case 12936://Spirit Tz-Kih
if (p.skillLvl[23] > 21) {
if(p.FamiliarID > 0)
{
p.frames.sendMessage(p, "You cannot summon more than one familiar at a time.");	
}
else
{
Engine.playerItems.deleteItem(p, 12808, itemSlot, 1); 
p.frames.sendMessage(p, "You summon a Spirit Tz-Kih.");
p.frames.setTab(p, 80, 663);
p.frames.animateInterfaceId(p, 9850, 663, 3);
p.frames.setNPCId(p, 7361, 663, 3);
Engine.newSummonNPC(7361, p.absX, p.absY+1, p.heightLevel, p.absX + 1, p.absY + 1, p.absX + -1, p.absY + -1, false, p.playerId);
p.addSkillXP(7000, 23);

}
}
else
{
p.frames.sendMessage(p, "You need at least level 22 summoning to summon that.");	
}
break;

case 12201://Bronze Minotour
if (p.skillLvl[23] > 35) {
if(p.FamiliarID > 0)
{
p.frames.sendMessage(p, "You cannot summon more than one familiar at a time.");	
}
else
{
Engine.playerItems.deleteItem(p, 12073, itemSlot, 1); 
p.frames.sendMessage(p, "You summon a Bronze Minotour.");
p.frames.setTab(p, 80, 663);
p.frames.animateInterfaceId(p, 9850, 663, 3);
p.frames.setNPCId(p, 6853, 663, 3);
Engine.newSummonNPC(6853, p.absX, p.absY+1, p.heightLevel, p.absX + 1, p.absY + 1, p.absX + -1, p.absY + -1, false, p.playerId);
p.addSkillXP(8000, 23);

}
}
else
{
p.frames.sendMessage(p, "You need at least level 36 summoning to summon that.");	
}
break;

case 12203://Iron Minotour
if (p.skillLvl[23] > 45) {
if(p.FamiliarID > 0)
{
p.frames.sendMessage(p, "You cannot summon more than one familiar at a time.");	
}
else
{
Engine.playerItems.deleteItem(p, 12075, itemSlot, 1); 
p.frames.sendMessage(p, "You summon an Iron Minotour.");
p.frames.setTab(p, 80, 663);
p.frames.animateInterfaceId(p, 9850, 663, 3);
p.frames.setNPCId(p, 6855, 663, 3);
Engine.newSummonNPC(6855, p.absX, p.absY+1, p.heightLevel, p.absX + 1, p.absY + 1, p.absX + -1, p.absY + -1, false, p.playerId);
p.addSkillXP(10000, 23);

}
}
else
{
p.frames.sendMessage(p, "You need at least level 46 summoning to summon that.");	
}
break;

case 12205://Steel Minotour
if (p.skillLvl[23] > 55) {
if(p.FamiliarID > 0)
{
p.frames.sendMessage(p, "You cannot summon more than one familiar at a time.");	
}
else
{
Engine.playerItems.deleteItem(p, 12077, itemSlot, 1); 
p.frames.sendMessage(p, "You summon a Steel Minotour.");
p.frames.setTab(p, 80, 663);
p.frames.animateInterfaceId(p, 9850, 663, 3);
p.frames.setNPCId(p, 6857, 663, 3);
Engine.newSummonNPC(6857, p.absX, p.absY+1, p.heightLevel, p.absX + 1, p.absY + 1, p.absX + -1, p.absY + -1, false, p.playerId);
p.addSkillXP(12000, 23);

}
}
else
{
p.frames.sendMessage(p, "You need at least level 56 summoning to summon that.");	
}
break;

case 12207://Mithril Minotour
if (p.skillLvl[23] > 65) {
if(p.FamiliarID > 0)
{
p.frames.sendMessage(p, "You cannot summon more than one familiar at a time.");	
}
else
{
Engine.playerItems.deleteItem(p, 12079, itemSlot, 1); 
p.frames.sendMessage(p, "You summon a Mithril Minotour.");
p.frames.setTab(p, 80, 663);
p.frames.animateInterfaceId(p, 9850, 663, 3);
p.frames.setNPCId(p, 6859, 663, 3);
Engine.newSummonNPC(6859, p.absX, p.absY+1, p.heightLevel, p.absX + 1, p.absY + 1, p.absX + -1, p.absY + -1, false, p.playerId);
p.addSkillXP(14000, 23);

}
}
else
{
p.frames.sendMessage(p, "You need at least level 66 summoning to summon that.");	
}
break;

case 12209://Adamant Minotour
if (p.skillLvl[23] > 75) {
if(p.FamiliarID > 0)
{
p.frames.sendMessage(p, "You cannot summon more than one familiar at a time.");	
}
else
{
Engine.playerItems.deleteItem(p, 12081, itemSlot, 1); 
p.frames.sendMessage(p, "You summon a Adamant Minotour.");
p.frames.setTab(p, 80, 663);
p.frames.animateInterfaceId(p, 9850, 663, 3);
p.frames.setNPCId(p, 6861, 663, 3);
Engine.newSummonNPC(6861, p.absX, p.absY+1, p.heightLevel, p.absX + 1, p.absY + 1, p.absX + -1, p.absY + -1, false, p.playerId);
p.addSkillXP(16000, 23);

}
}
else
{
p.frames.sendMessage(p, "You need at least level 76 summoning to summon that.");	
}
break;

case 12211://Rune Minotour
if (p.skillLvl[23] > 85) {
if(p.FamiliarID > 0)
{
p.frames.sendMessage(p, "You cannot summon more than one familiar at a time.");	
}
else
{
Engine.playerItems.deleteItem(p, 12083, itemSlot, 1); 
p.frames.sendMessage(p, "You summon a Rune Minotour.");
p.frames.setTab(p, 80, 663);
p.frames.animateInterfaceId(p, 9850, 663, 3);
p.frames.setNPCId(p, 6863, 663, 3);
Engine.newSummonNPC(6863, p.absX, p.absY+1, p.heightLevel, p.absX + 1, p.absY + 1, p.absX + -1, p.absY + -1, false, p.playerId);
p.addSkillXP(26000, 23);

}
}
else
{
p.frames.sendMessage(p, "You need at least level 86 summoning to summon that.");	
}
break;

case 12930://Fire Titan
if (p.skillLvl[23] > 78) {
if(p.FamiliarID > 0)
{
p.frames.sendMessage(p, "You cannot summon more than one familiar at a time.");	
}
else
{
Engine.playerItems.deleteItem(p, 12802, itemSlot, 1); 
p.frames.sendMessage(p, "You summon a Fire Titan.");
p.frames.setTab(p, 80, 663);
p.frames.animateInterfaceId(p, 9850, 663, 3);
p.frames.setNPCId(p, 7355, 663, 3);
Engine.newSummonNPC(7355, p.absX, p.absY+1, p.heightLevel, p.absX + 1, p.absY + 1, p.absX + -1, p.absY + -1, false, p.playerId);
p.addSkillXP(18000, 23);

}
}
else
{
p.frames.sendMessage(p, "You need at least level 79 summoning to summon that.");	
}
break;

case 12932://Moss Titan
if (p.skillLvl[23] > 78) {
if(p.FamiliarID > 0)
{
p.frames.sendMessage(p, "You cannot summon more than one familiar at a time.");	
}
else
{
Engine.playerItems.deleteItem(p, 12804, itemSlot, 1); 
p.frames.sendMessage(p, "You summon a Moss Titan.");
p.frames.setTab(p, 80, 663);
p.frames.animateInterfaceId(p, 9850, 663, 3);
p.frames.setNPCId(p, 7357, 663, 3);
Engine.newSummonNPC(7357, p.absX, p.absY+1, p.heightLevel, p.absX + 1, p.absY + 1, p.absX + -1, p.absY + -1, false, p.playerId);
p.addSkillXP(18000, 23);

}
}
else
{
p.frames.sendMessage(p, "You need at least level 79 summoning to summon that.");	
}
break;

case 12934://Ice Titan
if (p.skillLvl[23] > 78) {
if(p.FamiliarID > 0)
{
p.frames.sendMessage(p, "You cannot summon more than one familiar at a time.");	
}
else
{
Engine.playerItems.deleteItem(p, 12806, itemSlot, 1); 
p.frames.sendMessage(p, "You summon a Ice Titan.");
p.frames.setTab(p, 80, 663);
p.frames.animateInterfaceId(p, 9850, 663, 3);
p.frames.setNPCId(p, 7359, 663, 3);
Engine.newSummonNPC(7359, p.absX, p.absY+1, p.heightLevel, p.absX + 1, p.absY + 1, p.absX + -1, p.absY + -1, false, p.playerId);
p.addSkillXP(18000, 23);

}
}
else
{
p.frames.sendMessage(p, "You need at least level 79 summoning to summon that.");	
}
break;

case 12660://Lava Titan
if (p.skillLvl[23] > 82) {
if(p.FamiliarID > 0)
{
p.frames.sendMessage(p, "You cannot summon more than one familiar at a time.");	
}
else
{
Engine.playerItems.deleteItem(p, 12788, itemSlot, 1); 
p.frames.sendMessage(p, "You summon a Lava Titan.");
p.frames.setTab(p, 80, 663);
p.frames.animateInterfaceId(p, 9850, 663, 3);
p.frames.setNPCId(p, 7341, 663, 3);
Engine.newSummonNPC(7341, p.absX, p.absY+1, p.heightLevel, p.absX + 1, p.absY + 1, p.absX + -1, p.absY + -1, false, p.playerId);
p.addSkillXP(20000, 23);

}
}
else
{
p.frames.sendMessage(p, "You need at least level 83 summoning to summon that.");	
}
break;

case 12648://Swamp Titan
if (p.skillLvl[23] > 84) {
if(p.FamiliarID > 0)
{
p.frames.sendMessage(p, "You cannot summon more than one familiar at a time.");	
}
else
{
Engine.playerItems.deleteItem(p, 12776, itemSlot, 1); 
p.frames.sendMessage(p, "You summon a Swamp Titan.");
p.frames.setTab(p, 80, 663);
p.frames.animateInterfaceId(p, 9850, 663, 3);
p.frames.setNPCId(p, 7329, 663, 3);
Engine.newSummonNPC(7329, p.absX, p.absY+1, p.heightLevel, p.absX + 1, p.absY + 1, p.absX + -1, p.absY + -1, false, p.playerId);
p.addSkillXP(22500, 23);

}
}
else
{
p.frames.sendMessage(p, "You need at least level 85 summoning to summon that.");	
}
break;



case 12658://Geyser Titan
if (p.skillLvl[23] > 88) {
if(p.FamiliarID > 0)
{
p.frames.sendMessage(p, "You cannot summon more than one familiar at a time.");	
}
else
{
Engine.playerItems.deleteItem(p, 12786, itemSlot, 1); 
p.frames.sendMessage(p, "You summon a Geyser Titan.");
p.frames.setTab(p, 80, 663);
p.frames.animateInterfaceId(p, 9850, 663, 3);
p.frames.setNPCId(p, 7339, 663, 3);
Engine.newSummonNPC(7339, p.absX, p.absY+1, p.heightLevel, p.absX + 1, p.absY + 1, p.absX + -1, p.absY + -1, false, p.playerId);
p.addSkillXP(25000, 23);

}
}
else
{
p.frames.sendMessage(p, "You need at least level 89 summoning to summon that.");	
}
break;

case 12668://Abyssal Titan
if (p.skillLvl[23] > 92) {
if(p.FamiliarID > 0)
{
p.frames.sendMessage(p, "You cannot summon more than one familiar at a time.");	
}
else
{
Engine.playerItems.deleteItem(p, 12796, itemSlot, 1); 
p.frames.sendMessage(p, "You summon a Abyssal Titan.");
p.frames.setTab(p, 80, 663);
p.frames.animateInterfaceId(p, 9850, 663, 3);
p.frames.setNPCId(p, 7349, 663, 3);
Engine.newSummonNPC(7349, p.absX, p.absY+1, p.heightLevel, p.absX + 1, p.absY + 1, p.absX + -1, p.absY + -1, false, p.playerId);
p.addSkillXP(28000, 23);

}
}
else
{
p.frames.sendMessage(p, "You need at least level 93 summoning to summon that.");	
}
break;

case 12950://Iron Titan
if (p.skillLvl[23] > 94) {
if(p.FamiliarID > 0)
{
p.frames.sendMessage(p, "You cannot summon more than one familiar at a time.");	
}
else
{
Engine.playerItems.deleteItem(p, 12822, itemSlot, 1); 
p.frames.sendMessage(p, "You summon an Iron Titan.");
p.frames.setTab(p, 80, 663);
p.frames.animateInterfaceId(p, 9850, 663, 3);
p.frames.setNPCId(p, 7375, 663, 3);
Engine.newSummonNPC(7375, p.absX, p.absY+1, p.heightLevel, p.absX + 1, p.absY + 1, p.absX + -1, p.absY + -1, false, p.playerId);
p.addSkillXP(30000, 23);

}
}
else
{
p.frames.sendMessage(p, "You need at least level 95 summoning to summon that.");	
}
break;
case 12662://Steel Titan
if (p.skillLvl[23] > 98) {
if(p.FamiliarID > 0)
{
p.frames.sendMessage(p, "You cannot summon more than one familiar at a time.");	
}
else
{
Engine.playerItems.deleteItem(p, 12790, itemSlot, 1); 
p.frames.sendMessage(p, "You summon a Steel Titan.");
p.frames.setTab(p, 80, 663);
p.frames.animateInterfaceId(p, 9850, 663, 3);
p.frames.setNPCId(p, 7343, 663, 3);
Engine.newSummonNPC(7343, p.absX, p.absY+1, p.heightLevel, p.absX + 1, p.absY + 1, p.absX + -1, p.absY + -1, false, p.playerId);
p.addSkillXP(10, 23);

}
}
else
{
p.frames.sendMessage(p, "You need at least level 99 summoning to summon that.");	
}
break;


case 278:
if(itemId == p.shop2[itemSlot])
{
	p.frames.sendMessage(p, Engine.items.getItemName(itemId)+" currently costs: "+p.shop2p[itemSlot]+" coins.");
}
if(itemId == p.shop3[itemSlot])
{
	p.frames.sendMessage(p, Engine.items.getItemName(itemId)+" currently costs: "+p.shop3p[itemSlot]+" coins.");
}
if(itemId == p.shop4[itemSlot])
{
	p.frames.sendMessage(p, Engine.items.getItemName(itemId)+" currently costs: "+p.shop4p[itemSlot]+" coins.");
}
if(itemId == p.shop5[itemSlot])
{
	p.frames.sendMessage(p, Engine.items.getItemName(itemId)+" currently costs: "+p.shop5p[itemSlot]+" coins.");
}
if(itemId == p.shop6[itemSlot])
{
	p.frames.sendMessage(p, Engine.items.getItemName(itemId)+" currently costs: "+p.shop6p[itemSlot]+" coins.");
}
if(itemId == p.shop7[itemSlot])
{
	p.frames.sendMessage(p, Engine.items.getItemName(itemId)+" currently costs: "+p.shop7p[itemSlot]+" coins.");
}
if(itemId == p.shop8[itemSlot])
{
	p.frames.sendMessage(p, Engine.items.getItemName(itemId)+" currently costs: "+p.shop8p[itemSlot]+" coins.");
}
if(itemId == p.shop9[itemSlot])
{
	p.frames.sendMessage(p, Engine.items.getItemName(itemId)+" currently costs: "+p.shop9p[itemSlot]+" coins.");
}

if(itemId == p.shop10[itemSlot])
{
	p.frames.sendMessage(p, Engine.items.getItemName(itemId)+" currently costs: "+p.shop10p[itemSlot]+" coins.");
}
if(itemId == p.shop11[itemSlot])
{
	p.frames.sendMessage(p, Engine.items.getItemName(itemId)+" currently costs: "+p.shop11p[itemSlot]+" coins.");
}
if(itemId == p.shop12[itemSlot])
{
	p.frames.sendMessage(p, Engine.items.getItemName(itemId)+" currently costs: "+p.shop12p[itemSlot]+" coins.");
}





	break;


case 199:
Engine.playerItems.deleteItem(p,199, Engine.playerItems.getItemSlot(p, 199), 1);
Engine.playerItems.addItem(p, 249, 1);
p.addSkillXP(200*p.skillLvl[15] ,15);
p.frames.sendMessage(p, "You clean the guam leaf.");
break;

case 207:
Engine.playerItems.deleteItem(p,207, Engine.playerItems.getItemSlot(p, 207), 1);
Engine.playerItems.addItem(p, 257, 1);
p.addSkillXP(450*p.skillLvl[15] ,15);
p.frames.sendMessage(p, "You clean the ranarr weed.");
break;




        case 387: // Unequip item.

if(itemId == 4042 || itemId == 4041 || itemId == 4037 || itemId == 4039)
{
p.frames.sendMessage(p, "You cannot take this off.");
}
else
{
            if (itemSlot < p.equipment.length && p.equipment[itemSlot] == itemId) {
                if (!Engine.playerItems.addItem(p, p.equipment[itemSlot],
                        p.equipmentN[itemSlot])) {
                    break;
                }
                p.equipment[itemSlot] = -1;
                p.equipmentN[itemSlot] = 0;
                p.frames.setItems(p, 387, 28, 94, p.equipment, p.equipmentN);
                p.playerWeapon.setWeapon();
                p.appearanceUpdateReq = true;
                p.updateReq = true;
                p.calculateEquipmentBonus();
            }
}
            break;

        default:
            Misc.println("[" + p.username + "] Item option 1: " + interfaceId +" "+ itemSlot + " "+ item +" "+ items);
            break;
        }
    }
}
