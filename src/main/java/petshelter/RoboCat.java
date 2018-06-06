package petshelter;

public class RoboCat extends Robotic {

	public RoboCat(String petName, String type) {
		super(petName, type);
	}

	public void napCat(int happinessAmount) {
		changeHappiness(happinessAmount);
	}

}
