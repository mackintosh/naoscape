package Naoscape.io.packets;

import Naoscape.Engine;
import Naoscape.players.*;
import Naoscape.util.Misc;
import Naoscape.npcs.NPC;

public class bountyHunter {
/**
Author Mad Turnip
**/
	public bountyHunter(){
	
	}
	public void enterBounty(Player p){
		if(p == null || !p.online){
			return;
		}
		p.bountyOpp = 0;
		p.frames.setTab(p, 8, 653);
		getOpponent(p);
		p.pkIcon = 3;
	}
	public void leaveBounty(Player p){
		if(p == null || !p.online){
			return;
		}
		Player plr = Engine.players[p.bountyOpp];
		if(plr == null || !plr.online){
			return;
		}
		plr.frames.sendMessage(plr,"target has died / left bounty hunter");
		plr.bountyOpp = 0;
                p.bountyOpp = 0;
		getOpponent(plr);
	}

	public boolean bountyArea(int coordX,int coordY){
		if(coordX >= 3085 && coordX <= 3185 && coordY >= 3662 && coordY <= 3765)
			return true;
		return false;
	}
	public void getOpponent(Player p){
		if(p == null){
			return;
		}
		if(!bountyArea(p.absX,p.absY) || p.skillLvl[3] <= 0 ){
			return;
		}
		for (Player p2: Engine.players) {
            if (p2 == null || !p2.online) {
                continue;
			}
			if(!bountyArea(p2.absX,p2.absY) || p2.bountyOpp > 0 || p2 == p){
				continue;
			}
			p.frames.sendMessage(p,"An opponent has been found username: "+p2.username);
			p2.frames.sendMessage(p2,"An opponent has been found username: "+p.username);
			p.bountyOpp = p2.playerId;
			p2.bountyOpp = p.playerId;
			p.frames.setString(p, p2.username, 653, 8);
			p2.frames.setString(p2, p.username, 653, 8);
			p2.frames.setTab(p2, 8, 653);
			return;
		}
		p.frames.setString(p, "none", 653, 8);
		p.bountyOpp = 0;
	}
}

