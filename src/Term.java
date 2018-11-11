/**
 * Basically an ArrayList of Sections and a String field for the actual term
 * @author Fowad Sohail
 * @version 10/29/31
 */
import java.util.ArrayList;

public class Term {

	private ArrayList<Section> sections;
	private String termName;
	
	public Term(String termName) {
		this.termName = termName;
		sections = new ArrayList<>();
	}
	
	/**
	 * Add a section to the sections ArrayList
	 * @param sec The section to add
	 */
	public void addSection(Section sec) {
		sections.add(sec);
	}
	
	public ArrayList<Section> getSections(){
		return this.sections;
	}
}
