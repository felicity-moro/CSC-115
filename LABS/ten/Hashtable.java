public class Hashtable{
    
private static final int TABLE_SZ = 7; // a prime number

	Student[] table;
	int count;  // number of Students in the table

	public Hashtable() {
		table = new Student[TABLE_SZ];
		count = 0;
	}



	/* MethodName: insertCollisions
	 * Purpose: insert (or update entry) s in this Hashtable with no collision handling strategy
	 * Parameters: Student - s
	 * Throws:  TableFullException - if inserting a new key into a full table
	 *          CollisionException - if inserting a new key into table at index that is full
	 * Returns: nothing
	 */
	public void insertCollisions(Student s) throws TableFullException, CollisionException{
		int code = (s.hashCode())%TABLE_SZ;

		if (count == TABLE_SZ){
			if (table[code].equals(s)){
				table[code] = s;
				return;
			}
			throw new TableFullException();
		}
		if (table[code] == null){
			table[code] = s;
			count++;
			return;
		}
		if (table[code].equals(s)){
			table[code] = s;
			return;
		}
		if (table[code] != null){
			throw new CollisionException();
		}
		
	}


	/* MethodName: getCollisions
	 * Purpose: find Student with sid in this Hashtable with no collision handling and returns their grade
	 * Parameters: String - sid
	 * Throws:  KeyNotFoundException  - if Student with sid is not found in table
	 * Returns: int - the grade of Student with sid
	 */
	public int getCollisions(String SID) throws KeyNotFoundException{
		int code = (SID.hashCode())%TABLE_SZ;

		if (table[code].getSID().compareTo(SID) < 0 || table[code].getSID().compareTo(SID) > 0){
			throw new KeyNotFoundException();
		}else{
			return table[code].getGrade();
		}
	}


	/* MethodName: insertLinearProbing
	 * Purpose: insert (or update entry) s in this Hashtable with Linear Probing to handle collisions
	 * Parameters: Student - s
	 * Throws: TableFullException  - if inserting a new key into a full table
	 * Returns: nothing
	 */
	public void insertLinearProbing(Student s) throws TableFullException{
		int code = (s.hashCode())%TABLE_SZ;
		
		if (table[code] != null){
			for(int i = 0; i < TABLE_SZ; i++){
				if (table[code] == null){
					table[code] = s;
					count++;
					return;
				}else if (table[code].equals(s)){
					table[code] = s;
					return;
				}else{
					code++;
					if (code == TABLE_SZ){
						code = 0;
					}
				}
			}
			throw new TableFullException();
		}else if (table[code] == null){
			table[code] = s;
			count++;
			return;
		}
		else if (table[code].equals(s)){
			table[code] = s;
			return;
		}
	}



	/* getLinearProbing
	 * Purpose: find Student with sid in this Hashtable that uses Linear Probing and returns their grade
	 * Parameters: String - sid
	 * Throws:  KeyNotFoundException  - if Student with sid is not found in table
	 * Returns: int - the grade of Student with sid
	 */
	public int getLinearProbing(String SID) throws KeyNotFoundException{
		int code = (SID.hashCode())%TABLE_SZ;

		if (table[code] == null){
			throw new KeyNotFoundException();
		}
		if (table[code].getSID().compareTo(SID) == 0){
			return table[code].getGrade();
		}
		if (table[code].getSID().compareTo(SID) < 0 || table[code].getSID().compareTo(SID) > 0){
			
			for (int i = 0; i < TABLE_SZ; i++){
				if (table[code] == null){
					throw new KeyNotFoundException();
				}
				if (table[code].getSID().compareTo(SID) == 0){
					return table[code].getGrade();
				}
				if (table[code].getSID().compareTo(SID) < 0 || table[code].getSID().compareTo(SID) > 0){
					code++;
					if (code == TABLE_SZ){
						code = 0;
					}
				}
			}

			throw new KeyNotFoundException();

		}else{
			return table[code].getGrade();
		}

	}

	/*
	 * Purpose: returns the number of elements in this Hashtable
	 * Parameters: none
	 * Returns: int - the number of elements
	 */
	public int size() {
		return count;
	}

	/*
	 * Purpose: returns a String reprensentation of elements
	 *      in this Hashtable separated by newlines
	 * Parameters: none
	 * Returns: String - the representation
	 */
	public String toString() {
		String s = "";

		for(int i=0; i<TABLE_SZ; i++) {
			if (table[i] != null) {
				s  += table[i] + "\n";
			}
		}
		
		return s;
	}
    

}
