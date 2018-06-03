package petshelter;

public class RoboCat extends Robotic {

	public RoboCat(String petName, int health, int happiness, int rustLevel) {
		super(petName, health, happiness, rustLevel);

	}

	public void getCatNap(int happinessAmount) {
		this.setHappiness(happinessAmount);
	}

}
