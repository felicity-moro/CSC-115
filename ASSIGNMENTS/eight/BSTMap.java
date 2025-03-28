import java.util.*;

public class BSTMap<K extends Comparable<K>, V > implements  Map<K, V>  {
    
	BinarySearchTree<K,V> bst;

	public BSTMap () {
		bst = new BinarySearchTree<K,V>();
	}

	public boolean containsKey(K key) {
		try{
			bst.find(key);
		}catch (KeyNotFoundException e){
			return false;
		}
		 return true;
	}

	public V get (K key) throws KeyNotFoundException {
		try{
			return bst.find(key);
		}catch (KeyNotFoundException e){
			throw new KeyNotFoundException();
		}
	}

	public List<Entry<K,V> > entryList() {
		return bst.entryList();
	}

	public void put (K key, V value) {
		bst.insert(key,value);
	}

	public int size() {
		return bst.count;
	}

	public void clear() {
		bst.clear();
	}

}