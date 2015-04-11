package btp600Assignment2.Weapons;

public class Gravity extends SwordDecorator implements PowerUpStrategy {
	
	public Gravity() {}

	public Gravity(Weapon decoratedWeapon) { //Derived Constructor used to add on the decorator over the weapon, one after another.
		super(decoratedWeapon);
		System.out.println("Equipping the gravity power up to your weapon...");
	}

	public String displayWeapon() { //Returns the current power up decorated over the weapon.
		return decoratedWeapon.displayWeapon() + "(Gravity)";		
	}

	public int displayAttackPower() { //Returns the current power up attack power added to the weapon attack power.
		return decoratedWeapon.displayAttackPower() + 5;		
	}

	public String displayPowerUp() { //Returns the type of power up directly when the monster is defeated.
		return "Gravity";
	}
}
