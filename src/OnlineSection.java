import javax.swing.JOptionPane;

public class OnlineSection extends Section{
	
	public OnlineSection(Course course, Instructor instructor, int c) {
		super(course, instructor,c );
	}
	
	public boolean validateChoice() {
		 int answer = JOptionPane.showConfirmDialog (null, "Remote classes require online connectivity and good time management skills."
		 		+ "\n" + "Are you sure you want to register for this class?",  "Online registration verifcation", 0);
		 if(answer == 1) 
			 return false;
		 if(answer == 0)
			 return true;
		 else {
			 return false;
		 }
	}

	@Override
	public String getSchedule() {
		return "Online class";
	}
}
