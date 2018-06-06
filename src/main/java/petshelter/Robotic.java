package petshelter;

import java.util.concurrent.ThreadLocalRandom;

public class Robotic extends Pet {

	private int rustLevel = ThreadLocalRandom.current().nextInt(1, 31);
	private int rustLevelTick = ThreadLocalRandom.current().nextInt(1, 8);

	public int getRustLevel() {
		return rustLevel;
	}

	public Robotic(String petName, String type) {
		super(petName, type);
	}

	public void oil(int healthAmount, int oilAmount) {
		rustLevel += oilAmount;
		changeHealth(healthAmount);
	}

	public void roboticTick() {
		rustLevel += rustLevelTick;
		changeHappiness(getHappinessTick());
		if (rustLevel > 80 || getHappiness() < 30) {
			changeHealth(getHealthDownTick());
		} else if (rustLevel < 40 && getHappiness() > 60) {
			changeHealth(getHealthUpTick());
		}
	}

	@Override
	public String toString() {
		return getPetName() + "\t\t |" + getType() + "\t |" + getHealth() + "\t\t |" + getHappiness() + "\t\t |"
				+ rustLevel;
	}
}
