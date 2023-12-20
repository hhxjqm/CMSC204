

/** Interface for a generic Stack data structure
 * 
 * @author Professor Kartchner
 *
 * @param <T> data type
 */
public interface StackInterface<T> {

	/**
	 * Provide three constructors
	 * 1. takes in an int as the size of the stack
	 * 2. default constructor - uses default as the size of the stack
	 * 3. takes an ArrayList as a parameter, and fills the Stack with the elements of the ArrayList,
	 * 		First element in the ArrayList is the first bottom element of the Stack
	 *
	 * 	  YOU MUST MAKE A COPY OF LIST AND ADD THOSE ELEMENTS TO THE STACK, if you use the
	 * 	  list reference within your Stack, you will be allowing direct access to the data of
	 * 	  your Stack causing a possible security breach.
	 */
	
	/**
	 * Determines if Stack is empty
	 * @return true if Stack is empty, false if not
	 */
	public boolean isEmpty();

	/**
	 * Determines if Stack is full
	 * @return true if Stack is full, false if not
	 */
	public boolean isFull();
	

	/**
	 * Deletes and returns the element at the top of the Stack
	 * @return the element at the top of the Stack
	 */
	public T pop() throws StackUnderflowException;
	
	/**
	 * Returns the element at the top of the Stack, does not pop it off the Stack
	 * @return the element at the top of the Stack
	 */
	public T top() throws StackUnderflowException;

	/**
	 * Number of elements in the Stack
	 * @return the number of elements in the Stack
	 */
	public int size();
	
	/**
	 * Adds an element to the top of the Stack
	 * @param e the element to add to the top of the Stack
	 * @return true if the add was successful, false if not
	 */
	public boolean push(T e) throws StackOverflowException;
	
	
	/**
	 * Returns the elements of the Stack in a string from bottom to top, the beginning 
	 * of the String is the bottom of the stack
	 * @return an string which represent the Objects in the Stack from bottom to top
	 */
	public String toString();
	
	/**
	 * Returns the string representation of the elements in the Stack, the beginning of the 
	 * string is the bottom of the stack
	 * Place the delimiter between all elements of the Stack
	 * @return string representation of the Stack from bottom to top with elements 
	 * separated with the delimiter
	 */
	public String toString(String delimiter);

 
}