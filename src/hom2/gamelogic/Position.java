/*
 * Copyright Yiqi Liu
 * 
 */
package hom2.gamelogic;

/**
 *
 * @author Alex
 */

import hom2.gamelogic.Characters.Character;

public class Position {

    protected boolean isVisible;
    protected Character character;

    public Position(){
        this.isVisible = true;
        this.character = new CharacterFactory().makeCharacter();
    }
    
    
    public Position(boolean isVisible, Character character) {
        this.isVisible = isVisible;
        this.character = character;
    }

    @Override
    public String toString() {
        return "Grid{" + "isVisible=" + isVisible + ", character=" + character + '}';
    }
    
    public boolean isIsVisible() {
        return isVisible;
    }

    public void setIsVisible(boolean isVisible) {
        this.isVisible = isVisible;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }
}
