/**
 * Section of a specific course with a specific Instructor
 * @author Fowad Sohail
 * @version 10/29/18
 */
import java.util.Random;

public abstract class Section {

	
	private int CRN;
	private Course course;
	private Instructor instructor;
	

	public Section(Course course, Instructor inst, int c) {
		Random rand = new Random();
		//maybe write this so it increments rather than random
		CRN = c;
		this.course = course;
		this.instructor = inst;
	}

	public int getCRN() {
		return this.CRN;
	}
	
	public Course getCourse() {
		return this.course;
	}
	
	public Instructor getInstructor() {
		return this.instructor;
	}
	
	public abstract String getSchedule();
}
