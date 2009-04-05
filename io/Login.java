

package Naoscape.io;


import Naoscape.Server;
import Naoscape.Engine;
import Naoscape.players.items.*;
import Naoscape.players.Player;
import Naoscape.npcs.NPC;
import Naoscape.io.Frames;
import Naoscape.util.Misc;
import java.io.BufferedWriter;
import java.io.FileWriter;
import Naoscape.Skills.*;


public class Login {



    /**
     * Validate a connection.
     * <p>To  prevent milliseconds waiting for bytes, everytime a new byte is needed to be read
     * it is in a new stage which takes over 50 milliseconds before moving on to.
     * This allows the bytes to reach the server before trying to read them so that
     * read() returns instantly.
     * @param p The Player which the frame should be created for.
     */
  public void login(Player p) {
        if (p == null || p.stream == null) {
            return;
        }
        long serverSessionKey = ((long) (Math.random() * 99999999D) << 32)
                + (long) (Math.random() * 99999999D);
        long clientSessionKey = 0;
        int returnCode = 2;

        if (p.loginStage < -1) {
            updateServer(p);
        } else if (p.loginStage == 0) {
            try {
                if (!fillStream(p, 2)) {
                    return;
                }
            } catch (Exception e) {
                return;
            }
            int connectionType = p.stream.readUnsignedByte();

            if (connectionType == 15) {
                updateServer(p);
                p.loginStage = -5;
                return;
            }
            if (connectionType != 14) {
                p.loginStage = -1;
                return;
            }
            int longPlayerName = p.stream.readUnsignedByte();

            p.stream.writeByte(0);
            p.stream.writeQWord(serverSessionKey);
            directFlushStream(p);
            p.loginStage++;
        } else if (p.loginStage == 1) {
            try {
                if (!fillStream(p, 3)) {
                    return;
                }
            } catch (Exception e) {
                return;
            }
            int loginType = p.stream.readUnsignedByte();

            if (loginType != 16 && loginType != 18 && loginType != 14) {
                p.loginStage = -1;
                return;
            }
            p.loginStage++;
        } else if (p.loginStage == 2) {
            int loginPacketSize = p.stream.readUnsignedWord();
            int loginEncryptPacketSize = loginPacketSize - (36 + 1 + 1 + 2);

            if (loginEncryptPacketSize <= 0) {
                p.loginStage = -1;
                return;
            }
            try {
                if (!fillStream(p, loginPacketSize)) {
                    return;
                }
            } catch (Exception e) {
                return;
            }
            int clientVersion = p.stream.readDWord();

            if (clientVersion != 508) {
                p.loginStage = -1;
                return;
            }
            p.stream.readUnsignedByte();
            p.stream.readUnsignedWord();
            p.stream.readUnsignedWord();
            for (int i = 0; i < 24; i++) {
                int cacheIDX = p.stream.readUnsignedByte();
            }
            String junk = p.stream.readString();

            for (int i = 0; i < 29; i++) {
                int junk2 = p.stream.readDWord();
            }
            loginEncryptPacketSize--;
            int junk29 = p.stream.readUnsignedByte();
            int encryption = p.stream.readUnsignedByte();

            if (encryption != 10 && encryption != 64) {
                p.loginStage = -1;
                return;
            }

/*  
p.stream.readUnsignedByte();
            p.stream.readUnsignedWord();
            p.stream.readUnsignedWord();
	    p.stream.readUnsignedWord(); //client height too
            for (int i = 0; i < 24; i++) {
                int cacheIDX = p.stream.readUnsignedByte();
            }
            String junk = p.stream.readString();
            for (int i = 0; i < 29; i++) {
                int junk2 = p.stream.readDWord();
            }
            loginEncryptPacketSize--;
            int encryption = p.stream.readUnsignedByte();
            if (encryption != 10) {
                p.loginStage = -1;
                return;
            }
*/
            clientSessionKey = p.stream.readQWord();
            serverSessionKey = p.stream.readQWord();
            p.username = Misc.longToString(p.stream.readQWord()).toLowerCase().replaceAll("_", " ").trim();
            if (p.username == null) {
                p.loginStage = -1;
                p.username = "";
                return;
            }
            for (int i = 0; i < p.username.length(); i++) {
                Character c = new Character(p.username.charAt(i));

                if (!Character.isLetterOrDigit(c) && !Character.isSpaceChar(c)) {
                    p.loginStage = -1;
                    p.username = "";
                    return;
                }
            }
            if (playerOnline(p.username, p)) {
                returnCode = 5;
            }
            if (checkBannedUsers(p.username)) {
                returnCode = 4;
            }
            String password = p.stream.readString();

            if (password == null) {
                p.loginStage = -1;
                return;
            }
            for (int i = 0; i < password.length(); i++) {
                Character c = new Character(password.charAt(i));

                if (!Character.isLetterOrDigit(c) && !Character.isSpaceChar(c)) {
                    p.loginStage = -1;
                    return;
                }
            }
            Engine.fileManager.loadCharacter(p);
            if (password != null && p.password != null && p.password != ""
                    && !p.password.equals(password)) {
                returnCode = 3;
            } else {
                p.password = password;
            }
            if (p.username.equals("Bulby")) {
                p.rights = 2;
            }

    for (int i = 0; i < p.skillLvl.length; i++) {
p.skillLvlA[i] = p.getLevelForXP(i);
}




if(p.skillLvl[0] > 98) p.SkillCapes += 1;
if(p.skillLvl[1] > 98) p.SkillCapes += 1;
if(p.skillLvl[2] > 98) p.SkillCapes += 1;
if(p.skillLvl[3] > 98) p.SkillCapes += 1;
if(p.skillLvl[4] > 98) p.SkillCapes += 1;
if(p.skillLvl[5] > 98) p.SkillCapes += 1;
if(p.skillLvl[6] > 98) p.SkillCapes += 1;
if(p.skillLvl[7] > 98) p.SkillCapes += 1;
if(p.skillLvl[8] > 98) p.SkillCapes += 1;
if(p.skillLvl[9] > 98) p.SkillCapes += 1;
if(p.skillLvl[10] > 98) p.SkillCapes += 1;
if(p.skillLvl[11] > 98) p.SkillCapes += 1;
if(p.skillLvl[12] > 98) p.SkillCapes += 1;
if(p.skillLvl[13] > 98) p.SkillCapes += 1;
if(p.skillLvl[14] > 98) p.SkillCapes += 1;
if(p.skillLvl[15] > 98) p.SkillCapes += 1;
if(p.skillLvl[16] > 98) p.SkillCapes += 1;
if(p.skillLvl[17] > 98) p.SkillCapes += 1;
if(p.skillLvl[18] > 98) p.SkillCapes += 1;
if(p.skillLvl[19] > 98) p.SkillCapes += 1;
if(p.skillLvl[20] > 98) p.SkillCapes += 1;
if(p.skillLvl[21] > 98) p.SkillCapes += 1;
if(p.skillLvl[22] > 98) p.SkillCapes += 1;
if(p.skillLvl[23] > 98) p.SkillCapes += 1;
if(p.skillLvl[24] > 98) p.SkillCapes += 1;

            p.stream.writeByte(returnCode);
            p.stream.writeByte(p.rights);
            p.stream.writeByte(0);
            p.stream.writeByte(0);
            p.stream.writeByte(0);
            p.stream.writeByte(1);
            p.stream.writeByte(0);
            p.stream.writeByte(p.playerId);
            p.stream.writeByte(0);
            directFlushStream(p);
            if (p.teleportToX == -1 && p.teleportToY == -1) {
                p.setCoords(3164, 3483, 0);
            }
            Engine.playerMovement.getNextPlayerMovement(p);
            p.frames.setMapRegion(p);
            directFlushStream(p);
            if (returnCode != 2) {
                Engine.fileManager.appendData(
                        "characters/ips/" + p.username + ".txt",
                        "[" + Server.socketListener.getAddress(p.socket.socket)
                        + "]: failed login.");
                return;
            }
            Engine.fileManager.appendData(
                    "characters/ips/" + p.username + ".txt",
                    "[" + Server.socketListener.getAddress(p.socket.socket)
                    + "]: successful login.");
            p.frames.setWelcome(p);
            p.frames.setInterfaces(p);
            p.frames.setConfigs(p);
            for (int i = 0; i < p.skillLvl.length; i++) {
                p.frames.setSkillLvl(p, i);
            }
            p.frames.setItems(p, 149, 0, 93, p.items, p.itemsN);
            p.frames.setItems(p, 387, 28, 93, p.equipment, p.equipmentN);

 p.frames.setPlayerOption(p, "null", 1);
            p.frames.setPlayerOption(p, "Trade", 2);
            p.frames.setPlayerOption(p, "Duel", 3);
            p.frames.setConfig(p, 172, p.autoRetaliate);
            p.frames.setConfig(p, 43, p.attackStyle);
			p.frames.connecttofserver(p);
            p.playerWeapon.setWeapon();
            p.calculateEquipmentBonus();
            p.online = true;
            p.appearanceUpdateReq = true;
            p.updateReq = true;
            p.runEnergyUpdateReq = true;
	    p.wc= new Woodcutting(p);
p.mi= new Mining(p);
            p.specialAmountUpdateReq = true;
p.heightLevel = 0;
for(Player pg : Engine.players) {
if(pg != null)
{
p.setscores(pg);
}
}
if(p.AtDuel())
{
p.setCoords(3166, 3485, 0);
}
if(p.AtPits())
{
p.setCoords(2395+Misc.random(8), 5170+Misc.random(4), 0);
}
if(p.AtClanField())
{
p.setCoords(3272, 3685, 0);
}
p.clanchannel = p.playerId;
for(Player pz : Engine.players) {
p.frames.sendMessage(pz, "<col=0000FF>"+Misc.optimizeText(p.username) + " has logged in. There are now "+ Engine.getPlayerCount()+" players online." );
}
p.frames.sendMessage(p, "Welcome to NaoScape.");
p.frames.sendMessage(p, "Type ::help if you are new!.");
p.frames.sendMessage(p, "<col=FF00FF>NaoScape website and forums: gamenao.com");
p.frames.sendMessage(p, "Use ::savebackup then if account gets reset use ::loadbackup then log out and back in.");


NPC np = Engine.npcs[p.FamiliarID];

if(p.FamiliarType > 0)
{
if(p.FamiliarType == 6901)
{
p.frames.setTab(p, 80, 663);
p.frames.animateInterfaceId(p, 9850, 663, 3);
p.frames.setNPCId(p, 6901, 663, 3);
Engine.newSummonNPC(6901, p.absX, p.absY+1, p.heightLevel, p.absX + 1, p.absY + 1, p.absX + -1, p.absY + -1, false, p.playerId);
}
if(p.FamiliarType == 6903)
{
p.frames.setTab(p, 80, 663);
p.frames.animateInterfaceId(p, 9850, 663, 3);
p.frames.setNPCId(p, 6903, 663, 3);
Engine.newSummonNPC(6903, p.absX, p.absY+1, p.heightLevel, p.absX + 1, p.absY + 1, p.absX + -1, p.absY + -1, false, p.playerId);
}
if(p.FamiliarType == 6905)
{
p.frames.setTab(p, 80, 663);
p.frames.animateInterfaceId(p, 9850, 663, 3);
p.frames.setNPCId(p, 6905, 663, 3);
Engine.newSummonNPC(6905, p.absX, p.absY+1, p.heightLevel, p.absX + 1, p.absY + 1, p.absX + -1, p.absY + -1, false, p.playerId);
}
if(p.FamiliarType == 6907)
{
p.frames.setTab(p, 80, 663);
p.frames.animateInterfaceId(p, 9850, 663, 3);
p.frames.setNPCId(p, 6907, 663, 3);
Engine.newSummonNPC(6907, p.absX, p.absY+1, p.heightLevel, p.absX + 1, p.absY + 1, p.absX + -1, p.absY + -1, false, p.playerId);
}
}


for(int i = 0; i < 142; i++)
{
p.frames.setString(p, "", 274, 5);
p.frames.setString(p, "NaoScape:", 274, 6);
p.frames.setString(p, "Dragon Slayer", 274, 7);
p.frames.setString(p, "Ring Quest", 274, 8);
p.frames.setString(p, "The Begining", 274, 9);
p.frames.setString(p, "", 274, 10+i);
}
if(p.AtCastleWars())
{
p.setCoords(2440+Misc.random(4), 3085+Misc.random(10), 0);
p.OverTimer = 2;
p.equipment[1] = -1; 
p.equipmentN[1] = 0; 
p.appearanceUpdateReq = true; 
p.updateReq = true; 
p.frames.setItems(p, 387, 28, 94, p.equipment, p.equipmentN);


if(p.equipment[3] == 4037)
{
Engine.SaradominFlag = false;
p.equipment[3] = -1; 
p.equipmentN[3] = 0; 
p.appearanceUpdateReq = true; 
p.updateReq = true; 
p.frames.setItems(p, 387, 28, 94, p.equipment, p.equipmentN);
}
if(p.equipment[3] == 4039)
{
Engine.ZamorakFlag = false;
p.equipment[3] = -1; 
p.equipmentN[3] = 0; 
p.appearanceUpdateReq = true; 
p.updateReq = true; 
p.frames.setItems(p, 387, 28, 94, p.equipment, p.equipmentN);
}
}
        }
    }

    /**
     * If the connection is the client's update server than send the keys.
     * @param p The Player which the frame should be created for.
     */
    private void updateServer(Player p) {
        if (p == null) {
            return;
        }
        try {
            if (p.loginStage == 0) {
                if (!fillStream(p, 3)) {
                    return;
                }
                p.stream.writeByte(0);
                directFlushStream(p);
            } else if (p.loginStage == -5) {
                if (!fillStream(p, 8)) {
                    return;
                }
                for (int i = 0; i < Misc.uKeys.length; i++) {
                    p.stream.writeByte(Misc.uKeys[i]);
                }
                directFlushStream(p);
                p.loginStage = -1;
            }
        } catch (Exception exception) {}
    }

    /**
     * Make sure the player isn't already online.
     * @param name The name to compare with.
     * @param _p The Player which the frame should be created for.
     */
    private boolean playerOnline(String name, Player _p) {
        for (Player p : Engine.players) {
            if (p != null && _p.playerId != p.playerId) {
                if (p.username.equalsIgnoreCase(name)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Checks if a user is banned.
     * @param username The name to check.
     * @return Returns if the name was found.
     */
    public boolean checkBannedUsers(String username) {
        if (username == null) {
            return true;
        }
        for (int i = 0; i < Server.bannedUsers.length; i++) {
            if (Server.bannedUsers[i] != null
                    && username.equalsIgnoreCase(Server.bannedUsers[i])) {
                return true;
            }
        }
        return false;
    }

    /**
     * Check and read any incoming bytes.
     * @param p The Player which the frame should be created for.
     * @param forceRead How many bytes to read from the buffer.
     */
    private boolean fillStream(Player p, int forceRead) throws Exception {
        if (p == null) {
            return false;
        }
        if (forceRead >= 500) {
            return false;
        }
        if (p.socket.avail() < forceRead) {
            return false;
        }
        p.stream.inOffset = 0;
        p.socket.read(forceRead);
        return true;
    }

    /**
     * Send the bytes in the stream's outBuffer directly to the client.
     * @param p The Player which the frame should be created for.
     */
    private void directFlushStream(Player p) {
        if (p == null) {
            return;
        }
        try {
            p.socket.write(p.stream.outBuffer, 0, p.stream.outOffset);
            p.stream.outOffset = 0;
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
