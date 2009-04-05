

package Naoscape.io.packets;


import Naoscape.Engine;
import Naoscape.util.Misc;
import Naoscape.players.Player;


public class Equipment implements Packet {
    private String[] capes = { "cape", "Cape", "cloak", "Cloak"};
    private String[] hats = {
        "helm", "hood", "coif", "Coif", "hat", "mitre", "partyhat", "Hat",
        "full helm (t)", "full helm (g)", "hat (t)", "hat (g)", "cav", "boater", "Feather headdress",
        "helmet", "mask", "Helm of neitiznot", "Mime mask"};
    private String[] boots = { "boots", "Boots"};
    private String[] gloves = {
        "gloves", "gauntlets", "Gloves", "vambraces", "vamb", "bracers"};
    private String[] shields = {
        "kiteshield", "sq shield", "Toktz-ket", "books", "book",
        "kiteshield (t)", "kiteshield (g)", "kiteshield(h)", "defender",
        "shield"};
    private String[] amulets = { "amulet", "necklace", "stole", "Amulet of"};
    private String[] arrows = {
        "arrow", "arrows", "arrow(p)", "arrow(+)", "arrow(s)", "bolt",
        "Bolt rack", "Opal bolts", "Dragon bolts"};
    private String[] rings = { "ring"};
    private String[] body = {
        "platebody", "chainbody", "Zamorak d'hide", "robetop", "leathertop", "platemail", "top",
        "brassard", "Robe top", "body", "platebody (t)", "platebody (g)",
        "body(g)", "body_(g)", "chestplate", "torso", "shirt", "Varrock armour", "Guthix d'hide", "Saradomin d'hide",
 "Prince tunic", "Wizard robe (g)", "Wizard robe (t)" , "Runecrafter robe"};
    private String[] legs = {
        "platelegs", "knight robe", "plateskirt", "skirt", "bottoms", "chaps",
        "platelegs (t)", "platelegs (g)", "bottom", "skirt", "skirt (g)",
        "skirt (t)", "chaps (g)", "chaps (t)", "tassets", "legs"};
    private String[] weapons = {
        "scimitar", "longsword", "sword", "crozier", "longbow", "shortbow", "dagger",
        "mace", "halberd", "spear", "Abyssal whip", "axe", "flail", "crossbow",
        "Torags hammers", "dagger(p)", "dagger(+)", "dagger(s)", "spear(p)",
        "spear(+)", "spear(s)", "spear(kp)", "maul", "dart", "dart(p)",
        "javelin", "javelin(p)", "knife", "knife(p)", "Longbow", "Shortbow",
        "Crossbow", "Toktz-xil", "Toktz-mej", "Tzhaar-ket", "staff", "Staff",
        "godsword", "c'bow", "Crystal bow", "Dark bow", "Magic butterfly net"};

    /* Fullbody is an item that covers your arms. */
    private String[] fullbody = {
        "top", "shirt", "platebody", "Zamorak d'hide", "Ahrims robetop", "Karils leathertop",
        "brassard", "Robe top", "robetop", "platebody (t)", "platebody (g)",
        "chestplate", "torso", "chainbody", "Varrock armour", "Guthix d'hide", "Saradomin d'hide", "Prince tunic", "Wizard robe (g)", "Wizard robe (t)", "Runecrafter robe"};

    /* Fullhat covers your head but not your beard. */
    private String[] fullhat = {
        "med helm", "Dharoks helm", "hood", "Initiate helm", "Coif",
        "Helm of neitiznot"};

    /* Fullmask covers your entire head. */
    private String[] fullmask = {
        "full helm", "Slayer helmet", "Veracs helm", "Guthans helm",
        "Torags helm", "Karils coif", "full helm (t)", "full helm (g)", "Green h'ween mask", "Red h'ween mask", "Blue h'ween mask", "full helmet"};

    /**
     * Handles equipping items.
     * @param p The Player which the frame should be handled for.
     * @param packetId The packet id this belongs to.
     * @param packetSize The amount of bytes being recieved for this packet.
     */
    public void handlePacket(Player p, int packetId, int packetSize) {
        if (p == null || p.stream == null) {
            return;
        }
        int junk1 = p.stream.readDWord_v2();
        int wearId = p.stream.readUnsignedWordBigEndian();
        int index = p.stream.readUnsignedByte();
        int junk2 = p.stream.readUnsignedByte();

        p.attackingPlayer = false;
        if (index < 0 || index >= p.items.length) {
            return;
        }
        if (p.items[index] == wearId) {
            int targetSlot = itemType(wearId);

            if (targetSlot == -1) {
                Misc.println("[" + p.username + "] Unsupported item: " + wearId);
                return;
            }

if(p.equipment[3] == 4037 && p.AtCastleWars() || p.equipment[3] == 4039 && p.AtCastleWars())
{
return;
}
            int wearAmt = p.itemsN[index];
            int cLAttack = getCLAttack(wearId);
            int cLDefence = getCLDefence(wearId);
            int cLStrength = getCLStrength(wearId);
            int cLMagic = getCLMagic(wearId);
            int cLRanged = getCLRanged(wearId);
            int cLCrafting = getCLCrafting(wearId);



            if (wearId == 3140 && p.DragonSlayer != 5 || wearId == 1127 && p.DragonSlayer != 5) {
                p.frames.sendMessage(p,"You must complete dragon slayer before you can wear this.");
                return;
            }
            if (wearId == 9813 && p.QuestPoints < 2 || wearId == 9814 && p.QuestPoints < 2) {
                p.frames.sendMessage(p,"You must complete all of New Rune's quests to wear this.");
                return;
            }

            if (cLAttack > p.getLevelForXP(0)) {
                p.frames.sendMessage(p,
                        "You need " + cLAttack + " Attack to equip this item.");
                return;
            }
            if (cLDefence > p.getLevelForXP(1)) {
                p.frames.sendMessage(p,
                        "You need " + cLDefence + " Defence to equip this item.");
                return;
            }
            if (cLCrafting > p.getLevelForXP(20)) {
                p.frames.sendMessage(p,
                        "You need " + cLCrafting + " Runecrafting to equip this item.");
                return;
            }
            if (cLStrength > p.getLevelForXP(2)) {
                p.frames.sendMessage(p,
                        "You need " + cLStrength
                        + " Strength to equip this item.");
                return;
            }
            if (cLMagic > p.getLevelForXP(6)) {
                p.frames.sendMessage(p,
                        "You need " + cLMagic + " Magic to equip this item.");
                return;
            }
            if (cLRanged > p.getLevelForXP(4)) {
                p.frames.sendMessage(p,
                        "You need " + cLRanged + " Ranged to equip this item.");
                return;
            }
            if (twoHanded(wearId) && Engine.playerItems.freeSlotCount(p) < 1
                    && p.equipment[5] > 0) {
                p.frames.sendMessage(p, "Not enough space in your inventory.");
                return;
            }
            if (wearId >= 0 && wearAmt > 0) {
                Engine.playerItems.deleteItem(p, wearId, index, wearAmt);
                if (targetSlot == 3) {
                    if (twoHanded(wearId) && p.equipment[5] > -1) {
                        if (!Engine.playerItems.addItem(p, p.equipment[5],
                                p.equipmentN[5])) {
                            Engine.playerItems.addItem(p, wearId, wearAmt);
                            return;
                        }
                        p.equipment[5] = -1;
                        p.equipmentN[5] = 0;
                    }
                } else if (targetSlot == 5) {
                    if (twoHanded(p.equipment[3]) && p.equipment[3] > -1) {
                        if (!Engine.playerItems.addItem(p, p.equipment[3],
                                p.equipmentN[3])) {
                            Engine.playerItems.addItem(p, wearId, wearAmt);
                            return;
                        }
                        p.equipment[3] = -1;
                        p.equipmentN[3] = 0;
                    }
                }
                if (p.equipment[targetSlot] >= 0
                        && (wearId != p.equipment[targetSlot]
                                || !Engine.items.stackable(wearId))) {
                    Engine.playerItems.addItem(p, p.equipment[targetSlot],
                            p.equipmentN[targetSlot]);
                    p.equipmentN[targetSlot] = 0;
                }
                p.equipment[targetSlot] = wearId;
                p.equipmentN[targetSlot] += wearAmt;
                p.frames.setItems(p, 387, 28, 94, p.equipment, p.equipmentN);
                p.playerWeapon.setWeapon();
                p.appearanceUpdateReq = true;
                p.updateReq = true;
                p.calculateEquipmentBonus();
            }
        } else {// Player is trying to cheat.
        }
    }

    /**
     * Returns if the itemId is a two handed weapon or not.
     * @param itemId The id of the item to check.
     * @return Returns whether the item is two handed or not.
     */
    public boolean twoHanded(int itemId) {
        String wepEquiped = Engine.items.getItemName(itemId);

        if (itemId == 4212) {
            return true;
        } else if (itemId == 4214) {
            return true;
        } else if (wepEquiped.endsWith("2h sword")) {
            return true;
        } else if (wepEquiped.endsWith("net")) {
            return true;
        } else if (wepEquiped.endsWith("longbow")) {
            return true;
        } else if (wepEquiped.equals("Seercull")) {
            return true;
        } else if (wepEquiped.endsWith("shortbow")) {
            return true;
        } else if (wepEquiped.endsWith("Longbow")) {
            return true;
        } else if (wepEquiped.endsWith("Shortbow")) {
            return true;
        } else if (wepEquiped.endsWith("bow full")) {
            return true;
        } else if (wepEquiped.endsWith("halberd")) {
            return true;
        } else if (wepEquiped.equals("Granite maul")) {
            return true;
        } else if (wepEquiped.equals("Karils crossbow")) {
            return true;
        } else if (wepEquiped.equals("Torags hammers")) {
            return true;
        } else if (wepEquiped.equals("Veracs flail")) {
            return true;
        } else if (wepEquiped.equals("Dharoks greataxe")) {
            return true;
        } else if (wepEquiped.equals("Guthans warspear")) {
            return true;
        } else if (wepEquiped.equals("Tzhaar-ket-om")) {
            return true;
        } else if (wepEquiped.endsWith("godsword")) {
            return true;
        } else if (wepEquiped.equals("Saradomin sword")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Returns the ranged level needed for ItemID.
     * @param ItemID The id of the item to check.
     * @return The ranged level requirement to weild the item.
     */
    public int getCLRanged(int ItemID) {
        String itemName = Engine.items.getItemName(ItemID);

        if (ItemID == 2499) {
            return 50;
        }
        if (ItemID == 1135) {
            return 40;
        }
        if (ItemID == 1099) {
            return 40;
        }
        if (ItemID == 1065) {
            return 40;
        }
        if (ItemID == 2501) {
            return 60;
        }
        if (ItemID == 2503) {
            return 70;
        }
        if (ItemID == 2487) {
            return 50;
        }
        if (ItemID == 2489) {
            return 60;
        }
        if (ItemID == 2495) {
            return 60;
        }
        if (ItemID == 2491) {
            return 70;
        }
        if (ItemID == 2493) {
            return 50;
        }
        if (ItemID == 2505) {
            return 60;
        }
        if (ItemID == 2507) {
            return 70;
        }
        if (ItemID == 859) {
            return 40;
        }
        if (ItemID == 861) {
            return 40;
        }
        if (ItemID == 7370) {
            return 40;
        }
        if (ItemID == 7372) {
            return 40;
        }
        if (ItemID == 7378) {
            return 40;
        }
        if (ItemID == 7380) {
            return 40;
        }
        if (ItemID == 7374) {
            return 50;
        }
        if (ItemID == 7376) {
            return 50;
        }
        if (ItemID == 7382) {
            return 50;
        }
        if (ItemID == 7384) {
            return 50;
        }
        if (itemName.equals("Coif")) {
            return 20;
        }
        if (itemName.startsWith("Studded chaps")) {
            return 20;
        }
        if (itemName.startsWith("Studded")) {
            return 20;
        }
        if (itemName.equals("Karils coif")) {
            return 70;
        }
        if (itemName.equals("Karils leathertop")) {
            return 70;
        }
        if (itemName.equals("Karils leatherskirt")) {
            return 70;
        }
        if (itemName.equals("Robin hood hat")) {
            return 40;
        }
        if (itemName.equals("Ranger boots")) {
            return 40;
        }
        if (itemName.equals("Crystal bow full")) {
            return 70;
        }
        if (itemName.equals("New crystal bow")) {
            return 70;
        }
        if (itemName.equals("Karils crossbow")) {
            return 70;
        }
        if (ItemID == 2497) {
            return 70;
        }
        if (itemName.equals("Rune thrownaxe")) {
            return 40;
        }
        if (itemName.equals("Rune dart")) {
            return 40;
        }
        if (itemName.equals("Rune javelin")) {
            return 40;
        }
        if (itemName.equals("Rune knife")) {
            return 40;
        }
        if (itemName.equals("Adamant thrownaxe")) {
            return 30;
        }
        if (itemName.equals("Adamant dart")) {
            return 30;
        }
        if (itemName.equals("Adamant javelin")) {
            return 30;
        }
        if (itemName.equals("Adamant knife")) {
            return 30;
        }
        if (itemName.equals("Toktz-xil-ul")) {
            return 60;
        }
        if (itemName.equals("Seercull")) {
            return 50;
        }
        if (itemName.equals("Bolt rack")) {
            return 70;
        }
        if (itemName.equals("Rune arrow")) {
            return 40;
        }
        if (itemName.equals("Adamant arrow")) {
            return 30;
        }
        if (itemName.equals("Mithril arrow")) {
            return 1;
        } else {
            return 1;
        }
    }

    /**
     * Returns the magic level needed for ItemID.
     * @param ItemID The id of the item to check.
     * @return Returns the magic level requirement to weild the item.
     */
    public int getCLMagic(int ItemID) {
        String itemName = Engine.items.getItemName(ItemID);

        if (itemName.equals("Mystic hat")) {
            return 40;
        }
        if (itemName.equals("Mystic robe top")) {
            return 40;
        }
        if (itemName.equals("Mystic robe bottom")) {
            return 40;
        }
        if (itemName.equals("Mystic gloves")) {
            return 40;
        }
        if (itemName.equals("Mystic boots")) {
            return 40;
        }
        if (itemName.equals("Slayer's staff")) {
            return 50;
        }
        if (itemName.equals("Enchanted hat")) {
            return 40;
        }
        if (itemName.equals("Enchanted top")) {
            return 40;
        }
        if (itemName.equals("Enchanted robe")) {
            return 40;
        }
        if (itemName.equals("Splitbark helm")) {
            return 40;
        }
        if (itemName.equals("Splitbark body")) {
            return 40;
        }
        if (itemName.equals("Splitbark gauntlets")) {
            return 40;
        }
        if (itemName.equals("Splitbark legs")) {
            return 40;
        }
        if (itemName.equals("Splitbark greaves")) {
            return 40;
        }
        if (itemName.equals("Infinity gloves")) {
            return 50;
        }
        if (itemName.equals("Infinity hat")) {
            return 50;
        }
        if (itemName.equals("Infinity top")) {
            return 50;
        }
        if (itemName.equals("Infinity bottoms")) {
            return 50;
        }
        if (itemName.equals("Infinity boots")) {
            return 50;
        }
        if (itemName.equals("Ahrims hood")) {
            return 70;
        }
        if (itemName.equals("Ahrims robetop")) {
            return 70;
        }
        if (itemName.equals("Ahrims robeskirt")) {
            return 70;
        }
        if (itemName.equals("Ahrims staff")) {
            return 70;
        }
        if (itemName.equals("Saradomin cape")) {
            return 60;
        }
        if (itemName.equals("Saradomin staff")) {
            return 60;
        }
        if (itemName.equals("Zamorak cape")) {
            return 60;
        }
        if (itemName.equals("Zamorak staff")) {
            return 60;
        }
        if (itemName.equals("Guthix cape")) {
            return 60;
        }
        if (itemName.equals("Guthix staff")) {
            return 60;
        }
        if (itemName.equals("mud staff")) {
            return 30;
        }
        if (itemName.equals("Fire battlestaff")) {
            return 30;
        }
        return 1;
    }

    /**
     * Returns the strength level needed to weild ItemID.
     * @param ItemID The item id to check.
     * @return The strength level requirement for the item.
     */
    public int getCLStrength(int ItemID) {
        String itemName = Engine.items.getItemName(ItemID);

        if (itemName.equals("Torags hammers")) {
            return 70;
        }
        if (itemName.equals("Dharoks greataxe")) {
            return 70;
        }
        if (itemName.equals("Granite maul")) {
            return 50;
        }
        if (itemName.equals("Granite legs")) {
            return 99;
        }
        if (itemName.equals("Tzhaar-ket-om")) {
            return 60;
        }
        if (itemName.equals("Granite shield")) {
            return 50;
        }
        return 1;
    }

    /**
     * Returns the attack level needed for ItemID.
     * @param ItemID The item id to check.
     * @return The attack level needed to weild the item.
     */
    public int getCLAttack(int ItemID) {
        String itemName = Engine.items.getItemName(ItemID);

        if (itemName.equals("Black dagger")) {
            return 10;
        }
        if (itemName.equals("Black spear")) {
            return 10;
        }
        if (itemName.equals("Black longsword")) {
            return 10;
        }
        if (itemName.equals("Black scimitar")) {
            return 10;
        }
        if (itemName.equals("Black axe")) {
            return 10;
        }
        if (itemName.equals("Black battleaxe")) {
            return 10;
        }
        if (itemName.equals("Black mace")) {
            return 10;
        }
        if (itemName.equals("Black halberd")) {
            return 10;
        }
        if (itemName.equals("Mithril dagger")) {
            return 20;
        }
        if (itemName.equals("Mithril spear")) {
            return 20;
        }
        if (itemName.equals("Mihril longsword")) {
            return 20;
        }
        if (itemName.equals("Mithril scimitar")) {
            return 20;
        }
        if (itemName.equals("Mithril axe")) {
            return 20;
        }
        if (itemName.equals("Mithril battleaxe")) {
            return 20;
        }
        if (itemName.equals("Mithril mace")) {
            return 20;
        }
        if (itemName.equals("Mithril halberd")) {
            return 20;
        }
        if (itemName.equals("Adamant dagger")) {
            return 30;
        }
        if (itemName.equals("Adamant spear")) {
            return 30;
        }
        if (itemName.equals("Adamant longsword")) {
            return 30;
        }
        if (itemName.equals("Adamant scimitar")) {
            return 30;
        }
        if (itemName.equals("Adamant axe")) {
            return 30;
        }
        if (itemName.equals("Adamant battleaxe")) {
            return 30;
        }
        if (itemName.equals("Adamant mace")) {
            return 30;
        }
        if (itemName.equals("Adamant halberd")) {
            return 30;
        }
        if (itemName.equals("Rune dagger")) {
            return 40;
        }
        if (itemName.equals("Rune spear")) {
            return 40;
        }
        if (itemName.equals("Rune longsword")) {
            return 40;
        }
        if (itemName.equals("Rune scimitar")) {
            return 40;
        }
        if (itemName.equals("Rune axe")) {
            return 40;
        }
        if (itemName.equals("Rune battleaxe")) {
            return 40;
        }
        if (itemName.equals("Rune mace")) {
            return 40;
        }
        if (itemName.equals("Rune halberd")) {
            return 40;
        }
        if (itemName.equals("Dragon dagger(s)")) {
            return 60;
        }
        if (itemName.equals("Dragon dagger")) {
            return 60;
        }
        if (itemName.startsWith("Dragon spear")) {
            return 60;
        }
        if (itemName.equals("Dragon longsword")) {
            return 60;
        }
        if (itemName.equals("Dragon scimitar")) {
            return 60;
        }
        if (itemName.equals("Dragon axe")) {
            return 60;
        }
        if (itemName.equals("Dragon battleaxe")) {
            return 60;
        }
        if (itemName.equals("Dragon mace")) {
            return 60;
        }
        if (itemName.equals("Dragon halberd")) {
            return 60;
        }
        if (itemName.equals("Abyssal whip")) {
            return 70;
        }
        if (itemName.equals("Veracs flail")) {
            return 70;
        }
        if (itemName.equals("Torags hammers")) {
            return 70;
        }
        if (itemName.equals("Dharoks greataxe")) {
            return 70;
        }
        if (itemName.equals("Guthans warspear")) {
            return 70;
        }
        if (itemName.equals("Ahrims staff")) {
            return 70;
        }
        if (itemName.equals("Granite maul")) {
            return 50;
        }
        if (itemName.equals("Toktz-xil-ak")) {
            return 60;
        }
        if (itemName.equals("Tzhaar-ket-em")) {
            return 60;
        }
        if (itemName.equals("Toktz-xil-ek")) {
            return 60;
        }
        if (itemName.equals("Granite legs")) {
            return 99;
        }
        if (itemName.equals("Mud staff")) {
            return 30;
        }
        if (itemName.equals("Lava battlestaff")) {
            return 30;
        }
        if (itemName.equals("Toktz-mej-tal")) {
            return 60;
        }
        if (itemName.endsWith("godsword")) {
            return 75;
        }
        if (itemName.equals("Ancient staff")) {
            return 50;
        }
        return 1;
    }

    /**
     * Returns the defence level needed for ItemID.
     * @param ItemID The item id to check.
     * @return Returns the defence level requirement to weild the item.
     */

    public int getCLCrafting(int ItemID) {
        String itemName = Engine.items.getItemName(ItemID);

        if (itemName.startsWith("Runecrafter")) {
            return 70;
        }
return 1;
}
    public int getCLDefence(int ItemID) {
        String itemName = Engine.items.getItemName(ItemID);

        if (itemName.equals("Rune boots")) {
            return 40;
        }
        if (ItemID == 2499) {
            return 40;
        }
        if (ItemID == 4123) {
            return 5;
        }
        if (ItemID == 4125) {
            return 10;
        }
        if (ItemID == 4127) {
            return 20;
        }
        if (ItemID == 4129) {
            return 30;
        }
        if (ItemID == 7990) {
            return 60;
        }
        if (ItemID == 2501) {
            return 40;
        }
        if (ItemID == 1131) {
            return 10;
        }
        if (ItemID == 2503) {
            return 40;
        }
        if (ItemID == 1135) {
            return 40;
        }
        if (ItemID == 7462) {
            return 42;
        }
        if (ItemID == 7461) {
            return 42;
        }
        if (ItemID == 7460) {
            return 42;
        }
        if (ItemID == 7459) {
            return 20;
        }
        if (ItemID == 7458) {
            return 1;
        }
        if (ItemID == 7457) {
            return 1;
        }
        if (ItemID == 7456) {
            return 1;
        }
        if (itemName.equals("White med helm")) {
            return 10;
        }
        if (itemName.equals("White chainbody")) {
            return 10;
        }
        if (itemName.startsWith("White full helm")) {
            return 10;
        }
        if (itemName.startsWith("White platebody")) {
            return 10;
        }
        if (itemName.startsWith("White plateskirt")) {
            return 10;
        }
        if (itemName.startsWith("White platelegs")) {
            return 10;
        }
        if (itemName.startsWith("White kiteshield")) {
            return 10;
        }
        if (itemName.startsWith("White sq shield")) {
            return 10;
        }
        if (itemName.startsWith("Studded chaps")) {
            return 1;
        }
        if (itemName.startsWith("Studded")) {
            return 20;
        }
        if (itemName.startsWith("Black kiteshield(h)")) {
            return 10;
        }
        if (itemName.startsWith("Rune kiteshield(h)")) {
            return 40;
        }
        if (itemName.equals("Black med helm")) {
            return 10;
        }
        if (itemName.equals("Black chainbody")) {
            return 10;
        }
        if (itemName.startsWith("Black full helm")) {
            return 10;
        }
        if (itemName.startsWith("Black platebody")) {
            return 10;
        }
        if (itemName.startsWith("Black plateskirt")) {
            return 10;
        }
        if (itemName.startsWith("Black platelegs")) {
            return 10;
        }
        if (itemName.startsWith("Black kiteshield")) {
            return 10;
        }
        if (itemName.startsWith("Black sq shield")) {
            return 10;
        }
        if (itemName.equals("Mithril med helm")) {
            return 20;
        }
        if (itemName.equals("Mithril chainbody")) {
            return 20;
        }
        if (itemName.startsWith("Mithril full helm")) {
            return 20;
        }
        if (itemName.startsWith("Mithril platebody")) {
            return 20;
        }
        if (itemName.startsWith("Mithril plateskirt")) {
            return 20;
        }
        if (itemName.startsWith("Mithril platelegs")) {
            return 20;
        }
        if (itemName.startsWith("Mithril kiteshield")) {
            return 20;
        }
        if (itemName.startsWith("Mithril sq shield")) {
            return 20;
        }
        if (itemName.equals("Adamant med helm")) {
            return 30;
        }
        if (itemName.equals("Adamant chainbody")) {
            return 30;
        }
        if (itemName.startsWith("Adamant full helm")) {
            return 30;
        }
        if (itemName.startsWith("Adamant platebody")) {
            return 30;
        }
        if (itemName.startsWith("Adamant plateskirt")) {
            return 30;
        }
        if (itemName.startsWith("Adamant platelegs")) {
            return 30;
        }
        if (itemName.startsWith("Adamant kiteshield")) {
            return 30;
        }
        if (itemName.startsWith("Adamant sq shield")) {
            return 30;
        }
        if (itemName.startsWith("Adam full helm")) {
            return 30;
        }
        if (itemName.startsWith("Adam platebody")) {
            return 30;
        }
        if (itemName.startsWith("Adam plateskirt")) {
            return 30;
        }
        if (itemName.startsWith("Adam platelegs")) {
            return 30;
        }
        if (itemName.startsWith("Adam kiteshield")) {
            return 30;
        }
        if (itemName.startsWith("Adam kiteshield(h)")) {
            return 30;
        }
        if (itemName.startsWith("D-hide body(g)")) {
            return 40;
        }
        if (itemName.startsWith("D-hide body(t)")) {
            return 40;
        }
        if (itemName.equals("Dragon sq shield")) {
            return 60;
        }
        if (itemName.equals("Dragon med helm")) {
            return 60;
        }
        if (itemName.equals("Dragon chainbody")) {
            return 60;
        }
        if (itemName.equals("Dragon plateskirt")) {
            return 60;
        }
        if (itemName.equals("Dragon platelegs")) {
            return 60;
        }
        if (itemName.equals("Dragon sq shield")) {
            return 60;
        }
        if (itemName.equals("Rune med helm")) {
            return 40;
        }
        if (itemName.equals("Rune chainbody")) {
            return 40;
        }
        if (itemName.startsWith("Rune full helm")) {
            return 40;
        }
        if (itemName.startsWith("Rune platebody")) {
            return 40;
        }
        if (itemName.startsWith("Rune plateskirt")) {
            return 40;
        }
        if (itemName.startsWith("Rune platelegs")) {
            return 40;
        }
        if (itemName.startsWith("Rune kiteshield")) {
            return 40;
        }
        if (itemName.startsWith("Zamorak full helm")) {
            return 40;
        }
        if (itemName.startsWith("Zamorak platebody")) {
            return 40;
        }
        if (itemName.startsWith("Zamorak plateskirt")) {
            return 40;
        }
        if (itemName.startsWith("Zamorak platelegs")) {
            return 40;
        }
        if (itemName.startsWith("Zamorak kiteshield")) {
            return 40;
        }
        if (itemName.startsWith("Guthix full helm")) {
            return 40;
        }
        if (itemName.startsWith("Guthix platebody")) {
            return 40;
        }
        if (itemName.startsWith("Guthix plateskirt")) {
            return 40;
        }
        if (itemName.startsWith("Guthix platelegs")) {
            return 40;
        }
        if (itemName.startsWith("Guthix kiteshield")) {
            return 40;
        }
        if (itemName.startsWith("Saradomin full")) {
            return 40;
        }
        if (itemName.startsWith("Saradomin plate")) {
            return 40;
        }
        if (itemName.startsWith("Saradomin plateskirt")) {
            return 40;
        }
        if (itemName.startsWith("Saradomin legs")) {
            return 40;
        }
        if (itemName.startsWith("Zamorak kiteshield")) {
            return 40;
        }
        if (itemName.startsWith("Rune sq shield")) {
            return 40;
        }
        if (itemName.equals("Gilded full helm")) {
            return 40;
        }
        if (itemName.equals("Gilded platebody")) {
            return 40;
        }
        if (itemName.equals("Gilded plateskirt")) {
            return 40;
        }
        if (itemName.equals("Gilded platelegs")) {
            return 40;
        }
        if (itemName.equals("Gilded kiteshield")) {
            return 40;
        }
        if (itemName.equals("Fighter torso")) {
            return 40;
        }
        if (itemName.equals("Granite legs")) {
            return 99;
        }
        if (itemName.equals("Toktz-ket-xil")) {
            return 60;
        }
        if (itemName.equals("Dharoks helm")) {
            return 70;
        }
        if (itemName.equals("Dharoks platebody")) {
            return 70;
        }
        if (itemName.equals("Dharoks platelegs")) {
            return 70;
        }
        if (itemName.equals("Guthans helm")) {
            return 70;
        }
        if (itemName.equals("Guthans platebody")) {
            return 70;
        }
        if (itemName.equals("Guthans chainskirt")) {
            return 70;
        }
        if (itemName.equals("Torags helm")) {
            return 70;
        }
        if (itemName.equals("Torags platebody")) {
            return 70;
        }
        if (itemName.equals("Torags platelegs")) {
            return 70;
        }
        if (itemName.equals("Veracs helm")) {
            return 70;
        }
        if (itemName.equals("Veracs brassard")) {
            return 70;
        }
        if (itemName.equals("Veracs plateskirt")) {
            return 70;
        }
        if (itemName.equals("Ahrims hood")) {
            return 70;
        }
        if (itemName.equals("Ahrims robetop")) {
            return 70;
        }
        if (itemName.equals("Ahrims robeskirt")) {
            return 70;
        }
        if (itemName.equals("Karils coif")) {
            return 70;
        }
        if (itemName.equals("Karils leathertop")) {
            return 70;
        }
        if (itemName.equals("Karils leatherskirt")) {
            return 70;
        }
        if (itemName.equals("Granite shield")) {
            return 50;
        }
        if (itemName.equals("New crystal shield")) {
            return 70;
        }
        if (itemName.equals("Archer helm")) {
            return 45;
        }
        if (itemName.equals("Berserker helm")) {
            return 45;
        }
        if (itemName.equals("Warrior helm")) {
            return 45;
        }
        if (itemName.equals("Farseer helm")) {
            return 45;
        }
        if (itemName.equals("Initiate helm")) {
            return 20;
        }
        if (itemName.equals("Initiate platemail")) {
            return 20;
        }
        if (itemName.equals("Initiate platelegs")) {
            return 20;
        }
        if (itemName.equals("Dragonhide body")) {
            return 40;
        }
        if (itemName.equals("Mystic hat")) {
            return 20;
        }
        if (itemName.equals("Mystic robe top")) {
            return 20;
        }
        if (itemName.equals("Mystic robe bottom")) {
            return 20;
        }
        if (itemName.equals("Mystic gloves")) {
            return 20;
        }
        if (itemName.equals("Mystic boots")) {
            return 20;
        }
        if (itemName.equals("Enchanted hat")) {
            return 20;
        }
        if (itemName.equals("Enchanted top")) {
            return 20;
        }
        if (itemName.equals("Enchanted robe")) {
            return 20;
        }
        if (itemName.equals("Splitbark helm")) {
            return 40;
        }
        if (itemName.equals("Splitbark body")) {
            return 40;
        }
        if (itemName.equals("Splitbark gauntlets")) {
            return 40;
        }
        if (itemName.equals("Splitbark legs")) {
            return 40;
        }
        if (itemName.equals("Splitbark greaves")) {
            return 40;
        }
        if (itemName.equals("Infinity gloves")) {
            return 25;
        }
        if (itemName.equals("Infinity hat")) {
            return 25;
        }
        if (itemName.equals("Infinity top")) {
            return 25;
        }
        if (itemName.equals("Infinity bottoms")) {
            return 25;
        }
        if (itemName.equals("Infinity boots")) {
            return 25;
        }
        return 1;
    }

    /**
     * Returns the type of item.
     * @param item The item id to get the type for.
     * @return Returns the type of item this is.
     */
    public int itemType(int item) {
        String weapon = Engine.items.getItemName(item);

        for (int i = 0; i < capes.length; i++) {
            if (weapon.contains(capes[i])) {
                return 1;
            }
        }
        for (int i = 0; i < hats.length; i++) {
            if (weapon.contains(hats[i])) {
                return 0;
            }
        }
        for (int i = 0; i < boots.length; i++) {
            if (weapon.endsWith(boots[i]) || weapon.startsWith(boots[i])) {
                return 10;
            }
        }
        for (int i = 0; i < gloves.length; i++) {
            if (weapon.endsWith(gloves[i]) || weapon.startsWith(gloves[i])) {
                return 9;
            }
        }
        for (int i = 0; i < shields.length; i++) {
            if (weapon.contains(shields[i])) {
                return 5;
            }
        }
        for (int i = 0; i < amulets.length; i++) {
            if (weapon.endsWith(amulets[i]) || weapon.startsWith(amulets[i])) {
                return 2;
            }
        }
        for (int i = 0; i < arrows.length; i++) {
            if (weapon.endsWith(arrows[i]) || weapon.startsWith(arrows[i])) {
                return 13;
            }
        }
        for (int i = 0; i < rings.length; i++) {
            if (weapon.endsWith(rings[i]) || weapon.startsWith(rings[i])) {
                return 12;
            }
        }
        for (int i = 0; i < body.length; i++) {
            if (weapon.contains(body[i])) {
                return 4;
            }
        }
        for (int i = 0; i < legs.length; i++) {
            if (weapon.contains(legs[i])) {
                return 7;
            }
        }
        for (int i = 0; i < weapons.length; i++) {
            if (weapon.endsWith(weapons[i]) || weapon.startsWith(weapons[i])) {
                return 3;
            }
        }
        return -1;
    }

    /**
     * Returns if itemId is a full body.
     * @param itemId The item id to check.
     * @return Returns whether or not the item covers the body or not.
     */
    public boolean isFullbody(int itemId) {
        String weapon = Engine.items.getItemName(itemId);

        for (int i = 0; i < fullbody.length; i++) {
            if (weapon.contains(fullbody[i])) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns if itemId is a full hat.
     * @param itemId The item to check.
     * @return Returns if the item covers the hair.
     */
    public boolean isFullhat(int itemId) {
        String weapon = Engine.items.getItemName(itemId);

        for (int i = 0; i < fullhat.length; i++) {
            if (weapon.endsWith(fullhat[i])) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns if itemId is a full hat.
     * @param itemId The item to check.
     * @return Returns if the item covers the entire head.
     */
    public boolean isFullmask(int itemId) {
        String weapon = Engine.items.getItemName(itemId);

        for (int i = 0; i < fullmask.length; i++) {
            if (weapon.endsWith(fullmask[i])) {
                return true;
            }
        }
        return false;
    }
}
