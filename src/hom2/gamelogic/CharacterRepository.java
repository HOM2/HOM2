/*
 * Copyright Yiqi Liu
 * 
 */
package hom2.gamelogic;

import java.util.ArrayList;
import hom2.gamelogic.Characters.GameCharacter;
import sun.rmi.runtime.Log;

/**
 *
 * @author Alex
 */

/**
 * 
 * This classis used as a layer reserving an easy way to use a
 * database to store game data in the future
 */

public class CharacterRepository {
    protected static int count = 0;
    ArrayList<GameCharacter> characters;
    
    public CharacterRepository(){
        this.characters =  new ArrayList<> ();
    }
    
    
    // Get. return null if the character is dead
    public GameCharacter get(int id){
        GameCharacter c = characters.get(id);
        if (c != null && c.isAlive() == true){
            return c;
        }else{
            return null;
        }
    }
    
    public GameCharacter set(int id, GameCharacter c){
        if (characters.get(id) != null){
            characters.set(id, c);
            return c;
        }
        else{
            return null;
        }
    }
    
    public GameCharacter add(GameCharacter c){
        c.setId(++count);
        characters.add(c);
        return c;
    }
    
    // Set dead instead of deletion, transparent for the outside world
    public GameCharacter delete(int id){
        GameCharacter c = characters.get(id);
        if (c != null){
            c.setIsAlive(false);
            return c;    
        }else{
            return null;
        }
        
    }
    
    
}
