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
				Organic oPet = (Organic) pet;
				oPet.changeHunger(feedAmount);
			}
		}
	}

	public void waterAllOrganicPets(int waterAmount) {
		Collection<Pet> allPets = pets.values();
		for (Pet pet : allPets) {
			if (pet instanceof Organic) {
				Organic oPet = (Organic) pet;
				oPet.changeThirst(waterAmount);
			}
		}
	}

	public void oilAllRoboticPets(int healthAmount, int oilAmount) {
		Collection<Pet> allPets = pets.values();
		for (Pet pet : allPets) {
			if (pet instanceof Robotic) {
				Robotic rPet = (Robotic) pet;
				rPet.oil(healthAmount, oilAmount);
			}
		}
	}

	public void walkAllDogs() {
		Collection<Pet> allPets = pets.values();
		for (Pet pet : allPets) {
			if (pet instanceof ODog) {
				ODog oDog = (ODog) pet;
				oDog.walk(20, -30);
			} else if (pet instanceof RoboDog) {
				RoboDog rDog = (RoboDog) pet;
				rDog.walk(20);
			}
		}
	}

	public void napAllCats() {
		Collection<Pet> allPets = pets.values();
		for (Pet pet : allPets) {
			if (pet instanceof OCat) {
				OCat oCat = (OCat) pet;
				oCat.napCat(20);
			} else if (pet instanceof RoboCat) {
				RoboCat rCat = (RoboCat) pet;
				rCat.napCat(20);
			}
		}
	}

	public void cleanAllDogCages() {
		Collection<Pet> allPets = pets.values();
		for (Pet pet : allPets) {
			if (pet instanceof ODog) {
				ODog oDog = (ODog) pet;
				oDog.cleanCage(20);
			}
		}
	}

	public void cleanLitterBox() {
		Collection<Pet> allPets = pets.values();
		litterBox = 0;
		for (Pet pet : allPets) {
			if (pet instanceof OCat) {
				OCat oCat = (OCat) pet;
				oCat.litterBoxClean(20);
			}
		}
	}

	public void petShelterTick() {
		Collection<Pet> allPets = pets.values();
		for (Pet pet : allPets) {
			if (pet instanceof OCat) {
				OCat oCat = (OCat) pet;
				litterBox += oCat.getWasteTick();
			}
		}
		for (Pet pet : allPets) {
			if (pet instanceof Organic) {
				if (pet instanceof ODog) {
					ODog oDog = (ODog) pet;
					oDog.organicDogTick();
				}
				if (pet instanceof OCat) {
					OCat oCat = (OCat) pet;
					if (litterBox > 80) {
						oCat.setLitterBoxFull(true);
					}
					oCat.organicCatTick();
				}
			} else {
				Robotic rPet = (Robotic) pet;
				rPet.roboticTick();
			}
		}
	}

	public void showPetStats() {
		Collection<Pet> allPets = pets.values();
		System.out.println("This is the status of your organic pets:");
		System.out.println("Name \t\t |Type \t\t |Health \t |Happiness \t |Hunger \t |Thirst \t |Cage Waste");
		System.out.println(
				"-----------------|---------------|---------------|---------------|---------------|---------------|---------------");
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
	
	public String formatPetName(String originalName) {
		String lowerCasePetName = originalName.toLowerCase();
		String firstLetter = lowerCasePetName.substring(0, 1);
		firstLetter = firstLetter.toUpperCase();
		String restOfName = lowerCasePetName.substring(1);
		return firstLetter + restOfName;
	}
	
	public void showPetNameType() {
		Collection<Pet> allPets = pets.values();
		for (Pet pet : allPets) {
			System.out.println(pet.nameType());
		}
	}
}
