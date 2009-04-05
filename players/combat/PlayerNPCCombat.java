
package Naoscape.players.combat;


import Naoscape.Engine;
import Naoscape.players.Player;
import Naoscape.players.items.PlayerWeapon;
import Naoscape.util.Misc;
import Naoscape.npcs.NPC;


public class PlayerNPCCombat {
    public void attackNPC(Player p) {
        NPC n = Engine.npcs[p.attackNPC];		
		
        int hitDamage = Misc.random(maxMeleeHit(p));
        int hitDamage2 = Misc.random(hitDamage);
		int CombatXPRate = 100;

        int offsetX = (p.absX - n.absX) * -1;
        int offsetY = (p.absY - n.absY) * -1;	

        if (p.attackNPC <= 0 || p.attackNPC >= Engine.npcs.length || n == null
                || n.isDead || p.isDead) {
            resetAttack(p);
        }

if(n.isDead == true)
{
if(n.npcType == 742 && p.DragonSlayer == 3)
{
p.HeadTimer = 8;
p.DragonSlayer = 4;
Engine.playerItems.addItem(p, 11279, 1);
p.frames.sendMessage(p,"You slayed Elvarg and took his head!");
}
}
if(n.isDead == true)
{
if(n.npcType == 1465 && p.Quests == 4)
{
p.Quests = 5;
p.frames.sendMessage(p,"Barbarian spirit wtf!");
Engine.newSummonNPC(749, p.absX, p.absY+1, p.heightLevel, p.absX + 1, p.absY + 1, p.absX + -1, p.absY + -1, false, p.playerId);
}
}
if(n.isDead == true)
{
if(n.npcType == 749 && p.Quests == 5)
{
p.Quests = 6;
p.frames.sendMessage(p,"Wow now it's a Dragon!");
Engine.newSummonNPC(55, p.absX, p.absY+1, p.heightLevel, p.absX + 1, p.absY + 1, p.absX + -1, p.absY + -1, false, p.playerId);
}
}
if(n.isDead == true)
{
if(n.npcType == 55 && p.Quests == 6)
{
p.Quests = 7;
p.frames.sendMessage(p,"Woot all dead and theres the ring!");
}
}
if(n.isDead == true && p.SlayerAm > 0)
{
if(p.SlayerTask == 0 && n.npcType == 941)
{
p.SlayerAm -= 1;
p.addSkillXP(150*p.skillLvl[18], 18);
}
if(p.SlayerTask == 0 && n.npcType == 55)
{
p.SlayerAm -= 1;
p.addSkillXP(150*p.skillLvl[18], 18);
}
if(p.SlayerTask == 0 && n.npcType == 53)
{
p.SlayerAm -= 1;
p.addSkillXP(150*p.skillLvl[18], 18);
}
if(p.SlayerTask == 0 && n.npcType == 5363)
{
p.SlayerAm -= 1;
p.addSkillXP(500*p.skillLvl[18], 18);
}
if(p.SlayerTask == 1 && n.npcType == 9)
{
p.SlayerAm -= 1;
p.addSkillXP(250*p.skillLvl[18], 18);
}
if(p.SlayerTask == 2 && n.npcType == 110 || p.SlayerTask == 2 && n.npcType == 111 || p.SlayerTask == 2 && n.npcType == 112)
{
p.SlayerAm -= 1;
p.addSkillXP(250*p.skillLvl[18], 18);
}
if(p.SlayerTask == 3 && n.npcType == 4387 || p.SlayerTask == 3 && n.npcType == 6998)
{
p.SlayerAm -= 1;
p.addSkillXP(400*p.skillLvl[18], 18);
}
if(p.SlayerTask == 4 && n.npcType == 21)
{
p.SlayerAm -= 1;
p.addSkillXP(250*p.skillLvl[18], 18);
}
}

        if (p.combatDelay > 0) {
            return;
        }
        if (Misc.getDistance(n.absX, n.absY, p.absX, p.absY) >= 1
                && UsingABow(p.equipment[3])) {
            p.teleportToX = p.absX;
            p.teleportToY = p.absY;
            if (p.equipment[3] == 4214) {
                p.requestAnim(p.attackEmote, 0);
                p.requestGFX(250, 100);
                p.combatDelay = p.attackDelay;				
                p.frames.createGlobalProjectile(p.absY, p.absX, offsetY, offsetX,
                        249, 43, 31, 70, n.npcId);   			
                p.requestFaceTo(n.npcId);
                n.appendHit(hitDamage, 0);
				
                n.requestAnim(n.defendEmote, 0);
            } else if (arrowNot(p.equipment[13])) {
                if (!p.usingSpecial) {
                    p.requestAnim(p.attackEmote, 0);
                } else if (p.usingSpecial) {
                    p.usingSpecial = false;
                    p.frames.setConfig(p, 301, 0); 
                    p.requestAnim(p.attackEmote, 0);	
                }		
                p.requestGFX(fetchArrowBack(p.equipment[13]), 100); 
                p.frames.createGlobalProjectile(p.absY, p.absX, offsetY,
                        offsetX, fetchArrowAir(p.equipment[13]), 43, 31, 70,
                        n.npcId); 
                p.combatDelay = p.attackDelay;				
                p.requestFaceTo(n.npcId);
                n.appendHit(Misc.random(p.skillLvl[4]/4), 0);

if(p.skillLvl[4] < 15) 
{
hitDamage = 1;
}
else
{
  hitDamage = p.skillLvl[4]/4;
}
                n.requestAnim(424, 0);
   		p.addSkillXP(4 * hitDamage * CombatXPRate ,4);
p.addSkillXP(2 * hitDamage * CombatXPRate ,3);
                if (!n.attackingPlayer) {
                    n.attackingPlayer = true;
                    n.attackPlayer = p.playerId;
                }	
            } else {
                p.frames.sendMessage(p,
                        "You need some arrows to attack a player");
                resetAttack(p);
            }
        } else if (Misc.getDistance(n.absX, n.absY, p.absX, p.absY) <= 1
                && UsingABow(p.equipment[3]) == false) {
            if (!p.usingSpecial) {
                p.requestAnim(p.attackEmote, 0);
            } else if (p.usingSpecial) {
                p.frames.setConfig(p, 301, 0); 
                if (p.equipment[3] == 11694 && p.specialAmount >= 50) { // Armadyl godsword.
                    hitDamage = Misc.random((int) (maxMeleeHit(p) * 1.25));
                    p.usingSpecial = false;
                    p.specialAmount -= 50;
                    p.requestAnim(7074, 0);
                    p.requestGFX(1222, 0);
                } else if (p.equipment[3] == 11696 && p.specialAmount == 100) { // Bandos godsword.
                    hitDamage = Misc.random(
                            (int) (maxMeleeHit(p) * 1.1));
                    p.usingSpecial = false;
                    p.specialAmount -= 100;
                    p.requestAnim(7073, 0);
                    p.requestGFX(1223, 0);
                } else if (p.equipment[3] == 11698 && p.specialAmount >= 75) { // Saradomin godsword.
                    hitDamage = Misc.random((int) (maxMeleeHit(p) * 1.1));
                    p.usingSpecial = false;
                    p.specialAmount -= 75;
                    p.requestAnim(7071, 0);
                    p.requestGFX(1220, 0);
                } else if (p.equipment[3] == 11700 && p.specialAmount >= 75) { // Zamorak godsword.
                    hitDamage = Misc.random((int) (maxMeleeHit(p) * 1.1));
                    p.usingSpecial = false;
                    p.specialAmount -= 50;
                    p.requestAnim(7070, 0);
                    p.requestGFX(1221, 0);
                } else if (p.equipment[3] == 4151 && p.specialAmount >= 50) { // Abyssal whip.
                    hitDamage = Misc.random((int) (maxMeleeHit(p) * 0.9));
                    p.usingSpecial = false;
                    p.specialAmount -= 50;
                    p.requestAnim(1658, 0);
                    n.requestGFX(341, 100);
                } else if (p.equipment[3] == 1305 && p.specialAmount >= 25) { // Dragon longsword.
                    hitDamage = Misc.random((int) (maxMeleeHit(p) * 1.0));
                    p.usingSpecial = false;
                    p.specialAmount -= 25;
                    p.requestAnim(1058, 0);
                    p.requestGFX(248, 100);
                    p.requestAnim(1658, 0);
                } else if (p.equipment[3] == 4587 && p.specialAmount >= 70) { // Dragon scimitar.
                    hitDamage = Misc.random((int) (maxMeleeHit(p) * 1.0));
                    p.usingSpecial = false;
                    p.specialAmount -= 70;
                    p.requestAnim(2081, 0);
                    p.requestGFX(347, 100);
                } else if (p.equipment[3] == 1434 && p.specialAmount >= 40) { // Dragon mace.
                    hitDamage = Misc.random((int) (maxMeleeHit(p) * 1.1));
                    p.usingSpecial = false;
                    p.specialAmount -= 40;
                    p.requestAnim(1060, 0);
                    p.requestGFX(251, 100);
                } else if (p.equipment[3] == 3204 && p.specialAmount >= 100) { // Dragon halberd.
                    hitDamage2 = Misc.random((int) (maxMeleeHit(p) * 1.1));
                    p.usingSpecial = false;
                    p.specialAmount -= 100;
                    p.requestAnim(1665, 0);
                    p.requestGFX(282, 100);
                    n.appendHit(hitDamage2, 0);
                } else if (p.equipment[3] == 5698 && p.specialAmount >= 25) { // Dragon dagger(s).
                    hitDamage2 = Misc.random((int) (maxMeleeHit(p) * 1.00));
                    p.usingSpecial = false;
                    p.specialAmount -= 25;
                    p.requestAnim(1062, 0);
                    p.requestGFX(252, 100);
                    n.appendHit(hitDamage2, 0);
                } else {
                    p.usingSpecial = false;
                    p.frames.sendMessage(p,
                            "You don't have enough special energy.");
                }
            }
            p.combatDelay = p.attackDelay;
            p.requestFaceTo(n.npcId);
            n.appendHit(hitDamage, 0);
							 if(p.attackStyle == 0) {
  		p.addSkillXP(4 * hitDamage * CombatXPRate ,0);
p.addSkillXP(2 * hitDamage * CombatXPRate ,3);
      } 
	  if(p.attackStyle == 1) {
   		p.addSkillXP(4 * hitDamage * CombatXPRate ,2);
p.addSkillXP(2 * hitDamage * CombatXPRate ,3);
      } if(p.attackStyle == 2) {
   		p.addSkillXP(4 * hitDamage * CombatXPRate ,1);
p.addSkillXP(2 * hitDamage * CombatXPRate ,3);
      } if(p.attackStyle == 3) {
   		p.addSkillXP((4 * hitDamage * CombatXPRate)/3 ,0);
   		p.addSkillXP((4 * hitDamage * CombatXPRate)/3 ,1);
   		p.addSkillXP((4 * hitDamage * CombatXPRate)/3 ,2);
p.addSkillXP(3 * hitDamage * CombatXPRate ,3);
      }
            n.requestAnim(n.defendEmote, 0);
            p.specialAmountUpdateReq = true;
            if (!n.attackingPlayer) {
                n.attackingPlayer = true;
                n.attackPlayer = p.playerId;
            }
        }
    }

    public static boolean UsingABow(int bow) {
        for (int i = 0; i < Bows.length; i++) {
            if (bow == Bows[i]) {
                return true;
            }
        }
        return false;
    }
    public static int Bows[] = {
        4212, 4214, 4215, 4216, 4217, 4218, 4219, 4220, 4221, 4222, 4223, 837,
        767, 4734, 839, 841, 843, 845, 847, 849, 851, 853, 855, 857, 859, 861,
        2883, 4827, 6724
    };
	
    public boolean arrowNot(int id) {
        if (id == 882) {
            return true;
        }
        if (id == 884) {
            return true;
        }
        if (id == 886) {
            return true;
        }
        if (id == 888) {
            return true;
        }
        if (id == 890) {
            return true;
        }
        if (id == 892) {
            return true;
        }	
        return false;
    }

    public int fetchArrowAir(int id) {
        if (id == 882) {
            return 10;
        }
        if (id == 884) {
            return 11;
        }
        if (id == 886) {
            return 12;
        }
        if (id == 888) {
            return 13;
        }
        if (id == 890) {
            return 14;
        }
        if (id == 892) {
            return 15;
        } else {
            return 500;
        }
    }
	
    public int fetchArrowBack(int id) {
        if (id == 882) {
            return 19;
        }
        if (id == 884) {
            return 18;
        }
        if (id == 886) {
            return 20;
        }
        if (id == 888) {
            return 21;
        }
        if (id == 890) {
            return 22;
        }
        if (id == 892) {
            return 24;
        } else {
            return 500;
        }
    }
	
    public int maxMeleeHit(Player p) {
        int a = p.skillLvl[2];
        int b = p.equipmentBonus[10];
        double c = (double) a;
        double d = (double) b;
        double f = 0;
        double h = 0;

        f = (d * 0.00175) + 0.1;
        h = Math.floor(c * f + 2.05);
        return (int) h;
    }

    public void resetAttack(Player p) {
        if (p == null) {
            return;
        }
        p.attackingNPC = false;
        if (p.faceToReq != 65535) {
            p.requestFaceTo(65535);
        }
    }
}
