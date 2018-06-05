package petshelter;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class PetShelter {

	int litterBox = 0;
	Map<String, Pet> pets = new HashMap<String, Pet>();
	
	public int getLitterBox() {
		return litterBox;
	}
	
	public void addToLitterBox(int wasteAmount) {
		litterBox += wasteAmount;
	}

	public void addPet(Pet newPet) {
		pets.put(newPet.getPetName(), newPet);
	}

	public Pet findPet(String petName) {
		return pets.get(petName);
	}

	public Collection<Pet> getAllPets() {
		return pets.values();
	}

	public void removePet(Pet pet) {
		pets.remove(pet.getPetName(), pet);
	}

	public void feedAllOrganicPets(int feedAmount) {
		Collection<Pet> allPets = pets.values();
		for (Pet pet : allPets) {
			if (pet instanceof Organic) {
				Organic oPet = (Organic)pet;
				oPet.receiveFood(feedAmount);
			}
		}
	}

	public void waterAllOrganicPets(int waterAmount) {
		Collection<Pet> allPets = pets.values();
		for (Pet pet : allPets) {
			if (pet instanceof Organic) {
				Organic oPet = (Organic)pet;
				oPet.receiveWater(waterAmount);
			}
		}
		
	}
	
	public void walkAllDogs() {
		
	}
	//Walk all dogs
	//Nap all cats

	public void oilAllRoboticPets(int healthAmount, int oilAmount) {
		Collection<Pet> allPets = pets.values();
		for (Pet pet : allPets) {
			if (pet instanceof Robotic) {
				Robotic rPet = (Robotic)pet;
				rPet.oil(healthAmount, oilAmount);
			}
		}
		
	}

	public void petShelterTick() {
		Collection<Pet> allPets = pets.values();
		for (Pet pet : allPets) {
			if (pet instanceof Organic) {
				if (pet instanceof ODog) {
					ODog oDog = (ODog)pet;
					oDog.organicDogTick();
				}
				if (pet instanceof OCat) {
					OCat oCat = (OCat)pet;
					oCat.organicCatTick();
					litterBox += oCat.getWasteTick();
				}
			} else {
				Robotic rPet = (Robotic)pet;
				rPet.roboticTick();
			}			
		}		
	}
	
	public void showPetStats() {
		Collection<Pet> allPets = pets.values();
		System.out.println("This is the status of your organic pets:");
		System.out.println("Name \t\t |Type \t\t |Health \t |Happiness \t |Hunger \t |Thirst \t |Waste");
		System.out.println("-----------------|---------------|---------------|---------------|---------------|---------------|---------------");
		for (Pet pet : allPets) {
			if (pet instanceof Organic) {
				System.out.println(pet.toString());
			}		
		}
		System.out.println("Litter Box status: " + litterBox);
		System.out.println();
		System.out.println("This is the status of your robotic pets:");
		System.out.println("Name \t\t |Type \t\t |Health \t |Happiness \t |Rust Level");
		System.out.println("-----------------|---------------|---------------|---------------|---------------");
		for (Pet pet : allPets) {
			if (pet instanceof Robotic) {
				System.out.println(pet.toString());
			}
			
		}
	}
	
	
	
}
