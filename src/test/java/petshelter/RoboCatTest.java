package petshelter;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class RoboCatTest {

	RoboCat testRoboCat;
	RoboCat testRoboCat2;

	@Before
	public void setUp() {
		testRoboCat = new RoboCat("RoboCat", 50, 30, 20);
		testRoboCat2 = new RoboCat("Mark", 75, 35, 40);
	}

	@Test
	public void shouldHaveHealth() {
		int healthLevel = testRoboCat.getHealth();
		assertEquals(healthLevel, 50);
	}

	@Test
	public void twoRoboCatsHaveDifferentHealth() {
		int healthLevel = testRoboCat.getHealth();
		int healthLevel2 = testRoboCat2.getHealth();
		assertEquals(healthLevel, 50);
		assertEquals(healthLevel2, 75);
	}

	@Test
	public void twoRoboCatsHaveDifferentHappiness() {
		int happinessLevel = testRoboCat.getHappiness();
		int happinessLevel2 = testRoboCat2.getHappiness();
		assertEquals(happinessLevel, 30);
		assertEquals(happinessLevel2, 35);
	}
	
	@Test
	public void oilShouldDecreaseRustLevel() {
		int rustBefore = testRoboCat.getRustLevel();
		testRoboCat.oil(25, -10);
		int rustAfter = testRoboCat.getRustLevel();
		assertEquals(rustAfter, rustBefore - 10);
	}

	@Test
	public void oilShouldIncreaseHealth() {
		int healthBefore = testRoboCat.getHealth();
		testRoboCat.oil(25, -10);
		int healthAfter = testRoboCat.getHealth();
		assertEquals(healthAfter, healthBefore + 25);
	}
	
	@Test
	public void roboCatNapIncreasesHappiness() {
		int hapBefore = testRoboCat.getHappiness();
		testRoboCat.getCatNap(25);
		int hapAfter = testRoboCat.getHappiness();
		assertEquals(hapAfter, hapBefore + 25);
	}
	
}
