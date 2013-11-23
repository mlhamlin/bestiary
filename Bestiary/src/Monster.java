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
    
    public String printName(){
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
    
    public String printHP(){
        return Integer.toString(hp);
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }
    
    public String printArmor(){
        return Integer.toString(armor);
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
    
    public String printDamageCore(){
        String s = "";
        switch (this.dmgDice){
            case D_FOUR :
                s = "d4";
                break;
            case D_SIX  :
                s = "d6";
                break;
            case D_EIGHT    :
                s = "d8";
                break;
            case D_TEN  :
                s = "d10";
                break;
            case D_TWELVE   :
                s = "d12";
                break;
            case D_TWENTY   :
                s = "d20";
                break;
        }
        
        if(this.dmgMod > 0){
            s += "+" + this.dmgMod;
        }else if(this.dmgMod < 0){
            s += "-" + this.dmgMod;
        }
        
        return s;
    }
        
    public String printAttackString(){
        String s = "";
        s += this.attackName + " (";
        switch (this.dmgRoll) {
            case NORMAL :
                s += printDamageCore() + " damage";
                break;
            case BESTOF :
                s += "b[2" + printDamageCore() + "] damage";
                break;
            case WORSTOF :
                s += "w[2" + printDamageCore() + "] damage";
                break;
        }
        
        if(attackTags[4]){
            s += " " + piercing + " piercing";
        }
        
        s += ")";
        
        return s;
    }

    public String getInstinct() {
        return instinct;
    }

    public void setInstinct(String instinct) {
        this.instinct = instinct;
    }
    
    public String printInstinct() {
        return instinct;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public String printDescription(){
        return description;
    }
    
     public ArrayList<String> getMoves() {
        return moves;
    }

    public void setMoves(ArrayList<String> moves) {
        this.moves = moves;
    }
       
    public String printMoves(){
        
        String s = "<html> <body bgcolor=\"#EEEEEE\"> <ul>";
        
        for(String str : this.moves){
            s += " <li>" + str + "</li> ";
        }
        
        s += " </ul> </body> </html> ";
        
        return s;
        
    }

    public ArrayList<String> getSpecialQualities() {
        return specialQualities;
    }

    public void setSpecialQualities(ArrayList<String> specialQualities) {
        this.specialQualities = specialQualities;
    }

    public String printQualities(){
        String s = "";
        
        for(String str : this.specialQualities){
            
            if(!s.equals("")){
                s += ", ";
            }
            
            s += str;
        }
       
        return s;
    }
    
    public void setMonsterTag(int i, boolean b){
        if((i >= 0) && (i <= 18)){
            this.tags[i] = b;
        }
    }
    
    public boolean getMonsterTag(int i){
        if((i >= 0) && (i <= 18)){
            return this.tags[i];
        }else{
            return false;
        }
    }
    
    public String printMonsterTags(){
        
        String s = "";
        
        if(this.tags[0]){
            s += ", Magical";
        }
        
        if(this.tags[1]){
            s += ", Devious";
        }
        
        if(this.tags[2]){
            s += ", Amorphous";
        }
        
        if(this.tags[3]){
            s += ", Organized";
        }
        
        if(this.tags[4]){
            s += ", Intelligent";
        }
        
        if(this.tags[5]){
            s += ", Hoarder";
        }
        
        if(this.tags[6]){
            s += ", Stealthy";
        }
        
        if(this.tags[7]){
            s += ", Terrifying";
        }
        
        if(this.tags[8]){
            s += ", Cautious";
        }
        
        if(this.tags[9]){
            s += ", Construct";
        }
        
        if(this.tags[10]){
            s += ", Planar";
        }
        
        if(this.tags[11]){
            s += ", Horde";
        }
        
        if(this.tags[12]){
            s += ", Group";
        }
        
        if(this.tags[13]){
            s += ", Solitary";
        }
        
        if(this.tags[14]){
            s += ", Tiny";
        }
        
        if(this.tags[15]){
            s += ", Small";
        }
        
        //Normal skipped on purpose
        
        if(this.tags[17]){
            s += ", Large";
        }
        
        if(this.tags[18]){
            s += ", Huge";
        }
        
        if(!s.equals("")){
            s = s.substring(2);
        }
        
        return s;
    }
    
    public void setAttackTag(int i, boolean b){
        if((i >= 0) && (i <= 13)){
            this.tags[i] = b;
        }
    }
    
    public boolean getAttackTag(int i){
        if((i >= 0) && (i <= 13)){
            return this.tags[i];
        }else{
            return false;
        }
    }
    
    public String printAttackTags(){
        
        String s = "";
        
        if(this.tags[0]){
            s += ", " + this.ammo + " Ammo";
        }
        
        if(this.tags[1]){
            s += ", Forceful";
        }
        
        if(this.tags[2]){
            s += ", Ignores Armor";
        }
        
        if(this.tags[3]){
            s += ", Messy";
        }
        
        //Piercing skipped on purpose
        
        if(this.tags[5]){
            s += ", Precise";
        }
        
        if(this.tags[6]){
            s += ", Reload";
        }
        
        if(this.tags[7]){
            s += ", Stun";
        }
        
        if(this.tags[8]){
            s += ", Thrown";
        }
        
        if(this.tags[9]){
            s += ", Hand";
        }
        
        if(this.tags[10]){
            s += ", Close";
        }
        
        if(this.tags[11]){
            s += ", Reach";
        }
        
        if(this.tags[12]){
            s += ", Near";
        }
        
        if(this.tags[13]){
            s += ", Far";
        }
        
        if(!s.equals("")){
            s = s.substring(2);
        }
        
        return s;
    }
    
}
    

