/**
 * 
 * @author Huan Shiuan Huang
 *
 */
public class TreeNode<T> {

	T data;
	TreeNode left, right;
	
	/**
	 * Create a new TreeNode with left and right child set to null and data set to the dataNode
	 * @param dataNode - the data to be stored in the TreeNode
	 */
	public TreeNode(T dataNode){
		data = dataNode;
		left = right = null;
	}
	
	/**
	 * used for making deep copies
	 * @param node - node to make copy of
	 */
	public TreeNode(TreeNode<T> node) {
		data = node.data;
		left = node.left;
		right = node.right;
	}
	
	/**
	 * Return the data within this TreeNode
	 * @return the data within the TreeNode
	 */
	public T getData(){
		return data;
	}
	
	/**
	 * Setter of the left
	 * @param data - node that set in left
	 */
	public void setLeft(TreeNode data) {
		left = data;
	}
	
	/**
	 * Setter of the right
	 * @param data - node that set in right
	 */
	public void setRight(TreeNode data) {
		right = data;
	}
	
	/**
	 * Getter of the left
	 * @return left
	 */
	public TreeNode getLeft() {
		return left;
	}
	
	/**
	 * Getter of the right
	 * @return right
	 */
	public TreeNode getRight() {
		return right;
	}
}
