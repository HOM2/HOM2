/*
 * Copyright Yiqi Liu
 * 
 */
package hom2.gamelogic;

import java.util.ArrayList;
import hom2.gamelogic.Characters.Character;

/**
 *
 * @author Alex
 */
public class CharacterRepository {
    ArrayList<Character> characters = new ArrayList<> ();
    
    
    public Character get(int id){
        Character c = characters.get(id);
        if (c != null && c.getIsAlive == true){
            return c;
        }else{
            return null;
        }
    }
    
    public Character set(int id, Character c){
        if (characters.get(id) != null){
            characters.set(id, c);
            return c;
        }
        else{
            return null;
        }
    }
    
    public Character add(Character c){
        characters.add(c);
        return c;
    }
    
    public Character delete(int id){
        Character c = characters.get(id);
        if (c != null){
            c.setIsAlive(false);
            return c;    
        }else{
            return null;
        }
        
    }
    
    
}
