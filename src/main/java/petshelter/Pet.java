package petshelter;

import java.util.concurrent.ThreadLocalRandom;

public abstract class Pet {

	private String petName;
	private String type;
	private boolean isAlive = true;
	private int health = ThreadLocalRandom.current().nextInt(70, 101);
	private int healthDownTick = ThreadLocalRandom.current().nextInt(-7, 0);
	private int healthUpTick = ThreadLocalRandom.current().nextInt(1, 6);
	private int happiness = ThreadLocalRandom.current().nextInt(70, 101);
	private int happinessTick = ThreadLocalRandom.current().nextInt(-7, 0);
	
	public String getPetName() {
		return petName;
	}
	
	public String getType() {
		return type;
	}
	
	public boolean getIsAlive() {
		return isAlive;
	}

	public int getHealth() {
		return health;
	}

	public int getHealthUpTick() {
		return healthUpTick;
	}
	
	public int getHealthDownTick() {
		return healthDownTick;
	}

	public int getHappiness() {
		return happiness;
	}
	
	public void setIsAlive(boolean status) {
		isAlive = status;
	}
	
	public void setHappiness(int amount) {
		happiness = amount;
	}
	
	public int getHappinessTick() {
		return happinessTick;
	}
	
	public Pet(String petName, String type) {
		this.petName = petName;
		this.type = type;
	}

	public void changeHappiness(int amount) {
		happiness += amount;
		if (happiness > 100) {
			happiness = 100;
		} else if (happiness < 0) {
			happiness = 0;
		}
	}

	public void changeHealth(int amount) {
		health += amount;
		if (health > 100) {
			health = 100;
		} else if (health <= 0) {
			isAlive = false;
		}
	}

	public String nameType() {
		return petName + " is a " + type + ".";
	}
}
