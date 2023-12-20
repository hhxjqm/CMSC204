import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeBookTest {

	GradeBook grade1;
	GradeBook grade2;
	
	@BeforeEach
	void setUp() throws Exception {
		grade1 = new GradeBook(5);
		grade2 = new GradeBook(5);
		
		grade1.addScore(10.0);
		grade1.addScore(11.0);
		grade2.addScore(12.0);
		grade2.addScore(13.0);
	}

	@AfterEach
	void tearDown() throws Exception {
		grade1 = null;
		grade2 = null;
	}

	@Test
	void testAddScore() {
		
		assertTrue(grade1.toString().equals("10.0 11.0 0.0 0.0 0.0 "));
		assertTrue(grade2.toString().equals("12.0 13.0 0.0 0.0 0.0 "));
		
		assertEquals(2,grade1.getScoreSize());
		assertEquals(2,grade2.getScoreSize());
	}

	@Test
	void testSum() {
		assertEquals(21.0, grade1.sum());
		assertEquals(25.0, grade2.sum());
	}

	@Test
	void testMinimum() {
		assertEquals(10.0, grade1.minimum());
		assertEquals(12.0, grade2.minimum());
	}

	@Test
	void testFinalScore() {
		assertEquals(11.0, grade1.finalScore());
		assertEquals(13.0, grade2.finalScore());
	}

}
