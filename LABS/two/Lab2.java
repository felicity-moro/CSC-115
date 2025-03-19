/*
 * Lab2.java
 *
 * A class of static methods that operate on Students
 *
 */
public class Lab2 {
    
	/*
	 * Purpose: determines which student has the higher grade
	 * Parameters: Student - s1, Student - s2
	 * Returns: Student - the Student with the higher grade,
	 *                    s1 if they have the same grade
	 * Precondition: s1 and s2 are not null
	 */
	public static Student getHigherGradeStudent(Student s1, Student s2) {
		
		if (s1.getGrade() >= s2.getGrade()){
			return s1;
		}

		return s2; 
	}


	/*
	 * Purpose: determines whether the grade of Student s
	 *          is above the threshold
	 * Parameters: Student - s, int - threshold
	 * Returns: boolean - true if grade is above threshold, false otherwise
	 * Preconditions: s is not null
	 */
	// TODO: implement isGradeAbove
	public static boolean isGradeAbove(Student s, int threshold){

		if (s.getGrade() > threshold){
			return true;
		}
		return false;
	}



	/*
	 * Purpose: creates an array sIDs of all Students in students
	 * Parameters: Student[] - students
	 * Returns: String[] - array of sIDs
	 * Preconditions: students is not null and contains no null elements
	 */
	// TODO: implement getClasslist

	public static String[] getClasslist(Student[] group){

		String[] SIDgroup = new String[group.length];

		for (int i = 0 ; i < group.length; i++){

			SIDgroup[i] = group[i].getSID();

		}

		return SIDgroup;
	}


	/*
	 * Purpose: counts the number of Students in students
	 *          with grade above threshold
	 * Parameters: Student[] - students, int - threshold
	 * Returns: int - the number of students with a grade above threshold
	 * Preconditions: students is not null and contains no null elements
	 */
	// TODO: implement countAbove
	// HINT: you should be using the isGradeAbove method!

	public static int countAbove(Student[] s, int threshold){

		int counter = 0;
		for (int i = 0; i < s.length; i++){
			if (isGradeAbove(s[i],threshold)==true){
			counter++;
			}
		}
		return counter;
	}


	/*
	 * Purpose: calculates the average grade of Students in students,
	 *          does NOT include students with -1 grade in calculation
	 *          average is 0.0 if students is empty or all students have -1 grade
	 * Parameters: Student[] - students
	 * Returns: double - the average grade
	 * Preconditions: students is not null and contains no null elements
	 */
	// TODO: implement getClassAverage
	// HINT: you can use the isGradeAbove method again

	public static double getClassAverage(Student[] s){

		int count = s.length;
		double average = 0.0;
		if (s.length == 0){
			return average;
		}

		for (int i = 0; i < s.length; i++){
			if (isGradeAbove(s[i],-1) == true){
				average += s[i].getGrade();
			} else {
				count--;
			}
		}

		average /= count;
		return average;

	}


	/*
	 * Purpose: creates a new array 1 longer than students
	 *          and adds all students and s to the new array
	 * Parameters: Student[] - students, Student s
	 * Returns: Student[] - the new array
	 * Preconditions: students is not null and contains no null elements
	 *                Student s is not already contained within students
	 */
	// TODO: implement registerStudent
	public static Student[] registerStudent(Student[] original, Student s){

		Student[] updated = new Student[original.length + 1];
		
		for (int i = 0; i < original.length; i++){
			updated[i] = original[i];

		}

		updated[original.length] = s;
		return updated;
	}

}
