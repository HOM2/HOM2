package hom2.gamelogic.Enemies;

import java.util.ArrayList;

import hom2.gamelogic.Position;
import hom2.gamelogic.Weapons.PowerUpContext;

public class Dragon extends Enemy implements Subject {
	//needs return methods to display what it is
	private int currentHealthPoints = 200;
	private String name = "Rimescale of the Flame";
	private int enemyAttackPower = 9;
	
	private ArrayList<ObserverMinion> observerMinions;
	private int drakeHealthPoints = 0; //set something by default
	
	public boolean enemyBoss() { return true; } //Check if this is true, if it is, after this battle, show the ending if user wins
	
	private Position currentPosition;

	public Dragon() { //A collection of observers
		observerMinions = new ArrayList<ObserverMinion>();
	}
	
	public String position() { //Returns the position if needed
		return "";
	}

	public int healthPoints() {	//Returns the health points of the dragon
		return currentHealthPoints;
	}

	public int enemyAttackPower() { //Returns the attack power of the dragon
		return enemyAttackPower;		
	}

	public String enemyName() { //Returns the name of the dragon
		return name;		
	}

	public String powerUpDrop() { return ""; } //Last boss, no drops, should not drop anything.
	
	
	/* ********************* Observer methods here *********************************** */
	public void registerObserverMinion(ObserverMinion o) { //Method to add observers for the dragon
		observerMinions.add(o);
	}

	public void removeObserverMinion(ObserverMinion o) { //Method to remove observers for the dragon, if necessary
		int i = observerMinions.indexOf(o);
		if(i >= 0)
			observerMinions.remove(i);
	}

	public void notifyObserverMinions() { //Method to notify observers of changes from the dragon, when needed
		for(int i = 0; i < observerMinions.size(); i++) {
			ObserverMinion observerMinion = (ObserverMinion) observerMinions.get(i);
			observerMinion.update(drakeHealthPoints, 3); //maybe need the position too?
		}
	}
	
	//When the boss is below a health point threshold, it will summon drakes base on its current health points.
	//Notify the observer minions
	public void spawnsDrakes(int hp) { 
		drakeHealthPoints = hp;
		notifyObserverMinions();
	}

}
