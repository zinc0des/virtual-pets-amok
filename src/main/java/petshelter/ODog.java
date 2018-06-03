package petshelter;

public class ODog extends Organic {

	public ODog(String petName, int health, int happiness, int hunger, int thirst, int waste) {
		super(petName, health, happiness, hunger, thirst, waste);
	}

	public void walk(int hapAmount, int wasteAmount) {
		this.setHappiness(hapAmount);
		this.setWaste(wasteAmount);
	}

	public void cleanCage(int healthAmount) {
		int wasteBefore = 0 - getWaste();
		this.setWaste(wasteBefore);
		this.setHealth(healthAmount);
	}
}
