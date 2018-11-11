/**
 * Basically an ArrayList of Courses
 * @author Fowad Sohail
 * @version 10/29/18
 */
import java.util.ArrayList;

public class Catalog {
	private ArrayList<Course> courses;
	
	public Catalog() {
		courses = new ArrayList<>();
	}
	/**
	 * Add a course to the courses field
	 * @param course The course to add
	 */
	public void addCourse(Course course) {
		courses.add(course);
	}
	
	public ArrayList<Course> getCourses(){
		return this.courses;
	}
	
	
}
