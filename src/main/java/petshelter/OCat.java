package petshelter;

public class OCat extends Organic {
	
	boolean litterBoxFull = false;
	
	public void setLitterBoxFull(boolean isFull) {
		litterBoxFull = isFull;
	}

	public OCat(String petName, String type, int health, int happiness, int hunger, int thirst, int waste) {
		super(petName, type, health, happiness, hunger, thirst, waste);
	}

	public void litterBoxClean(int healthAmount) {
		int wasteBefore = 0 - getWaste();
		changeWaste(wasteBefore);
		changeHealth(healthAmount);
		litterBoxFull = false;
	}

	public void napCat(int happinessAmount) {
		this.changeHappiness(happinessAmount);
	}
	
	public void organicCatTick() {
		changeHunger(getHungerTick());
		changeThirst(getThirstTick());
		changeHappiness(getHappinessTick());
		if (getHunger() > 80 || getThirst() > 80 || litterBoxFull || getHappiness() < 30) {
			changeHealth(getHealthDownTick());
		} else if (getHunger() < 40 && getThirst() < 40 && !litterBoxFull && getHappiness() > 60) {
			changeHealth(getHealthUpTick());
		}
	}
	
	@Override
	public String toString() {
		return getPetName() + "\t\t |" + getType() + "\t |" + getHealth() + "\t\t |" + getHappiness() + "\t\t |" + getHunger() + "\t\t |" + getThirst() + "\t\t |";
	}
}
