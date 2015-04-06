package hom2.gamelogic.Characters;

import java.util.ArrayList;

import hom2.gamelogic.BattleController;
import hom2.gamelogic.Enemies.*;
import hom2.gamelogic.NavigationController;
import hom2.gamelogic.Position;
import hom2.gamelogic.Weapons.Weapon;

public class Warrior extends Character {
	//needs return methods to display what it is
	private String type = "Warrior";
	private Weapon currentWeapon;
	private ArrayList<Weapon> collectedWeapons;
	private int currentHealthPoints = 100;
	private String name = "Damian";
	private boolean isAlive;
	
	//receives the move commands, send for calc. and return the results
	private NavigationController navigateController; 
	private BattleController battleController;
	
	private Position currentPosition; //Maybe we need to use it, not necessary
	
	public Warrior() { //Each warrior has their own collection of weapon power ups 
		collectedWeapons = new ArrayList();
	}

	public String position() { //Returns the current position of the hero
		return "";
	}

	public String weaponEquippedNames() { //Returns the character's power ups currently equipped
		return currentWeapon.displayWeapon();
	}
	
	public int weaponEquippedAttackPower() { //Returns the character's total power up attack power added together
		return currentWeapon.displayAttackPower();
	}
	
	public void addWeaponPowerUp(Weapon powerUp) { //character adds the power up here
		currentWeapon = powerUp;
		collectedWeapons.add(powerUp); //Add a weapon power up to the collection that the hero has collected
	}
	
	public ArrayList<Weapon> collectedPowerUps() { //Returns an arraylist of collected power ups by the character
		return collectedWeapons;
	}

	public int healthPoints() { //Returns the current health points of the character
		return currentHealthPoints;	
	}

	public String characterName() { //Returns the name of the chracter
		return name;
	}

	public NavigationController navigationController() {
		return navigateController;
	}

	public BattleController battleController() {
		return battleController;
	}
}
