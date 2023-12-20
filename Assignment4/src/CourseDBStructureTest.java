import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This is the test file for the CourseDBManager
 * which is implemented from the CourseDBManagerInterface
 * @author Professor Kartchner
 */
public class CourseDBStructureTest {
	CourseDBStructure cds, testStructure;

	@Before
	public void setUp() throws Exception {
		cds = new CourseDBStructure(20);
		testStructure = new CourseDBStructure("Testing", 20);
	}

	@After
	public void tearDown() throws Exception {
		cds = testStructure = null;
	}
	
	/**
	 * Test the tableSize for CourseDBStructures constructed
	 * with both constructors
	 */
	@Test
	public void testGetTableSize()
	{
		assertEquals(20, cds.getTableSize());
		assertEquals(20, testStructure.getTableSize());		
	}
	
	/**
	 * Test the hashTable for CourseDBStructures constructed
	 * with both constructors
	 */
	@Test
	public void testHashTable()
	{
		//CourseDBStructure cds = new CourseDBStructure(500);
		assertEquals(20, cds.hashTable.length);
		CourseDBElement cde = new CourseDBElement("CMSC500", 39999, 4, "SC100", "Nobody InParticular"); 
		cds.add(cde);
		LinkedList<CourseDBElement> list = cds.hashTable[cde.hashCode()%cds.getTableSize()];
		
		
		assertEquals(39999, list.get(0).getCRN());
		
		cds = new CourseDBStructure("Testing",20);
		assertEquals(20, cds.hashTable.length);	
		cds.add(cde);
		list = cds.hashTable[cde.hashCode()%20];
		assertEquals(39999, list.get(0).getCRN());
	}
}