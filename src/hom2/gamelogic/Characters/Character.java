package hom2.gamelogic.Characters;

import java.util.ArrayList;

import hom2.gamelogic.BattleController;
import hom2.gamelogic.NavigationController;
import hom2.gamelogic.Weapons.Weapon;

public abstract class Character { //Template
	
	boolean characterMoves() { return false; }
	boolean characterOpensItemMenu() { return false; }
	
	boolean characterAttacks() { return false; }
	boolean characterRetreats() { return false; }
	boolean characterHeals() { return false; }
	
	public abstract String position();
	public abstract String weaponEquippedNames();
	public abstract int weaponEquippedAttackPower();
	public abstract ArrayList<Weapon> collectedPowerUps();
	public abstract int healthPoints();
	public abstract String characterName();
	public abstract void addWeaponPowerUp(Weapon powerUps);
	
	public abstract NavigationController navigationController();
	public abstract BattleController battleController();
}
