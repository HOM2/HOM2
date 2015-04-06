package hom2.gamelogic.Enemies;

import java.util.Random;

import hom2.gamelogic.Position;
import hom2.gamelogic.Weapons.*;

public class DragonKnight extends Enemy {
	//needs return methods to display what it is
	private int currentHealthPoints = 100;
	private String name = "Dragon Knight";
	private int enemyAttackPower = 4;
	private PowerUpContext weaponPowerUpDrop;
	
	public boolean enemyBoss() { return false; }
	
	private Position currentPosition;
	
	public DragonKnight() { //When a dragon knight is created, it will randomly assign a power up. When user defeats it, they will be able to clam it.
		Random rand = new Random();
		int randomNum = rand.nextInt((3 - 1) + 1) + 1;
		weaponPowerUpDrop = generateRandomPowerUp(randomNum);
	}
	
	public PowerUpContext generateRandomPowerUp(int randomNum) { //Returns a context (behavior) of a power up
		switch(randomNum) {
		case 1:
			return new PowerUpContext(new Fire());
			
		case 2:
			return new PowerUpContext(new LifeSteal());
			
		default:
			return new PowerUpContext(new Ice());
			
		}
	}
	
	public String powerUpDrop() { //Returns the name of the power up drop
		return weaponPowerUpDrop.displayPowerUp();
	}

	public String position() { //Returns the location of the dragon knight, if needed
		return "";	
	}

	public int healthPoints() { //Returns the health points of dragon knight
		return currentHealthPoints;
	}

	@Override
	public String enemyName() { //Returns the name of dragon knight
		return name;
	}

	@Override
	public int enemyAttackPower() { //Returns the attack power of dragon knight
		return enemyAttackPower;	
	}

	public void registerObserverMinion(ObserverMinion o) {}
	public void removeObserverMinion(ObserverMinion o) {}
	public void notifyObserverMinions() {}

}
