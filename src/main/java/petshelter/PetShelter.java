package petshelter;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class PetShelter {

	Map<String, Pet> pets = new HashMap<String, Pet>();

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

	public void oilAllRoboticPets(int oilAmount) {
		
		
	}
	
	
	
	
	
}
