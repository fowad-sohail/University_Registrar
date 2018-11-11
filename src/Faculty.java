/**
 * Basically an ArrayList of Instructors
 * @author Fowad Sohail
 * @version 10/29/18
 */
import java.util.ArrayList;

public class Faculty {

	private ArrayList<Instructor> faculty;
	
	public Faculty() {
		faculty = new ArrayList<>();
	}
	
	/**
	 * add Instructor to faculty fields
	 * @param prof The added Instructor
	 */
	public void addInstructor(Instructor prof) {
		faculty.add(prof);
	}
	
	public ArrayList<Instructor> getInstructors() {
		return this.faculty;
	}
}
