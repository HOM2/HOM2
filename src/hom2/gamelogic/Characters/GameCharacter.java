package hom2.gamelogic.Characters;

import java.util.ArrayList;

import hom2.gamelogic.BattleController;
import hom2.gamelogic.NavigationController;
import hom2.gamelogic.Weapons.Weapon;

public abstract class GameCharacter { //Template
    
    protected int id;
    protected int healthPoints;
    
    
    boolean characterMoves() {
        return false;
    }

    boolean characterOpensItemMenu() {
        return false;
    }

    boolean characterAttacks() {
        return false;
    }

    boolean characterRetreats() {
        return false;
    }

    boolean characterHeals() {
        return false;
    }

    public abstract String position();

    public abstract String weaponEquippedNames();

    public abstract int weaponEquippedAttackPower();

    public abstract ArrayList<Weapon> collectedPowerUps();

    public abstract int getHealthPoints();
    

    public abstract String characterName();

    public abstract void addWeaponPowerUp(Weapon powerUps);

    public abstract NavigationController navigationController();

    public abstract BattleController battleController();

    // Added by Yiqi. Required.
    // A character need an Id, to implement the Repository pattern
    public int getId(){return this.id;}
    public void setId(int id){this.id = id;}
    public void setHealthPoints(int hp){this.healthPoints = hp;}
    public boolean equal(GameCharacter c){return this.getId() == c.getId();}
    
    // DEBUG: Added by Yiqi, temporarily.
    public boolean isAlive() {
        return true;
    }

    ;
        public void setIsAlive(boolean v) {
    }
;

}
