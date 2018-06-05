package petshelter;

public class OCat extends Organic {

	public OCat(String petName, String type, int health, int happiness, int hunger, int thirst, int waste) {
		super(petName, type, health, happiness, hunger, thirst, waste);
	}

	public void litterBoxClean(int healthAmount) {
		int wasteBefore = 0 - getWaste();
		changeWaste(wasteBefore);
		changeHealth(healthAmount);
	}

	public void getCatNap(int happinessAmount) {
		changeHappiness(happinessAmount);
	}
	
	public void organicCatTick() {
		changeHunger(getHungerTick());
		changeThirst(getThirstTick());
		changeHappiness(getHappinessTick());
		if (getHunger() > 80 || getThirst() > 80 || getHappiness() < 30) {
			changeHealth(getHealthTick());
		}
	}
	
	@Override
	public String toString() {
		return getPetName() + "\t\t |" + getType() + "\t |" + getHealth() + "\t\t |" + getHappiness() + "\t\t |" + getHunger() + "\t\t |" + getThirst() + "\t\t |";
	}
}
