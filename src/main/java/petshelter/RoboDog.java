package petshelter;

public class RoboDog extends Robotic {

	public RoboDog(String petName, String type) {
		super(petName, type);
	}

	public void walk(int happinessAmount) {
		changeHappiness(happinessAmount);
	}
}
