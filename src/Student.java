import java.util.HashMap;

/**
 * A subclass of Person, with its own field String major
 * @author Fowad Sohail
 * @version 9/28/2018
 */


public class Student extends Person {
	
	private String major;
	private HashMap<Integer, Section> currentSections;	//key-CRN #		value-Section object
	
	/**
	 * Creates a Student object with the given parameters and calls its superclass constructor.
	 * @param firstName Used in superclass constructor
	 * @param middleName Used in superclass constructor
	 * @param lastName Used in superclass constructor
	 * @param email Used in superclass constructor
	 * @param ssn Used in superclass constructor
	 * @param age Used in superclass constructor
	 * @param m The major field
	 */
	public Student(String firstName, String middleName, String lastName, String email, String ssn, int age, String m) {
		super(firstName, middleName, lastName, email, ssn, age);
		this.major = m;
	}

	public Student(int i, String lastName) {
		super(i, lastName);
	}

	public String getMajor() {
		return this.major;
	}
	
	public void setMajor(String newM) {
		this.major = newM;
	}
	
	/**
	 * Adds a Section object to the currentSections collection
	 * @param sec Section object
	 */
	public void add(Section sec) {
		currentSections.put(sec.getCRN(), sec);
	}
	
/**
 * Removes a Section object to the currentSections collection
 * @param sec Section object
 */
	public void drop(Section sec) {
		currentSections.remove(sec);
	}
}
