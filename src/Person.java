/**
 * A person class for a university with relevant fields
 * @author Fowad Sohail
 * @version 9/27/2018
 *
 */


public class Person {
	static int OLDESTAGE = 0;
	
	
	
	private int id;
	private String firstName;
	private String middleName;
	private String lastName;
	private String email;
	private String ssn;
	private int age;
	private int numPeople = 0;
	
	/**
	 * Create a Person object and initalize all fields according to the given parameters.
	 * @param firstName Assigned to the firstName field
	 * @param middleName Assigned to the middleName field
	 * @param lastName Assigned to the lastName field
	 * @param email Assigned to the email field
	 * @param ssn Assigned to the ssn field
	 * @param age Assigned to the age field
	 */
	public Person(String firstName, String middleName, String lastName, String email, String ssn, int age) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.email = email;
		this.ssn = ssn;
		this.age = age;
		this.id = 1 + numPeople;
		if(age > OLDESTAGE) {
			OLDESTAGE = age;
		}
	}
	
	public Person(int id, String lastname) {
		this.id = id;
		this.lastName = lastname;
	}
	
	/**
	 * Checks if the age is greater than 16
	 * @return true if age > 16, false otherwise
	 * @param userAge The given age entered by the user
	 */
	public static boolean ageIsValid(int userAge) {
		if(userAge > 16) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Checks if the email passes several validation checks. 
	 * The validation checks are: 
	 *  	String must contain a '@' and at least one '.'
	 *  	A '.' must follow the '@'
	 *  	String must only contain one '@'
	 * @return true if the email is valid, false if the email fails any of the validation checks
	 * @param userEmail The given email provided by the user
	 */
	public static boolean emailIsValid(String userEmail) {
		int numAts = 0; //the number of @s in the email
		
		if(userEmail.contains("@")) {	//if it contains an @, check how many there are
			char[] emailArray = userEmail.toCharArray();
			for(Character c : emailArray) {
				if(c.equals('@')) {
					numAts = numAts++;
				}
			}
		}
		
		else {	//if email doesn't contain @, its invalid
			return false;
		}
		
		if(numAts > 1) {	//if more than one @, email is invalid
			return false;
		}
			
		String domain = getEmailDomain(userEmail);
		if(! domain.contains(".") || domain.startsWith(".") || domain.equals(null)) {
			return false;
		}
		
		return true;
	}
	
	/**
	 * Checks if the ssn is valid according to several validation checks.
	 * The validation checks are:
	 * 		String must contain two '-' characters in the correct position
	 * 		The length of the string must be 11
	 * 		String must contain only digits or numbers.
	 * @return true if the ssn is valid, false if it fails any of the validation checks
	 * @param userSSN The given ssn provided by the user
	 */
	public static boolean ssnIsValid(String userSSN) {
		if(userSSN.length() != 11) {	//if its not of length 11, its invalid
			return false;
		}
		
		char[] ssnArray = userSSN.toCharArray();
		
		for(Character c : ssnArray) {
			if(Character.isLetter(c)) {	//if any of the characters are not digits or dashes, its invalid
				return false;			//meaning if any character is a letter, its invalid
			}
		}
		
		Character fourthChar = (Character) ssnArray[3];
		Character seventhChar = (Character) ssnArray[6];
		if(! fourthChar.equals('-') || ! seventhChar.equals('-')) {
			return false;
		}
		return true;
	}

	/**
	 * Returns the person's full name. ("Edgar Allen Poe")
	 * return firstName + " " + middleName + " " + lastName
	 */
	public String toString() {
		return firstName + " " + middleName + " " + lastName;
	}
	
	/**
	 * Returns the domain portion of the person's email. (The characters after @)
	 * @return domain[1] The portion of the email after the @
	 * @param userEmail The user defined email
	 */
	public static String getEmailDomain(String userEmail) {
		String[] domain;
		domain = userEmail.split("@");
		if(domain.length == 1)
			return null;
		return domain[1];
	}
	
	/**
	 * Returns the last 4 digits of the person's SSN number
	 * @return last 4 digits of ssn
	 * @param userSSN The user defined ssn
	 */
	public String getLast4SSN(String userSSN) {
		return userSSN.substring(userSSN.length() - 4, userSSN.length());
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	
	public String getMiddleName() {
		return this.middleName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setSSN(String ssn) {
		this.ssn = ssn;
	}
	
	public String getSSN() {
		return this.ssn;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getAge() {
		return this.age;
	}
}
