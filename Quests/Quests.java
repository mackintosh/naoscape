

package Naoscape.Quests;


import java.io.*;
import Naoscape.net.SocketListener;
import Naoscape.players.PlayerSave;
import Naoscape.util.Misc;


public abstract class Quests {

   	// The name of this quest.
    	protected String name = "";
    	// The unique ID of this quest (MUST BE UNIQUE!!!)
    	protected int uid = -1;
    	// The current 'stage' of this quest.
    	protected int stage = -1;
    	// The stage that this quest finishes at.
    	protected int finalStage = -1;

    	public abstract void define();
    	public abstract void completeQuest();
    
    	/**
     	* @return The unique ID of this quest.
     	*/
    	public final int getUID()
    	{
    		return uid;
    	}
    
    	/**
     	* Changes the current stage of this quest.
     	*/
    	public final void setStage(int stage)
    	{
    		this.stage = stage;
    	
    		if(stage == finalStage)
    			completeQuest();
    		
    		if(stage != 1)
    			System.out.println("Successfully saved quest (stage = " + stage + ").");
    	}
    
    	/**
     	* Sets the final stage of this quest.
     	*/
    	public final void setFinalStage(int stage)
    	{
    		this.finalStage = stage;
    	}
    
    	/**
     	* @return This quest's finishing stage.
     	*/
    	public final int getFinalStage()
    	{
    		return finalStage;
    	}
    
    	/**
     	* @return If this quest has been completed.
     	*/
    	public final boolean completed()
    	{
    		return stage == finalStage;
    	}
    
    	/**
     	* @return This quest's current stage.
     	*/
    	public final int getStage()
    	{
    		return stage;
    	}
    
    	/**
     	* Changes the name of this quest.
     	*/
    	public final void setName(String name)
    	{
    		this.name = name;
    	}

	public final boolean questStarted()
	{
		return stage != -1;
	}
	
	/**
	 * @return This quest's name.
	 */
	public final String getName()
	{
		return name;
	}
	
	/**
	 * Pauses the current thread.
	 */
	public final void sleep(long ms)
	{
		try { Thread.sleep(ms); } catch(InterruptedException ie){}
	}

}