public class QueueRefBased implements Queue {

	private QueueNode front;
	private QueueNode back;
	// no numElements for this implementation

	public QueueRefBased() {
		front = null;
		back = null;
	}

	public int size() {
		int count = 1;

		if (front == null){
			return 0;
		}

		QueueNode cur = front;

		while (cur.next != null){
			count++;
			cur = cur.next;
		}
		return count;			
	}

	public boolean isEmpty() {
		if (size() == 0){
			return true;
		}else{
		return false;
		}
	}

	public void enqueue (int value) {
		QueueNode node = new QueueNode(value);

		if (isEmpty()){
			front = node;
			back = node;
			return;
		}
		back.next = node;
		back = node;
	}

	public int dequeue() {
		if (isEmpty()){
			return 0;
		}
		int value = front.getValue();
		front = front.next;
		return value;
	}

	public int peek() {
		return front.getValue();
	}

	public void makeEmpty() {
		front = null;
		back = null;
	}
}
