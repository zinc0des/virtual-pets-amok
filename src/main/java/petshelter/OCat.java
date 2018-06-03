package petshelter;

public class OCat extends Organic {

	public OCat(String petName, int health, int happiness, int hunger, int thirst, int waste) {
		super(petName, health, happiness, hunger, thirst, waste);
	}

	public void litterBoxClean(int healthAmount) {
		int wasteBefore = 0 - getWaste();
		this.setWaste(wasteBefore);
		this.setHealth(healthAmount);
	}

	public void getCatNap(int happinessAmount) {
		this.setHappiness(happinessAmount);
	}
}
