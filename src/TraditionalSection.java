
public class TraditionalSection extends Section {

	/*
	 * when do i initialize the time1 and time 2 fields?
	 */
	
//	Timeslot[] times = new Timeslot[2];
	Timeslot time1;
	Timeslot time2;
	
	public TraditionalSection(Course course, Instructor inst, int c, Timeslot t1, Timeslot t2) {
		super(course, inst, c);
		time1 = t1;
		time2 = t2;
	}
	
	public String getSchedule() {
		return time1.formattedTimes() + " " + time2.formattedTimes();
	}
}
