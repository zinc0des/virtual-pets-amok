package petshelter;

import java.util.concurrent.ThreadLocalRandom;

public class Organic extends Pet {

	private int hunger = ThreadLocalRandom.current().nextInt(1, 41);
	private int hungerTick = ThreadLocalRandom.current().nextInt(1, 8);
	private int thirst = ThreadLocalRandom.current().nextInt(1, 41);
	private int thirstTick = ThreadLocalRandom.current().nextInt(1, 8);
	private int waste = ThreadLocalRandom.current().nextInt(1, 41);
	private int wasteTick = ThreadLocalRandom.current().nextInt(1, 8);

	public int getHunger() {
		return hunger;
	}

	public int getHungerTick() {
		return hungerTick;
	}

	public int getThirst() {
		return thirst;
	}	

	public int getThirstTick() {
		return thirstTick;
	}

	public int getWaste() {
		return waste;
	}

	public int getWasteTick() {
		return wasteTick;
	}
	
	public void setThirst(int amount) {
		thirst = amount;
	}

	public Organic(String petName, String type) {
		super(petName, type);
	}
	
	public void changeHunger(int hungerAmount) {
		hunger += hungerAmount;
		if (hunger < 0) {
			hunger = 0;
		}
	}

	public void changeThirst(int thirstAmount) {
		thirst += thirstAmount;
		if (thirst < 0) {
			thirst = 0;
		}
	}
	
	public void changeWaste(int wasteAmount) {
		waste += wasteAmount;
		if (waste < 0) {
			waste = 0;
		}
	}

}
