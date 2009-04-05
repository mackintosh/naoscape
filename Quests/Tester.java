
package Naoscape.Quests;


import java.io.*;
import Naoscape.net.SocketListener;
import Naoscape.players.PlayerSave;
import Naoscape.util.Misc;
import Naoscape.Quests.*;
import Naoscape.Server;
import Naoscape.Engine;
import Naoscape.players.Player;
import Naoscape.util.Misc;
import Naoscape.io.*;


public abstract class Tester extends Quests {
        
    	protected String name = "";

    	protected int uid = 1;

    	protected int stage = -1;

    	protected int finalStage = 50;

	/**
	 * This is an abstract Method, and as such
	 * must be overwritten by every subclass of 
	 * Quest. It defines the unique features of
	 * each quest - its name, its 'completion stage',
	 * any items, npcs, objects that are associated
	 * with it.
	 */
	public void define()
	{
		setName("Tester"); // Sets the name of this quest.
		setFinalStage(100); // The stage at which this quest ends.
	}

	/**
	 * Also an abstract Method that must be overwritten.
	 * This is called when the getFinalStage() is met.
	 */
	public void completeQuest(Player p)
	{
                Engine.playerItems.addItem(p, 995, 500); // gives 500 coins on complete
		
		sleep(2500); // waits 2500 mil secounds
		
		p.frames.sendMessage(p, "You have completed " + getName() + "!"); // send message
		p.frames.sendMessage(p, "@gre@You just gained 1 quest point!"); // send message
		}
	}