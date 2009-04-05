

package Naoscape.players.items;


import Naoscape.Engine;
import Naoscape.players.Player;


public class PlayerBank {
    public void bankItem(Player p, int id, int amt) {
        if (p == null || id < 0 || id >= 28 || p.items[id] == -1) {
            return;
        }
        int itemId = p.items[id];
        int invItemCount = Engine.playerItems.invItemCount(p, itemId);

        if (amt <= 0 || amt > invItemCount) {
            amt = invItemCount;
        }
        int bankItemCount = getBankItemCount(p, itemId);
        int freeBankSlot = getFreeBankSlot(p);

        if (bankItemCount == 0 && freeBankSlot == -1) {
            p.frames.sendMessage(p, "Not enough space in your bank.");
            return;
        } else if (bankItemCount > 0) {
            int bankItemSlot = getBankItemSlot(p, itemId);

            p.bankItemsN[bankItemSlot] += amt;
            if (p.bankItemsN[bankItemSlot] > 999999999) {
                p.bankItemsN[bankItemSlot] = 999999999;
            }
        } else {
            p.bankItems[freeBankSlot] = itemId;
            p.bankItemsN[freeBankSlot] = amt;
            if (p.bankItemsN[freeBankSlot] > 999999999) {
                p.bankItemsN[freeBankSlot] = 999999999;
            }
        }
        Engine.playerItems.deleteItem(p, itemId, id, amt);
        p.frames.setItems(p, -1, 64207, 95, p.bankItems, p.bankItemsN);
        p.frames.setItems(p, -1, 64209, 93, p.items, p.itemsN);
        p.frames.setItems(p, 149, 0, 93, p.items, p.itemsN);
        p.frames.setString(p, p.bankItemCount() + "", 762, 97);
    }

    public void bankWithdraw(Player p, int id, int amt) {
        if (p == null || id < 0 || id >= 500 || p.bankItems[id] == -1) {
            return;
        }
        int itemId = p.bankItems[id];
        int bankItemCount = getBankItemCount(p, itemId);

        if (amt <= 0 || amt > bankItemCount) {
            amt = bankItemCount;
        }
        int invItemCount = Engine.playerItems.invItemCount(p, itemId);
        int freeInvSlot = Engine.playerItems.findInvSlot(p);

        if ((invItemCount == 0 && !Engine.items.stackable(itemId))
                && freeInvSlot == -1) {
            p.frames.sendMessage(p, "Not enough space in your inventory.");
            return;
        } else if (invItemCount > 0 && Engine.items.stackable(itemId)) {
            int invItemSlot = Engine.playerItems.getItemSlot(p, itemId);

            p.itemsN[invItemSlot] += amt;
            if (p.itemsN[invItemSlot] > 999999999) {
                p.itemsN[invItemSlot] = 999999999;
            }
        } else {
            if (Engine.items.stackable(itemId)) {
                Engine.playerItems.addItem(p, itemId, amt);
            } else {
                int tempAmt = amt;

                while (tempAmt > 0) {
                    if (!Engine.playerItems.addItem(p, itemId, 1)) {
                        p.frames.sendMessage(p,
                                "Not enough space in your inventory.");
                        break;
                    }
                    tempAmt--;
                }
                amt = (amt - tempAmt);
            }
        }
        p.bankItemsN[id] -= amt;
        if (p.bankItemsN[id] <= 0) {
            p.bankItems[id] = -1;
        }
        alignBank(p);
        p.frames.setItems(p, -1, 64207, 95, p.bankItems, p.bankItemsN);
        p.frames.setItems(p, -1, 64209, 93, p.items, p.itemsN);
        p.frames.setItems(p, 149, 0, 93, p.items, p.itemsN);
        p.frames.setString(p, p.bankItemCount() + "", 762, 97);
    }

    public void alignBank(Player p) {
        int[] tempBank = p.bankItems;
        int[] tempBankN = p.bankItemsN;
        int id = 0;

        for (int i = 0; i < 500; i++) {
            if (tempBank[i] != -1) {
                p.bankItems[id] = tempBank[i];
                p.bankItemsN[id++] = tempBankN[i];
            }
        }
        for (int i = id; i < 500; i++) {
            p.bankItems[i] = -1;
            p.bankItemsN[i] = 0;
        }
    }

    public int getBankItemSlot(Player p, int itemId) {
        for (int i = 0; i < 500; i++) {
            if (p.bankItems[i] == itemId) {
                return i;
            }
        }
        return -1;
    }

    public int getFreeBankSlot(Player p) {
        for (int i = 0; i < 500; i++) {
            if (p.bankItems[i] == -1) {
                return i;
            }
        }
        return -1;
    }

    public int getBankItemCount(Player p, int itemId) {
        for (int i = 0; i < 500; i++) {
            if (p.bankItems[i] == itemId) {
                return p.bankItemsN[i];
            }
        }
        return 0;
    }
}
