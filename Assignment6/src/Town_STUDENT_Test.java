import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Town_STUDENT_Test {
	Town t1 = new Town("town1");
	Town t2 = new Town("town2");
	Town t3 = new Town("town3");
	Town t4 = new Town("town4");
	Town t5 = new Town("town5");
	
	@BeforeEach
	void setUp() throws Exception {
		
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testHashCode() {
		String a = "town1";
		assertEquals(a.hashCode(), t1.hashCode());
	}

	@Test
	void testCompareTo() {
		assertEquals(t1.compareTo(t1), 0);
	}
	

	@Test
	void testGetName() {
		assertEquals(t1.getName(), "town1");
	}

	@Test
	void testToString() {
		assertEquals(t1.getName(), "town1");
	}

	@Test
	void testEqualsObject() {
		 assertTrue(t1.equals(t1));
		 assertFalse(t1.equals(t2));
	}

}
