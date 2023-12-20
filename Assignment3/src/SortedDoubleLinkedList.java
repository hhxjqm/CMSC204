import java.util.Comparator;

/**
 * 
 * @author Huan Shiuan Huang
 *
 * @param <T> Generic
 */
public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList <T> {

	private Comparator<T> c = null;

	/**
	 * Creates an empty list that is associated with the specified comparator.
	 * @param comparator2 - Comparator to compare data elements
	 */
	public SortedDoubleLinkedList(java.util.Comparator<T> comparator2) {
		c = comparator2;
	}

	/**
	 * Inserts the specified element at the correct position in the sorted list. Notice we can insert the same element several times. Your implementation must traverse the list only once in order to perform the insertion. Do not implement this method using iterators. Notice that you don't need to call any of the super class methods in order to implement this method.
	 * @param data - the data to be added to the list
	 * @return a reference to the current object
	 */
	public SortedDoubleLinkedList<T> add(T data) {
		
		//create a new node with param
		Node e = new Node(data, null, null);
		if (size == 0) {
			
			head = e;
			tail = e;
			size++;
			return this;
		}

		//Add to front if data is smaller than the head
		else if (c.compare(data, head.data) < 0) {
			e.next = head;
			head.prev = e;
			head = e;
			size++;
			return this;
		}
		
		//Add to end if data is larger than the tail
		else if(c.compare(data, tail.data) > 0) {
			tail.next = e;
			e.prev = tail;
			tail = e;
			size++;
			return this;
		}
		
		else {
			Node s = head;
			boolean suc = false;
			while (suc == false) {
				
				if (c.compare(data, s.data) > 0 && c.compare(data, s.next.data) < 0) {
					e.next = s.next;
					e.prev = s;
					if(s.prev != null)
						s.prev.next = s;
					s.next.prev = e;
					s.next = e;
					size++;
					suc = true;
					return this;
				}
				s = s.next;
			}
		}
		
		return this;
	}

	/**
	 * This operation is invalid for a sorted list. An UnsupportedOperationException will be generated using the message "Invalid operation for sorted list."
	 * @Overrides addToEnd in class BasicDoubleLinkedList<T>
	 * @param data - the data for the Node within the linked list
	 * @return reference to the current object
	 * @throws java.lang.UnsupportedOperationException - if method is called
	 * 
	 */
	@Override
	public BasicDoubleLinkedList<T> addToEnd(T data)  throws java.lang.UnsupportedOperationException {
		throw new UnsupportedOperationException("Invalid operation for sorted list");
	}
	
	/**
	 * This operation is invalid for a sorted list. An UnsupportedOperationException will be generated using the message "Invalid operation for sorted list."
	 * @Overrides addToFront in class BasicDoubleLinkedList<T>
	 * @param data - the data for the Node within the linked list
	 * @return reference to the current object
	 * @throws java.lang.UnsupportedOperationException - if method is called
	 * 
	 */
	@Override
	public BasicDoubleLinkedList<T> addToFront(T data) throws java.lang.UnsupportedOperationException {
		throw new UnsupportedOperationException("Invalid operation for sorted list");
	}

	/**
	 * Implements the iterator by calling the super class iterator method.
	 * @Specified iterator in interface java.lang.Iterable<T>
	 * @Overrides addToFront in class BasicDoubleLinkedList<T>
	 * @return an iterator positioned at the head of the list
	 */
	@Override
	public java.util.ListIterator<T> iterator() {
		return super.iterator();
	}

	/**
	 * Implements the remove operation by calling the super class remove method.
	 * @Overrides remove in class BasicDoubleLinkedList<T>
	 * @param data - the data element to be removed
     * @param comparator - the comparator to determine equality of data elements
     * @return data element or null
	 */
	@Override
	public SortedDoubleLinkedList<T> remove(T data, java.util.Comparator<T> comparator) {
		super.remove(data, comparator);
		return this;
	}
}
