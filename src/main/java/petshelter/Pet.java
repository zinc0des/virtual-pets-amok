package petshelter;

public abstract class Pet {

	private String petName;
	private String type;
	private int health;
	private int healthTick = -5;
	private int happiness;
	private int happinessTick = -5;
	
	public String getPetName() {
		return petName;
	}
	
	public String getType() {
		return type;
	}

	public int getHealth() {
		return health;
	}

	public int getHealthTick() {
		return healthTick;
	}

	public int getHappinessTick() {
		return happinessTick;
	}

	public int getHappiness() {
		return happiness;
	}

	public void setHappiness(int amount) {
		this.happiness += amount;
		if (happiness > 100) {
			happiness = 100;
		}
	}

	public void setHealth(int amount) {
		this.health += amount;
		if (health > 100) {
			health = 100;
		}
	}

	public Pet(String petName, String type, int health, int happiness) {
		this.petName = petName;
		this.type = type;
		this.health = health;
		this.happiness = happiness;
	}

}
