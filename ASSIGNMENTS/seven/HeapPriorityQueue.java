/*
* HeapPriorityQueue.java
*
* An implementation of a minimum PriorityQueue using a heap.
* based on the implementation in "Data Structures and Algorithms
* in Java", by Goodrich and Tamassia
*
* This implementation will throw a Runtime, HeapEmptyException
*	if the heap is empty and removeLow is called.
*
* This implementation will throw a Runtime, HeapFullException
*	if the heap is full and insert is called.
*
*/
@SuppressWarnings({"rawtypes", "unchecked"})
public class HeapPriorityQueue implements PriorityQueue {

	protected final static int DEFAULT_SIZE = 10000;
	
	protected Comparable[] storage;
	protected int currentSize;

	/*
	 * Constructor that initializes the array to hold DEFAULT_SIZE elements
	 */
	public HeapPriorityQueue() {
		currentSize = 0;
		storage = new Comparable[DEFAULT_SIZE];
		// if using a 1-based implementation, remember to allocate an 
		// extra space in the array since index 0 is not used. 
	}
	
	/*
	 * Constructor that initializes the array to hold size elements
	 */
	public HeapPriorityQueue(int size) {
		currentSize = 0;
		storage = new Comparable[size];

		// if using a 1-based implementation, remember to allocate an 
		// extra space in the array since index 0 is not used. 
	}

	public void insert (Comparable element) throws HeapFullException {

		if (isEmpty()){
			storage[0] = element;
			currentSize++;
		}else if (isFull()){
			throw new HeapFullException();
		}else{
			storage[currentSize] = element;
			bubbleUp(currentSize);
			currentSize++;
		}

		// TODO: implement this
		
		// When inserting the first element, choose whether to use 
		// a 0-based on 1-based implementation. Whatever you choose,
		// make sure your implementation for the rest of the program
		// is consistent with this choice.		
    }
	
	public void bubbleUp(int index) {
		if ((index) > 0){
			if (storage[index].compareTo(storage[(index-1)/2]) < 0){
				Comparable holder = storage[(index-1)/2];
				storage[(index-1)/2] = storage[index];				
				storage[index] = holder;
				bubbleUp((index-1)/2);
			}
		}else{
			return;
		}
	}
			
	public Comparable removeMin() throws HeapEmptyException {
		if (isEmpty()){
			throw new HeapEmptyException("No min to Remove");
		}else{
			Comparable holder = storage[0];
			storage[0] = storage[currentSize-1];
			currentSize--;
			bubbleDown(0);
			return holder;
		}
	}
	
	private void bubbleDown(int index) {
		if ((index*2)+1 < currentSize){
			int next = 0;

			if((index*2)+2 > currentSize || storage[(index*2)+1].compareTo(storage[(index*2)+2]) < 0){
				next = (index*2)+1;
			}else{
				next = (index*2)+2;
			}

			if(storage[index].compareTo(storage[next]) <= 0){
				return;
			}

			Comparable holder = storage[index];
			storage[index] = storage[next];
			storage[next] = holder;
			bubbleDown(next);
		}else{
			return;
		}
	}

	public boolean isEmpty(){
		return currentSize == 0; 
	}
	
	public boolean isFull(){
		return currentSize == storage.length; 
	}
	
	public int size () {
		return currentSize;
	}

	public String toString() {
		String s = "";
		String sep = "";
		// This implementation of toString assumes you 
		// are using a 1-based approach. Update the initial
		// and final value for i if using a 0-based
		for(int i=0; i<currentSize; i++) {
			s += sep + storage[i];
			sep = " ";
		}
		return s;
	}
}
