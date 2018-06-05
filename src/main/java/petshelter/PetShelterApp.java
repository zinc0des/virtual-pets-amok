package petshelter;

import java.util.Scanner;

public class PetShelterApp {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		String menuChoice = "0";
		PetShelter myShelter = new PetShelter();
		RoboCat rCat1 = new RoboCat("Sparks", "Robot Cat", 50, 30, 80);
		RoboDog rDog1 = new RoboDog("Bolts", "Robot Dog", 30, 40, 60);
		OCat oCat1 = new OCat("Teeney", "Organic Cat", 50, 30, 60, 60, 20);
		OCat oCat2 = new OCat("Tiny", "Organic Cat", 50, 30, 60, 60, 30);
		ODog oDog1 = new ODog("Baci", "Organic Dog", 50, 30, 50, 60, 50);
		myShelter.addPet(rCat1);
		myShelter.addPet(rDog1);
		myShelter.addPet(oCat1);
		myShelter.addPet(oCat2);
		myShelter.addPet(oDog1);

		System.out.println("Thank you for volunteering at the Amok Pet Shelter!");

		while (!menuChoice.equals("6")) {
			System.out.println();
			myShelter.showPetStats();
			System.out.println();
			System.out.println("What would you like to do next?");
			System.out.println();
			System.out.println("1. Feed all organic pets");
			System.out.println("2. Water all organic pets");
			System.out.println("3. Oil all robotic pets");
			System.out.println("4. Take all dogs for a walk");
			System.out.println("5. Nap with all the cats");
			System.out.println("6. Clean all dog cages");
			System.out.println("6. Clean all dog cages");
			System.out.println("6. Adopt a pet");
			System.out.println("7. Admit a new pet");
			System.out.println("8. Quit");
			System.out.print("> ");

			menuChoice = input.nextLine();
			switch (menuChoice) {
			case "1":
				System.out.println();
				myShelter.petShelterTick();
				myShelter.feedAllOrganicPets(-25);
				System.out.println("You fed the organic pets.");			
				break;
			case "2":
				System.out.println();
				myShelter.petShelterTick();
				myShelter.waterAllOrganicPets(-30);
				System.out.println("You watered the organic pets.");			
				break;
			case "3":
				System.out.println();
				myShelter.petShelterTick();
				myShelter.oilAllRoboticPets(40, -20);
				System.out.println("You oiled the robotic pets.");			
				break;
			case "4":
				System.out.println();
				myShelter.petShelterTick();
				myShelter.walkAllDogs();
				System.out.println("You walked all of the dogs.");			
				break;
			
			
			
			
			
			
			
			
			
			}
		}
	}
}
