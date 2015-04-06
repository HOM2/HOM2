/*
 * Copyright Yiqi Liu
 * 
 */
package hom2.gamelogic;

/**
 *
 * @author Alex
 */

import hom2.gamelogic.Characters.GameCharacter;
import java.awt.Point;
import java.util.Objects;

public class Position {
    
    
    protected Point point;
    
    protected boolean visible;
    protected GameCharacter character;

    public Position(){
        this.visible = true;
        this.point = new Point();
    }
    
    
    public Position(boolean isVisible, GameCharacter character) {
        this.visible = isVisible;
        this.character = character;
    }
  
    
    // Equals only check the coordinates (the point)
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.point);
        return hash;
    }

    // Equals only check the coordinates (the point)
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Position other = (Position) obj;
        if (!Objects.equals(this.point, other.point)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "Grid{" + "isVisible=" + visible + ", character=" + character + '}';
    }
    
    
    // Getter setters

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }
    
    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean isVisible) {
        this.visible = isVisible;
    }

    public GameCharacter getCharacter() {
        return character;
    }

    public void setCharacter(GameCharacter character) {
        this.character = character;
    }
}
