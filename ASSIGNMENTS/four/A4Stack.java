public class A4Stack<T> implements Stack<T> {
	
	private A4Node<T> head;
	// Do NOT add any other fields to this class.
	// You should be able to implement the Stack 
	// interface with just a head field.

	public A4Stack() {
		head = null;
	}
	
	public void push(T value) {

		A4Node<T> n = new A4Node<T>(value);

		if (!isEmpty()){
			n.setNext(head);
		}
		head = n;
	}
	
	public T pop() {
		if (isEmpty()){
			return null;
		}
		T result = head.getData();
		head = head.next;
		return result;
	}
	
	public void popAll() {
		if (isEmpty()){
			return;
		}else{
			pop();
			popAll();
		}
	}
	
	public boolean isEmpty() {
		if (head == null){
			return true;
		}
		return false;
	}
	
	public T peek() {
		if (isEmpty()){
			return null;
		}
		T result = head.getData();
		return result;
	}
	
	// Implemented for you for debugging purposes
	public String toString() {
		String result = "{";
		String separator = "";
		
		A4Node<T> cur = head;
		while (cur != null) {
			result += separator + cur.getData().toString();
			separator = ", ";
			cur = cur.next;
		}
	
		result += "}";
		return result;
	}
}