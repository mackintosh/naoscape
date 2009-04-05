package Naoscape.io.packets;

import Naoscape.players.Player;
import Naoscape.players.items.PlayerItems;
import Naoscape.Engine;
import Naoscape.util.Misc;
import Naoscape.Skills.*;


public class ItemOnObject implements Packet {

	/**
	 * Handles item on item packet.
	 * @param Player p The player which the packet will be created for.
	 * @param packetId the packet id which is activated (Which handles this class)
	 * @param packetSize the amount of bytes being received for the packet.
	 */
	public void handlePacket(Player player, int packetId, int packetSize) {
		if (player == null)
			return;
		/**
		 * These are the correct stream methods
		 * for item on item packet.
		 */

		int usedWith = player.stream.readUnsignedWord();
        	int itemUsed = player.stream.readSignedWordA();
		PlayerItems pi = new PlayerItems();
	player.wc.resetWoodcutting();
player.mi.resetMining();


if (itemUsed == 4968 && usedWith == 34573) { //Marigold
if(player.HerbType > 0)
{
player.frames.sendMessage(player, "You can't plant more than one thing at a time.");
}
else
{
player.HerbloreTimer = 30;
player.HerbloreType = 7867;
player.HerbType = 1;
Engine.playerItems.deleteItem(player,5096, Engine.playerItems.getItemSlot(player, 5096), 1);
player.requestAnim(5212, 0);
player.createGlobalObject(7867, player.heightLevel, 2809, 3463, 0, 10);
}
}
if (itemUsed == 4972 && usedWith == 34573) { //Limpwurt
if(player.HerbType > 0)
{
player.frames.sendMessage(player, "You can't plant more than one thing at a time.");
}
else
{
player.HerbloreTimer = 30;
player.HerbloreType = 7851;
player.HerbType = 1;
Engine.playerItems.deleteItem(player,5100, Engine.playerItems.getItemSlot(player, 5100), 1);
player.requestAnim(5212, 0);
player.createGlobalObject(7851, player.heightLevel, 2809, 3463, 0, 10);
}
}
if (itemUsed == 5155 && usedWith == 34573) { //AppleTree
if(player.HerbType > 0)
{
player.frames.sendMessage(player, "You can't plant more than one thing at a time.");
}
else
{
player.HerbloreTimer = 30;
player.HerbloreType = 7936;
player.HerbType = 2;
Engine.playerItems.deleteItem(player,5283, Engine.playerItems.getItemSlot(player, 5283), 1);
player.requestAnim(5212, 0);
player.createGlobalObject(7936, player.heightLevel, 2813, 3463, 0, 10);
}
}
if (itemUsed == 5160 && usedWith == 34573) { //PapayaTree
if(player.HerbType > 0)
{
player.frames.sendMessage(player, "You can't plant more than one thing at a time.");
}
else
{
player.HerbloreTimer = 30;
player.HerbloreType = 8106;
player.HerbType = 2;
Engine.playerItems.deleteItem(player,5288, Engine.playerItems.getItemSlot(player, 5288), 1);
player.requestAnim(5212, 0);
player.createGlobalObject(8106, player.heightLevel, 2813, 3463, 0, 10);
}
}


//=======================================SMITHING =====================================
if (itemUsed == 308 && usedWith == 56332) {//Tin
player.frames.setString(player, "Smelt 1", 458, 1);
player.frames.setString(player, "Smelt 5", 458, 2);
player.frames.setString(player, "Smelt All", 458, 3);
player.frames.showChatboxInterface(player, 458);
player.SmithingXP = 50;
player.SmithingID = 436;
player.SmithingGet = 2349;
player.Smithing = true;
player.Cooking = false;
player.TalkAgent = false;
player.DecorChange = false;
}
if (itemUsed == 310 && usedWith == 56332) {//Copper
player.frames.setString(player, "Smelt 1", 458, 1);
player.frames.setString(player, "Smelt 5", 458, 2);
player.frames.setString(player, "Smelt All", 458, 3);
player.frames.showChatboxInterface(player, 458);
player.SmithingXP = 50;
player.SmithingID = 438;
player.SmithingGet = 2349;
player.Smithing = true;
player.Cooking = false;
player.TalkAgent = false;
player.DecorChange = false;
}
if (itemUsed == 312 && usedWith == 56332) {//Iron
player.frames.setString(player, "Smelt 1", 458, 1);
player.frames.setString(player, "Smelt 5", 458, 2);
player.frames.setString(player, "Smelt All", 458, 3);
player.frames.showChatboxInterface(player, 458);
player.SmithingXP = 100;
player.SmithingID = 440;
player.SmithingGet = 2351;
player.Smithing = true;
player.Cooking = false;
player.TalkAgent = false;
player.DecorChange = false;
}
if (itemUsed == 325 && usedWith == 56332) {//Coal
player.frames.setString(player, "Smelt 1", 458, 1);
player.frames.setString(player, "Smelt 5", 458, 2);
player.frames.setString(player, "Smelt All", 458, 3);
player.frames.showChatboxInterface(player, 458);
player.SmithingXP = 150;
player.SmithingID = 453;
player.SmithingGet = 2353;
player.Smithing = true;
player.Cooking = false;
player.TalkAgent = false;
player.DecorChange = false;
}
if (itemUsed == 316 && usedWith == 56332) {//Gold
player.frames.setString(player, "Smelt 1", 458, 1);
player.frames.setString(player, "Smelt 5", 458, 2);
player.frames.setString(player, "Smelt All", 458, 3);
player.frames.showChatboxInterface(player, 458);
player.SmithingXP = 200;
player.SmithingID = 444;
player.SmithingGet = 2357;
player.Smithing = true;
player.Cooking = false;
}

if (itemUsed == 319 && usedWith == 56332) {//Mith
player.frames.setString(player, "Smelt 1", 458, 1);
player.frames.setString(player, "Smelt 5", 458, 2);
player.frames.setString(player, "Smelt All", 458, 3);
player.frames.showChatboxInterface(player, 458);
player.SmithingXP = 300;
player.SmithingID = 447;
player.SmithingGet = 2359;
player.Smithing = true;
player.Cooking = false;
player.TalkAgent = false;
player.DecorChange = false;
}

if (itemUsed == 321 && usedWith == 56332) {//Addy
player.frames.setString(player, "Smelt 1", 458, 1);
player.frames.setString(player, "Smelt 5", 458, 2);
player.frames.setString(player, "Smelt All", 458, 3);
player.frames.showChatboxInterface(player, 458);
player.SmithingXP = 400;
player.SmithingID = 449;
player.SmithingGet = 2361;
player.Smithing = true;
player.Cooking = false;
player.TalkAgent = false;
player.DecorChange = false;
}

if (itemUsed == 323 && usedWith == 56332) {//Rune
player.frames.setString(player, "Smelt 1", 458, 1);
player.frames.setString(player, "Smelt 5", 458, 2);
player.frames.setString(player, "Smelt All", 458, 3);
player.frames.showChatboxInterface(player, 458);
player.SmithingXP = 500;
player.SmithingID = 451;
player.SmithingGet = 2363;
player.Smithing = true;
player.Cooking = false;
player.TalkAgent = false;
player.DecorChange = false;
}




//======================================= COOKING =====================================

if (itemUsed == 445 && usedWith == 28173) {
player.frames.setString(player, "Cook 1", 458, 1);
player.frames.setString(player, "Cook 5", 458, 2);
player.frames.setString(player, "Cook All", 458, 3);
player.frames.showChatboxInterface(player, 458);
player.CookXP = 50;
player.CookID = 317;
player.CookGet = 315;
player.Cooking = true;
player.Smithing = false;
player.TalkAgent = false;
player.DecorChange = false;
}


if (itemUsed == 463 && usedWith == 28173) {
if(player.skillLvl[7] < 15)
{
player.frames.sendMessage(player, "You need level 15 Cooking to cook this.");
}
else
{
player.frames.setString(player, "Cook 1", 458, 1);
player.frames.setString(player, "Cook 5", 458, 2);
player.frames.setString(player, "Cook All", 458, 3);
player.frames.showChatboxInterface(player, 458);
player.CookXP = 100;
player.CookID = 335;
player.CookGet = 333;
player.Cooking = true;
player.Smithing = false;
player.TalkAgent = false;
player.DecorChange = false;
}}
if (itemUsed == 491 && usedWith == 28173) {
if(player.skillLvl[7] < 30)
{
player.frames.sendMessage(player, "You need level 30 Cooking to cook this.");
}
else
{
player.frames.setString(player, "Cook 1", 458, 1);
player.frames.setString(player, "Cook 5", 458, 2);
player.frames.setString(player, "Cook All", 458, 3);
player.frames.showChatboxInterface(player, 458);
player.CookXP = 200;
player.CookID = 363;
player.CookGet = 365;
player.Cooking = true;
player.Smithing = false;
player.TalkAgent = false;
player.DecorChange = false;
}}

if (itemUsed == 505 && usedWith == 28173) {
if(player.skillLvl[7] < 50)
{
player.frames.sendMessage(player, "You need level 50 Cooking to cook this.");
}
else
{
player.frames.setString(player, "Cook 1", 458, 1);
player.frames.setString(player, "Cook 5", 458, 2);
player.frames.setString(player, "Cook All", 458, 3);
player.frames.showChatboxInterface(player, 458);
player.CookXP = 350;
player.CookID = 377;
player.CookGet = 379;
player.Cooking = true;
player.Smithing = false;
player.TalkAgent = false;
player.DecorChange = false;
}}

if (itemUsed == 511 && usedWith == 28173) {
if(player.skillLvl[7] < 79)
{
player.frames.sendMessage(player, "You need level 79 Cooking to cook this.");
}
else
{
player.frames.setString(player, "Cook 1", 458, 1);
player.frames.setString(player, "Cook 5", 458, 2);
player.frames.setString(player, "Cook All", 458, 3);
player.frames.showChatboxInterface(player, 458);
player.CookXP = 550;
player.CookID = 383;
player.CookGet = 385;
player.Cooking = true;
player.Smithing = false;
player.TalkAgent = false;
player.DecorChange = false;
}}

if (itemUsed == 261 && usedWith == 28173) {
if(player.skillLvl[7] < 90)
{
player.frames.sendMessage(player, "You need level 90 Cooking to cook this.");
}
else
{
player.frames.setString(player, "Cook 1", 458, 1);
player.frames.setString(player, "Cook 5", 458, 2);
player.frames.setString(player, "Cook All", 458, 3);
player.frames.showChatboxInterface(player, 458);
player.CookXP = 700;
player.CookID = 389;
player.CookGet = 391;
player.Cooking = true;
player.Smithing = false;
player.TalkAgent = false;
player.DecorChange = false;
}
}




		System.out.println("Used with: "+usedWith+" itemUsed: "+itemUsed);
	}

}