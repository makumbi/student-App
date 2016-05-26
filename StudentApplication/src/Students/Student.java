package Students;

public class Student {
	private String name, major;
	private double gpa;
	private int totalCredits;
	private int totalPoints;

	
	// Student Constructor
	public Student(String name, String major){
		
		this.name = name;
		this.major = major;
		this.gpa = 4.0;
		
	} // End Student Constructor
	
	// courseCompleted Method
	public double courseCompleted(int grade, int creditHours){
		
		totalPoints += grade * creditHours;
		totalCredits += creditHours;
		gpa = (double) totalPoints / totalCredits;
		
		return gpa;
		
	} // End CourseCompleted Method
	
	// toString Method
	public String toString(){
		return "Student: " + name + "\n Major: " + major + "\n GPA: " 
				+ gpa;
	} // End toString Method 

}

