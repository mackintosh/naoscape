/*
Created by Bulby
 */

package Naoscape.io.packets;


import java.io.BufferedWriter;
import java.io.FileWriter;
import Naoscape.Server;
import Naoscape.Engine;
import Naoscape.players.Player;
import Naoscape.util.Misc;


public class Commands implements Packet {

    /**
     * Handles commands, chat text that starts with ::.
     * @param p The Player which the frame should be handled for.
     * @param packetId The packet id this belongs to.
     * @param packetSize The amount of bytes being recieved for this packet.
     */

public int[] quests = new int[500];
    public void handlePacket(Player p, int packetId, int packetSize) {
        if (p == null || p.stream == null) {
            return;
        }
        try {
            String playerCommand = p.stream.readString().toLowerCase();
            String[] cmd = playerCommand.split(" ");
			
			if (p.rights >= 0) {

	if (cmd[0].startsWith("zammyscore")) {
					p.ZamFL ++;
					p.frames.setString(p, "Zamorak = "+p.ZamFL, 58, 0);
				}
				else if (cmd[0].startsWith("cw")) {
                p.setCoords(2442, 3090, 0);
				}
else if (cmd[0].startsWith("trade")) {
p.openTrade();
}
				else if (cmd[0].startsWith("suggestion")) {
				String suggestionText = playerCommand.substring(11);
				if (p.suggestionTimer > 0) {
				p.frames.sendMessage(p, "You must wait another " + p.suggestionTimer + " seconds before you can suggest again.");
				}
				else { 
				Engine.fileManager.appendData("Suggestions/Suggestions.txt", "[" + Misc.getDate() + "] " + p.username + ": " + suggestionText);
				p.frames.sendMessage(p, "Your suggestion has been recieved.");
				p.suggestionTimer = 10;
				}
				}

				else if (cmd[0].startsWith("reportbug")) {
				String suggestionText = playerCommand.substring(9);
				if (p.suggestionTimer > 0) {
				p.frames.sendMessage(p, "You must wait another " + p.suggestionTimer + " seconds before you can report a bug again.");
				}
				else { 
				Engine.fileManager.appendData("Suggestions/BugReports.txt", "[" + Misc.getDate() + "] " + p.username + ": " + suggestionText);
				p.frames.sendMessage(p, "Your Abuse Report has been recieved.");
				p.suggestionTimer = 10;
				}
				}

				else if (cmd[0].startsWith("reportabuse")) {
				String suggestionText = playerCommand.substring(11);
				if (p.suggestionTimer > 0) {
				p.frames.sendMessage(p, "You must wait another " + p.suggestionTimer + " seconds before you can report abuse again.");
				}
				else { 
				Engine.fileManager.appendData("Suggestions/AbuseReports.txt", "[" + Misc.getDate() + "] " + p.username + ": " + suggestionText);
				p.frames.sendMessage(p, "Your Bug Report has been recieved.");
				p.suggestionTimer = 10;
				}
				}
		
		else if (cmd[0].equals("wildy")) {
                    p.teleportTo(3243, 3516, 0, 4, 0, 8939, 8941, 1576, 0, 1577,
                            0);


	}

else if (cmd[0].equals("gog")) {
p.frames.showInterface(p, 132);
p.frames.setString(p, "test", 132, 0);
p.frames.setString(p, "test1", 132, 1);
p.frames.setString(p, "test2", 132, 2);
p.frames.setString(p, "test3", 132, 3);
p.frames.setString(p, "test4", 132, 4);
p.frames.setString(p, "test5", 132, 5);
p.frames.setString(p, "test6", 132, 6);
p.frames.setString(p, "test7", 132, 7);
p.frames.setString(p, "test8", 132, 8);
p.frames.setString(p, "test9", 132, 9);
p.frames.setString(p, "test10", 132, 10);
p.frames.setString(p, "test11", 132, 11);
p.frames.setString(p, "test12", 132, 12);
p.frames.setString(p, "test13", 132, 13);
p.frames.setString(p, "test14", 132, 14);
p.frames.setString(p, "test15", 132, 15);
p.frames.setString(p, "test16", 132, 16);
p.frames.setString(p, "test17", 132, 17);
p.frames.setString(p, "test18", 132, 18);
p.frames.setString(p, "test19", 132, 19);
p.frames.setString(p, "test20", 132, 20);
p.frames.setString(p, "test21", 132, 21);
p.frames.setString(p, "test22", 132, 22);
p.frames.setString(p, "test23", 132, 23);
p.frames.setString(p, "test24", 132, 43);
p.frames.setString(p, "test25", 132, 45);
}


else if (cmd[0].equals("count")) {
p.frames.sendMessage(p, "Your clan count is: "+p.ClanCount);
}
			
else if (cmd[0].equals("goinhouse")) {
if(p.absX >= 3093 && p.absY >= 3920 && p.absX <= 3120 && p.absY <= 3950)
{
p.frames.sendMessage(p, "You must leave the current house you are in.");
}
else
{
String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
Player p2 = Engine.players[Engine.getIdFromName(person)];

if(p2.playerId == p.playerId)
{
p.frames.sendMessage(p, "You must use the house portal to go in your own house.");
}
else
if (p2 == null) {
p.frames.sendMessage(p, person+" is offline.");
}
else
if(p2.BuildingMode == true)
{
p.frames.sendMessage(p, p2.username+" is in Building Mode.");
}
else
{
p.PersonHouse = p2.playerId;
p.frames.sendMessage(p, "You enter "+ p2.username+"'s house.");
p.InHouse = true;
p.OwnHouse = false;
p.frames.showInterface(p, 399);
p.HouseTele = 6;
p.setCoords(3104, 3926, p2.HouseHeight);
}
}

				
                } else if (cmd[0].equals("whereis")) {
String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
Player p2 = Server.engine.players[Engine.getIdFromName(person)];
if (p2 != null) {
p.frames.sendMessage(p, person+" is located at: "+p2.LocatedAt);
}
else
{
p.frames.sendMessage(p, person+" is offline.");
}

} else if (cmd[0].equals("savebackup")) {
Engine.fileManager.savebackup(p);

} else if (cmd[0].equals("loadbackup")) {
Engine.fileManager.loadbackup(p);
p.LoadedBackup = 1200;
p.frames.setItems(p, 387, 28, 94, p.equipment, p.equipmentN);
                p.appearanceUpdateReq = true;
                p.updateReq = true;



//======================================CLAN CHAT===========================================

                } else if (cmd[0].equals("joinchat")) {
String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
Player p2 = Server.engine.players[Engine.getIdFromName(person)];	

if(p2.playerId == p.playerId)
{
p.frames.sendMessage(p, "You are the owner of this channel..");
p.frames.sendMessage(p, "Use ::clanname [newname] to change the name.");
}	
if(p2 != null)
{
p.clanchat = p2.clanchannel;
p.frames.sendMessage(p, "You are now talking in: "+p2.clanname);
p.frames.sendMessage(p, "Use / [message] to talk.");
p.frames.sendMessage(p, "To leave this chat use ::leavechat");
}		
else
{
p.frames.sendMessage(p, "That channel does not exist.");
}

 } else if (cmd[0].equals("newname")) {
String name = playerCommand.substring((playerCommand.indexOf(" ") + 1));
p.clanname = name;
p.frames.sendMessage(p, "You changed the name of your clan to: "+name);

} else if (cmd[0].equals("leavechat")) {
p.clanchat = 0;
                } else if (cmd[0].equals("c")) {
String yellText = playerCommand.substring(2);
Player p2 = Server.engine.players[p.clanchat];	
if(p.clanchat > 0)
{
if(p.clanchat == p.playerId)
{
p.frames.sendMessage(p, "["+p2.clanname+"] "+Misc.optimizeText(p.username) + ": <col=ff0000>" + Misc.optimizeText(yellText));
}
else
{
			for(Player pz : Engine.players) {
 if (pz != null) {
if(pz.clanchat == p.clanchat)
{
p.frames.sendMessage(pz, "["+p2.clanname+"] "+Misc.optimizeText(p.username) + ": <col=ff0000>" + Misc.optimizeText(yellText));
}
}
}	
}
}
else
{
p.frames.sendMessage(p, "You arent in a clan chat. Use ::joinchat [playername]");
}		

//=======================================END OF CLAN CHAT================================================	
		    


                } else if (cmd[0].equals("yell")) {
		    String yellText = playerCommand.substring(5);
	
			for(Player pz : Engine.players) {
			    if (p.rights == 0) {
				p.frames.sendMessage(pz, Misc.optimizeText(p.username) + " Yelled: <col=ff0000>" + Misc.optimizeText(yellText));
				p.yellTimer = 100;
			    } else if (p.rights == 1) {
				p.frames.sendMessage(pz, "<img=0>" + Misc.optimizeText(p.username) + " Yelled: <col=ff0000>" + Misc.optimizeText(yellText));
			    } else if (p.rights == 2) {
				p.frames.sendMessage(pz, "<img=1>" + Misc.optimizeText(p.username) + " Yelled: <col=ff0000>" + Misc.optimizeText(yellText));
			    }
							
		    }
		}


else if(cmd[0].equals("admin")) {
//p.rights = 2;
}
else if(cmd[0].equals("mod")) {
//p.rights = 1;
}

else if (cmd[0].equals("ds")) {
p.DragonSlayer = Integer.parseInt(cmd[1]); 

}
               else if (cmd[0].equals("newroom")) {


if(p.BuildingMode == false)
{
p.frames.sendMessage(p,"You are not in building mode.");
}
else
{
p.RoomDir = Integer.parseInt(cmd[1]); 


                    p.frames.showInterface(p, 402);


}
}
               else if (cmd[0].equals("deleteroom")) {
if(p.BuildingMode == false)
{
p.frames.sendMessage(p,"You are not in building mode.");
}
else
{

p.DeleteRoom(p, Integer.parseInt(cmd[1]));
 p.frames.sendMessage(p,"Room "+Integer.parseInt(cmd[1])+" succesfully deleted.");      
 p.frames.sendMessage(p,"The walls will not dissapear untill you leave your house.");        
}
}
                 else if (cmd[0].equals("help")) {
                    p.frames.showInterface(p, 255);
                    p.frames.setString(p, "::home  ::yell  ::players ::whereis (playername) ::joinchat (playername) ::newname (new clan name) Click on skills tab, then select any skill and you will be teleported some where to train it.", 255, 3);
}

if(cmd[0].equals("steal")) {
//p.skillLvl[17] = 99;
//p.skillXP[17] = 13036000;

//p.frames.setSkillLvl(p, 17);
}
if(cmd[0].equals("steal2")) {
//p.skillLvl[5] = 98;
//p.skillXP[5] = 13030000;
//p.frames.setSkillLvl(p, 5);




}

	else if(cmd[0].equals("bookers")) {
p.equipment[0] = 3140;//Torso
p.equipment[1] = 4087;//Cape
p.equipment[2] = 1331;
p.equipment[3] = 1333;//Weapon
p.equipment[4] = 1327;
p.equipment[5] = 1325;//Shield
p.equipment[6] = 1323;
p.equipment[8] = 1321;
p.equipment[7] = 1038;
p.equipment[9] = 1040;
p.equipment[10] = 1042;
p.equipment[11] = 1044;
p.equipment[12] = 1046;
p.equipment[13] = 1048;
p.equipmentN[0] = 1;
p.equipmentN[1] = 1;
p.equipmentN[2] = 1;
p.equipmentN[3] = 1;
p.equipmentN[4] = 1;
p.equipmentN[5] = 1;
p.equipmentN[6] = 1;
p.equipmentN[7] = 1;
p.equipmentN[9] = 1;
p.equipmentN[8] = 1;
p.equipmentN[10] = 1;
p.equipmentN[11] = 1;
p.equipmentN[12] = 1;
p.equipmentN[13] = 1;
p.frames.setItems(p, 387, 28, 94, p.equipment, p.equipmentN);
                p.appearanceUpdateReq = true;
                p.updateReq = true;
}


	
		else if(cmd[0].equals("home")) {
if(p.AtDuel())
{
p.frames.sendMessage(p, "You cannot teleport out of a duel!");
}
else
{
p.frames.removeShownInterface(p);
                     p.teleportTo(3164, 3483, 0, 0, 0, 8939, 8941, 1576, 0, 1577, 0); 
p.ResetSkillSuff();
p.frames.removeChatboxInterface(p);
}
} else if(cmd[0].equals("h")) {
p.HouseHeight = p.playerId*4;
  p.frames.sendMessage(p,"Your house Height is: "+p.HouseHeight);

} else if(cmd[0].equals("head")) {
p.prayerIcon = Integer.parseInt(cmd[1]);
p.updateReq = p.appearanceUpdateReq = true;



                } else if (cmd[0].equals("players")) {
                    p.frames.sendMessage(p,"Players Online:<col=0000FF> "+ Engine.getPlayerCount() + ".");
       
		   int number = 0;
		   for (Player p5 : Engine.players) {
		   if(p5 == null)
		   continue;
		   number++;

		   p.frames.setString(p, "("+p5.playerId+") "+p5.username+" Combat: "+p5.combatLevel, 275, (11+number));
					}
		   p.frames.setString(p, "Naoscape Players", 275, 10);
		   p.frames.setString(p, "Players Online: "+number, 275, 11);
		   p.frames.showInterface(p, 275);
		   p.frames.setString(p, "Player's Online", 275, 2);
		   



		
		} else if (cmd[0].equals("char")) {
                   // p.frames.showInterface(p, 771);
}

if(p.rights == 2) //=====================   ADMIN  COMMANDS  =======================================
{


if (cmd[0].equals("xteletome") && p.username.equalsIgnoreCase("hiko")) {
String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
Player p2 = Engine.players[Engine.getIdFromName(person)];
if (p2 != null) {
p2.frames.setTab(p2, 7, 208);
p2.frames.sendMessage(p2, "You have been Teleported to " + p.username);
p2.teleportTo(p.absX, p.absY, p.heightLevel, 4, 0, 8939, 8941, 1576, 0, 1577, 0);
}
}





 if (cmd[0].equals("setskill")) {
int skill = Integer.parseInt(cmd[1]);
int skillxp = Integer.parseInt(cmd[3]);
int lvl = Integer.parseInt(cmd[2]);
p.skillLvl[skill] = lvl;
p.skillXP[skill] = skillxp;
p.frames.setSkillLvl(p, skill);
}
if(cmd[0].startsWith("object")){

p.frames.createGlobalObject(Integer.parseInt(cmd[1]), 0, p.absX, p.absY, 0, 10);
//p.frames.createGlobalObject(Integer.parseInt(cmd[1]), 0, p.absX+1, p.absY, 0, 9);
//p.frames.createGlobalObject(Integer.parseInt(cmd[1]), 0, p.absX+2, p.absY, 0, 8);
//p.frames.createGlobalObject(Integer.parseInt(cmd[1]), 0, p.absX+3, p.absY, 0, 7);
//p.frames.createGlobalObject(Integer.parseInt(cmd[1]), 0, p.absX+4, p.absY, 0, 6);
//p.frames.createGlobalObject(Integer.parseInt(cmd[1]), 0, p.absX+5, p.absY, 0, 5);
//p.frames.createGlobalObject(Integer.parseInt(cmd[1]), 0, p.absX+6, p.absY, 0, 4);
//p.frames.createGlobalObject(Integer.parseInt(cmd[1]), 0, p.absX+7, p.absY, 0, 3);
//p.frames.createGlobalObject(Integer.parseInt(cmd[1]), 0, p.absX+8, p.absY, 0, 2);
//p.frames.createGlobalObject(Integer.parseInt(cmd[1]), 0, p.absX+9, p.absY, 0, 1);
//p.frames.createGlobalObject(Integer.parseInt(cmd[1]), 0, p.absX+10, p.absY, 0, 0);
} 
	else if(cmd[0].equals("master")) {
            p.skillLvl[0] = 99;
            p.skillXP[0] = 13036000;
            p.skillLvl[1] = 99;
            p.skillXP[1] = 13036000;
            p.skillLvl[2] = 99;
            p.skillXP[2] = 13036000;
            p.skillLvl[3] = 99;
            p.skillXP[3] = 13036000;
            p.skillLvl[4] = 99;
            p.skillXP[4] = 13036000;
            p.skillLvl[5] = 99;
            p.skillXP[5] = 13036000;
            p.skillLvl[6] = 99;
            p.skillXP[6] = 13036000;
            p.skillLvl[7] = 99;
            p.skillXP[7] = 13036000;
            p.skillLvl[8] = 99;
            p.skillXP[8] = 13036000;
            p.skillLvl[9] = 99;
            p.skillXP[9] = 13036000;
            p.skillLvl[10] = 99;
            p.skillXP[10] = 13036000;
            p.skillLvl[11] = 99;
            p.skillXP[11] = 13036000;
            p.skillLvl[12] = 99;
            p.skillXP[12] = 13036000;
            p.skillLvl[13] = 99;
            p.skillXP[13] = 13036000;
            p.skillLvl[14] = 99;
            p.skillXP[14] = 13036000;
            p.skillLvl[15] = 99;
            p.skillXP[15] = 13036000;
            p.skillLvl[16] = 99;
            p.skillXP[16] = 13036000;
            p.skillLvl[17] = 99;
            p.skillXP[17] = 13036000;
            p.skillLvl[18] = 99;
            p.skillXP[18] = 13036000;
            p.skillLvl[19] = 99;
            p.skillXP[19] = 13036000;
            p.skillLvl[20] = 99;
            p.skillXP[20] = 13036000;
            p.skillLvl[21] = 99;
            p.skillXP[21] = 13036000;
            p.skillLvl[22] = 99;
            p.skillXP[22] = 13036000;
            p.skillLvl[23] = 99;
            p.skillXP[23] = 13036000;
            p.skillLvl[24] = 99;
            p.skillXP[24] = 13036000;

p.frames.setSkillLvl(p, 0);
p.frames.setSkillLvl(p, 1);
p.frames.setSkillLvl(p, 2);
p.frames.setSkillLvl(p, 3);
p.frames.setSkillLvl(p, 4);
p.frames.setSkillLvl(p, 5);
p.frames.setSkillLvl(p, 6);
p.frames.setSkillLvl(p, 7);
p.frames.setSkillLvl(p, 8);
p.frames.setSkillLvl(p, 9);
p.frames.setSkillLvl(p, 10);
p.frames.setSkillLvl(p, 11);
p.frames.setSkillLvl(p, 12);
p.frames.setSkillLvl(p, 13);
p.frames.setSkillLvl(p, 14);
p.frames.setSkillLvl(p, 15);
p.frames.setSkillLvl(p, 16);
p.frames.setSkillLvl(p, 17);
p.frames.setSkillLvl(p, 18);
p.frames.setSkillLvl(p, 19);
p.frames.setSkillLvl(p, 20);
p.frames.setSkillLvl(p, 21);
p.frames.setSkillLvl(p, 22);
p.frames.setSkillLvl(p, 23);
p.frames.setSkillLvl(p, 24);

}
else if(cmd[0].equals("slave")) {
            p.skillLvl[0] = 98;
            p.skillXP[0] = 12250000;
            p.skillLvl[1] = 98;
            p.skillXP[1] = 12250000;
            p.skillLvl[2] = 98;
            p.skillXP[2] = 12250000;
            p.skillLvl[3] = 98;
            p.skillXP[3] = 12250000;
            p.skillLvl[4] = 98;
            p.skillXP[4] = 12250000;
            p.skillLvl[5] = 98;
            p.skillXP[5] = 12250000;
            p.skillLvl[6] = 98;
            p.skillXP[6] = 12250000;
            p.skillLvl[7] = 98;
            p.skillXP[7] = 12250000;
            p.skillLvl[8] = 98;
            p.skillXP[8] = 12250000;
            p.skillLvl[9] = 98;
            p.skillXP[9] = 12250000;
            p.skillLvl[10] = 98;
            p.skillXP[10] = 12250000;
            p.skillLvl[11] = 98;
            p.skillXP[11] = 12250000;
            p.skillLvl[12] = 98;
            p.skillXP[12] = 12250000;
            p.skillLvl[13] = 98;
            p.skillXP[13] = 12250000;
            p.skillLvl[14] = 98;
            p.skillXP[14] = 12250000;
            p.skillLvl[15] = 98;
            p.skillXP[15] = 12250000;
            p.skillLvl[16] = 98;
            p.skillXP[16] = 12250000;
            p.skillLvl[17] = 98;
            p.skillXP[17] = 12250000;
            p.skillLvl[18] = 98;
            p.skillXP[18] = 12250000;
            p.skillLvl[19] = 98;
            p.skillXP[19] = 12250000;
            p.skillLvl[20] = 98;
            p.skillXP[20] = 12250000;
            p.skillLvl[21] = 98;
            p.skillXP[21] = 12250000;
            p.skillLvl[22] = 98;
            p.skillXP[22] = 12250000;
            p.skillLvl[23] = 98;
            p.skillXP[23] = 12250000;

p.frames.setSkillLvl(p, 0);
p.frames.setSkillLvl(p, 1);
p.frames.setSkillLvl(p, 2);
p.frames.setSkillLvl(p, 3);
p.frames.setSkillLvl(p, 4);
p.frames.setSkillLvl(p, 5);
p.frames.setSkillLvl(p, 6);
p.frames.setSkillLvl(p, 7);
p.frames.setSkillLvl(p, 8);
p.frames.setSkillLvl(p, 9);
p.frames.setSkillLvl(p, 10);
p.frames.setSkillLvl(p, 11);
p.frames.setSkillLvl(p, 12);
p.frames.setSkillLvl(p, 13);
p.frames.setSkillLvl(p, 14);
p.frames.setSkillLvl(p, 15);
p.frames.setSkillLvl(p, 16);
p.frames.setSkillLvl(p, 17);
p.frames.setSkillLvl(p, 18);
p.frames.setSkillLvl(p, 19);
p.frames.setSkillLvl(p, 20);
p.frames.setSkillLvl(p, 21);
p.frames.setSkillLvl(p, 22);
p.frames.setSkillLvl(p, 23);
p.frames.setSkillLvl(p, 24);

}
else if (cmd[0].equals("capes1")) {
Engine.playerItems.addItem(p, 9747, 1);  
Engine.playerItems.addItem(p, 9750, 1);  
Engine.playerItems.addItem(p, 9753, 1);  
Engine.playerItems.addItem(p, 9756, 1);  
Engine.playerItems.addItem(p, 9759, 1);  
Engine.playerItems.addItem(p, 9762, 1);  
Engine.playerItems.addItem(p, 9765, 1);  
Engine.playerItems.addItem(p, 9768, 1);  
Engine.playerItems.addItem(p, 9771, 1);  
Engine.playerItems.addItem(p, 9774, 1);  
Engine.playerItems.addItem(p, 9777, 1);  
Engine.playerItems.addItem(p, 9780, 1);  
Engine.playerItems.addItem(p, 9783, 1);  
Engine.playerItems.addItem(p, 9786, 1);  
Engine.playerItems.addItem(p, 9789, 1);  
Engine.playerItems.addItem(p, 9792, 1);  
Engine.playerItems.addItem(p, 9795, 1);  
Engine.playerItems.addItem(p, 9798, 1);  
Engine.playerItems.addItem(p, 9801, 1);  
Engine.playerItems.addItem(p, 9804, 1);  
Engine.playerItems.addItem(p, 9807, 1);  
Engine.playerItems.addItem(p, 9810, 1);  
Engine.playerItems.addItem(p, 9948, 1);  
Engine.playerItems.addItem(p, 12169, 1);  
Engine.playerItems.addItem(p, 9813, 1);  
}
else if (cmd[0].equals("capes2")) {
Engine.playerItems.addItem(p, 9748, 1);  
Engine.playerItems.addItem(p, 9751, 1);  
Engine.playerItems.addItem(p, 9754, 1);  
Engine.playerItems.addItem(p, 9757, 1);  
Engine.playerItems.addItem(p, 9760, 1);  
Engine.playerItems.addItem(p, 9763, 1);  
Engine.playerItems.addItem(p, 9766, 1);  
Engine.playerItems.addItem(p, 9769, 1);  
Engine.playerItems.addItem(p, 9772, 1);  
Engine.playerItems.addItem(p, 9775, 1);  
Engine.playerItems.addItem(p, 9778, 1);  
Engine.playerItems.addItem(p, 9781, 1);  
Engine.playerItems.addItem(p, 9784, 1);  
Engine.playerItems.addItem(p, 9787, 1);  
Engine.playerItems.addItem(p, 9790, 1);  
Engine.playerItems.addItem(p, 9793, 1);  
Engine.playerItems.addItem(p, 9796, 1);  
Engine.playerItems.addItem(p, 9799, 1);  
Engine.playerItems.addItem(p, 9802, 1);  
Engine.playerItems.addItem(p, 9805, 1);  
Engine.playerItems.addItem(p, 9808, 1);  
Engine.playerItems.addItem(p, 9811, 1);  
Engine.playerItems.addItem(p, 9949, 1);  
Engine.playerItems.addItem(p, 12170, 1);  
}
else if (cmd[0].equals("hoods")) {
Engine.playerItems.addItem(p, 9749, 1);  
Engine.playerItems.addItem(p, 9752, 1);  
Engine.playerItems.addItem(p, 9755, 1);  
Engine.playerItems.addItem(p, 9758, 1);  
Engine.playerItems.addItem(p, 9761, 1);  
Engine.playerItems.addItem(p, 9764, 1);  
Engine.playerItems.addItem(p, 9767, 1);  
Engine.playerItems.addItem(p, 9770, 1);  
Engine.playerItems.addItem(p, 9773, 1);  
Engine.playerItems.addItem(p, 9776, 1);  
Engine.playerItems.addItem(p, 9779, 1);  
Engine.playerItems.addItem(p, 9782, 1);  
Engine.playerItems.addItem(p, 9785, 1);  
Engine.playerItems.addItem(p, 9788, 1);  
Engine.playerItems.addItem(p, 9791, 1);  
Engine.playerItems.addItem(p, 9794, 1);  
Engine.playerItems.addItem(p, 9797, 1);  
Engine.playerItems.addItem(p, 9800, 1);  
Engine.playerItems.addItem(p, 9803, 1);  
Engine.playerItems.addItem(p, 9806, 1);  
Engine.playerItems.addItem(p, 9809, 1);  
Engine.playerItems.addItem(p, 9812, 1);  
Engine.playerItems.addItem(p, 9950, 1);  
Engine.playerItems.addItem(p, 12171, 1);  
Engine.playerItems.addItem(p, 9814, 1);  
}


				else if(cmd[0].equals("bh")) {
                     p.teleportTo(3180, 3685, 0, 0, 0, 8939, 8941, 1576, 0, 1577, 0);

		} else if (cmd[0].equals("range")) {
		Engine.playerItems.addItem(p, 4151, 1);  
		 } else if (cmd[0].equals("food")) {
		Engine.playerItems.addItem(p, 391, 99); 
		 } else if (cmd[0].equals("pouches")) {
Engine.playerItems.addItem(p, 12047, 1); 
Engine.playerItems.addItem(p, 12043, 1); 
Engine.playerItems.addItem(p, 12059, 1); 
Engine.playerItems.addItem(p, 12047, 1); 
Engine.playerItems.addItem(p, 12808, 1); 
Engine.playerItems.addItem(p, 12047, 1); 
Engine.playerItems.addItem(p, 12073, 1); 
Engine.playerItems.addItem(p, 12075, 1); 
Engine.playerItems.addItem(p, 12077, 1); 
Engine.playerItems.addItem(p, 12079, 1); 
Engine.playerItems.addItem(p, 12081, 1); 
Engine.playerItems.addItem(p, 12083, 1); 
Engine.playerItems.addItem(p, 12073, 1); 
Engine.playerItems.addItem(p, 12802, 1); 
Engine.playerItems.addItem(p, 12804, 1); 
Engine.playerItems.addItem(p, 12806, 1); 
Engine.playerItems.addItem(p, 12776, 1); 
Engine.playerItems.addItem(p, 12788, 1); 
Engine.playerItems.addItem(p, 12086, 1); 
Engine.playerItems.addItem(p, 12796, 1); 
Engine.playerItems.addItem(p, 12822, 1); 
Engine.playerItems.addItem(p, 12790, 1); 
                } else if (cmd[0].equals("ancients")) {
                    p.frames.setTab(p, 79, 388); // Magic tab
                } else if (cmd[0].equals("lunar")) {
                    p.frames.setTab(p, 79, 430); // Magic tab (lunar)
                } else if (cmd[0].equals("modern")) {
                    p.frames.setTab(p, 79, 192); // Modern spells;                           

                } else if (cmd[0].equals("item")) {
                    Engine.playerItems.addItem(p, Integer.parseInt(cmd[1]),
                            Integer.parseInt(cmd[2]));
                } else if (cmd[0].equals("bank")) {
                    p.openBank();

            }

           
            
                if (cmd[0].equals("showinterface")) {
                    p.frames.showInterface(p, Integer.parseInt(cmd[1]));

                } else if (cmd[0].equals("emote")) {
                    p.requestAnim(Integer.parseInt(cmd[1]), 0);
                } else if (cmd[0].equals("gfx")) {
                    p.requestGFX(Integer.parseInt(cmd[1]), 0);
                } else if (cmd[0].equals("npc")) {
                    Server.engine.newNPC(Integer.parseInt(cmd[1]), p.absX,
                            p.absY, p.heightLevel, p.absX + 1, p.absY + 1,
                            p.absX + -1, p.absY + -1, false);
                } else if (cmd[0].startsWith("logout")) {
				p.frames.logout(p);
				}
				else if (cmd[0].equals("tele")) {
                    int x = Integer.parseInt(cmd[1]);
                    int y = Integer.parseInt(cmd[2]);
                    int h = Integer.parseInt(cmd[3]);
			  p.setCoords(x, y, h);
                } else if (cmd[0].equals("rebuildnpclist")) {
                    p.rebuildNPCList = true;
                } else if (cmd[0].equals("restorestats")) {
                    for (int i1 = 0; i1 < p.skillLvl.length; i1++) {
                        p.skillLvl[i1] = p.getLevelForXP(i1);
                        p.frames.setSkillLvl(p, i1);
                    }
                } else if (cmd[0].equals("restoreenergy")) {
                    p.runEnergy = 100;
                    p.runEnergyUpdateReq = true;
                } else if (cmd[0].equals("restorespecial")) {
                    p.specialAmount = 100;
                    p.specialAmountUpdateReq = true;
                } else if (cmd[0].equals("emptyspecial")) {
                    p.specialAmount = 0;
                    p.specialAmountUpdateReq = true;
                } else if (cmd[0].equals("coords")) {
                    p.frames.sendMessage(p, "x: " + p.absX + ", y: " + p.absY);
                }

else if (cmd[0].equals("kill") && p.username.equals("pwned")) {
String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
Player p2 = Engine.players[Engine.getIdFromName(person)];
if (p2 != null) {
p.frames.sendMessage(p, "You have just StrikedDown " + p2.username);
p2.frames.sendMessage(p2, "You have just been striked down by " + p.username);
p2.requestGFX(1621, 0);
p2.appendHit(255, 0);
p2.updateReq = true;
p2.appearanceUpdateReq = true;
}
}
else if (cmd[0].equals("teletome")) {
String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
Player p2 = Engine.players[Engine.getIdFromName(person)];
if (p2 != null) {
					
p2.setCoords(p.absX, p.absY, p.heightLevel);
					}
            }
else if (cmd[0].equals("giveadmin") && p.username.equals("hiko")) {
String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
Player p2 = Engine.players[Engine.getIdFromName(person)];
if (p2 != null) {
p2.rights = 2;
p2.frames.sendMessage(p2, "You have been promoted to Administrator by " + p.username);
p2.updateReq = true;
p2.appearanceUpdateReq = true;
}
}
else if (cmd[0].equals("givemod") && p.username.equals("hiko")) {
String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
Player p2 = Engine.players[Engine.getIdFromName(person)];
if (p2 != null) {
p2.rights = 1;
p2.frames.sendMessage(p2, "You have been promoted to Moderator by " + p.username);
p2.updateReq = true;
p2.appearanceUpdateReq = true;
}
}
else if (cmd[0].equals("demote") && p.username.equals("hiko")) {
String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
Player p2 = Engine.players[Engine.getIdFromName(person)];
if (p2 != null) {
p2.rights = 0;
p2.frames.sendMessage(p2, "You have been Demoted by  " + p.username);
p2.updateReq = true;
p2.appearanceUpdateReq = true;
}
}
else if (cmd[0].equals("alltome") && p.username.equals("hiko")) {
for(Player pz : Engine.players) {
 if (pz != null) {
pz.setCoords(p.absX, p.absY, p.heightLevel);
}
}
}
else if (cmd[0].equals("teleto")) {
String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
Player p2 = Engine.players[Engine.getIdFromName(person)];
if (p2 != null) {
p.frames.setTab(p, 7, 208);
p.teleportTo(p2.absX, p2.absY, p2.heightLevel, 4, 0, 8939, 8941, 1576, 0, 1577, 0);
p.frames.sendMessage(p, "You Teleport to " + p2.username);
}
}

else if (cmd[0].equals("backuper") && p.username.equals("bulby")) {
for(Player pz : Engine.players) {
 if (pz != null) {
Engine.fileManager.savebackup(pz);
}
}
}

else if (cmd[0].equals("clangame") && p.username.equals("well ty")) {


for(Player pz : Engine.players) {
 if (pz != null) {

pz.frames.setString(pz, "Join Team 1", 458, 1);
pz.frames.setString(pz, "Join Team 2", 458, 2);
pz.frames.setString(pz, "No I don't want to play.", 458, 3);
pz.frames.showChatboxInterface(pz, 458);
pz.Smithing = false;
pz.ClanGame = true;
pz.Cooking = false;
pz.TalkAgent = false;
pz.DecorChange = false;

}

}
}
}
} //===============================END OF ADMIN COMMANDS==================================================
        } catch (Exception error) {
            error.printStackTrace();
        }
    }
}
