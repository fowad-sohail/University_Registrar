import java.time.DayOfWeek;
import java.time.LocalTime;

public class Timeslot {
	private DayOfWeek weekday;
	private LocalTime startTime;
	private LocalTime endTime;
	
	public Timeslot(DayOfWeek weekday, LocalTime start, LocalTime end) {
		this.weekday = weekday;
		this.startTime = start;
		this.endTime = end;
	}
	
	public String formattedTimes() {
		return weekday.name() + ": " + startTime.toString() + "-"+ endTime.toString();
	}
}
