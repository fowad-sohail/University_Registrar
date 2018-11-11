import javax.swing.JOptionPane;

public class HybridSection extends Section {

	
	Timeslot time;
	
	public HybridSection(Course course, Instructor inst, int c, Timeslot t) {
		super(course, inst, c);
		this.time = t;
	}
	
	public boolean validateChoice() {
		int answer = JOptionPane.showConfirmDialog (null, "Hybrid classes require online connectivity."
		 		+ "\n" + "Are you sure you want to register for this class?",  "Hybrid registration verifcation", 0);
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
		return time.formattedTimes();
	}

}
