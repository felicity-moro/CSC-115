import java.util.*;

public class HashMap<K extends Comparable<K>, V> implements Map<K,V> {

	private List<List<Entry<K,V>>> table;
	private int	count;
	private int tableSize;

	// For Part III
	private long getLoops;
	private long putLoops;

	public HashMap() {
		tableSize = 1000003; // prime number
		table = new ArrayList<List<Entry<K,V>>>(tableSize);

		// initializes table as a list of empty lists
		for (int i = 0; i < tableSize; i++) {
			table.add(new LinkedList<Entry<K,V>>());
		}

		count = 0;

		// For Part III:
		//resetGetLoops();
		//resetPutLoops();
	}

	// For Part III
	public long getGetLoopCount() {
		return getLoops;
	}

	// For Part III
	public long getPutLoopCount() {
		return putLoops;
	}

	// For Part III
	public void resetGetLoops() {
		getLoops = 0;
	}
	
	// For Part III
	public void resetPutLoops() {
		putLoops = 0;
	}

	public boolean containsKey(K key) {
		// gets the index in the table this key should be in
		int index = Math.abs(key.hashCode()) % tableSize;
		List<Entry<K,V>> inList = table.get(index);

		if (inList.size() == 0){
			return false;
		}else{
			Iterator <Entry<K,V>> iter = inList.iterator();
			while(iter.hasNext()){
				Entry<K,V> obj = iter.next();
				if (obj.getKey().compareTo(key) == 0){
					return true;
				}
			}
		}
		
		return false;
	}

	public V get (K key) throws KeyNotFoundException {

		// gets the index in the table this key should be in
		int index = Math.abs(key.hashCode()) % tableSize;
		List<Entry<K,V>> inList = table.get(index);

		if (inList.size() == 0){
			throw new KeyNotFoundException();
		}else{
			Iterator <Entry<K,V>> iter = inList.iterator();
			while(iter.hasNext()){
				Entry<K,V> obj = iter.next();
				if (obj.getKey().compareTo(key) == 0){
					return obj.getValue();
				}
			}
		}
		
		throw new KeyNotFoundException();
	}


	public List<Entry<K,V> >entryList() {
		List <Entry<K,V>> resultList = new LinkedList<Entry<K,V>>();
		// TODO: complete the rest of this method

		// Tip: you will need to iterate through each index in the table (and each index holds a list)
		//      you will THEN need to iterate through each element in the linked list chain at a 
		//      specific index and add each element to l

		Iterator <List<Entry<K,V>>> tableIter = table.iterator();
		while (tableIter.hasNext()){
			List<Entry<K,V>> theList = tableIter.next();
			Iterator <Entry<K,V>> lIter = theList.iterator();

			while(lIter.hasNext()){
				Entry<K,V> obj = lIter.next();
				resultList.add(obj);
			}
		}
		return resultList;
	}
	
	public void put (K key, V value){
		// gets the index in the table this key should be in
		int index = Math.abs(key.hashCode())%tableSize;
		List<Entry<K,V>> inList = table.get(index);
		Entry<K,V> e = new Entry<K,V>(key, value);


		if (inList.size() == 0){
			inList.add(e);
			count++;
			return;
		}else{
			Iterator <Entry<K,V>> iter = inList.iterator();
			while(iter.hasNext()){
				Entry<K,V> obj = iter.next();
				if (obj.getKey().compareTo(key) == 0){
					obj.setValue(value);
					return;
				}
			}
			inList.add(e);
			count++;
		}
	}

	public int size() {
		return count;
	}

    public void clear() {
		for(int i = 0; i < tableSize; i++) {
			table.get(i).clear();
		}
        count = 0;
    }

}