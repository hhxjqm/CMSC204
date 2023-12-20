import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

class BasicDoubleLinkedList_STUDENT_Test {

	BasicDoubleLinkedList<Double> DoubleData;
	DoubleComparator c;
	
	
	@BeforeEach
	void setUp() throws Exception {
		
		c = new DoubleComparator();
		DoubleData = new BasicDoubleLinkedList<Double>();
		DoubleData.addToFront(1.0);
		DoubleData.addToEnd(2.0);
	}

	@AfterEach
	void tearDown() throws Exception {
		DoubleData = null;
		c = null;
	}

	@Test
	void testGetSize() {
		assertEquals(2,DoubleData.getSize());
	}

	@Test
	void testAddToEnd() {
		assertEquals(2.0, DoubleData.getLast());
		DoubleData.addToEnd(3.0);
		assertEquals(3.0, DoubleData.getLast());

	}

	@Test
	void testAddToFront() {
		assertEquals(1.0, DoubleData.getFirst());
		DoubleData.addToFront(0.0);
		assertEquals(0.0, DoubleData.getFirst());
	}

	@Test
	void testGetFirst() {
		assertEquals(1.0, DoubleData.getFirst());
		DoubleData.addToFront(0.0);
		assertEquals(0.0, DoubleData.getFirst());
	}

	@Test
	void testGetLast() {
		assertEquals(2.0, DoubleData.getLast());
		DoubleData.addToEnd(3.0);
		assertEquals(3.0, DoubleData.getLast());
	}

	@Test
	void testIterator() {
		DoubleData.addToEnd(10.0);
		DoubleData.addToEnd(20.0);
		DoubleData.addToEnd(30.0);
		DoubleData.addToEnd(40.0);
		
		ListIterator<Double> it = DoubleData.iterator();
		
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
	void testRemove() {
		DoubleData.remove(1.0, c);
		assertEquals(2.0, DoubleData.getFirst());
		DoubleData.addToFront(100.0);
		DoubleData.remove(2.0, c);
		assertEquals(100.0, DoubleData.getFirst());
	}

	@Test
	void testRetrieveFirstElement() {
		assertEquals(1.0, DoubleData.retrieveFirstElement());	
		assertEquals(2.0, DoubleData.retrieveFirstElement());
	}

	@Test
	void testRetrieveLastElement() {
		assertEquals(2.0, DoubleData.retrieveLastElement());	
		assertEquals(1.0, DoubleData.retrieveLastElement());
	}

	@Test
	void testToArrayList() {
		
		DoubleData.addToEnd(100.0);
		DoubleData.addToEnd(50.0);
		ArrayList<Double> list;
		list = DoubleData.toArrayList();
		assertEquals(1.0, list.get(0));
		assertEquals(2.0, list.get(1));
		assertEquals(100.0, list.get(2));
		assertEquals(50.0, list.get(3));
	}

	private class DoubleComparator implements Comparator<Double>
	{

		@Override
		public int compare(Double arg0, Double arg1) {
			
			return arg0.compareTo(arg1);
		}
		
	}
}
