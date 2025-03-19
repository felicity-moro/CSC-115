// Name: Felicity Moro
// Student number: v01045357

public class A3LinkedList implements A3List {
	private A3Node head;
	private A3Node tail;
	private int length;
	
	public A3LinkedList() {
		head = null;
		tail = null;
		length = 0;
	}
	 
	public void addFront(String s) {

		A3Node node = new A3Node(s);
		if (length == 0){
			tail = node;
		}
		if (length != 0){
			head.prev = node;
			node.next = head;
		}
		head = node;
		length++;
	}

	public void addBack(String s) {

		A3Node node = new A3Node(s);
		if (length == 0){
			head = node;
		}
		if (length != 0){
			tail.next = node;
			node.prev = tail;
		}
		tail = node;
		length++;
	}
	
	public int size() {
		return length;
	}
	
	public boolean isEmpty() {
		return length==0;
	}
	
	public void removeFront() {
		if (length == 0){
			return;
		}
		head.next.prev = null;
		head = head.next;
		length--;
	}
	
	public void removeBack() {
		if (length == 0){
			return;
		}
		tail.prev.next = null;
		tail = tail.prev;
		length--;
	}
	
	
	
	//////////////////
	/* PART 2 BELOW */
	//////////////////
	
	public void removeMiddle() {

		if ((length == 0)){
			return;
		}

		if (length%2 != 0){
			double position = (length/2) + 0.5;
			A3Node cur = head;

			if (length == 1){
				head = null;
				tail = null;
				length = 0;
				return;
			}

			for (int i = 1; i < position; i++){
				cur = cur.next;
			}

			cur.prev.next = cur.next;
			cur.next.prev = cur.prev;
			length--;

		} else {

			float position = length/2;
			A3Node cur = head;

			if (length == 2){
				head = null;
				tail = null;
				length = 0;
				return;
			}

			for (int i = 1; i < position; i++){
				cur = cur.next;
			}
			cur.prev.next = cur.next.next;
			cur.next.next.prev = cur.prev;
			length -= 2;
		}
	}
	
	
	public void interleave(A3LinkedList other) {
		
		A3Node cur1 = head;
		A3Node cur2 = other.head;

		if (length == 0){
			return;
		}

		while (cur1 != null){
			int i = 1;
			A3Node holder = null;

			if (((i%2 != 0)) && (cur1.next != null)){

				if (cur1.next.next != null){
					
					cur1.next.next.prev= cur2.next;

					cur2.next.next.prev = cur1.next;
				}
				
				
				holder = cur1.next;
				cur1.next = cur2.next;
				cur1.next.prev = cur1;

				cur2.next = holder;
				cur2.next.prev = holder.prev;

				cur1.next.prev = cur1;
				cur2.next.prev = cur2;

			}

			cur1 = cur1.next;
			cur2 = cur2.next;
			i++;
		}

	}
	
	
	////////////////////////////////////////
	/* METHODS BELOW TO HELP WITH TESTING */
	////////////////////////////////////////
	
	/*
	 * Purpose: return a string representation of the list 
	 *          when traversed from front to back
	 * Parameters: none
	 * Returns: nothing
	 *
	 * USED TO HELP YOU WITH DEBUGGING
	 * DO NOT CHANGE THIS METHOD
	 */
	public String frontToBack() {
		String result = "{";
		A3Node cur = head;
		while (cur != null) {
			result += cur.getData();
			cur = cur.next;
		}
		result += "}";
		return result;
	}
	
	/*
	 * Purpose: return a string representation of the list 
	 *          when traversed from back to front
	 * Parameters: none
	 * Returns: nothing
	 *
	 * USED TO HELP YOU WITH DEBUGGING
	 * DO NOT CHANGE THIS METHOD
	 */
	public String backToFront() {
		String result = "{";
		A3Node cur = tail;
		while (cur != null) {
			result += cur.getData();
			cur = cur.prev;
		}
		result += "}";
		return result;
	}
}
	