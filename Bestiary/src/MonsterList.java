/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author marthahamlin
 */
import java.util.*;

public class MonsterList implements Iterable<Monster>{
    
    TreeSet<Monster> internalList;
    
    static final Comparator<Monster> NameOrder = 
                                        new Comparator<Monster>() {
        @Override
        public int compare(Monster m1, Monster m2) {
            return m1.getName().compareToIgnoreCase(m2.getName());
        }
    };
    
    public MonsterList(){
        internalList = new TreeSet<Monster>(NameOrder);
    }
    
    public void addMonster(Monster m){
        internalList.add(m);
    }
    
    public boolean removeMonster(String m){
        boolean found = false;
        
        for(Monster mon : internalList){
            if(mon.getName().equals(m)){
                internalList.remove(mon);
                found = true;
            }
        }
        
        return found;
    }
    
    public Monster getMonster(String m){
        
        for(Monster mon : internalList){
            if(mon.getName().equals(m)){
                return mon;
            }
        }
        
        return null;
    }
    
    public boolean loadMonster(String monName, LargeMonsterCard monCard){
        
        boolean found = false;
        
        for(Monster mon : internalList){
            if(mon.getName().equals(monName)){
                mon.loadToCard(monCard);
                found = true;
            }
        }
        
        return found;
    }
    
    public boolean loadMonster(String monName, MiniMonsterCard monCard){
        
        boolean found = false;
        
        for(Monster mon : internalList){
            if(mon.getName().equals(monName)){
                mon.loadToCard(monCard);
                found = true;
            }
        }
        
        return found;
    }
    
    @Override
    public Iterator<Monster> iterator(){
        return internalList.iterator();
    }
    
}