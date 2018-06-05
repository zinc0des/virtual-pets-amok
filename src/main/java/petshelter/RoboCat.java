package petshelter;

public class RoboCat extends Robotic {

	public RoboCat(String petName, String type, int health, int happiness, int rustLevel) {
		super(petName, type, health, happiness, rustLevel);
	}

	public void napCat(int happinessAmount) {
		changeHappiness(happinessAmount);
	}

}
