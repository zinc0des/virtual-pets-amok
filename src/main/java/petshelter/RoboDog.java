package petshelter;

public class RoboDog extends Robotic {

	public RoboDog(String petName, String type, int health, int happiness, int rustLevel) {
		super(petName, type, health, happiness, rustLevel);
	}

	public void walk(int hapAmount) {
		changeHappiness(hapAmount);
	}
}
