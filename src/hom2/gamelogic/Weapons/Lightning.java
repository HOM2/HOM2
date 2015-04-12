package hom2.gamelogic.Weapons;

public class Lightning extends SwordDecorator implements PowerUpStrategy {
	
	public Lightning() {}

	public Lightning(Weapon decoratedWeapon) { //Derived Constructor used to add on the decorator over the weapon, one after another.
		super(decoratedWeapon);
		System.out.println("Equipping the lighting power up to your weapon...");
	}

	public String displayWeapon() { //Returns the current power up decorated over the weapon.
		return decoratedWeapon.displayWeapon() + "(Lightning)";		
	}

	public int displayAttackPower() { //Returns the current power up attack power added to the weapon attack power.
		return decoratedWeapon.displayAttackPower() + 4;		
	}

	public String displayPowerUp() { //Returns the type of power up directly when the monster is defeated.
		return "Lightning";
	}
}
