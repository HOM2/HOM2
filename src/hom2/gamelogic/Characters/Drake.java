package hom2.gamelogic.Characters;

import java.util.ArrayList;

import hom2.gamelogic.BattleController;
import hom2.gamelogic.Characters.GameCharacter;
import hom2.gamelogic.Position;
import hom2.gamelogic.Weapons.PowerUpContext;
import hom2.gamelogic.Weapons.Weapon;

public class Drake extends GameCharacter implements ObserverMinion {

    //needs return methods to display what it is

    private long currentHealthPoints;
    private long maxHealthPoints;
    private String name = "Drakes of the Flame";
    private long enemyAttackPower;
    private boolean alive = true;
    private boolean boss = false;

    private Subject dragonStats; //Manages a bit of the dragon statistics/data

    //Observer methods
    public Drake(Subject dragonStats) { //Register the drake as an observer
        this.dragonStats = dragonStats;
        dragonStats.registerObserverMinion(this);
    }

    public void update(long hp, long minionAP) { //Updates all the drake observers
        currentHealthPoints = hp;
        enemyAttackPower = minionAP;
        maxHealthPoints = currentHealthPoints;
        //this.currentPosition = position; //Position will be the same as the dragon
    }

	//Template methods
    public long healthPoints() { //Returns the health points of the drakes
        return currentHealthPoints;
    }

    public long getAttackPower() { //Returns the attack power of the drakes
        return enemyAttackPower;
    }

    public String getName() { //Returns the name of the drakes
        return name;
    }

    public String powerUpDrop() {
        return "";
    } //Last battle, a minion spawned, no drops

    public void registerObserverMinion(ObserverMinion o) {
    }

    public void removeObserverMinion(ObserverMinion o) {
    }

    public void notifyObserverMinions() {
    }

    public boolean isEnemyOf(Character ch) {
        String characterType = (ch.getClass()).getSimpleName();
        if (characterType.equals("Warrior")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isAlive() {
        return alive;
    }

    public void setIsAlive(boolean b) {
        if (b) {
            alive = true;
        } else {
            alive = false;
        }
    }

    public long getHealthIncreasement() {
        return 0;
    }

    public void setName(String n) {
        name = n;
    }

    public CharacterType getType() {
        return CharacterType.Drakes;
    }

    public long getTeamNumber() {
        return 0;
    }

    public Boolean isBoss() {
        return boss;
    }

    public void setIsBoss(boolean b) {
        boss = b;
    }

    public void setTeamNumber(long num) {
    }

    public void collectWeapon(Weapon w) {
    }

    public ArrayList<Weapon> collectedPowerUps() {
        return null;
    }

    public String weaponEquippedNames() {
        return null;
    }

    public void update(int hp, int minionAP) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
