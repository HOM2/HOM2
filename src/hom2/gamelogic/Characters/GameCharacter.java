package hom2.gamelogic.Characters;

import java.util.ArrayList;

import hom2.gamelogic.Weapons.Weapon;

public abstract class GameCharacter implements Subject { //Template; implements Subject so the observer can use the Template character

    protected int id;
    
    public abstract boolean isEnemyOf(Character ch);

    public abstract void collectWeapon(Weapon w);

    public abstract boolean isAlive();

    public abstract void setIsAlive(boolean b);

    public abstract long getAttackPower();

    public abstract long getHealthIncreasement();

    public abstract String getName();

    public abstract void setName(String n);

    public enum CharacterType { Warrior, Dragon, Dragon_Knight, Drakes }

    public abstract CharacterType getType();

    public abstract long getTeamNumber();

    public abstract void setTeamNumber(long num);

    public abstract Boolean isBoss();

    public abstract void setIsBoss(boolean b);

    public abstract long healthPoints();

    public abstract ArrayList<Weapon> collectedPowerUps();

    public abstract String weaponEquippedNames();

    public abstract String powerUpDrop();

    // Added by Yiqi. Required.
    // A character need an Id, to implement the Repository pattern
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public boolean equal(GameCharacter c) {
        return this.getId() == c.getId();
    }
}
