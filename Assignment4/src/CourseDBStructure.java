import java.io.IOException;
import java.util.LinkedList;

public class CourseDBStructure implements CourseDBStructureInterface{

	int size;
	LinkedList<CourseDBElement>[] hashTable;
	
	/**
	 * Constructor that hold one parameter
	 * @param size - size of the hash table you want
	 */
	public CourseDBStructure(int size) {
		this.size = size;
		hashTable = new LinkedList[size];
	}
	
	/**
	 * Constructor that hold two parameter
	 * @param size of the hash table you want and testing String
	 */
	public CourseDBStructure(String test, int size) {
		this.size = size;
		hashTable = new LinkedList[size];
	}
	
	/**
	 * Add the element to the linked list, use the hash code.
	 */
	@Override
	public void add(CourseDBElement element) {
		
		//get the hash code
		int hashIndex = element.hashCode();
		
		//add to the linked list
		if(hashTable[hashIndex%size] == null) {
			LinkedList<CourseDBElement> link = new LinkedList<>();
			hashTable[hashIndex%size] = link;
			link.add(element);
		}
				
		//if there is no same element in the table
		else if(!hashTable[hashIndex%size].contains(element)){
			hashTable[hashIndex].add(element);
		}

	}

	/**
	 * get the element base on CRN
	 * @return element
	 */
	@Override
	public CourseDBElement get(int crn) throws IOException {
		
		//get the hash code
		int hashIndex = String.valueOf(crn).hashCode();
		
		
		if(hashTable[hashIndex%size] == null) {
			throw new IOException();
		}
		
		for (int i = 0; i < hashTable[hashIndex%size].size(); i++) {
			if(hashTable[hashIndex%size].get(i).getCRN() == crn)
				return hashTable[hashIndex%size].get(i);
		}
		
		throw new IOException();
	}

	/**
	 * get the size of the hash table
	 * @return number of the size
	 */
	@Override
	public int getTableSize() {
	
		return size;
	}
	
	
}
