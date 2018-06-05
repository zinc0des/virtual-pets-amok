package petshelter;

public class Organic extends Pet {

	private int hunger;
	private int hungerTick = 5;
	private int thirst;
	private int thirstTick = 5;
	private int waste;
	private int wasteTick = 5;

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

	public void setWaste(int wasteAmount) {
		waste += wasteAmount;
	}

	public void setHunger(int hungerAmount) {
		hunger += hungerAmount;
	}
	
	public void setThirst(int thirstAmount) {
		thirst += thirstAmount;
	}

	public Organic(String petName, String type, int health, int happiness, int hunger, int thirst, int waste) {
		super(petName, type, health, happiness);
		this.hunger = hunger;
		this.thirst = thirst;
		this.waste = waste;
	}

	public void receiveFood(int amount) {
		hunger += amount;
		if (hunger < 0) {
			hunger = 0;
		}
	}

	public void receiveWater(int amount) {
		thirst += amount;
		if (thirst < 0) {
			thirst = 0;
		}
	}

//	public void organicTick() {
//		hunger += hungerTick;
//		thirst += thirstTick;
//		waste += wasteTick;
//		setHappiness(getHappinessTick());
//		if (hunger > 80 || thirst > 80 || waste > 80 || getHappiness() < 30) {
//			setHealth(getHealthTick());
//		}
//	}
	
//	@Override
//	public String toString() {
//		return getPetName() + "\t\t |" + getType() + "\t |" + getHealth() + "\t\t |" + getHappiness() + "\t\t |" + hunger + "\t\t |" + thirst + "\t\t |" + waste;
//	}

}
