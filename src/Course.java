
public class Course {
	
	private String courseNumber;
	private String title;
	private Department department;
	
	public Course(String courseNumber, String title, Department dept) {
		this.courseNumber = courseNumber;
		this.title = title;
		this.department = dept;
	}
	
	public Department getDepartment() {
		return this.department;
	}

	public String getCourseNumber() {
		return courseNumber;
	}

	public void setCourseNumber(String courseNumber) {
		this.courseNumber = courseNumber;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
	
}
