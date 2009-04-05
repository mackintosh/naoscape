
package Naoscape.io.packets;


import Naoscape.Engine;
import Naoscape.players.Player;
import Naoscape.util.Misc;
import Naoscape.Skills.*;


public class ObjectOption1 implements Packet {

    /**
     * make sure to document EVERY coordinate to go with each object unless an un-important object(wilderness ditch lol).
     * This will prevent people from spawning an object client side and actually using it.
     * So make sure to include with the id, objectX == # && objectY == #
     */

    public static int capes[] = {1052,6570,9747, 9748, 9750, 9751};

public static boolean cape(Player p)
{

if(Engine.playerItems.HasItemAmount(p, 1052, 1) || Engine.playerItems.HasItemAmount(p, 6570, 1) || Engine.playerItems.HasItemAmount(p, 6568, 1)
 || Engine.playerItems.HasItemAmount(p, 9747, 1) || Engine.playerItems.HasItemAmount(p, 9748, 1) || Engine.playerItems.HasItemAmount(p, 9750, 1)
 || Engine.playerItems.HasItemAmount(p, 9751, 1) || Engine.playerItems.HasItemAmount(p, 9753, 1) || Engine.playerItems.HasItemAmount(p, 9754, 1)
 || Engine.playerItems.HasItemAmount(p, 9756, 1) || Engine.playerItems.HasItemAmount(p, 9757, 1) || Engine.playerItems.HasItemAmount(p, 9759, 1)
 || Engine.playerItems.HasItemAmount(p, 9760, 1) || Engine.playerItems.HasItemAmount(p, 9762, 1) || Engine.playerItems.HasItemAmount(p, 9763, 1)
 || Engine.playerItems.HasItemAmount(p, 9765, 1) || Engine.playerItems.HasItemAmount(p, 9766, 1) || Engine.playerItems.HasItemAmount(p, 9767, 1)
 || Engine.playerItems.HasItemAmount(p, 9769, 1) || Engine.playerItems.HasItemAmount(p, 9771, 1) || Engine.playerItems.HasItemAmount(p, 9772, 1)
 || Engine.playerItems.HasItemAmount(p, 9774, 1) || Engine.playerItems.HasItemAmount(p, 9775, 1) || Engine.playerItems.HasItemAmount(p, 9777, 1)
 || Engine.playerItems.HasItemAmount(p, 9778, 1) || Engine.playerItems.HasItemAmount(p, 9780, 1) || Engine.playerItems.HasItemAmount(p, 9781, 1)
 || Engine.playerItems.HasItemAmount(p, 9783, 1) || Engine.playerItems.HasItemAmount(p, 9784, 1) || Engine.playerItems.HasItemAmount(p, 9786, 1)
 || Engine.playerItems.HasItemAmount(p, 9787, 1) || Engine.playerItems.HasItemAmount(p, 9789, 1) || Engine.playerItems.HasItemAmount(p, 9790, 1)
 || Engine.playerItems.HasItemAmount(p, 9792, 1) || Engine.playerItems.HasItemAmount(p, 9793, 1) || Engine.playerItems.HasItemAmount(p, 9795, 1)
 || Engine.playerItems.HasItemAmount(p, 9796, 1) || Engine.playerItems.HasItemAmount(p, 9798, 1) || Engine.playerItems.HasItemAmount(p, 9799, 1)
 || Engine.playerItems.HasItemAmount(p, 9801, 1) || Engine.playerItems.HasItemAmount(p, 9802, 1) || Engine.playerItems.HasItemAmount(p, 9804, 1)
 || Engine.playerItems.HasItemAmount(p, 9805, 1) || Engine.playerItems.HasItemAmount(p, 9807, 1) || Engine.playerItems.HasItemAmount(p, 9808, 1)
 || Engine.playerItems.HasItemAmount(p, 9810, 1) || Engine.playerItems.HasItemAmount(p, 9811, 1) || Engine.playerItems.HasItemAmount(p, 9813, 1)

 || Engine.playerItems.HasItemAmount(p, 1038, 1) || Engine.playerItems.HasItemAmount(p, 1040, 1) || Engine.playerItems.HasItemAmount(p, 1042, 1)
 || Engine.playerItems.HasItemAmount(p, 1044, 1) || Engine.playerItems.HasItemAmount(p, 1046, 1) || Engine.playerItems.HasItemAmount(p, 1048, 1)
 || Engine.playerItems.HasItemAmount(p, 1050, 1) || Engine.playerItems.HasItemAmount(p, 1053, 1) || Engine.playerItems.HasItemAmount(p, 1055, 1)
 || Engine.playerItems.HasItemAmount(p, 1057, 1) || Engine.playerItems.HasItemAmount(p, 1149, 1) || Engine.playerItems.HasItemAmount(p, 1155, 1)
 || Engine.playerItems.HasItemAmount(p, 1157, 1) || Engine.playerItems.HasItemAmount(p, 1159, 1) || Engine.playerItems.HasItemAmount(p, 1161, 1)
 || Engine.playerItems.HasItemAmount(p, 1163, 1) || Engine.playerItems.HasItemAmount(p, 1165, 1) || Engine.playerItems.HasItemAmount(p, 4716, 1)
 || Engine.playerItems.HasItemAmount(p, 4708, 1) || Engine.playerItems.HasItemAmount(p, 4724, 1) || Engine.playerItems.HasItemAmount(p, 4732, 1)
 || Engine.playerItems.HasItemAmount(p, 4745, 1) || Engine.playerItems.HasItemAmount(p, 4753, 1) || Engine.playerItems.HasItemAmount(p, 11335, 1)
 || Engine.playerItems.HasItemAmount(p, 10828, 1) || Engine.playerItems.HasItemAmount(p, 10334, 1) || Engine.playerItems.HasItemAmount(p, 10342, 1)
 || Engine.playerItems.HasItemAmount(p, 10350, 1) || Engine.playerItems.HasItemAmount(p, 2639, 1) || Engine.playerItems.HasItemAmount(p, 2641, 1)
 || Engine.playerItems.HasItemAmount(p, 2743, 1) || Engine.playerItems.HasItemAmount(p, 2581, 1) || Engine.playerItems.HasItemAmount(p, 12210, 1)
 || Engine.playerItems.HasItemAmount(p, 12213, 1) || Engine.playerItems.HasItemAmount(p, 12216, 1) || Engine.playerItems.HasItemAmount(p, 12219, 1)
 || Engine.playerItems.HasItemAmount(p, 12222, 1) || Engine.playerItems.HasItemAmount(p, 9749, 1) || Engine.playerItems.HasItemAmount(p, 9752, 1)
 || Engine.playerItems.HasItemAmount(p, 9755, 1) || Engine.playerItems.HasItemAmount(p, 9758, 1) || Engine.playerItems.HasItemAmount(p, 9761, 1)
 || Engine.playerItems.HasItemAmount(p, 9764, 1) || Engine.playerItems.HasItemAmount(p, 9767, 1) || Engine.playerItems.HasItemAmount(p, 9770, 1)
 || Engine.playerItems.HasItemAmount(p, 9773, 1) || Engine.playerItems.HasItemAmount(p, 9776, 1) || Engine.playerItems.HasItemAmount(p, 9779, 1)
 || Engine.playerItems.HasItemAmount(p, 9782, 1) || Engine.playerItems.HasItemAmount(p, 9785, 1) || Engine.playerItems.HasItemAmount(p, 9788, 1)
 || Engine.playerItems.HasItemAmount(p, 9791, 1) || Engine.playerItems.HasItemAmount(p, 9794, 1) || Engine.playerItems.HasItemAmount(p, 9797, 1)
 || Engine.playerItems.HasItemAmount(p, 9800, 1) || Engine.playerItems.HasItemAmount(p, 9803, 1) || Engine.playerItems.HasItemAmount(p, 9806, 1)
 || Engine.playerItems.HasItemAmount(p, 9809, 1) || Engine.playerItems.HasItemAmount(p, 9812, 1) || Engine.playerItems.HasItemAmount(p, 9814, 1)
)
{
return true;
}
else
{
return false;
}
}
    /**
     * Handles the first option on objects.
     * @param p The Player which the frame should be handled for.
     * @param packetId The packet id this belongs to.
     * @param packetSize The amount of bytes being recieved for this packet.
     */
    public void handlePacket(Player p, int packetId, int packetSize) {
        if (p == null || p.stream == null) {
            return;
        }
        if (!p.objectOption1) {
	p.wc.resetWoodcutting();
p.mi.resetMining();
            p.clickX = p.stream.readUnsignedWordBigEndian();
            p.clickId = p.stream.readUnsignedWord();
            p.clickY = p.stream.readUnsignedWordBigEndianA();


          if (Misc.getDistance(p.absX, p.absY, p.clickX, p.clickY) > 30) {
                return;
            }
            p.objectOption1 = true;
        }
        int distance = 0;

        if (p.walkDir != -1 || p.runDir != -1
                || distance > objectSize(p.clickId)) {
            return;
        }
        p.objectOption1 = false;

        switch (p.clickId) {


case 25213:
p.setCoords(3048, 3203, 0);
break;
case 3203:
p.frames.sendMessage(p, "You cannot forfeit yet.");
break;

case 30204:
p.setCoords(1675, 5599, 0);
p.frames.sendMessage(p, "You enter the GREAT Fist of Guthix!");
break;

case 30203:
p.setCoords(3242, 3574, 0);
p.frames.sendMessage(p, "You leave the fist of guthix...");
break;


case 36773:
if(p.absX == 3205 && p.absY == 3209 && p.heightLevel == 0)
{
p.setCoords(3205, 3209, 1);
}
break;
case 36774:
if(p.absX == 3205 && p.absY == 3209 && p.heightLevel == 1)
{
p.setCoords(3205, 3209, 0);
}
break;

case 36844:
if(p.absX == 3207 && p.absY == 3222)
{
p.setCoords(3208, 3222, 1);
}
if(p.absX == 3208 && p.absY == 3222)
{
p.setCoords(3207, 3222, 1);
}
break;

case 1805:
if(p.absX == 3191&& p.absY == 3363)
{
p.setCoords(3191, 3362, 0);
}
if(p.absX == 3191&& p.absY == 3362)
{
p.setCoords(3191, 3363, 0);
}
break;

case 26917:
if(p.absX == 3069 && p.absY == 3513)
{
p.setCoords(3069, 3514, 0);
}
if(p.absX == 3069&& p.absY == 3514)
{
p.setCoords(3069, 3513, 0);
}
break;

case 3192:
for(Player pg : Engine.players) {
if(pg != null)
{
p.setscores(pg);
}
}
p.frames.showInterface(p, 156);
p.frames.setString(p, "Top 30 Highscores", 156, 5);
p.frames.setString(p, "1: "+Engine.fileManager.placeN01+ " Lvls: "+Engine.fileManager.place01+" XP: " +Engine.fileManager.placeXP01, 156, 7);
p.frames.setString(p, "2: "+Engine.fileManager.placeN02+ " Lvls: "+Engine.fileManager.place02+" XP: " +Engine.fileManager.placeXP02, 156, 8);
p.frames.setString(p, "3: "+Engine.fileManager.placeN03+ " Lvls: "+Engine.fileManager.place03+" XP: " +Engine.fileManager.placeXP03, 156, 9);
p.frames.setString(p, "4: "+Engine.fileManager.placeN04+ " Lvls: "+Engine.fileManager.place04+" XP: " +Engine.fileManager.placeXP04, 156, 10);
p.frames.setString(p, "5: "+Engine.fileManager.placeN05+ " Lvls: "+Engine.fileManager.place05+" XP: " +Engine.fileManager.placeXP05, 156, 11);
p.frames.setString(p, "6: "+Engine.fileManager.placeN06+ " Lvls: "+Engine.fileManager.place06+" XP: " +Engine.fileManager.placeXP06, 156, 12);
p.frames.setString(p, "7: "+Engine.fileManager.placeN07+ " Lvls: "+Engine.fileManager.place07+" XP: " +Engine.fileManager.placeXP07, 156, 13);
p.frames.setString(p, "8: "+Engine.fileManager.placeN08+ " Lvls: "+Engine.fileManager.place08+" XP: " +Engine.fileManager.placeXP08, 156, 14);
p.frames.setString(p, "9: "+Engine.fileManager.placeN09+ " Lvls: "+Engine.fileManager.place09+" XP: " +Engine.fileManager.placeXP09, 156, 15);
p.frames.setString(p, "10: "+Engine.fileManager.placeN10+ " Lvls: "+Engine.fileManager.place10+" XP: " +Engine.fileManager.placeXP10, 156, 16);
p.frames.setString(p, "11: "+Engine.fileManager.placeN11+ " Lvls: "+Engine.fileManager.place11+" XP: " +Engine.fileManager.placeXP11, 156, 17);
p.frames.setString(p, "12: "+Engine.fileManager.placeN12+ " Lvls: "+Engine.fileManager.place12+" XP: " +Engine.fileManager.placeXP12, 156, 18);
p.frames.setString(p, "13: "+Engine.fileManager.placeN13+ " Lvls: "+Engine.fileManager.place13+" XP: " +Engine.fileManager.placeXP13, 156, 19);
p.frames.setString(p, "14: "+Engine.fileManager.placeN14+ " Lvls: "+Engine.fileManager.place14+" XP: " +Engine.fileManager.placeXP14, 156, 20);
p.frames.setString(p, "15: "+Engine.fileManager.placeN15+ " Lvls: "+Engine.fileManager.place15+" XP: " +Engine.fileManager.placeXP15, 156, 21);
p.frames.setString(p, "16: "+Engine.fileManager.placeN16+ " Lvls: "+Engine.fileManager.place16+" XP: " +Engine.fileManager.placeXP16, 156, 22);
p.frames.setString(p, "17: "+Engine.fileManager.placeN17+ " Lvls: "+Engine.fileManager.place17+" XP: " +Engine.fileManager.placeXP17, 156, 23);
p.frames.setString(p, "18: "+Engine.fileManager.placeN18+ " Lvls: "+Engine.fileManager.place18+" XP: " +Engine.fileManager.placeXP18, 156, 24);
p.frames.setString(p, "19: "+Engine.fileManager.placeN19+ " Lvls: "+Engine.fileManager.place19+" XP: " +Engine.fileManager.placeXP19, 156, 25);
p.frames.setString(p, "20: "+Engine.fileManager.placeN20+ " Lvls: "+Engine.fileManager.place20+" XP: " +Engine.fileManager.placeXP20, 156, 26);
p.frames.setString(p, "21: "+Engine.fileManager.placeN21+ " Lvls: "+Engine.fileManager.place21+" XP: " +Engine.fileManager.placeXP21, 156, 27);
p.frames.setString(p, "22: "+Engine.fileManager.placeN22+ " Lvls: "+Engine.fileManager.place22+" XP: " +Engine.fileManager.placeXP22, 156, 28);
p.frames.setString(p, "23: "+Engine.fileManager.placeN23+ " Lvls: "+Engine.fileManager.place23+" XP: " +Engine.fileManager.placeXP23, 156, 29);
p.frames.setString(p, "24: "+Engine.fileManager.placeN24+ " Lvls: "+Engine.fileManager.place24+" XP: " +Engine.fileManager.placeXP24, 156, 30);
p.frames.setString(p, "25: "+Engine.fileManager.placeN25+ " Lvls: "+Engine.fileManager.place25+" XP: " +Engine.fileManager.placeXP25, 156, 31);
p.frames.setString(p, "26: "+Engine.fileManager.placeN26+ " Lvls: "+Engine.fileManager.place26+" XP: " +Engine.fileManager.placeXP26, 156, 32);
p.frames.setString(p, "27: "+Engine.fileManager.placeN27+ " Lvls: "+Engine.fileManager.place27+" XP: " +Engine.fileManager.placeXP27, 156, 33);
p.frames.setString(p, "28: "+Engine.fileManager.placeN28+ " Lvls: "+Engine.fileManager.place28+" XP: " +Engine.fileManager.placeXP28, 156, 34);
p.frames.setString(p, "29: "+Engine.fileManager.placeN29+ " Lvls: "+Engine.fileManager.place29+" XP: " +Engine.fileManager.placeXP29, 156, 35);
p.frames.setString(p, "30: "+Engine.fileManager.placeN30+ " Lvls: "+Engine.fileManager.place30+" XP: " +Engine.fileManager.placeXP30, 156, 36);
p.frames.setString(p, "", 156, 37);
p.frames.setString(p, "", 156, 38);
p.frames.setString(p, "", 156, 39);
p.frames.setString(p, "", 156, 40);
p.frames.setString(p, "", 156, 41);
p.frames.setString(p, "", 156, 42);
p.frames.setString(p, "", 156, 43);
p.frames.setString(p, "", 156, 44);
p.frames.setString(p, "", 156, 45);
p.frames.setString(p, "", 156, 46);
p.frames.setString(p, "", 156, 47);
p.frames.setString(p, "", 156, 48);
p.frames.setString(p, "", 156, 49);
p.frames.setString(p, "", 156, 50);
p.frames.setString(p, "", 156, 51);
p.frames.setString(p, "", 156, 52);
p.frames.setString(p, "", 156, 53);
p.frames.setString(p, "", 156, 54);
p.frames.setString(p, "", 156, 55);
p.frames.setString(p, "", 156, 56);
p.frames.setString(p, "", 156, 57);
p.frames.setString(p, "", 156, 58);
p.frames.setString(p, "", 156, 59);
p.frames.setString(p, "", 156, 60);
p.frames.setString(p, "", 156, 61);
p.frames.setString(p, "", 156, 62);
p.frames.setString(p, "", 156, 63);
p.frames.setString(p, "", 156, 64);
p.frames.setString(p, "", 156, 65);
p.frames.setString(p, "", 156, 66);
p.frames.setString(p, "", 156, 67);
p.frames.setString(p, "", 156, 68);
p.frames.setString(p, "", 156, 69);
p.frames.setString(p, "", 156, 70);
p.frames.setString(p, "", 156, 71);
p.frames.setString(p, "", 156, 72);
p.frames.setString(p, "", 156, 73);
p.frames.setString(p, "", 156, 74);
p.frames.setString(p, "", 156, 75);
p.frames.setString(p, "", 156, 76);
p.frames.setString(p, "", 156, 77);
p.frames.setString(p, "", 156, 78);
p.frames.setString(p, "", 156, 79);
p.frames.setString(p, "", 156, 80);
p.frames.setString(p, "", 156, 81);
p.frames.setString(p, "", 156, 82);
p.frames.setString(p, "", 156, 83);
p.frames.setString(p, "", 156, 84);
p.frames.setString(p, "", 156, 85);
p.frames.setString(p, "", 156, 86);
p.frames.setString(p, "", 156, 87);
p.frames.setString(p, "", 156, 88);
p.frames.setString(p, "", 156, 89);
p.frames.setString(p, "", 156, 90);
p.frames.setString(p, "", 156, 91);
p.frames.setString(p, "", 156, 92);
p.frames.setString(p, "", 156, 93);
p.frames.setString(p, "", 156, 94);
p.frames.setString(p, "", 156, 95);
p.frames.setString(p, "", 156, 96);
break;
case 9369:
if(p.absX == 2399 && p.absY == 5177)
{
p.setCoords(2399, 5175,0);
p.OverTimer = 5;
p.frames.setOverlay(p, 653);
}
if(p.absX == 2399 && p.absY == 5175)
{
p.setCoords(2399, 5177,0);
p.OverTimer = 5;
p.frames.removeOverlay(p);
}

break;
case 9368:
if(p.absX == 2399 && p.absY == 5167)
{
p.setCoords(2399, 5169,0);
p.OverTimer = 5;
}
break;


case 28140:
p.ResetClanWars();
break;
case 28214:

if(!p.AtClanField())
{
p.frames.showInterface(p, 120);
p.JadTele = 4; 
p.frames.showChatboxInterface(p, 241);
p.frames.animateInterfaceId(p, 9837, 241, 2);
p.frames.setNPCId(p, 6537, 241, 2);
p.frames.setString(p, "", 241, 3);
p.frames.setString(p, "Hah, you won't last 2 minutes...", 241, 4);
p.frames.sendMessage(p, "Welcome to Tzhaar, fight Tztok-Jad or enjoy the fight pits.");
}
else
{
if(p.ClanSide == 0)
{
p.setCoords(3272, 3675, 0);
}
if(p.ClanSide == 1)
{
p.setCoords(3273, 3692, 0);
}
}
break;

case 28213:
if(!p.AtClanLobby())
{
p.frames.showInterface(p, 120);
p.ClanTele = 4; 
p.frames.showChatboxInterface(p, 241);
p.frames.animateInterfaceId(p, 9850, 241, 2);
p.frames.setNPCId(p, 6537, 241, 2);
p.frames.setString(p, "", 241, 3);
p.frames.setString(p, "Enjoy your gang fights...", 241, 4);
p.frames.sendMessage(p, "Use ::joinchat [playername] to join a clan.");
}
else
{
if(p.ClanBattle == true)
{
if(p.ClanTimer == -1)
{
p.frames.sendMessage(p, "Game has already  begun.");
}else
if(p.ClanSide == 0)
{
p.setCoords(3299, 3722, p.clanheight);
}
else if(p.ClanSide == 1)
{
p.setCoords(3291, 3830, p.clanheight);
}
}
else
{
p.frames.sendMessage(p, "Your clan has not challenged any one yet.");
}
}
break;

//=============================CONSTRUCTION===============================

case 13161:
p.frames.showInterface(p, 591);
break;
case 15482:
p.InHouse = true;
p.OwnHouse = true;
p.HouseHeight = p.playerId*4;
p.frames.showInterface(p, 399);
p.HouseTele = 6;
p.setCoords(3104, 3926, p.HouseHeight);
p.frames.showInterface(p, 399);

break;

case 13405:
p.KickPlayers = false;
p.BuildingMode = false;
p.setCoords(2544, 3096, 0);
break;

//=======================END OF CONSTRUCTION==========================
case 7871:
p.HerbType = 0;
p.requestAnim(5212, 0);
p.addSkillXP(250*p.skillLvl[19], 19);
Engine.playerItems.addItem(p, 6010, 1);
p.createGlobalObject(7843, p.heightLevel, 2809, 3463, 0, 10);
break;

case 7855:
p.HerbType = 0;
p.requestAnim(5212, 0);
p.addSkillXP(750*p.skillLvl[19], 19);
Engine.playerItems.addItem(p, 225, 1);
p.createGlobalObject(7843, p.heightLevel, 2809, 3463, 0, 10);
break;

case 8111:
p.HerbType = 0;
p.requestAnim(5212, 0);
p.addSkillXP(1000*p.skillLvl[19], 19);
Engine.playerItems.addItem(p, 5972, 1);
p.createGlobalObject(8135, p.heightLevel, 2813, 3463, 0, 10);
break;

case 7941:
p.HerbType = 0;
p.requestAnim(5212, 0);
p.addSkillXP(500*p.skillLvl[19], 19);
Engine.playerItems.addItem(p, 1955, 1);
p.createGlobalObject(8135, p.heightLevel, 2813, 3463, 0, 10);
break;


case 28716:
if (distance > 0 && (p.walkDir > 0 || p.runDir > 0) || distance != 0 && p.walkDir <= 0 && p.runDir <= 0) {
		p.frames.showInterface(p, 669);
              return;
}

case 28714:
if (distance > 0 && (p.walkDir > 0 || p.runDir > 0) || distance != 0 && p.walkDir <= 0 && p.runDir <= 0) {
p.teleportTo(2926, 3444, 0, 4, 4, 8939, 8941, 1576, 0, 1577, 0);
}
break;

case 6282:
  p.frames.showInterface(p, 120);

                    p.PkTimer = 4; 
p.frames.showChatboxInterface(p, 241);
p.frames.animateInterfaceId(p, 9827, 241, 2);
p.frames.setNPCId(p, 6537, 241, 2);
p.frames.setString(p, "", 241, 3);
p.frames.setString(p, "Ready to die??", 241, 4);
break;

case 8132:
p.Smithing = false;
p.Cooking = false;
p.Farm = true;
p.frames.setString(p, "Grow Apple Tree", 458, 1);
p.frames.setString(p, "Grow Spirit Tree", 458, 2);
p.frames.setString(p, "Grow Papaya Tree", 458, 3);
p.frames.showChatboxInterface(p, 458);
break;

case 2282://Rope Swing
if(p.absX == 2551 && p.absY == 3554)
{
p.chatText = "Heck no!";
p.chatTextUpdateReq = true;
p.updateReq = true;
p.SwingTimer1 = 2;
p.isRunning = true;
}
break;

case 2294://Log
if(p.absX == 2551 && p.absY == 3546)
{
p.LogTimer = 4;
p.AgilityXP = 250;
p.AgilityTimer = 12;
p.jumpDelay = 12;
p.NewEmote = 844;
p.isRunning = false;
p.reqWalkQueue(2541,3546);
}
break;

case 20211://Obstacle Net
if(p.absX == 2539 && p.absY == 3546 || p.absX == 2539 && p.absY == 3545)
{
p.AgilityXP = 400;
p.AgilityTimer = 6;
p.NetTimer = 4;
p.requestAnim(3063, 0);
}
break;

case 2302://WallSlide
if(p.absX == 2536 && p.absY == 3547)
{
p.AgilityXP = 200;
p.AgilityTimer = 5;
p.jumpDelay = 5;
p.NewEmote = 756;
p.isRunning = false;
p.reqWalkQueue(2532,3547);
}
break;

case 3205:
p.setCoords(2532, 3546, 0);
break;

case 1948:
if(p.AgilityTimer == -1)
{
if(p.absX == 2535 && p.absY == 3553)
{
p.wallTimer1 = 1;
p.NewEmote = 839;
}
if(p.absX == 2538 && p.absY == 3553)
{
p.wallTimer2 = 1;
p.NewEmote = 839;
}
if(p.absX == 2541 && p.absY == 3553)
{
p.wallTimer3 = 1;
p.NewEmote = 839;
}
}
break;


case 25161:
if(p.AgilityTimer == -1)
{
if(p.absX == 2845 && p.absY == 9635 || p.absX == 2845 && p.absY == 9636)
{
p.wallTimer4 = 1;
p.NewEmote = 839;
}
if(p.absX == 2847 && p.absY == 9635 || p.absX == 2847 && p.absY == 9636)
{
p.wallTimer5 = 1;
p.NewEmote = 839;
}
}
break;

case 2484:
if(p.ActionTimer == 0)
{
p.ActionTimer = 3;
p.requestAnim(791, 0);
Engine.playerItems.addItem(p, 554+Misc.random(12), Misc.random(30));
p.addSkillXP(75*p.skillLvl[20] ,20);
p.frames.sendMessage(p, "You make some runes...");
}
break;

case 2471:
p.setCoords(2605, 3092, 0);
break;





case 4387://cw sara portal
if(p.equipment[1] > 0 && p.equipmentN[1] > 0) 
{ 
p.frames.sendMessage(p, "You cannot be wearing a cape.");
}
else
if(p.equipment[0] > 0 && p.equipmentN[0] > 0) 
{ 
p.frames.sendMessage(p, "You cannot be wearing anything on your head.");
}
else
if(Engine.CWGameTime > 0)
{ 
p.frames.sendMessage(p, "Game has already begun.");
}
else
if(cape(p) == true)
{
p.frames.sendMessage(p, "You cannot bring capes or hats into the game.");
}
else if(Engine.ZamorakTeam < Engine.SaradominTeam)
{
p.frames.sendMessage(p, "This team has more players than the other.");
}
else
{
p.equipment[1] = 4041; 
p.equipmentN[1] = 1; 
p.appearanceUpdateReq = true; 
p.updateReq = true; 
p.frames.setItems(p, 387, 28, 94, p.equipment, p.equipmentN);
p.setCoords(2377+Misc.random(4), 9486+Misc.random(4), 0);
p.frames.sendMessage(p, "You join Saradomin's side.");
}

break;
case 25808:
case 4483:
p.openBank();
break;
case 4408:
if(p.equipment[1] > 0 && p.equipmentN[1] > 0) 
{ 
p.frames.sendMessage(p, "You cannot be wearing a cape.");
}
else
if(p.equipment[0] > 0 && p.equipmentN[0] > 0) 
{ 
p.frames.sendMessage(p, "You cannot be wearing anything on your head.");
}
else
if(Engine.CWGameTime > 0) 
{ 
p.frames.sendMessage(p, "Game has already begun.");
}
else
if(cape(p) == true)
{
p.frames.sendMessage(p, "You cannot bring capes or hats into the game.");
}
else
{
if(Engine.ZamorakTeam > Engine.SaradominTeam || Engine.ZamorakTeam == Engine.SaradominTeam)
{
p.equipment[1] = 4041; 
p.equipmentN[1] = 1; 
p.appearanceUpdateReq = true; 
p.updateReq = true; 
p.frames.setItems(p, 387, 28, 94, p.equipment, p.equipmentN);
p.setCoords(2377+Misc.random(4), 9486+Misc.random(4), 0);
p.frames.sendMessage(p, "You join Saradomin's side..");
}
else if(Engine.ZamorakTeam < Engine.SaradominTeam)
{
p.equipment[1] = 4042; 
p.equipmentN[1] = 1; 
p.appearanceUpdateReq = true; 
p.updateReq = true; 
p.frames.setItems(p, 387, 28, 94, p.equipment, p.equipmentN);
p.setCoords(2420+Misc.random(4), 9521+Misc.random(4), 0);
p.frames.sendMessage(p, "You join Zamorak's side..");
}
}
break;
case 4388:
if(p.equipment[1] > 0 && p.equipmentN[1] > 0) 
{ 
p.frames.sendMessage(p, "You cannot be wearing a cape.");
}
else
if(p.equipment[0] > 0 && p.equipmentN[0] > 0) 
{ 
p.frames.sendMessage(p, "You cannot be wearing anything on your head.");
}
else
if(Engine.CWGameTime > 0) 
{ 
p.frames.sendMessage(p, "Game has already begun.");
}
else
if(cape(p) == true)
{
p.frames.sendMessage(p, "You cannot bring capes or hats into the game.");
}
else if(Engine.ZamorakTeam < Engine.SaradominTeam)
{
p.frames.sendMessage(p, "This team has more players than the other.");
}
else
{
p.equipment[1] = 4042; 
p.equipmentN[1] = 1; 
p.appearanceUpdateReq = true; 
p.updateReq = true; 
p.frames.setItems(p, 387, 28, 94, p.equipment, p.equipmentN);
p.setCoords(2420+Misc.random(4), 9521+Misc.random(4), 0);
p.frames.sendMessage(p, "You join Zamorak's side..");
}
break;



case 4902:
if(p.CWTeam == 0 && p.equipment[3] == 4039)
{
Engine.SaradominScore += 1;
Engine.ZamorakFlag = false;
Engine.ZamorakP = 0;
p.equipment[3] = -1; 
p.equipmentN[3] = 0; 
p.appearanceUpdateReq = true; 
p.updateReq = true; 
p.frames.setItems(p, 387, 28, 94, p.equipment, p.equipmentN);
for(Player pg : Engine.players) {
p.frames.sendMessage(pg, p.username+" scored a point for Saradomin.");
}
}
else
if(Engine.SaradominFlag == true)
{
p.frames.sendMessage(p, "The flag has already been taken.");
}
else
if(p.CWTeam == 1)
{
Engine.SaradominP = p.playerId;
Engine.SaradominFlag = true;
Engine.playerItems.addItem(p, p.equipment[3], 1);
p.equipment[3] = 4037; 
p.equipmentN[3] = 1; 
p.appearanceUpdateReq = true; 
p.updateReq = true; 
p.frames.setItems(p, 387, 28, 94, p.equipment, p.equipmentN);
p.frames.sendMessage(p, "You take Saradomin's flag.");
}
else
{
p.frames.sendMessage(p, "This is your flag.");
}
break;

case 4903:
if(p.CWTeam == 1 && p.equipment[3] == 4037)
{
Engine.ZamorakScore += 1;
Engine.SaradominFlag = false;
Engine.SaradominP = 0;
p.equipment[3] = -1; 
p.equipmentN[3] = 0; 
p.appearanceUpdateReq = true; 
p.updateReq = true; 
p.frames.setItems(p, 387, 28, 94, p.equipment, p.equipmentN);
for(Player pg : Engine.players) {
p.frames.sendMessage(pg, p.username+" scored a point for Zamorak.");
}
}
else
if(Engine.ZamorakFlag == true)
{
p.frames.sendMessage(p, "The flag has already been taken.");
}
else
if(p.CWTeam == 0)
{
Engine.ZamorakP = p.playerId;
Engine.ZamorakFlag = true;
Engine.playerItems.addItem(p, p.equipment[3], 1);
p.equipment[3] = 4039; 
p.equipmentN[3] = 1; 
p.appearanceUpdateReq = true; 
p.updateReq = true; 
p.frames.setItems(p, 387, 28, 94, p.equipment, p.equipmentN);
p.frames.sendMessage(p, "You take Zamorak's flag.");
}
else
{
p.frames.sendMessage(p, "This is your flag.");
}
break;

case 4407:
case 4390:
case 4406:
case 4389:
p.setCoords(2440+Misc.random(4), 3085+Misc.random(10), 0);
p.OverTimer = 2;
p.equipment[1] = -1; 
p.equipmentN[1] = 0; 
p.appearanceUpdateReq = true; 
p.updateReq = true; 
p.frames.setItems(p, 387, 28, 94, p.equipment, p.equipmentN);
if(p.equipment[3] == 4037 && p.CWTeam == 1)
{
Engine.SaradominFlag = false;
p.equipment[3] = -1; 
p.equipmentN[3] = 0; 
p.appearanceUpdateReq = true; 
p.updateReq = true; 
p.frames.setItems(p, 387, 28, 94, p.equipment, p.equipmentN);
}
if(p.equipment[3] == 4039 && p.CWTeam == 0)
{
Engine.ZamorakFlag = false;
p.equipment[3] = -1; 
p.equipmentN[3] = 0; 
p.appearanceUpdateReq = true; 
p.updateReq = true; 
p.frames.setItems(p, 387, 28, 94, p.equipment, p.equipmentN);
}
break;

case 4484:
p.frames.showChatboxInterface(p, 55);
p.frames.setString(p, "Saradomin: "+Engine.SaradominScore, 55, 1);
p.frames.setString(p, "Zamorak: "+Engine.ZamorakScore, 55, 2);
break;

case 26972:
case 28089:
case 2213:
p.openBank();
break;
case 36575://Barricade table (saradomin)
Engine.playerItems.addItem(p, 4053, 1);
break;
case 36582://Barricade table (zamorak)
Engine.playerItems.addItem(p, 4053, 1);
break;
case 36577://Explode potion table(saradomin)
Engine.playerItems.addItem(p, 4045, 1);
break;

case 36584://Explode potion table(zamorak)
Engine.playerItems.addItem(p, 4045, 1);
break;

case 36576://Rope table(saradomin)
Engine.playerItems.addItem(p, 954, 1);
break;
case 36583://Rope table(zamorak)
Engine.playerItems.addItem(p, 954, 1);
break;


case 36573:// Toolkit table (saradomin)
Engine.playerItems.addItem(p, 4051, 1);
break;
case 36580:// Toolkit table (zamorak)
Engine.playerItems.addItem(p, 4051, 1);
break;

case 36574:// Rock table(saradomin)
Engine.playerItems.addItem(p, 4043, 1);
break;
case 36581:// Rock table(zamorak)
Engine.playerItems.addItem(p, 4043, 1);
break;
case 36585:// pick table(zamorak)
Engine.playerItems.addItem(p, 1265, 1);
break;

case 36578:
Engine.playerItems.addItem(p, 1265, 1);
break;


case 4469://cw sara barrier 
if(p.absX == 2426 && p.absY == 3080)
{
p.setCoords(2426, 3081, 1);
}
if(p.absX == 2426 && p.absY == 3081 && p.CWTeam == 0)
{
p.setCoords(2426, 3080, 1);
}
if(p.absX == 2423 && p.absY == 3076)
{
p.setCoords(2422, 3076, 1);
}
if(p.absX == 2422 && p.absY == 3076 && p.CWTeam == 0)
{
p.setCoords(2423, 3076, 1);
}
break;

case 36484://cw sara stairs
p.setCoords(2426, 3074, 3);
break;
case 4470://cw zammy barrier 
if(p.absX == 2373 && p.absY == 3127)
{
p.setCoords(2373, 3126, 1);
}
if(p.absX == 2373 && p.absY == 3126 && p.CWTeam == 1)
{
p.setCoords(2373, 3127, 1);
}
if(p.absX == 2376 && p.absY == 3131)
{
p.setCoords(2377, 3131, 1);
}
if(p.absX == 2377 && p.absY == 3131 && p.CWTeam == 1)
{
p.setCoords(2376, 3131, 1);
}
break;


case 4467://zammy door
if(p.absX == 2385 && p.absY == 3134)
{
p.setCoords(2384, 3134, 0);
}
if(p.absX == 2384 && p.absY == 3134)
{
p.setCoords(2385, 3134, 0);
}
break;
case 36521://cw zammy stairs
p.setCoords(2369, 3127, 2);
break;



case 36540:
case 4415://cw sara down staircase
if(p.absX == 2420 && p.absY == 3080)
{
p.setCoords(2419, 3077, 0);
}
if(p.absX == 2430 && p.absY == 3080)
{
p.setCoords(2427, 3081, 1);
}
if(p.absX == 2426 && p.absY == 3074)
{
p.setCoords(2425, 3077, 2);
}
if(p.absX == 2416 && p.absY == 3075)
{
p.setCoords(2417, 3078, 0);
}
if(p.absX == 2382 && p.absY == 3129)
{
p.setCoords(2383, 3132, 0);
}
if(p.absX == 2379 && p.absY == 3127)
{
p.setCoords(2380, 3130, 0);
}
if(p.absX == 2369 && p.absY == 3127)
{
p.setCoords(2372, 3126, 1);
}
if(p.absX == 2373 && p.absY == 3133)
{
p.setCoords(2374, 3130, 2);
}
if(p.absX == 2383 && p.absY == 3132)
{
p.setCoords(2382, 3129, 0);
}
break;


case 36532://cw zammy up staircase
p.setCoords(2379, 3127, 1);
break;

case 36523://cw zammy  stairs
p.setCoords(2373, 3133, 3);
break;

case 36480://cw sara up steps
p.setCoords(2430, 3080, 2);
break;



case 4465://cw sara door(unlock)
if(p.absX == 2414 && p.absY == 3073)
{
p.setCoords(2415, 3073, 0);
}
if(p.absX == 2415 && p.absY == 3073)
{
p.setCoords(2414, 3073, 0);
}
break;

case 36579://cw sara bandages
Engine.playerItems.addItem(p, 4049, 1);
p.requestAnim(881, 0);
break;
case 36586://cw zammy bandages
Engine.playerItems.addItem(p, 4049, 1);
p.requestAnim(881, 0);
break;



case 36481://cw sara steps(to catapult)
p.setCoords(2415, 3075, 0);
break;

case 36495://cw sara steps(to starting room)
p.setCoords(2420, 3080, 1);
break;

	case 1276:
				 case 1277:
				  case 1278:
				   case 1279:
				    case 1280:
				     case 1282:
				      case 1283:
				       case 1284:
				        case 1285:
				         case 1286:
				          case 1289:
				           case 1290: 
				            case 1291:
				             case 1315:
				              case 1316:
				               case 1318:
				                case 1319:
				                case 1330:		
				               case 1331:
				              case 1332: 
				             case 1365:
				            case 1383:  
				           case 1384:
				          case 2409: 
				         case 3033:
				        case 3034:
				       case 3035: 
				      case 3036:	
				     case 3881:
				    case 3882:		
				   case 3883:  
				  case 5902:
				 case 5903:  
				case 5904: /* Normal */
				case 1308:
				case 5551:
				case 5552:
				case 5553:/* Willow */
				case 1281:
				case 3037:/* Oak */
				case 1292: 
				case 1306:/* Magic */
				case 1307:
				case 4674:/* Maple */
				case 9034:/* Mahogany */
				case 9036:/* Teak */
				case 2023: /* Achey */
				case 1309: /* Yews */
					p.wc = new Woodcutting(p);
					p.wc.startCutting(p.clickId);
				break; 
				case 2110:
				case 2090:
				case 11189:
				case 11190:
				case 11191:
				case 2091:/* Copper */
				case 2094:
				case 11186:
				case 11187:
				case 11188:
				case 2095:/* Tin */
				case 2092:
				case 2093:/* Iron */
				case 2100:
				case 2101:/* Silver */
				case 2098:
				case 11183:
				case 11184:
				case 11185:
				case 2099:/* Gold */
				case 2096:
				case 2097:/* Coal */
				case 2102:
				case 2103:/* Mithril */
				case 2104:
				case 2105:/* Adamantite */
				case 2106:
				case 2107:/* Rune */
				case 4028:
				case 4029: 
				case 4030:/* Limestone( */
				case 6669:
				case 6670: 
				case 6671:/* Elemental */
					p.mi = new Mining(p);
					p.mi.startCutting(p.clickId);
				break;


        case 23271:
            p.jumpDelay = 3;
            if (p.absY > p.clickY) {
                p.reqWalkQueue(p.absX, p.clickY - 1);
            }
            if (p.absY < p.clickY) {
                p.reqWalkQueue(p.absX, p.clickY + 2);
            }
            break;

        default:
            Misc.println("[" + p.username + "] Unhandled object 1: " + p.clickId);
            break;
        }
    }

    private int objectSize(int id) {
        switch (id) {
        case 23271:
            return 2;

        default:
            return 1;
        }
    }
}
