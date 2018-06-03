package petshelter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class OCatTest {

	OCat testOCat;
	OCat testOCat2;

	@Before
	public void setUp() {
		testOCat = new OCat("Mittens", 50, 30, 20, 60, 50);
		testOCat2 = new OCat("Teeney", 75, 35, 40, 70, 50);
	}

	@Test
	public void shouldHaveHealth() {
		int healthLevel = testOCat.getHealth();
		assertEquals(healthLevel, 50);
	}

	@Test
	public void twoCatsHaveDifferentHealth() {
		int healthLevel = testOCat.getHealth();
		int healthLevel2 = testOCat2.getHealth();
		assertEquals(healthLevel, 50);
		assertEquals(healthLevel2, 75);
	}

	@Test
	public void twoCatsHaveDifferentHappiness() {
		int happinessLevel = testOCat.getHappiness();
		int happinessLevel2 = testOCat2.getHappiness();
		assertEquals(happinessLevel, 30);
		assertEquals(happinessLevel2, 35);
	}

	@Test
	public void feedCatDecreasesHunger() {
		int hungerBefore = testOCat.getHunger();
		testOCat.receiveFood(-20);
		int hungerAfter = testOCat.getHunger();
		assertEquals(hungerAfter, hungerBefore - 20);
	}

	@Test
	public void waterCatDecreasesThirst() {
		int thirstBefore = testOCat.getThirst();
		testOCat.receiveWater(-10);
		int thirstAfter = testOCat.getThirst();
		assertEquals(thirstAfter, thirstBefore - 10);
	}

	@Test
	public void aCleanLitterBoxIncreasesHealth() {
		int healthBefore = testOCat.getHealth();
		testOCat.litterBoxClean(25);
		int healthAfter = testOCat.getHealth();
		assertEquals(healthAfter, healthBefore + 25);
	}

	@Test
	public void aCleanLitterBoxSetsWasteToZero() {
		testOCat.litterBoxClean(25);
		int wasteAfter = testOCat.getWaste();
		assertEquals(wasteAfter, 0);
	}

	@Test
	public void tickIncreasesHunger() {
		int hungerBefore = testOCat.getHunger();
		testOCat.organicTick();
		int hungerAfter = testOCat.getHunger();
		assertTrue(hungerAfter > hungerBefore);
	}

	@Test
	public void tickIncreasesThirst() {
		int thirstBefore = testOCat.getThirst();
		testOCat.organicTick();
		int thirstAfter = testOCat.getThirst();
		assertTrue(thirstAfter > thirstBefore);
	}

	@Test
	public void tickIncreasesWaste() {
		int wasteBefore = testOCat.getWaste();
		testOCat.organicTick();
		int wasteAfter = testOCat.getWaste();
		assertTrue(wasteAfter > wasteBefore);
	}

	@Test
	public void healthDecreaseIfThirstIsAbove80() {
		testOCat.setThirst(79);
		int healthBefore = testOCat.getHealth();
		testOCat.organicTick();
		int healthAfter = testOCat.getHealth();
		assertTrue(healthAfter < healthBefore);
	}

	@Test
	public void catNapIncreasesHappiness() {
		int hapBefore = testOCat.getHappiness();
		testOCat.getCatNap(25);
		int hapAfter = testOCat.getHappiness();
		assertEquals(hapAfter, hapBefore + 25);
	}

}
