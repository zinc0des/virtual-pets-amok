package petshelter;

public class Robotic extends Pet {

	private int rustLevel;

	public int getRustLevel() {
		return rustLevel;
	}

	public Robotic(String petName, int health, int happiness, int rustLevel) {
		super(petName, health, happiness);
		this.rustLevel = rustLevel;
	}

	public void oil(int healthAmount, int oilAmount) {
		rustLevel += oilAmount;
		setHealth(healthAmount);
	}
}
