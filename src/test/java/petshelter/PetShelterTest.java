package petshelter;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.junit.Before;
import org.junit.Test;


public class PetShelterTest {

	PetShelter underTest;
	RoboCat testRoboCat;
	RoboDog testRoboDog;
	OCat testOCat;
	ODog testODog;

	@Before
	public void setUp() {
		underTest = new PetShelter();
		testRoboCat = new RoboCat("Sparks", 50, 30, 80);
		testRoboDog = new RoboDog("Bolts", 30, 40, 60);
		testOCat = new OCat("Teeney", 50, 30, 60, 60, 50);
		testODog = new ODog("Baci", 50, 30, 50, 60, 50);
		
		underTest.addPet(testOCat);
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
	public void shouldBeAbleToAddFourPets() {
		Collection<Pet> allPets = underTest.getAllPets();
		assertThat(allPets, containsInAnyOrder(testRoboCat, testOCat, testRoboDog, testODog));
		assertEquals(4, allPets.size(), 0);
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
		int feedAmount = -20;
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
		int waterAmount = -10;
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
		underTest.oilAllRoboticPets(oilAmount);
		int rCRustLevelAfter = testRoboCat.getRustLevel();
		int rDRustLevelAfter = testRoboDog.getRustLevel();
		assertEquals(rCRustLevelAfter, rCRustLevelBefore + oilAmount);
		assertEquals(rDRustLevelAfter, rDRustLevelBefore + oilAmount);
	}
	
	
	
	
	
}
