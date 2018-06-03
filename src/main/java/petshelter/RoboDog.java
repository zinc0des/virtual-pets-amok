package petshelter;

public class RoboDog extends Robotic {

	public RoboDog(String petName, int health, int happiness, int rustLevel) {
		super(petName, health, happiness, rustLevel);
	}

	public void walk(int hapAmount) {
		this.setHappiness(hapAmount);
	}
}
