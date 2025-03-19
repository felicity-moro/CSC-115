public class StudentLinkedList implements StudentList {

	StudentNode head;
	int count;

	public StudentLinkedList() {
		head = null;
		count = 0;
	}

	public void add(Student s) {

		StudentNode node = new StudentNode(s);
		if (head == null){
			head = node;
			count++;
			return;
		}
		StudentNode cur = head;
		while (cur.getNext() != null){
			cur = cur.getNext();
		}
		cur.next = node;
		count++;
	}

	public int size() {
		return count;
	}

	public void removeFront() {
		if (count == 0){
			return;
		}
		if (head.next == null){
			head = null;
			count--;
			return;
		}
		head = head.getNext();
		count--;
		return;
	}

	public boolean contains(Student s) {

		if (count == 0){
			return false;
		}
		StudentNode cur = head;

		while (cur != null){
			if (cur.getData().equals(s)){
				return true;
			}
			cur = cur.getNext();
		}

		return false;
	}
	
	/*
	 * Purpose: returns a String reprensentation of elements
	 *      in this list separated by newlines
	 * Parameters: none
	 * Returns: String - the representation
	 */
	public String toString() {
		// DO NOT CHANGE THIS METHOD - it is correct
		// Changing it will result in your code getting
		// a score of 0 from the autograder for this lab
		
		String s = "";
		StudentNode tmp = head;

		while(tmp != null) {
			s  += tmp.getData() + "\n";
			tmp = tmp.next;
		}

		return s;
	}
}
