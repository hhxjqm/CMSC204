import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Road_STUDENT_Test {

	Town t1 = new Town("town1");
	Town t2 = new Town("town2");
	Town t3 = new Town("town3");
	Town t4 = new Town("town4");
	Town t5 = new Town("town5");
	
	Road r1 = new Road(t1, t2, 1, "road1");
	Road r2 = new Road(t3, t1, 2, "road2");
	Road r3 = new Road(t2, t3, 3, "road3");
	Road r4 = new Road(t4, t3, 1, "road4");
	Road r5 = new Road(t2, t5, 1, "road5");

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testCompareTo() {
		assertEquals(r1.compareTo(r1), 0);
	}

	@Test
	void testContains() {
		assertTrue(r1.contains(t1));
	}

	@Test
	void testToString() {
		assertEquals(r1.toString(), "road1,1;town1;town2");
	}

	@Test
	void testGetName() {
		assertEquals(r1.getName(), "road1");
	}

	@Test
	void testGetDestination() {
		assertEquals(r1.getDestination().getName(), "town2");
	}

	@Test
	void testGetSource() {
		assertEquals(r1.getSource().getName(), "town1");
	}

	@Test
	void testGetWeight() {
		assertEquals(r1.getWeight(), 1);
	}

	@Test
	void testEqualsObject() {
		assertTrue(r1.equals(r1));
		assertFalse(r1.equals(r2));
	}

}
