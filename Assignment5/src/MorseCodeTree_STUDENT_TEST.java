import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MorseCodeTree_STUDENT_TEST {

	MorseCodeTree tree = new MorseCodeTree();
	 
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
		tree = null;
	
	}

	@Test
	void testInsert() {
		tree.insert(".", "e");
		assertEquals(tree.getRoot().getLeft().getData(), "e");
	}

	@Test
	void testAddNode() {
		tree.addNode(tree.getRoot(), ".", "e");
		assertEquals(tree.getRoot().getLeft().getData(), "e");
	}

	@Test
	void testFetch() {
		 String a = ".-";
	     String letterA = tree.fetch(a);

	     assertEquals(letterA, "a");
	}

	@Test
	void testFetchNode() {
		String a = ".-";
	    String letterA = tree.fetchNode(tree.getRoot(), a);

	   assertEquals(letterA, "a");
	}
	
	@Test
	void testMorseCodeTree() {
		assertEquals(tree.toArrayList().get(0), "h");
		assertEquals(tree.toArrayList().get(1), "s");
	}

	@Test
	void testGetRoot() {
		assertEquals(tree.getRoot().getData(), "");
	}

	@Test
	void testSetRoot() {
		TreeNode<String> node = new TreeNode("Hi");
		tree.setRoot(node);
		assertEquals(tree.getRoot().getData(), "Hi");
	}

	@Test
	void testBuildTree() {
		assertEquals(tree.toArrayList().get(0), "h");
		assertEquals(tree.toArrayList().get(1), "s");
	}

	@Test
	void testToArrayList() {
		ArrayList<String> list = new ArrayList<>();
		list = tree.toArrayList();
		assertEquals(list.get(0), "h");
		assertEquals(list.get(1), "s");
	}

	@Test
	void testLNRoutputTraversal() {
		assertEquals(tree.toArrayList().get(0), "h");
		assertEquals(tree.toArrayList().get(1), "s");
	}

}
