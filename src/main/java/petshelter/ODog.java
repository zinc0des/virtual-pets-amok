package petshelter;

public class ODog extends Organic {

	public ODog(String petName, String type) {
		super(petName, type);
	}

	public void walk(int hapAmount, int wasteAmount) {
		changeHappiness(hapAmount);
		changeWaste(wasteAmount);
	}

	public void cleanCage(int healthAmount) {
		int wasteBefore = 0 - getWaste();
		changeWaste(wasteBefore);
		changeHealth(healthAmount);
	}

	public void organicDogTick() {
		changeHunger(getHungerTick());
		changeThirst(getThirstTick());
		changeWaste(getWasteTick());
		changeHappiness(getHappinessTick());
		if (getHunger() > 70 || getThirst() > 70 || getWaste() > 70 || getHappiness() < 40) {
			changeHealth(getHealthDownTick());
		} else if (getHunger() < 40 && getThirst() < 40 && getWaste() < 40 && getHappiness() > 60) {
			changeHealth(getHealthUpTick());
		}
	}

	@Override
	public String toString() {
		if (getIsAlive()) {
			return getPetName() + "\t\t |" + getType() + "\t |" + getHealth() + "\t\t |" + getHappiness() + "\t\t |"
					+ getHunger() + "\t\t |" + getThirst() + "\t\t |" + getWaste();
		} else {
			return getPetName() + "\t\t |" + getType() + "\t |Died \t\t | \t\t | \t\t | \t\t |";
		}
	}
}
