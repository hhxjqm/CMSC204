import java.io.*;
import java.util.*;

/**
 * This interface imposes a total ordering on the objects of each 
 * class that implements it. This ordering is referred to as the 
 * class's natural ordering, and the class's compareTo method is 
 * referred to as its natural comparison method.
 * 
 * Lists (and arrays) of objects that implement this interface 
 * can be sorted automatically by Collections.sort (and Arrays.sort). 
 * 
 * @param element a CourseDBElement
 * @return a negative integer if x.compareTo(y) < 0, 
 *         zero if x.compareTo(y) == 0,
 * 	   and a positive integer if x.compareTo(y) > 0.
 */

public interface Comparable {

	int compareTo(CourseDBElement element);

}