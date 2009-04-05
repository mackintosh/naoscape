
package Naoscape.Quests;

import Naoscape.players.Player;

import java.io.File;
import java.util.Vector;

public class QuestLoader
{
	private static Vector<Class> classes = null;
	
	public final static void loadClasses()
	{
		/** QUEST LOADING **/
        	classes.clear();
        
        	File f = new File(System.getProperty("user.dir") + File.separator + "quests" + File.separator);
        	String[] files = f.list();

		System.out.println();
        	System.out.println("<-- Loading Quest class files -->");
        	System.out.println();
        
        	for(int x = 0; x < files.length; x++) 
        	{
           		try 
            		{
                		if(files[x].endsWith(".class") && files[x].indexOf('$') < 0)
               			{       	
	                    		Class c = Class.forName(files[x].substring(0, files[x].length() - 6));
	                    		String t = files[x].substring(0, files[x].length() - 6).toLowerCase();
	                    		classes.add(c);
	                    		System.out.println(" - Loaded:   " + t);
                		}
            		} catch(Exception e) 
            		{
                		e.printStackTrace();
            		}
        	}
        
        	System.out.println();
        	System.out.println("<-- " + classes.size() + " Quest class files loaded -->");
        	System.out.println();
	}
	
	public final static Vector<Class> getClasses()
	{
		if (classes == null) {
			return null;
		}	
		return (Vector<Class>)classes.clone();
	}
	
	public final static void initClasses() {
		if (classes == null) {
			classes = new Vector<Class>();
			loadClasses();
		}
	}
}