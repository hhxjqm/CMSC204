import java.util.ArrayList;

/** Interface for a Queue data structure
 * 
 * @author Professor Kartchner
 *
 * @param <T> data type
 */
public interface QueueInterface<T> {
	/** provide three constructors
	 * 1. takes an int as the size of the queue
	 * 2. default constructor - uses a default as the size of the queue
	 * 3. takes an ArrayList as a parameter, and fills the Queue with the
	 * 	elements of the ArrayList, First element in the ArrayList is the first element in the Queue
	 *
	 * 	  YOU MUST MAKE A COPY OF LIST AND ADD THOSE ELEMENTS TO THE QUEUE, if you use the
	 * 	  list reference within your Queue, you will be allowing direct access to the data of
	 * 	  your Queue causing a possible security breach.
	 */

	/**
	 * Determines if Queue is empty
	 * @return true if Queue is empty, false if not
	 */
	public boolean isEmpty();

	/**
	 * Determines of the Queue is empty
	 * @return
	 */
	public boolean isFull();
	
	/**
	 * Deletes and returns the element at the front of the Queue
	 * @return the element at the front of the Queue
	 */
	public T dequeue() throws QueueUnderflowException;

	/**
	 * Number of elements in the Queue
	 * @return the number of elements in the Queue
	 */
	public int size();
	
	/**
	 * Adds an element to the end of the Queue
	 * @param e the element to add to the end of the Queue
	 * @return true if the add was successful, false if not
	 */
	public boolean enqueue(T e) throws QueueOverflowException;
	
	
	/**
	 * Returns the string representation of the elements in the Queue, 
	 * the beginning of the string is the front of the queue
	 * @return string representation of the Queue with elements
	 */
	public String toString();
	
	/**
	 * Returns the string representation of the elements in the Queue, the beginning of the string is the front of the queue
	 * Place the delimiter between all elements of the Queue
	 * @return string representation of the Queue with elements separated with the delimiter
	 */
	public String toString(String delimiter);
	
	 /**
	  * Fills the Queue with the elements of the ArrayList, First element in the ArrayList
	  * is the first element in the Queue
	  * YOU MUST MAKE A COPY OF LIST AND ADD THOSE ELEMENTS TO THE QUEUE, if you use the
	  * list reference within your Queue, you will be allowing direct access to the data of
	  * your Queue causing a possible security breech.
	  * @param list elements to be added to the Queue
	  */
	public void fill(ArrayList<T> list);
	
 

}