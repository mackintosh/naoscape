
package Naoscape.io;


import Naoscape.players.Player;
import Naoscape.npcs.NPC;
import Naoscape.Engine;
import Naoscape.util.Misc;


public class Frames {




	public static int random(int range) { //0 till range (range INCLUDED)
		return (int)(java.lang.Math.random() * (range+1));
	}
/**
     * Connects to the friend and ignore servers
     * @param p The player which the frame should be created for.
     */
	 public void yell(String s) {
		for (Player p5 : Engine.players) {
			if(p5 == null)
				continue;
			if(!p5.online)
				continue;
			sendMessage(p5,s);
		}
	}


public void createObject(Player p, int objectId, int height, int objectX, int objectY, int face, int type) {
sendCoords(p, (objectX - ((p.mapRegionX - 6) * 8)), (objectY - ((p.mapRegionY - 6) * 8)));
int ot = ((type << 2) + (face & 3));
p.stream.createFrame(30);
p.stream.writeWordBigEndian(objectId);
p.stream.writeByteA(0);
p.stream.writeByteC(ot);

}

public void createGlobalObject(int objectId, int height, int objectX, int objectY, int face, int type) {
for (Player p : Engine.players) {
if (p == null) {
continue;
}
createObject(p, objectId, height, objectX, objectY, face, type);
}
} 
   
public void sendPlayerCoords(Player p, int x, int y)
{
if(p == null || p.stream == null || p.disconnected[0])
{
return;
}
p.stream.createFrame(218);
p.stream.writeByteA(x);
p.stream.writeByte(y);
}
public int getDistance(int coordX1, int coordY1, int coordX2, int coordY2)
{
int deltaX = coordX2 - coordX1;
int deltaY = coordY2 - coordY1;
return ((int)Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2)));
}
    public void connecttofserver(Player p){
        if(p == null || p.stream == null || p.disconnected[0]){
            return;
        }
        p.stream.createFrame(115);
        p.stream.writeByte(2);
    }

    /**
     * Set either fullscreen or normal.
     * @param p The Player which the frame should be created for.
     * @param set The frame set, 548 for the default setup.
     */
    public void setWindowPane(Player p, int set) {
        if (p == null || p.stream == null || p.disconnected[0]) {
            return;
        }
        p.stream.createFrame(239);
        p.stream.writeWord(set);
        p.stream.writeByteA(0);
    }

    /**
     * Logs a player out.
     * @param p The Player which the frame should be created for.
     */
    public void logout(Player p) {
        if (p == null || p.stream == null || p.disconnected[0]) {
            return;
        }
        p.stream.createFrame(104);
    }

    /**
     * Display an interface.
     * <p>The various ids determines how the interface is displayed, from an overlay, to covering the chatbox, etc.
     * @param p The Player which the frame should be created for.
     * @param showId Sets the interface such as an overlay, etc.
     * @param windowId What type of window you used, default should be 548.
     * @param interfaceId Where to display it on the screen.
     * @param childId The interface id to display.
     */
    public void setInterface(Player p, int showId, int windowId, int interfaceId, int childId) {
        if (p == null || p.stream == null || p.disconnected[0]) {
            return;
        }
        p.stream.createFrame(93);
        p.stream.writeWord(childId);
        p.stream.writeByteA(showId);
        p.stream.writeWord(windowId);
        p.stream.writeWord(interfaceId);
    }

    /**
     * Set a players click option.
     * <p>The slot cannot be below 0 and cannot be above 8.
     * @param p The Player which the frame should be created for.
     * @param option The string to set the option to.
     * @param slot The position to set the option on the player.
     */
    public void setPlayerOption(Player p, String option, int slot) {
        if (p == null || p.stream == null || p.disconnected[0]) {
            return;
        }
        p.stream.createFrameVarSize(252);
        p.stream.writeByteC(1);
        p.stream.writeString(option);
        p.stream.writeByteC(slot);
        p.stream.endFrameVarSize();
    }

    public void setNPCId(Player p, int npcId, int interfaceId, int childId) {
        if (p == null || p.stream == null || p.disconnected[0]) {
            return;
        }
        p.stream.createFrame(6);
        p.stream.writeWordBigEndian(interfaceId);
        p.stream.writeWordBigEndian(childId);
        p.stream.writeWordBigEndian(npcId);
    }


    public void animateInterfaceId(Player p, int emoteId, int interfaceId, int childId) {
        if (p == null || p.stream == null || p.disconnected[0]) {
            return;
        }
        p.stream.createFrame(245);
        p.stream.writeWordBigEndian(interfaceId);
        p.stream.writeWordBigEndian(childId);
        p.stream.writeWord(emoteId);
    }

    /**
     * Setting client configs.
     * <p>This is used for setting prayers, running, etc.
     * @param p The Player which the frame should be created for.
     * @param id The config id to set.
     * @param set What to set the config.
     */
    public void setConfig(Player p, int id, int set) {
        if (p == null || p.stream == null || p.disconnected[0]) {
            return;
        }
        if (set < 128) {
            setConfig1(p, id, set);
        } else {
            setConfig2(p, id, set);
        }
    }

    public void setConfig1(Player p, int id, int set) {
        p.stream.createFrame(100);
        p.stream.writeWordA(id);
        p.stream.writeByteA(set);
    }

    public void setConfig2(Player p, int id, int set) {
        p.stream.createFrame(161);
        p.stream.writeWord(id);
        p.stream.writeDWord_v1(set);
    }

    /**
     * Creates a projectile. Can be used for magic, range etc.
     * @param p The Player which the frame should be created for.
     * @param CasterY The caster absY
     * @param CasterX The caster absX
     * @param offsetY The distance between caster and enemy Y
     * @param offsetX The distance between caster and enemy X
     * @param angle The starting place of the projectile
     * @param speed The speed minus the distance making it set.
     * @param gfxMoving The moving graphic ID
     * @param startHeight The starting height
     * @param endHeight The destination height
     * @param lockon The NPC the missile is locked onto.
     * */
    public void createProjectile(Player p, int casterY, int casterX, int offsetY, int offsetX, int angle,
            int speed, int gfxMoving, int startHeight, int endHeight, int lockon) {
        if (p == null || p.stream == null) {
            return;
        }
        sendCoords(p, (casterX - ((p.mapRegionX - 6) * 8)) - 3,
                (casterY - ((p.mapRegionY - 6) * 8)) - 2);
        p.stream.createFrame(112);
        p.stream.writeByte(angle);
        p.stream.writeByte(offsetX);
        p.stream.writeByte(offsetY); 
        p.stream.writeRShort(lockon); 
        p.stream.writeWord(gfxMoving); 
        p.stream.writeByte(startHeight); 
        p.stream.writeByte(endHeight); 
        p.stream.writeWord(51); 
        p.stream.writeWord(speed); 
        p.stream.writeByte(16);
        p.stream.writeByte(64);							
    }
	
    /**
     * Creates a Global Projectiles.
     * @param Objectid The Id of the Object to spawn.
     * @param Heigh The Height to spawn the Object on.
     * @param ObjectX The AbsX to spawn the Object on.
     * @param ObjectY The AbsY to spawn the Object on.
     * @param Face The Position for the OBject to face 
     * @param Type Object Type
     * */
    public void createGlobalProjectile(int casterY, int casterX, int offsetY, int offsetX, int gfxMoving, int startHeight, int endHeight, int speed, int atkIndex) {
        for (Player p : Engine.players) {
            if (p == null || p.disconnected[0]) {
                continue;
            }
            // createProjectile(p, casterY, casterX, offsetY, offsetX, angle, speed, gfxMoving, startHeight, endHeight, lockon)
            p.frames.createProjectile(p, casterY, casterX, offsetY, offsetX, 50,
                    speed, gfxMoving, startHeight, endHeight, atkIndex);
        }
    }

    public void setBankOptions(Player p) {
        if (p == null || p.stream == null || p.disconnected[0]) {
            return;
        }
        p.stream.createFrame(223);
        p.stream.writeWord(496);
        p.stream.writeWordBigEndianA(0);
        p.stream.writeWordBigEndian(73);
        p.stream.writeWordBigEndian(762);
        p.stream.writeWordBigEndian(1278);
        p.stream.writeWordBigEndian(20);
        p.stream.createFrame(223);
        p.stream.writeWord(27);
        p.stream.writeWordBigEndianA(0);
        p.stream.writeWordBigEndian(0);
        p.stream.writeWordBigEndian(763);
        p.stream.writeWordBigEndian(1150);
        p.stream.writeWordBigEndian(18);
    }

    /**
     * Set the run energy on the client.
     * @param p The Player which the frame should be created for.
     */
    public void setEnergy(Player p) {
        if (p == null || p.stream == null || p.disconnected[0]) {
            return;
        }
        p.stream.createFrame(99);
        p.stream.writeByte(p.runEnergy);
    }

    /**
     * Setting a tab.
     * @param p The Player which the frame should be created for.
     * @param tabId Which tab to display the interface on.
     * @param childId The interface to display on the tab.
     */
    public void setTab(Player p, int tabId, int childId) {
        setInterface(p, 1, childId == 137 ? 752 : 548, tabId, childId);
    }

    /**
     * Set the overlay to be displayed.
     * @param p The Player which the frame should be created for.
     * @param childId The interface id to display as an overlay.
     */
    public void setOverlay(Player p, int childId) {
        setInterface(p, 1, 548, 5, childId);
    }

    /**
     * Remove any overlays that might be set.
     * @param p The Player which the frame should be created for.
     */
    public void removeOverlay(Player p) {
        setInterface(p, 1, 548, 5, 56);
    }

    /**
     * Display an interface on the main area in the screen.
     * @param p The Player which the frame should be created for.
     * @param childId the interface id to display.
     */
    public void showInterface(Player p, int childId) {
        setInterface(p, 0, 548, 8, childId);
        p.interfaceId = childId;
    }

    /**
     * Remove an interface on the main screen.
     * @param p The Player which the frame should be created for.
     */
    public void removeShownInterface(Player p) {
        setInterface(p, 1, 548, 8, 56);
        p.interfaceId = -1;
    }

    
    /**
     * Display an interface on the chatbox.
     * @param p The Player which the frame should be created for.
     * @param childId The interface to display on the chatbox.
     */
    public void showChatboxInterface(Player p, int childId) {
        setInterface(p, 0, 752, 12, childId);
        p.chatboxInterfaceId = childId;
    }

    /**
     * Set the chatbox back removing any interfaces on it.
     * @param p The Player which the frame should be created for.
     */
    public void removeChatboxInterface(Player p) {
        setConfig(p, 334, 1);
        p.stream.createFrame(246);
        p.stream.writeWord(752);
        p.stream.writeWord(12);
        p.chatboxInterfaceId = -1;
    }

    /**
     * Set the inventory.
     * @param p The Player which the frame should be created for.
     * @param childId The interface to display on the inventory.
     */
    public void setInventory(Player p, int childId) {
        setInterface(p, 0, 548, 71, childId);
    }

    /**
     * Set interface defaults at login.
     * @param p The Player which the frame should be created for.
     */
    public void setInterfaces(Player p) {
        if (p == null || p.disconnected[0]) {
            return;
        }
        setTab(p, 6, 745);
        setTab(p, 11, 751); // Chat options
        setTab(p, 68, 752); // Chatbox
        setTab(p, 64, 748); // HP bar
        setTab(p, 65, 749); // Prayer bar
        setTab(p, 66, 750); // Energy bar
        setTab(p, 67, 747); // Summoning bar
        setTab(p, 8, 137); // Playername on chat
        setTab(p, 73, 92); // Attack tab
        setTab(p, 74, 320); // Skill tab
        setTab(p, 75, 274); // Quest tab
        setTab(p, 76, 149); // Inventory tab
        setTab(p, 77, 387); // Equipment tab
        setTab(p, 78, 271); // Prayer tab
        setTab(p, 79, 192); // Magic tab
        setTab(p, 81, 550); // Friend tab
        setTab(p, 82, 551); // Ignore tab
        setTab(p, 83, 589); // Clan tab
        setTab(p, 84, 261); // Setting tab
        setTab(p, 85, 464); // Emote tab
        setTab(p, 86, 187); // Music tab
        setTab(p, 87, 182); // Logout tab
    }

    /**
     * Set interface defaults at login.
     * @param p The Player which the frame should be created for.
     */
    public void setConfigs(Player p) {
        if (p == null || p.disconnected[0]) {
            return;
        }
        // setConfig(p, 1021, 1); tab flashing
        setConfig(p, 1160, -1);
        setConfig(p, 173, 0);
        setConfig(p, 313, -1);
        setConfig(p, 465, -1);
        setConfig(p, 802, -1);
        setConfig(p, 1085, 249852);
    }

    /**
     * Set welcome interface.
     * @param p The Player which the frame should be created for.
     */
    public void setWelcome(Player p) {
        if (p == null || p.disconnected[0]) {
            return;
        }
        setWindowPane(p, 549);
        setInterface(p, 1, 549, 2, 378);
        setInterface(p, 1, 549, 3, 17); // can use 15 - string 0 and 4, 17 - string 0 and 3, and 447 - string 0, 1 and 2.


if(p.RandomMessage == 0)
{
        setString(p, "Use the skills tab to teleport to train those skills!", 17, 0);
}
if(p.RandomMessage == 1)
{
        setString(p, "Did you know, Martin Thwait is a banker too!", 17, 0);
}
if(p.RandomMessage == 2)
{
        setString(p, "You can get money from pickpocketing.", 17, 0);
}
if(p.RandomMessage == 3)
{
        setString(p, "Construction is Easiest to 99, but way expensive!", 17, 0);
}
if(p.RandomMessage == 4)
{
        setString(p, "Skill masters can help you get started on a skill.", 17, 0);
}

if(p.RandomMessage == 5)
{
        setString(p, "Brother Jered gives you dragon bones after level 70!", 17, 0);
}
if(p.RandomMessage == 6)
{
        setString(p, "Hiko is the owner of this server.", 17, 0);
}
if(p.RandomMessage == 7)
{
        setString(p, "Cooking is the Easiest to 99.", 17, 0);
}
if(p.RandomMessage == 8)
{
        setString(p, "You can build your own house on this server!", 17, 0);
}
if(p.RandomMessage == 9)
{
        setString(p, "Dragon Slayer Quest now available.", 17, 0);
}



        setString(p, "",
                17, 3);
        setString(p, "No unread messages", 378, 37);
        setString(p, p.messageCount + "", 378, 39);
        setString(p, "", 378, 94);
        setString(p,
                "You have " + p.memberCount
                + " days of member credit remaining. Please click here to extend your credit",
                378,
                93);
        setString(p, p.memberCount + "", 378, 96);
        setString(p, "Welcome to NaoScape", 378, 115);
        setString(p, "", 378, 116);
    }

    /**
     * Send coordinates, used with other frames.
     * @param p The Player which the frame should be created for.
     * @param x The x coordinate.
     * @param y The y coordinate.
     */
    public void sendCoords(Player p, int x, int y) {
        if (p == null || p.stream == null || p.disconnected[0]) {
            return;
        }
        p.stream.createFrame(177);
        p.stream.writeByte(y);
        p.stream.writeByteS(x);
    }

    /**
     * Creates an item on the ground at itemX and itemY.
     * @param p The Player which the frame should be created for.
     * @param itemId The item id to be displayed.
     * @param itemAmt The amount the item stack size is.
     * @param itemX The absolute x coordinate to display the item.
     * @param itemY The absolute y coordinate to display the item.
     * @param itemHeight The height level to set the item.
     */
    public void createGroundItem(Player p, int itemId, int itemAmt, int itemX, int itemY, int itemHeight) {
        if (p == null || p.stream == null || p.disconnected[0]) {
            return;
        }
        if (Misc.getDistance(itemX, itemY, p.absX, p.absY) <= 60
                && p.heightLevel == itemHeight) {
            sendCoords(p, (itemX - ((p.mapRegionX - 6) * 8)),
                    (itemY - ((p.mapRegionY - 6) * 8)));
            p.stream.createFrame(25);
            p.stream.writeWordBigEndianA(itemAmt);
            p.stream.writeByte(0);
            p.stream.writeWordBigEndianA(itemId);
        }
    }

    /**
     * Removes an item on the ground at itemX and itemY.
     * @param p The Player which the frame should be created for.
     * @param itemId The item id to remove.
     * @param itemX The absolute x coordinate to remove the item.
     * @param itemY The absolute y coordinate to remove the item.
     * @param itemHeight The height level toe remove the item at.
     */
    public void removeGroundItem(Player p, int itemId, int itemX, int itemY, int itemHeight) {
        if (p == null || p.stream == null || p.disconnected[0]) {
            return;
        }
        if (Misc.getDistance(itemX, itemY, p.absX, p.absY) <= 60
                && p.heightLevel == itemHeight) {
            sendCoords(p, (itemX - ((p.mapRegionX - 6) * 8)),
                    (itemY - ((p.mapRegionY - 6) * 8)));
            p.stream.createFrame(201);
            p.stream.writeByte(0);
            p.stream.writeWord(itemId);
        }
    }

    /**
     * Send players stat.
     * @param p The Player which the frame should be created for.
     * @param lvlId The stat id to send.
     */
    public void setSkillLvl(Player p, int lvlId) {
        if (p == null || p.stream == null || p.disconnected[0]) {
            return;
        }
        p.stream.createFrame(217);
        p.stream.writeByteC(p.skillLvl[lvlId]);
        p.stream.writeDWord_v2(p.skillXP[lvlId]);
        p.stream.writeByteC(lvlId);
    }

    /**
     * Set item display on an interface.
     * @param p The Player which the frame should be created for.
     * @param interfaceId The interface to display the items on.
     * @param childId The child interface on the main interface.
     * @param itemArray The item id array to set on the interface.
     * @param itemAmt The item array to go with the itemArray.
     */
    public void setItems(Player p, int interfaceId, int childId, int type, int[] itemArray, int[] itemAmt) {
        if (p == null || p.stream == null || p.disconnected[0]) {
            return;
        }
        p.stream.createFrameVarSizeWord(255);
        p.stream.writeWord(interfaceId);
        p.stream.writeWord(childId);
        p.stream.writeWord(type);
        p.stream.writeWord(itemArray.length);
        for (int i = 0; i < itemArray.length; i++) {
            if (itemAmt[i] > 254) {
                p.stream.writeByteS(255);
                p.stream.writeDWord_v2(itemAmt[i]);
            } else {
                p.stream.writeByteS(itemAmt[i]);
            }
            p.stream.writeWordBigEndian(itemArray[i] + 1);
        }
        p.stream.endFrameVarSizeWord();
    }



    /**
     * Set interface configs.
     * <p>This is used to do things such as hiding and displaying the special attack bar.
     * @param p The Player which the frame should be created for.
     * @param interfaceId The interface to the set the config with.
     * @param childId The child that belongs to the interface to change.
     * @param 1 for true, 0 for false.
     */
    public void setInterfaceConfig(Player p, int interfaceId, int childId, boolean set) {
        if (p == null || p.stream == null || p.disconnected[0]) {
            return;
        }
        p.stream.createFrame(59);
        p.stream.writeByteC(set ? 1 : 0);
        p.stream.writeWord(childId);
        p.stream.writeWord(interfaceId);
    }

    /**
     * Display a message in the chatbox.
     * @param p The Player which the frame should be created for.
     * @param s The message to display in the chatbox.
     */
    public void sendMessage(Player p, String s) {
        if (p == null || p.stream == null || p.disconnected[0]) {
            return;
        }
        p.stream.createFrameVarSize(218);
        p.stream.writeString(s);
        p.stream.endFrameVarSize();
    }

    /**
     * Set a string on an interface.
     * @param p The Player which the frame should be created for.
     * @param str The string to set on the interface.
     * @param interfaceId The interface to set the text on.
     * @param childId The interface's child to set the text on.
     */
    public void setString(Player p, String str, int interfaceId, int childId) {
        if (p == null || p.stream == null || p.disconnected[0]) {
            return;
        }
        int sSize = str.length() + 5;

        p.stream.createFrame(179);
        p.stream.writeByte(sSize / 256);
        p.stream.writeByte(sSize % 256);
        p.stream.writeString(str);
        p.stream.writeWord(childId);
        p.stream.writeWord(interfaceId);
    }

    /**
     * Send this player's updated coordinates.
     * @param p The Player which the frame should be created for.
     */
    public void updateMovement(Player p) {
        if (p == null || p.stream == null || p.disconnected[0]) {
            return;
        }
        p.stream.createFrameVarSizeWord(216);
        p.stream.initBitAccess();
        p.stream.writeBits(1, 1);
        if (p.runDir == -1) {
            p.stream.writeBits(2, 1);
            p.stream.writeBits(3, p.walkDir);
            p.stream.writeBits(1, p.updateReq ? 1 : 0);
        } else {
            p.stream.writeBits(2, 2);
            p.stream.writeBits(3, p.runDir);
            p.stream.writeBits(3, p.walkDir);
            p.stream.writeBits(1, p.updateReq ? 1 : 0);
            if (p.runEnergy > 0) {
                p.runEnergyUpdateReq = true;
                p.runEnergy--;
            } else {
                p.isRunning = false;
            }
        }
    }

    /**
     * Tell the client this player isn't moving.
     * @param p The Player which the frame should be created for.
     */
    public void noMovement(Player p) {
        if (p == null || p.stream == null || p.disconnected[0]) {
            return;
        }
        p.stream.createFrameVarSizeWord(216);
        p.stream.initBitAccess();
        p.stream.writeBits(1, p.updateReq ? 1 : 0);
        if (p.updateReq) {
            p.stream.writeBits(2, 0);
        }
    }

    /**
     * Changes the coordinates this player is standing at.
     * @param p The Player which the frame should be created for.
     */
    public void teleport(Player p) {
        if (p == null || p.stream == null || p.disconnected[0]) {
            return;
        }
        p.stream.createFrameVarSizeWord(216);
        p.stream.initBitAccess();
        p.stream.writeBits(1, 1);
        p.stream.writeBits(2, 3);
        p.stream.writeBits(7, p.currentX);
        p.stream.writeBits(1, 1);
        p.stream.writeBits(2, p.heightLevel);
        p.stream.writeBits(1, p.updateReq ? 1 : 0);
        p.stream.writeBits(7, p.currentY);
    }

    /**
     * Send the map region and other positioning info to the client.
     * @param p The Player which the frame should be created for.
     */
    public void setMapRegion(Player p) {
        if (p == null || p.stream == null || p.disconnected[0]) {
            return;
        }
        p.stream.createFrameVarSizeWord(142);
        p.stream.writeWordA(p.mapRegionX);
        p.stream.writeWordBigEndianA(p.currentY);
        p.stream.writeWordA(p.currentX);
        boolean forceSend = true;
		p.rebuildNPCList = true;

        if ((((p.mapRegionX / 8) == 48) || ((p.mapRegionX / 8) == 49))
                && ((p.mapRegionY / 8) == 48)) {
            forceSend = false;
        }
        if (((p.mapRegionX / 8) == 48) && ((p.mapRegionY / 8) == 148)) {
            forceSend = false;
        }
        for (int xCalc = (p.mapRegionX - 6) / 8; xCalc
                <= ((p.mapRegionX + 6) / 8); xCalc++) {
            for (int yCalc = (p.mapRegionY - 6) / 8; yCalc
                    <= ((p.mapRegionY + 6) / 8); yCalc++) {
                int region = yCalc + (xCalc << 1786653352);

                if (forceSend
                        || ((yCalc != 49) && (yCalc != 149) && (yCalc != 147)
                        && (xCalc != 50) && ((xCalc != 49) || (yCalc != 47)))) {
                    int[] mapData = Engine.mapData.getData(region);

                    p.stream.writeDWord(mapData[0]);
                    p.stream.writeDWord(mapData[1]);
                    p.stream.writeDWord(mapData[2]);
                    p.stream.writeDWord(mapData[3]);
                }
            }
        }
        p.stream.writeByteC(p.heightLevel);
        p.stream.writeWord(p.mapRegionY);
        p.stream.endFrameVarSizeWord();
    }
}
