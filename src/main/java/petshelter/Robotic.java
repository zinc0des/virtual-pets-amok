package petshelter;

import java.util.concurrent.ThreadLocalRandom;

public class Robotic extends Pet {

	private int rustLevel = ThreadLocalRandom.current().nextInt(1, 41);
	private int rustLevelTick = ThreadLocalRandom.current().nextInt(1, 8);

	public int getRustLevel() {
		return rustLevel;
	}

	public Robotic(String petName, String type) {
		super(petName, type);
	}

	public void oil(int healthAmount, int oilAmount) {
		rustLevel += oilAmount;
		if (rustLevel < 0) {
			rustLevel = 0;
		}
		changeHealth(healthAmount);
	}

	public void roboticTick() {
		rustLevel += rustLevelTick;
		changeHappiness(getHappinessTick());
		if (rustLevel > 70 || getHappiness() < 40) {
			changeHealth(getHealthDownTick());
		} else if (rustLevel < 40 && getHappiness() > 60) {
			changeHealth(getHealthUpTick());
		}
	}

	@Override
	public String toString() {
		if (getIsAlive()) {
			return getPetName() + "\t\t |" + getType() + "\t |" + getHealth() + "\t\t |" + getHappiness() + "\t\t |"
					+ rustLevel;
		} else {
			return getPetName() + "\t\t |" + getType() + "\t |Died \t\t | \t\t |";
		}
	}
}
