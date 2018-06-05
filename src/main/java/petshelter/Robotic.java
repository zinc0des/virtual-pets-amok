package petshelter;

public class Robotic extends Pet {

	private int rustLevel;
	private int rustLevelTick = 7;

	public int getRustLevel() {
		return rustLevel;
	}

	public Robotic(String petName, String type, int health, int happiness, int rustLevel) {
		super(petName, type, health, happiness);
		this.rustLevel = rustLevel;
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
