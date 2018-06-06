package petshelter;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.Collection;

import org.junit.Before;
import org.junit.Test;


public class PetShelterTest {

	PetShelter underTest;
	RoboCat testRoboCat;
	RoboDog testRoboDog;
	OCat testOCat;
	OCat testOCat2;
	ODog testODog;

	@Before
	public void setUp() {
		underTest = new PetShelter();
		testRoboCat = new RoboCat("Sparks", "Robot Cat");
		testRoboDog = new RoboDog("Bolts", "Robot Dog");
		testOCat = new OCat("Teeney", "Organic Cat");
		testOCat2 = new OCat("Tiny", "Organic Cat");
		testODog = new ODog("Baci", "Organic Dog");
		
		underTest.addPet(testOCat);
		underTest.addPet(testOCat2);
		underTest.addPet(testODog);
		underTest.addPet(testRoboCat);
		underTest.addPet(testRoboDog);
	}
	
	@Test
	public void shouldBeAbleToAddPet() {
		Pet retrievedPet = underTest.findPet(testRoboCat.getPetName());
		assertThat(retrievedPet, is(testRoboCat));
	}
	
	@Test
	public void shouldBeAbleToAddFivePets() {
		Collection<Pet> allPets = underTest.getAllPets();
		assertThat(allPets, containsInAnyOrder(testRoboCat, testOCat, testRoboDog, testODog, testOCat2));
		assertEquals(5, allPets.size(), 0);
	}
	
	@Test
	public void shouldBeAbleToRemovePet() {
		underTest.removePet(testRoboCat);
		Pet retrievedPet = underTest.findPet(testRoboCat.getPetName());
		assertThat(retrievedPet, is(nullValue()));
	}
	
	@Test
	public void shouldBeAbleToFeedAllOrganicPets() {
		int oCHungerBefore = testOCat.getHunger();
		int oDHungerBefore = testODog.getHunger();
		int feedAmount = -5;
		underTest.feedAllOrganicPets(feedAmount);
		int oCHungerAfter = testOCat.getHunger();
		int oDHungerAfter = testODog.getHunger();
		assertEquals(oCHungerAfter, oCHungerBefore + feedAmount);
		assertEquals(oDHungerAfter, oDHungerBefore + feedAmount);		
	}
	
	@Test
	public void shouldBeAbleToWaterAllOrganicPets() {
		int oCThirstBefore = testOCat.getThirst();
		int oDThirstBefore = testODog.getThirst();
		int waterAmount = -5;
		underTest.waterAllOrganicPets(waterAmount);
		int oCThirstAfter = testOCat.getThirst();
		int oDThirstAfter = testODog.getThirst();
		assertEquals(oCThirstAfter, oCThirstBefore + waterAmount);
		assertEquals(oDThirstAfter, oDThirstBefore + waterAmount);		
	}
	
	@Test
	public void shouldBeAbleToOilAllRoboticPets() {
		int rCRustLevelBefore = testRoboCat.getRustLevel();
		int rDRustLevelBefore = testRoboDog.getRustLevel();
		int oilAmount = -10;
		int healthAmount = 15;
		underTest.oilAllRoboticPets(healthAmount, oilAmount);
		int rCRustLevelAfter = testRoboCat.getRustLevel();
		int rDRustLevelAfter = testRoboDog.getRustLevel();
		assertEquals(rCRustLevelAfter, rCRustLevelBefore + oilAmount);
		assertEquals(rDRustLevelAfter, rDRustLevelBefore + oilAmount);
	}
	
	@Test
	public void shouldBeAbleToOilAllRoboticPetsAndIncreaseHealth() {
		int rCHealthBefore = testRoboCat.getHealth();
		int rDHealthBefore = testRoboDog.getHealth();
		int oilAmount = -10;
		int healthAmount = 5;
		underTest.oilAllRoboticPets(healthAmount, oilAmount);
		int rCHealthAfter = testRoboCat.getHealth();
		int rDHealthAfter = testRoboDog.getHealth();
		assertEquals(rCHealthAfter, rCHealthBefore + healthAmount);
		assertEquals(rDHealthAfter, rDHealthBefore + healthAmount);
	}
	
	@Test
	public void catWasteCombinesInTheLitterbox() {
		underTest.petShelterTick();
		int oCatWaste = testOCat.getWasteTick();
		int oCat2Waste = testOCat2.getWasteTick();
		int litterBox = underTest.getLitterBox();
		assertEquals(litterBox, oCatWaste + oCat2Waste);	
	}
	
	
}
