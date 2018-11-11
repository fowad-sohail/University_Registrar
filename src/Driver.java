import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Random;

public class Driver {

	public static void main(String[] args) {

		// Build the objects needed to represent the registration process
		Catalog catalog = new Catalog();
		Term term = new Term("Fall 2018"); // change to the current term
		Faculty faculty = new Faculty();
		Student student = new Student(1, "Sohail"); // change to your last name

		// Populate these objects
		createInstructors(faculty); // Send the faculty object to method for instructor population
		createCourses(catalog); // Send the catalog object to method for course population

		int s = 40001;
		boolean check = false;
		Random rand = new Random();
		ArrayList<Timeslot> tempTimes = getTimeBlocks();
		// Populate the term with Section objects and give them random Instructors
		for (Course c : catalog.getCourses()) {
			/*check = false;*/
			Instructor i = faculty.getInstructors().get(rand.nextInt(faculty.getInstructors().size()));
			
			//while(!check){

		
			Timeslot q = tempTimes.get(rand.nextInt(tempTimes.size()));
			System.out.println(q.formattedTimes());
			//i.getTeachingTimes().add(q);
			tempTimes.remove(q);
			Timeslot q1 = tempTimes.get(rand.nextInt(tempTimes.size()));
			tempTimes.remove(q1);
			System.out.println(q1.formattedTimes());
			//i.getTeachingTimes().add(q1);
			Timeslot q2 = tempTimes.get(rand.nextInt(tempTimes.size()));
			//i.getTeachingTimes().add(q2);
			System.out.println(q2.formattedTimes());
			
			//for(Timeslot o : i.getTeachingTimes())	{
				
				//if(!(o.equals(q)) && !(o.equals(q1)) && !(o.equals(q2))) {
					term.addSection(new TraditionalSection(c, i, s, q, q1));
					s++;
					term.addSection(new HybridSection(c, i, s, q2));
					s++;
					term.addSection(new OnlineSection(c, i, s));
					s++;
					//check = true;
				//}	
				//}
					
			//}
			
		}
		
		
		RegistrarGUI gui = new RegistrarGUI(term.getSections(), student);

		try {
			Thread.sleep(100000000);
			System.exit(0);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private static void createInstructors(Faculty faculty) {
		faculty.addInstructor(new Instructor(101, "Johnson"));
		faculty.addInstructor(new Instructor(102, "Kay"));
		faculty.addInstructor(new Instructor(103, "Xu"));
		faculty.addInstructor(new Instructor(104, "Mulligan"));
		faculty.addInstructor(new Instructor(105, "Muldoon"));
		faculty.addInstructor(new Instructor(106, "Stanzione"));
		faculty.addInstructor(new Instructor(107, "Brady"));
		faculty.addInstructor(new Instructor(108, "Sawyer"));
		faculty.addInstructor(new Instructor(109, "Brown"));
		faculty.addInstructor(new Instructor(110, "Harrison"));
		faculty.addInstructor(new Instructor(111, "Ford"));
		faculty.addInstructor(new Instructor(112, "Danzinger"));
		faculty.addInstructor(new Instructor(113, "Clarke"));
		faculty.addInstructor(new Instructor(114, "Abraham"));
		faculty.addInstructor(new Instructor(115, "Perkowski"));
		faculty.addInstructor(new Instructor(116, "Brando"));
	}

	private static void createCourses(Catalog catalog) {
		catalog.addCourse(new Course("ART 01.101", "Art Appreciation", Department.Art));
		catalog.addCourse(new Course("ART 01.201", "Painting with Oils", Department.Art));
		catalog.addCourse(new Course("ART 01.202", "Painting with Water Colors", Department.Art));
		catalog.addCourse(new Course("BIOL 01.110", "Genetics", Department.Biology));
		catalog.addCourse(new Course("BIOL 04.301", "Anatomy and Physiology", Department.Biology));
		catalog.addCourse(new Course("CHEM 01.101", "Introduction to Chemistry", Department.Chemistry));
		catalog.addCourse(new Course("CHEM 01.201", "Organic Chemistry", Department.Chemistry));
		catalog.addCourse(new Course("CHEM 01.301", "Analytical Chemistry", Department.Chemistry));
		catalog.addCourse(new Course("CSC 04.114", "Object Oriented Programming", Department.Computer_Science));
		catalog.addCourse(new Course("CSC 04.301", "Human Computer Interaction", Department.Computer_Science));
		catalog.addCourse(new Course("CSC 07.211", "Artificial Intelligence", Department.Computer_Science));
		catalog.addCourse(new Course("CSC 04.370", "Software Engineering", Department.Computer_Science));
		catalog.addCourse(new Course("CSC 04.210", "Data Structures and Algorithms", Department.Computer_Science));
		catalog.addCourse(new Course("ECON 01.101", "Microeconomics", Department.Economics));
		catalog.addCourse(new Course("HIS 01.101", "Western Civilization", Department.History));
		catalog.addCourse(new Course("HIS 01.331", "Civil Wars", Department.History));
		catalog.addCourse(new Course("MUS 01.214", "The Genres of Rock Music", Department.Music));
		catalog.addCourse(new Course("PHIL 01.111", "Ethics", Department.Philosophy));
		catalog.addCourse(new Course("PHIL 01.221", "Existentialism", Department.Philosophy));
		catalog.addCourse(new Course("PHY 02.121", "Introduction to Mechanics", Department.Physics));
		catalog.addCourse(new Course("PSY 04.114", "Abnormal Psychology", Department.Psychology));
	}
	
	private static ArrayList<Timeslot> getTimeBlocks(){
		ArrayList<Timeslot> timeBlocks = new ArrayList<>();
		DayOfWeek[] dayOfWeeks = DayOfWeek.values();
		for (int j = 0; j < 5; j++) {
		    DayOfWeek dayOfWeek = dayOfWeeks[j];
		    for(int i = 8; i <= 18; i++) {
				//go through the times
				timeBlocks.add(new Timeslot(dayOfWeek, LocalTime.of(i, 0), LocalTime.of(i, 50)));
			}
		   }
		
//		for(DayOfWeek w : DayOfWeek.values()) {
//			for(int i = 8; i <= 18; i++) {
//				//go through the times
//				timeBlocks.add(new Timeslot(w, LocalTime.of(i, 0), LocalTime.of(i, 50)));
//			}
//		}
		return timeBlocks;
	}

}
