/*
 * Copyright Yiqi Liu
 * 
 */
package hom2.gamelogic;

import hom2.gamelogic.Characters.Warrior;
import hom2.gamelogic.Characters.Character;

/**
 *
 * @author Alex
 */
class CharacterFactory {

    public CharacterFactory() {
        
    }
    
    public Character makeCharacter(){
        return new Warrior();
    }
    
}
