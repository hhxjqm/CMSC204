/**
 * 
 * @author Huan Shiuan Huang
 *
 */
public class Road implements Comparable<Road>{

	Town source, destination;
	int degrees;
	String name;
	
	/**
	 * 0 if the road names are the same, a positive or negative number if the road names are not the same
	 */
	@Override
	public int compareTo(Road o) {
		return name.compareTo(o.name);
	}
	
	/**
	 * Constructor
	 * @param source - One town on the road
	 * @param destination - Another town on the road
	 * @param degrees - Weight of the edge, i.e., distance from one town to the other
	 * @param name - Name of the road
	 */
	public Road(Town source, Town destination, int degrees, String name) {
		this.source = source;
		this.destination = destination;
		this.degrees = degrees;
		this.name = name;
	}
	
	/**
	 * Constructor with weight preset at 1
	 * @param source - One town on the road
	 * @param destination - Another town on the road
	 * @param name - Name of the road
	 */
	public Road(Town source, Town destination, String name) {
		this.source = source;
		this.destination = destination;
		this.degrees = 1;
		this.name = name;
	}
	
	/**
	 * Returns true only if the edge contains the given town
	 * @param town - a vertex of the graph
	 * @return true only if the edge is connected to the given vertex
	 */
	public boolean contains(Town town) {
		if(source.getName().equals(town.getName()) || destination.getName().equals(town.getName()))
			return true;
		else
			return false;
	}
	
	/**
	 * Returns the road name
	 * @return The name of the road
	 */
	@Override
	public String toString() {
        return name + "," + degrees + ";" + source + ";" + destination;
	}

	/**
	 * Returns the road name
	 * @return The name of the road
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Returns the second town on the road
	 * @return A town on the road
	 */
	public Town getDestination() {
		return destination;
	}
	
	/**
	 * Returns the first town on the road
	 * @return A town on the road

	 */
	public Town getSource() {
		return source;
	}
	
	/**
	 * Returns the distance of the road
	 * @return the distance of the road
	 */
	public int getWeight() {
		return degrees;
	}
	
	/**
	 * Returns true if each of the ends of the road r is the same as the ends of this road. Remember that a road that goes from point A to point B is the same as a road that goes from point B to point A.
	 * @param r - road object to compare it to
	 */
	public boolean equals(Object r) {
		Road road = (Road) r;
		return (road.destination.equals(this.destination) 
                && road.source.equals(this.source)) || 
                (road.destination.equals(this.source) 
                && road.source.equals(this.destination));
	}
}
