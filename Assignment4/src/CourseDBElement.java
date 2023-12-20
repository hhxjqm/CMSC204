
public class CourseDBElement implements Comparable{

	String ID, room, name;
	int CRN, credits;
	
	// default constructor
	public CourseDBElement() {
		ID = "";
		room = "";
		name = "";
		CRN = 0;
		credits = 0;
	}
	
	public CourseDBElement(String ID, int CRN, int credits, String room, String name) {
		this.ID = ID;
		this.CRN = CRN;
		this.credits = credits;
		this.room = room;
		this.name = name;
	}
	
	// getters and setters
	
	/**
	 * getter of course ID
	 * @return course ID
	 */
	public String getID() {
		return ID;
	}

	/**
	 * getter of room number
	 * @return room number
	 */
	public String getRoom() {
		return room;
	}

	/**
	 * getter of instructor's name
	 * @return instructor's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * getter of course CRN
	 * @return CRN
	 */
	public int getCRN() {
		return CRN;
	}

	/**
	 * getter of number of credit
	 * @return number of credit
	 */
	public int getCredits() {
		return credits;
	}

	/**
	 * define the hash code of the element
	 * @return hash code of this element
	 */
	public int hashCode(){
		return String.valueOf(CRN).hashCode();
	}
	
	/**
	 * setter of the course CRN
	 * @param CRN
	 */
	public void setCRN(int CRN){
		this.CRN = CRN;
	}
	
	/**
	 * setter of course id
	 * @param iD
	 */
	public void setID(String iD) {
		ID = iD;
	}

	/**
	 * setter of room number
	 * @param room
	 */
	public void setRoom(String room) {
		this.room = room;
	}

	/**
	 * setter of instructor's name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * setter of number of credits
	 * @param credits
	 */
	public void setCredits(int credits) {
		this.credits = credits;
	}

	/**
	 * Override the compare to method
	 * @return the result of compare
	 */
	@Override
	public int compareTo(CourseDBElement num) {
		if(CRN > num.CRN)
			return 1;
		else if(CRN < num.CRN)
			return -1;
		else
			return 0;
	}
	
	/**
	 * show the message of the element
	 * @return the information of this element
	 */
	public String toString() {
		String str = "";
		str = "\nCourse:" + ID + " CRN:" + CRN + " Credits:" + credits + " Instructor:" + name + " Room:" + room;
		return str;
	}
}
