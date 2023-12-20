import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CourseDBManager implements CourseDBManagerInterface{

	CourseDBStructure DBS;
	
	public CourseDBManager() {
		DBS  = new CourseDBStructure(50);
	}
	
	/**
	 * create and add the information into data
	 */
	@Override
	public void add(String id, int crn, int credits, String roomNum, String instructor) {


		CourseDBElement data = new CourseDBElement(id, crn, credits, roomNum, instructor);
		
		DBS.add(data);
	}

	/**
	 * use the course CRN to find the data
	 * @return The data base on CRN
	 */
	@Override
	public CourseDBElement get(int crn) {
		try {
			CourseDBElement data = DBS.get(crn);
			return data;
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * Read and store the course information from file to array
	 */
	@Override
	public void readFile(File input) throws FileNotFoundException {
		
		// if the file is not exist, throw the exception
		 if(!input.exists())
			 throw new FileNotFoundException();
	     Scanner read = new Scanner(input);
	     
	     //while loop, read all line in the file
	     while(read.hasNextLine()) {
	    	 
	    	 String data = read.nextLine();
	    	 String[] str = data.split(" ");
	    	 
	    	 CourseDBElement e = new CourseDBElement();
	    	 e.setID(str[0]);
	    	 e.setCRN(Integer.parseInt(str[1]));
	    	 e.setCredits(Integer.parseInt(str[2]));
	    	 if(str[4].equals("Learning")) {
	    		e.setRoom("Distance Learning");
	    		
	    		String a = "";
	    		for(int i = 5; i < str.length; i++) 
	    			a += str[i];
	    		e.setName(a); 
	    	 }
	    	 else {
	    		e.setRoom(str[3]);
	    	 	String a = "";
	    		for(int i = 4; i < str.length; i++) 
	    			a += str[i];
	    		e.setName(a); 
	    	 }
	    	 
	    	 DBS.add(e);
	     }
	     read.close();
	}

	/**
	 * Store all element from linked List to Array List
	 * @return An array list that store all information
	 */
	@Override
	public ArrayList<String> showAll() {
		ArrayList<String> array = new ArrayList<>();
		
		//read each linked list from the table
		for(int i = 0; i < DBS.size; i++) {
			if (DBS.hashTable[i] == null)
				continue;
			else {
				//read each element from the linked list
				for(int j = 0; j < DBS.hashTable[i].size(); j++) {
					array.add(DBS.hashTable[i].get(j).toString());
				}
			}
		}
		return array;
	}

}
