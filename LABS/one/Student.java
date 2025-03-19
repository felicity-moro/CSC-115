/*
* Student.java
* A Student class
*/

public class Student {

	private String sID;
	private int grade;

	public Student() {
		sID = "";
		grade = -1;
	}

	public Student(String newsID, int grade) {
		this.sID = newsID;
		this.grade = grade;
	}
	
	public String getSID() {
		return this.sID; 
	}
	
	public void setSID(String newsID){
		this.sID = newsID;
	}

	public void setGrade(int newGrade){
		this.grade = newGrade;
	}

	public int getGrade() {
		return this.grade; 
	}

	public String ToString(){
		String Result = sID + ":" + grade;
		return Result;
	}
	
}
