package petshelter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ODogTest {

	ODog testODog;
	ODog testODog2;

	@Before
	public void setUp() {
		testODog = new ODog("Baci", "Organic Dog");
		testODog2 = new ODog("Kisses", "Organic Dog");
	}

	@Test
	public void twoDogsHaveDifferentHealth() {
		int healthLevel = testODog.getHealth();
		int healthLevel2 = testODog2.getHealth();
		assertNotEquals(healthLevel, healthLevel2);
	}

	@Test
	public void twoDogsHaveDifferentHappiness() {
		int happinessLevel = testODog.getHappiness();
		int happinessLevel2 = testODog2.getHappiness();
		assertNotEquals(happinessLevel, happinessLevel2);
	}

	@Test
	public void feedDogDecreasesHunger() {
		int hungerBefore = testODog.getHunger();
		testODog.changeHunger(-5);
		int hungerAfter = testODog.getHunger();
		assertEquals(hungerAfter, hungerBefore - 5);
	}

	@Test
	public void waterDogDecreasesThirst() {
		int thirstBefore = testODog.getThirst();
		testODog.changeThirst(-5);
		int thirstAfter = testODog.getThirst();
		assertEquals(thirstAfter, thirstBefore - 5);
	}

	@Test
	public void walkDogIncreasesHappiness() {
		int hapBefore = testODog.getHappiness();
		testODog.walk(5, 25);
		int hapAfter = testODog.getHappiness();
		assertEquals(hapAfter, hapBefore + 5);
	}

	@Test
	public void walkDogDecreasesWaste() {
		int wasteBefore = testODog.getWaste();
		testODog.walk(25, -10);
		int wasteAfter = testODog.getWaste();
		assertEquals(wasteAfter, wasteBefore - 10);
	}

	@Test
	public void cleanCageIncreasesHealth() {
		int healthBefore = testODog.getHealth();
		testODog.cleanCage(5);
		int healthAfter = testODog.getHealth();
		assertEquals(healthAfter, healthBefore + 5);
	}

	@Test
	public void cleanCageSetsWasteToZero() {
		testODog.cleanCage(25);
		int wasteAfter = testODog.getWaste();
		assertEquals(wasteAfter, 0);
	}

	@Test
	public void tickIncreasesHunger() {
		int hungerBefore = testODog.getHunger();
		testODog.organicDogTick();
		int hungerAfter = testODog.getHunger();
		assertTrue(hungerAfter > hungerBefore);
	}

	@Test
	public void tickIncreasesThirst() {
		int thirstBefore = testODog.getThirst();
		testODog.organicDogTick();
		int thirstAfter = testODog.getThirst();
		assertTrue(thirstAfter > thirstBefore);
	}

	@Test
	public void tickIncreasesWaste() {
		int wasteBefore = testODog.getWaste();
		testODog.organicDogTick();
		int wasteAfter = testODog.getWaste();
		assertTrue(wasteAfter > wasteBefore);
	}

	@Test
	public void healthDecreaseIfThirstIsAbove80() {
		testODog.setThirst(80);
		int healthBefore = testODog.getHealth();
		testODog.organicDogTick();
		int healthAfter = testODog.getHealth();
		assertTrue(healthAfter < healthBefore);
	}

	@Test
	public void healthDecreasesIfHappinessIsBelow30() {
		testODog.setHappiness(31);
		int healthBefore = testODog.getHealth();
		testODog.organicDogTick();
		int healthAfter = testODog.getHealth();
		assertTrue(healthAfter < healthBefore);
	}
}
