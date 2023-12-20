import java.util.ArrayList;

/**
 * 
 * @author Huan Shiuan Huang
 *
 */
public class MorseCodeTree implements LinkedConverterTreeInterface<String> {

	private TreeNode<String> root;
	
	/**
	 * Constructor - calls the buildTree method
	 */
	public MorseCodeTree() {
		buildTree();
	}

	/**
	 * Returns a reference to the root
	 * @return reference to root
	 */
	@Override
	public TreeNode<String> getRoot() {
		return root;
	}

	/**
	 * sets the root of the MorseCodeTree
	 * @param newNode - a copy of newNode will be the new root
	 */
	@Override
	public void setRoot(TreeNode<String> newNode) {
		root = newNode;
	}

	/**
	 * Adds element to the correct position in the tree based on the code This method will call the recursive method addNode
	 * @param code - the code for the new node to be added, example ".-."
     * @param letter - the letter for the corresponding code, example "r"
     * @return the MorseCodeTree with the new node added
	 */
	@Override
	public LinkedConverterTreeInterface<String> insert(String code, String result) {
		addNode(root, code, result);
		return this;
	}

	/**
	 * This is a recursive method that adds element to the correct position in the tree based on the code. A '.' (dot) means traverse to the left. A "-" (dash) means traverse to the right. The code ".-" would be stored as the right child of the left child of the root Algorithm for the recursive method:
1. if there is only one character
a. if the character is '.' (dot) store to the left of the current root
b. if the character is "-" (dash) store to the right of the current root
c. return
2. if there is more than one character
a. if the first character is "." (dot) new root becomes the left child
b. if the first character is "-" (dash) new root becomes the right child
c. new code becomes all the remaining charcters in the code (beyond the first character)
d. call addNode(new root, new code, letter)
@param root - the root of the tree for this particular recursive instance of addNode
code - the code for this particular recursive instance of addNode
letter - the data of the new TreeNode to be added
	 */
	@Override
	public void addNode(TreeNode<String> root, String code, String letter) {
		TreeNode<String> node = new TreeNode<>(letter);
		
		//Add the node into right place
		if(code.length() == 1) {
			if(code.equals("."))
				root.setLeft(node);
			else
				root.setRight(node);
		}
		else {
			String newCode = code.substring(1);
			
			if(code.charAt(0) == '.')
				addNode(root.getLeft(), newCode, letter);
			else
				addNode(root.getRight(), newCode, letter);
		
		}
		
	}

	/**
	 * Fetch the data in the tree based on the code This method will call the recursive method fetchNode
	 * @param code - the code that describes the traversals to retrieve the string (letter)
	 * @return the string (letter) that corresponds to the code
	 */
	@Override
	public String fetch(String code) {
		String search;
		search = fetchNode(root, code);
        return search;
	}

	/**
	 * This is the recursive method that fetches the data of the TreeNode that corresponds with the code A '.' (dot) means traverse to the left. A "-" (dash) means traverse to the right. The code ".-" would fetch the data of the TreeNode stored as the right child of the left child of the root
	 * @param root - the root of the tree for this particular recursive instance of addNode
code - the code for this particular recursive instance of addNode
@return the string (letter) corresponding to the code
	 */
	@Override
	public String fetchNode(TreeNode<String> root, String code) {
		String search = "";
		if(code.length() == 0) {
			return "";
		}
		//Get the letter base on the code
		if(code.length() == 1) {
			if(code.equals("."))
				search = (String) root.getLeft().getData();
			else if(code.equals("-"))
				search = (String) root.getRight().getData();
		}
		
		else {
			String newCode = code.substring(1);
			
			if(code.charAt(0) == '.')
				search = fetchNode(root.getLeft(), newCode);
			else if(code.charAt(0) == '-')
				search = fetchNode(root.getRight(), newCode);
		}
		
		return search;
	}

	/**
	 * This operation is not supported in the MorseCodeTree
	 * @param data - data of node to be deleted
	 * @return reference to the current tree
	 * @throws java.lang.UnsupportedOperationException
	 */
	@Override
	public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	/**
	 * This operation is not supported in the MorseCodeTree
	 * @param data - data of node to be deleted
	 * @return reference to the current tree
	 * @throws java.lang.UnsupportedOperationException
	 */
	@Override
	public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	/**
	 * This method builds the MorseCodeTree by inserting the nodes of the tree level by level based on the code. The root will have a value of "" (empty string) level one: insert(".", "e"); insert("-", "t"); level two: insert("..", "i"); insert(".-", "a"); insert("-.", "n"); insert("--", "m"); etc. Look at the tree and the table of codes to letters in the assignment description.
	 * 
	 */
	@Override
	public void buildTree() {
		root = new TreeNode<>("");
		
		//insert 26 letter in a tree
		insert(".", "e");
        insert("-", "t");
        insert("..", "i");
        insert(".-", "a");
        insert("-.", "n");
        insert("--", "m");
        insert("...", "s");
        insert("..-", "u");
        insert(".-.", "r");
        insert(".--", "w");
        insert("-..", "d");
        insert("-.-", "k");
        insert("--.", "g");
        insert("---", "o");
        insert("....", "h");
        insert("...-", "v");
        insert("..-.", "f");
        insert(".-..", "l");
        insert(".--.", "p");
        insert(".---", "j");
        insert("-...", "b");
        insert("-..-", "x");
        insert("-.-.", "c");
        insert("-.--", "y");
        insert("--..", "z");
        insert("--.-", "q");
	}

	/**
	 * Returns an ArrayList of the items in the linked Tree in LNR (Inorder) Traversal order Used for testing to make sure tree is built correctly
	 * @return an ArrayList of the items in the linked Tree
	 */
	@Override
	public ArrayList<String> toArrayList() {
		ArrayList<String> List = new ArrayList<>();
        LNRoutputTraversal(root, List);
        return List;
	}

	/**
	 * The recursive method to put the contents of the tree in an ArrayList in LNR (Inorder)
	 * @param root - the root of the tree for this particular recursive instance
list - the ArrayList that will hold the contents of the tree in LNR order
	 */
	@Override
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
		//Store letter into an Array List using inorder
		if(root != null) {
			LNRoutputTraversal(root.getLeft(), list);
			list.add(root.data);
			LNRoutputTraversal(root.right, list);
		}
		
	}
}
