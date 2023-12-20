import java.util.ArrayList;
import java.util.List;


/**
 * 
 * @author Huan Shiuan Huang
 *
 */
public class Town implements Comparable<Town>{

	String name;
	List<Town> adj = new ArrayList<>();
	
	/**
	 * Compare to method
	 * @return 0 if names are equal, a positive or negative number if the names are not equal
	 */
	@Override
	public int compareTo(Town o) {	
		return name.compareTo(o.name);
	}

	/**
	 * Constructor. Requires town's name.
	 * @param name - name of the town
	 */
	public Town(String name) {
		this.name = name;
	}
	
	/**
	 * Copy constructor.
	 * @param templateTown - an instance of Town
	 */
	public Town(Town templateTown) {
		this.name = templateTown.name;
	}
	
	/**
	 * Returns the town's name
	 * @return town's name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * To string method
	 * @return the town name
	 */
	public String toString() {
		return name;
	}
	
	/**
	 * @return the hashcode for the name of the town
	 */
	public int hashCode() {
		return name.hashCode();
	}
	
	/**
	 * @return true if the town names are equal, false if not
	 */
	@Override
	public boolean equals(Object obj) {
		Town town = (Town) obj;
		return name.equals(town.name);
	}
	 /**
	  * Add adj town to the list
	  * @param a Town
	  */
	public void addadj(Town a) {
		adj.add(a);
	}
}
