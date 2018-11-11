import java.util.ArrayList;

/**
 * A subclass of Person, with a unique field String department
 * @author Fowad Sohail
 * @version 9/29/2018
 */


public class Instructor extends Person {

	private String department;
	private ArrayList<Timeslot> teachingTimes = new ArrayList<>();;
		
	/**
	 * Creates an Instructor object with the given parameters and calls its superclass constructor.
	 * @param firstName Used in superclass constructor
	 * @param middleName Used in superclass constructor
	 * @param lastName Used in superclass constructor
	 * @param email Used in superclass constructor
	 * @param ssn Used in superclass constructor
	 * @param age Used in superclass constructor
	 * @param d The department field
	 */
	public Instructor(String firstName, String middleName, String lastName, String email, String ssn, int age, String d) {
		super(firstName, middleName, lastName, email, ssn, age);
		department = d;
		
	}
	
	public Instructor(int i, String lastName) {
		super(i, lastName);
	}

	public String getDepartment() {
		 return this.department;
	 }
	
	public void setDepartment(String newD) {
		this.department = newD;
	}
	
	public void addTeachingTimes(Timeslot e) {
		teachingTimes.add(e);
	}
	
	public ArrayList<Timeslot> getTeachingTimes()	{
		return this.teachingTimes;
	}
}

 