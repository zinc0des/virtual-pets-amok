package petshelter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ODogTest {

	ODog testODog;
	ODog testODog2;

	@Before
	public void setUp() {
		testODog = new ODog("Baci", "Organic Dog", 50, 32, 20, 60, 50);
		testODog2 = new ODog("Kisses", "Organic Dog", 75, 35, 40, 70, 50);
	}

	@Test
	public void shouldHaveHealth() {
		int healthLevel = testODog.getHealth();
		assertEquals(healthLevel, 50);
	}

	@Test
	public void twoDogsHaveDifferentHealth() {
		int healthLevel = testODog.getHealth();
		int healthLevel2 = testODog2.getHealth();
		assertEquals(healthLevel, 50);
		assertEquals(healthLevel2, 75);
	}

	@Test
	public void twoDogsHaveDifferentHappiness() {
		int happinessLevel = testODog.getHappiness();
		int happinessLevel2 = testODog2.getHappiness();
		assertEquals(happinessLevel, 32);
		assertEquals(happinessLevel2, 35);
	}

	@Test
	public void feedDogDecreasesHunger() {
		int hungerBefore = testODog.getHunger();
		testODog.receiveFood(-20);
		int hungerAfter = testODog.getHunger();
		assertEquals(hungerAfter, hungerBefore - 20);
	}

	@Test
	public void waterDogDecreasesThirst() {
		int thirstBefore = testODog.getThirst();
		testODog.receiveWater(-10);
		int thirstAfter = testODog.getThirst();
		assertEquals(thirstAfter, thirstBefore - 10);
	}

	@Test
	public void walkDogIncreasesHappiness() {
		int hapBefore = testODog.getHappiness();
		testODog.walk(25, 25);
		int hapAfter = testODog.getHappiness();
		assertEquals(hapAfter, hapBefore + 25);
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
		testODog.cleanCage(25);
		int healthAfter = testODog.getHealth();
		assertEquals(healthAfter, healthBefore + 25);
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
		testODog.setThirst(79);
		int healthBefore = testODog.getHealth();
		testODog.organicDogTick();
		int healthAfter = testODog.getHealth();
		assertTrue(healthAfter < healthBefore);
	}

	@Test
	public void healthDecreasesIfHappinessIsBelow30() {
		int healthBefore = testODog.getHealth();
		testODog.organicDogTick();
		int healthAfter = testODog.getHealth();
		assertTrue(healthAfter < healthBefore);
	}
}
