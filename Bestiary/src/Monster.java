/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author marthahamlin
 */

/*  Monster Tags
 * 
 * 0    Magical
 * 1    Devious
 * 2    Amorphous
 * 3    Organized
 * 4    Intelligent
 * 5    Hoarder
 * 6    Stealthy
 * 7    Terrifying
 * 8    Cautious
 * 9    Construct
 * 10   Planar
 * 11   Horde
 * 12   Group
 * 13   Solitary
 * 14   Tiny
 * 15   Small
 * 16   Normal
 * 17   Large
 * 18   Huge
 * 
 */

/*  Attack Tags
 * 
 * 0    Ammo
 * 1    Forceful
 * 2    Ignores Armor
 * 3    Messy
 * 4    Piercing
 * 5    Precise
 * 6    Reload
 * 7    Stun
 * 8    Thrown
 * 9    Hand
 * 10   Close
 * 11   Reach
 * 12   Near
 * 13   Far
 */
import java.util.ArrayList;
import java.util.Arrays;

public class Monster {
    
    String name;
        
    boolean canFight;
    int hp;
    int armor;
    String attackName;
    Dice dmgDice;
    int dmgMod;
    RollType dmgRoll;
    
    String instinct;
    String description;
    boolean[] tags;
    ArrayList<String> specialQualities;
    boolean[] attackTags;
    ArrayList<String> moves;
    int ammo;
    int piercing;
    
    public Monster(){
        name = "";
        
        canFight = false;
        hp = 0;
        armor = 0;
        attackName = "";
        dmgDice = Dice.D_FOUR;
        dmgMod = 0;
        dmgRoll = RollType.NORMAL;
        attackTags = new boolean[14];
        Arrays.fill(attackTags, false);
        
        instinct = "";
        
        description = "";
        
        tags = new boolean[19];
        Arrays.fill(tags, false);
        
        specialQualities = new ArrayList<String>();
        
        moves = new ArrayList<String>();
    }
    
    public void setName(String s){
        name = s;
    }
    
    public String getName(){
        return name;
    }
    
    public void setCanFight(boolean b){
        canFight = b;
    }
    
    public boolean getCanFight(){
        return canFight;
    } 
    
    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public String getAttackName() {
        return attackName;
    }

    public void setAttackName(String attackName) {
        this.attackName = attackName;
    }

    public Dice getDmgDice() {
        return dmgDice;
    }

    public void setDmgDice(Dice dmgDice) {
        this.dmgDice = dmgDice;
    }

    public int getDmgMod() {
        return dmgMod;
    }

    public void setDmgMod(int dmgMod) {
        this.dmgMod = dmgMod;
    }

    public RollType getDmgRoll() {
        return dmgRoll;
    }

    public void setDmgRoll(RollType dmgRoll) {
        this.dmgRoll = dmgRoll;
    }

    public String getInstinct() {
        return instinct;
    }

    public void setInstinct(String instinct) {
        this.instinct = instinct;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
    

