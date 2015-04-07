package hom2.gamelogic.Characters;

public interface Subject {
	public void registerObserverMinion(ObserverMinion o);
	public void removeObserverMinion(ObserverMinion o);
	public void notifyObserverMinions();
}
