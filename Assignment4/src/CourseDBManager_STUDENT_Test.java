import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CourseDBManager_STUDENT_Test {

	public CourseDBManagerInterface mgr;
	
	@BeforeEach
	void setUp() throws Exception {
		mgr = new CourseDBManager();
		
		mgr.add("CMSC204",5000,4,"Distance Learning","Tab");
	}

	@AfterEach
	void tearDown() throws Exception {
		mgr = null;
	}

	@Test
	void testAdd() {
		try {
			mgr.add("CMSC207",60000,4,"Distance Learning","Huang");
		}
		catch(Exception e) {
			fail("This should not have caused an Exception");
		}
	}

	@Test
	void testGet() {
		try {
		mgr.get(5000);
		}
		catch (Exception e) {
			fail("Should not have thrown an exception");
		}
		
	}

	@Test
	void testReadFile() {
		try {
			File inputFile = new File("Student_test.txt");
			PrintWriter inFile = new PrintWriter(inputFile);
			inFile.println("CMSC204 5000 4 Distance Learning H H Huang");
			inFile.print("CMSC207 50001 4 SC450 abcde");
			inFile.close();	
		} catch (Exception e) {
			fail("Should not have thrown an exception");
		}
	}

	@Test
	void testShowAll() {
		mgr.add("CMSC201",5001,4,"CS001","pro A a");
		mgr.add("CMSC202",5002,4,"BS002","asd fff s s");
		mgr.add("CMSC203",5003,4,"AS003","HUUUU iiio");
		
		ArrayList<String> list = mgr.showAll();
		
		assertEquals(list.get(0),"\nCourse:CMSC204 CRN:5000 Credits:4 Instructor:Tab Room:Distance Learning");
		assertEquals(list.get(1),"\nCourse:CMSC201 CRN:5001 Credits:4 Instructor:pro A a Room:CS001");
		assertEquals(list.get(2),"\nCourse:CMSC202 CRN:5002 Credits:4 Instructor:asd fff s s Room:BS002");
		assertEquals(list.get(3),"\nCourse:CMSC203 CRN:5003 Credits:4 Instructor:HUUUU iiio Room:AS003");
	}

}
