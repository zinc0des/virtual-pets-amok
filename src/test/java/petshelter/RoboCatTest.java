package petshelter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class RoboCatTest {

	RoboCat testRoboCat;
	RoboCat testRoboCat2;

	@Before
	public void setUp() {
		testRoboCat = new RoboCat("RoboCat", "Robot Cat");
		testRoboCat2 = new RoboCat("Mark", "Robot Cat");
	}

	@Test
	public void twoRoboCatsHaveDifferentHealth() {
		int healthLevel = testRoboCat.getHealth();
		int healthLevel2 = testRoboCat2.getHealth();
		assertNotEquals(healthLevel, healthLevel2);
	}

	@Test
	public void twoRoboCatsHaveDifferentHappiness() {
		int happinessLevel = testRoboCat.getHappiness();
		int happinessLevel2 = testRoboCat2.getHappiness();
		assertNotEquals(happinessLevel, happinessLevel2);
	}
	
	@Test
	public void oilShouldDecreaseRustLevel() {
		int rustBefore = testRoboCat.getRustLevel();
		testRoboCat.oil(25, -5);
		int rustAfter = testRoboCat.getRustLevel();
		assertEquals(rustAfter, rustBefore - 5);
	}

	@Test
	public void oilShouldIncreaseHealth() {
		int healthBefore = testRoboCat.getHealth();
		testRoboCat.oil(5, -10);
		int healthAfter = testRoboCat.getHealth();
		assertEquals(healthAfter, healthBefore + 5);
	}
	
	@Test
	public void roboCatNapIncreasesHappiness() {
		int hapBefore = testRoboCat.getHappiness();
		testRoboCat.napCat(5);
		int hapAfter = testRoboCat.getHappiness();
		assertEquals(hapAfter, hapBefore + 5);
	}
	
	@Test
	public void healthDecreasesIfHappinessIsBelow30() {
		testRoboCat.setHappiness(30);
		int healthBefore = testRoboCat.getHealth();
		System.out.println(healthBefore);
		testRoboCat.roboticTick();
		int healthAfter = testRoboCat.getHealth();
		System.out.println(healthAfter);
		assertTrue(healthAfter < healthBefore);
	}
	
}
