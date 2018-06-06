package petshelter;

import static org.junit.Assert.assertNotsEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class OCatTest {

	OCat testOCat;
	OCat testOCat2;

	@Before
	public void setUp() {
		testOCat = new OCat("Mittens", "Organic Cat");
		testOCat2 = new OCat("Teeney", "Organic Cat");
	}

	@Test
	public void twoCatsHaveDifferentHealth() {
		int healthLevel = testOCat.getHealth();
		int healthLevel2 = testOCat2.getHealth();
		assertNotEquals(healthLevel, healthLevel2);
	}

	@Test
	public void twoCatsHaveDifferentHappiness() {
		int happinessLevel = testOCat.getHappiness();
		int happinessLevel2 = testOCat2.getHappiness();
		assertNotEquals(happinessLevel, happinessLevel2);
	}

	@Test
	public void feedCatDecreasesHunger() {
		int hungerBefore = testOCat.getHunger();
		testOCat.changeHunger(-5);
		int hungerAfter = testOCat.getHunger();
		assertEquals(hungerAfter, hungerBefore - 5);
	}

	@Test
	public void waterCatDecreasesThirst() {
		int thirstBefore = testOCat.getThirst();
		testOCat.changeThirst(-5);
		int thirstAfter = testOCat.getThirst();
		assertEquals(thirstAfter, thirstBefore - 5);
	}

	@Test
	public void aCleanLitterBoxIncreasesHealth() {
		int healthBefore = testOCat.getHealth();
		testOCat.litterBoxClean(5);
		int healthAfter = testOCat.getHealth();
		assertEquals(healthAfter, healthBefore + 5);
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
		testOCat.organicCatTick();
		int hungerAfter = testOCat.getHunger();
		assertTrue(hungerAfter > hungerBefore);
	}

	@Test
	public void tickIncreasesThirst() {
		int thirstBefore = testOCat.getThirst();
		testOCat.organicCatTick();
		int thirstAfter = testOCat.getThirst();
		assertTrue(thirstAfter > thirstBefore);
	}

	@Test
	public void healthDecreaseIfThirstIsAbove80() {
		testOCat.setThirst(80);
		int healthBefore = testOCat.getHealth();
		testOCat.organicCatTick();
		int healthAfter = testOCat.getHealth();
		assertTrue(healthAfter < healthBefore);
	}

	@Test
	public void catNapIncreasesHappiness() {
		int hapBefore = testOCat.getHappiness();
		testOCat.napCat(5);
		int hapAfter = testOCat.getHappiness();
		assertEquals(hapAfter, hapBefore + 5);
	}

}
