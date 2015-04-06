package hom2.gamelogic.Enemies;

import hom2.gamelogic.Position;
import hom2.gamelogic.Weapons.PowerUpContext;

public class Drake extends Enemy implements ObserverMinion {
	//needs return methods to display what it is
	private int currentHealthPoints;
	private int maxHealthPoints;
	private String name = "Drakes of the Flame";
	private int enemyAttackPower;
	
	private Subject dragonStats; //Manages a bit of the dragon statistics/data
	
	private Position currentPosition; //Don't really need it, here just in case

	//Observer methods
	public Drake(Subject dragonStats) { //Register the drake as an observer
		this.dragonStats = dragonStats;
		dragonStats.registerObserverMinion(this);
	}
	
	public void update(int hp, int minionAP) { //Updates all the drake observers
		currentHealthPoints = hp;
		enemyAttackPower = minionAP;
		maxHealthPoints = currentHealthPoints;
		//this.currentPosition = position; //Position will be the same as the dragon
	}

	//Template methods
	public String position() { //Returns the current position of the drakes, if needed
		return "";	
	}

	public int healthPoints() { //Returns the health points of the drakes
		return currentHealthPoints;
	}

	public int enemyAttackPower() { //Returns the attack power of the drakes
		return enemyAttackPower;			
	}

	public String enemyName() { //Returns the name of the drakes
		return name;		
	}

	public String powerUpDrop() { return ""; } //Last battle, a minion spawned, no drops
	public void registerObserverMinion(ObserverMinion o) {}
	public void removeObserverMinion(ObserverMinion o) {}
	public void notifyObserverMinions() {}

}
