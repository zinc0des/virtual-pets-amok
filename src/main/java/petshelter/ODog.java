package petshelter;

public class ODog extends Organic {

	public ODog(String petName, String type, int health, int happiness, int hunger, int thirst, int waste) {
		super(petName, type, health, happiness, hunger, thirst, waste);
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
	
	public void organicDogTick() {
		setHunger(getHungerTick());
		setThirst(getThirstTick());
		setWaste(getWasteTick());
		setHappiness(getHappinessTick());
		if (getHunger() > 80 || getThirst() > 80 || getWaste() > 80 || getHappiness() < 30) {
			setHealth(getHealthTick());
		}
	}
	
	@Override
	public String toString() {
		return getPetName() + "\t\t |" + getType() + "\t |" + getHealth() + "\t\t |" + getHappiness() + "\t\t |" + getHunger() + "\t\t |" + getThirst() + "\t\t |" + getWaste();
	}
}
