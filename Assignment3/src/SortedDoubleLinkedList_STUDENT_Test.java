import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SortedDoubleLinkedList_STUDENT_Test {

	SortedDoubleLinkedList<Double> data;
	DoubleComparator c;

	@BeforeEach
	void setUp() throws Exception {
		c = new DoubleComparator();
		data = new SortedDoubleLinkedList<Double>(c);
		data.add(1.0);
		data.add(2.0);
	}

	@AfterEach
	void tearDown() throws Exception {
		c= null;
		data = null;
	}

	@Test
	void testAddToEnd() {
		try {
			data.addToEnd(100.0);
			assertTrue("Did not throw a UnsupportedOperationException",false);
			}
			catch(UnsupportedOperationException e) {
				assertTrue("Successfully threw a UnsupportedOperationException",true);
			}
	}

	@Test
	void testAddToFront() {
		try {
			data.addToFront(100.0);
			assertTrue("Did not throw a UnsupportedOperationException",false);
			}
			catch(UnsupportedOperationException e) {
				assertTrue("Successfully threw a UnsupportedOperationException",true);
			}
	}

	@Test
	void testIterator() {
		
		data.add(10.0);
		data.add(20.0);
		data.add(30.0);
		data.add(40.0);
		
		ListIterator<Double> it = data.iterator();
		
		assertEquals(true, it.hasNext());
		assertEquals(1.0, it.next());
		assertEquals(2.0, it.next());
		assertEquals(10.0, it.next());
		assertEquals(20.0, it.next());
		assertEquals(30.0, it.next());
		assertEquals(40.0, it.next());
		assertEquals(false, it.hasNext());
		assertEquals(true, it.hasPrevious());
		assertEquals(40.0, it.previous());
		assertEquals(30.0, it.previous());
		assertEquals(20.0, it.previous());
		assertEquals(10.0, it.previous());
		assertEquals(2.0, it.previous());
		assertEquals(1.0, it.previous());
		assertEquals(false, it.hasPrevious());
		
		try {
		assertEquals(10.0, it.previous());
		assertTrue("Did not throw a NoSuchElementException",false);
		}
		catch(NoSuchElementException e) {
			assertTrue("Successfully threw a NoSuchElementException",true);
		}
	}

	@Test
	void testAdd() {
		data.add(100.0);
		assertEquals(100.0, data.getLast());
		data.add(0.0);
		assertEquals(0.0, data.getFirst());
	}

	@Test
	void testRemoveTComparatorOfT() {
		data.remove(1.0, c);
		assertEquals(2.0, data.getFirst());
		data.add(100.0);
		data.remove(2.0, c);
		assertEquals(100.0, data.getFirst());
	}

	private class DoubleComparator implements Comparator<Double>
	{

		@Override
		public int compare(Double arg0, Double arg1) {
			
			return arg0.compareTo(arg1);
		}
		
	}
}
