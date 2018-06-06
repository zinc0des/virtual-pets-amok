package petshelter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

public class RoboDogTest {

	RoboDog testRoboDog;
	RoboDog testRoboDog2;

	@Before
	public void setUp() {
		testRoboDog = new RoboDog("Astro", "Robot Dog");
		testRoboDog2 = new RoboDog("Physics", "Robot Dog");
	}

	@Test
	public void twoRoboDogsHaveDifferentHealth() {
		int healthLevel = testRoboDog.getHealth();
		int healthLevel2 = testRoboDog2.getHealth();
		assertNotEquals(healthLevel, healthLevel2);
	}

	@Test
	public void twoRoboDogsHaveDifferentHappiness() {
		int happinessLevel = testRoboDog.getHappiness();
		int happinessLevel2 = testRoboDog2.getHappiness();
		assertEquals(happinessLevel, 30);
		assertEquals(happinessLevel2, 35);
	}

	@Test
	public void walkRoboDogIncreasesHappiness() {
		int hapBefore = testRoboDog.getHappiness();
		testRoboDog.walk(25);
		int hapAfter = testRoboDog.getHappiness();
		assertEquals(hapAfter, hapBefore + 25);
	}

	@Test
	public void oilShouldDecreaseRustLevel() {
		int rustBefore = testRoboDog.getRustLevel();
		testRoboDog.oil(25, -10);
		int rustAfter = testRoboDog.getRustLevel();
		assertEquals(rustAfter, rustBefore - 10);
	}

	@Test
	public void oilShouldIncreaseHealth() {
		int healthBefore = testRoboDog.getHealth();
		testRoboDog.oil(5, -10);
		int healthAfter = testRoboDog.getHealth();
		assertEquals(healthAfter, healthBefore + 5);
	}
}
