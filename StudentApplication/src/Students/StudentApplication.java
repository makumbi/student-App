package Students;

// Required Java Classes
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.Map.*;
import javax.swing.*;

public class StudentApplication extends JFrame {
	
	// Create JTextField
	
	
	private JTextField studentIdTxt = new JTextField();
	private JTextField studentNameTxt = new JTextField();
	private JTextField studentMajorTxt = new JTextField();
	// Create ComboBox
	private static JComboBox<String> selection = new JComboBox<String>();
	private static JComboBox<String> grade = new JComboBox<String>();
	private static JComboBox<String> credits = new JComboBox<String>();
	// Create JButton
	JButton procesRequest = new JButton("Process Request");
	// Declare Map
	Map<Integer, String> student = new HashMap<Integer, String>(); //Use a Map<Integer, List(with 2 strings)>
	Map<Integer, Student> allStudents = new  HashMap<Integer, Student>();
	// StudentApplication Constructor
	public StudentApplication(){
		dropItems();
		panel();
		listeners();
	} // End StudentApplication Constructor
	
	// Main Method
	public static void main(String[] args){
		// Create and Display Application GUI
		StudentApplication studentGUI = new StudentApplication();
		studentGUI.pack();
		studentGUI.setTitle("Project 4");
		studentGUI.setSize(300, 300);
		studentGUI.setLocationRelativeTo(null);
		studentGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		studentGUI.setVisible(true);
		
	} // End Main Method
	
	// Panel Method
	private void panel(){
		// Create panel to hold components
		JPanel componentsPanel = new JPanel();
		componentsPanel.setLayout(new GridLayout(9, 2)); // Nine rows, two columns
		componentsPanel.add(new JLabel("Id: "));
		componentsPanel.add(studentIdTxt, BorderLayout.EAST);
		componentsPanel.add(Box.createHorizontalStrut(5));
		componentsPanel.add(Box.createHorizontalStrut(5));
		componentsPanel.add(new JLabel("Name: "));
		componentsPanel.add(studentNameTxt, BorderLayout.EAST);
		componentsPanel.add(Box.createHorizontalStrut(5));
		componentsPanel.add(Box.createHorizontalStrut(5));
		componentsPanel.add(new JLabel("Major: "));
		componentsPanel.add(studentMajorTxt, BorderLayout.EAST);
		componentsPanel.add(Box.createHorizontalStrut(5));
		componentsPanel.add(Box.createHorizontalStrut(5));
		componentsPanel.add(new JLabel("Choose Selection: "));
		componentsPanel.add(selection, BorderLayout.EAST);
		componentsPanel.add(Box.createHorizontalStrut(5));
		componentsPanel.add(Box.createHorizontalStrut(5));
		componentsPanel.add(procesRequest, BorderLayout.WEST);
		componentsPanel.add(Box.createHorizontalStrut(5));
		add(componentsPanel, BorderLayout.NORTH);
	} // End PanelHoldNorth method
	
	// Items in ComboBox
	private void dropItems(){
		selection.addItem("Insert"); 
		selection.addItem("Delete");
		selection.addItem("Find");
		selection.addItem("Update");
	}// End dropItems Method
	
	// Items in ComboBox Grade
	private void gradeItems(){
		grade.addItem("A");
		grade.addItem("B");
		grade.addItem("C");
		grade.addItem("D");
		grade.addItem("F");
	}
	
	// Items in ComboxBox Credits
	private void creditsItems(){
		credits.addItem("3");
		credits.addItem("6");
	}
	// Listener Method	
	private void listeners(){
		// Place ActionListener on JButton
		

	//	selection.addItemListener(new ItemListener(){
			//public void itemStateChanged(ItemEvent itemEvent){		
	procesRequest.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent actionEvent){
			
			String f =	(String) selection.getSelectedItem();
			
					if(f.charAt(0) == 'I'){
						insertStudentName();
					}
					else if(f.charAt(0) == 'D'){
						deleteStudent();
					}
					else if(f.charAt(0) == 'F'){
						findStudent();
					}
					else if(f.charAt(0) == 'U'){
						updateStudentGPA();
					}
				
					
					} // End ItemStateChanged Method
	        });	
			 // End ActionPerformed Method
		// End AddActionListener Method
	} // End Listener Method
	
	// insertStudentName Method
	private void insertStudentName(){ 
		System.out.println("insert Student name function run");
		// Checks whether Student Id Exists 
		if(!(student.containsKey(getIdTxt()))){
				student.put(getIdTxt(), getNameTxt());
				Student s = new Student(getNameTxt(), getMajorTxt());
				allStudents.put(getIdTxt(), s);
				// Displaying User Input
				JOptionPane.showMessageDialog(null, "Thank for your input!\n" + "Student Key: "
						+ getIdTxt() + "\nStudent Name: " + getNameTxt() + "\nStudent Major: " + getMajorTxt());
		}else{
			JOptionPane.showMessageDialog(null, "Student Key Already Exists");
		} // End If-Else Statement
	} // End insertStudentName Method
	
	
	// deleteStudent Method
	private void deleteStudent(){
		System.out.println("ur inside delete student bro");
		String studentKey = JOptionPane.showInputDialog("Please verify student ID");
		int value = Integer.parseInt(studentKey);
		
		if(student.containsKey(value)){
			JOptionPane.showMessageDialog(null, allStudents.get(value).toString() + "\nHas been deleted");
			student.remove(value);
			allStudents.remove(value);
		}
		else{
			JOptionPane.showMessageDialog(null, "Student does not exist");
		}

		
	} // End DeleteStudent Method
	
	
	private int findHelper(String n, Map<Integer, String> s){
		System.out.println("Helper was run");
		//ArrayList<Integer> ids = new ArrayList<Integer>();
		int nameFound = 0;
		Iterator<Entry<Integer, String>> itr = s.entrySet().iterator();
		while(itr.hasNext()){
			int loopN = itr.next().getKey();
			
			if( student.get(loopN).equals(n)){
				nameFound =  loopN;
			}
		}
		return nameFound;
		
	}

	// findStudent Method
	private void findStudent(){  
		System.out.println("ur inside find student now bro");
		String name = JOptionPane.showInputDialog("Name: ");
		if(student.containsValue(name)){
			int nameKey = findHelper(name, student);
			//ArrayList<Integer> nameIds = findHelper(name, student);
			JOptionPane.showMessageDialog(null, "Here is the " + allStudents.get(nameKey).toString());
			
		//for(int x=0; x < nameIds.size(); x++){
		/*int result = JOptionPane.showConfirmDialog(null, "Is it this student:" + "\nStudent Key: "
		+ nameIds.get(x) + "\nStudent Name: " + student.get(nameIds.get(x)) );
			if  */
		
			
		} 
		
		/*for(Iterator<String> itr = student.values().iterator();;){
			while(itr.hasNext()){
				if(itr.next().contains(name)){
					JOptionPane.showMessageDialog(null, "Found Entry! \n" + "Student's Name: " + name);
							
				}else{
				JOptionPane.showMessageDialog(null, "Name does not exist");	
				} // End If-Else Statement
			} // End While Statement
		} // End For-Else Statement*/
	} // End findStudent Method
	
	private void updateStudentGPA(){
		String valueKey = JOptionPane.showInputDialog("Enter Student Key");
		int studentKey = Integer.parseInt(valueKey);
		
		 final String[] gradesPossible = { "A", "B", "C", "D", "F" };
		 
		 String gradeS = (String) JOptionPane.showInputDialog(null, 
		        "What is the student's grade?",
		        "Student Grade",
		        JOptionPane.QUESTION_MESSAGE, 
		        null, 
		        gradesPossible, 
		        gradesPossible[0]);
		 
		 final String[] creditsPossible = { "3", "6"};
		 
		 String creditS = (String) JOptionPane.showInputDialog(null, 
		        "How many credits was the class?",
		        "Credit Hours",
		        JOptionPane.QUESTION_MESSAGE, 
		        null, 
		        creditsPossible, 
		        creditsPossible[0]);
		 
		 JOptionPane.showMessageDialog(null, student.get(studentKey) + "'s GPA has been updated!");
		 
		 int grade = 0;
		 
		 if (gradeS.equals("A")){
			 grade = 4;
		 }
		 else if (gradeS.equals("B")){
			 grade = 3;
		 }
		 else if (gradeS.equals("C")){
			 grade = 2;
		 }
		 else if (gradeS.equals("D")){
			 grade = 1;
		 }
		 else if (gradeS.equals("F")){
			 grade = 0;
		 }
		 
		 int credit = Integer.parseInt(creditS);
		 
		 allStudents.get(studentKey).courseCompleted(grade, credit);
		 System.out.println(allStudents.get(studentKey).toString());
 
		
	} // End updateStudentGPA Method


	private Integer getIdTxt(){
		Integer value = null;
		try{
			value = Integer.parseInt(studentIdTxt.getText());
		}catch (NullPointerException e){
			JOptionPane.showMessageDialog(null, "Please Enter Student ID");
		}catch (NumberFormatException err){
			JOptionPane.showMessageDialog(null, "Enter Integer Value into Student ID");
		} // End Try-Catch Method
		return value;
	} // End getIdTxt Method
	// getNameTxt Method
	private String getNameTxt(){
		String value = " ";
		try{
			value = studentNameTxt.getText();
		}catch (NullPointerException e){
			JOptionPane.showMessageDialog(null, "Please Enter Student Name");
		}catch (NumberFormatException err){
			JOptionPane.showMessageDialog(null, "Enter String Value into Student Name");
		} // End Try-Catch Method
		return value;
	} // End getNameTxt Method
	// getMajorTxt method
	private String getMajorTxt(){
		String value = " ";
		try{
			value = studentMajorTxt.getText();
		}catch (NullPointerException e){
			JOptionPane.showMessageDialog(null, "Please Enter Student Major");
		}catch (NumberFormatException err){
			JOptionPane.showMessageDialog(null, "Enter String Value into Student Major");
		} // End getMajorTxt Method
		return value;
	} // End getMajorTxt Method

} // End StudentApplication Class
