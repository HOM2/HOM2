package hom2.gamelogic.Weapons;

public class PowerUpContext { //Uses the strategy based on different type of behaviors
	private PowerUpStrategy strategy;
	
	public PowerUpContext(PowerUpStrategy strategy) {
		this.strategy = strategy;
	}
	
	public String displayPowerUp() {
		return strategy.displayPowerUp();
	}
}
