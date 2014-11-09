package dictionary;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Iterator;

/** A dictionary class backed by an arraylist.
 * @author John Bannister */
public class MyDictionary1<K, V> extends Dictionary<K, V> {
	ArrayList<Entry<K,V>> list;
	
	/**  */
	public MyDictionary1() {
		list = new ArrayList<Entry<K,V>>();
	}

	/** @see java.util.Dictionary#size() */
	@Override
	public int size() {
		return list.size();
	}

	/** @see java.util.Dictionary#isEmpty() */
	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	/** @see java.util.Dictionary#keys() */
	@Override
	public Enumeration<K> keys() {
		ArrayList<K> keyList = new ArrayList<K>();
		for(Entry<K,V> i : list)
			keyList.add(i.getKey());
		return new MyEnumeration<K>(keyList.iterator());
	}

	/** @see java.util.Dictionary#elements() */
	@Override
	public Enumeration<V> elements() {
		ArrayList<V> valList = new ArrayList<V>();
		for(Entry<K,V> i : list)
			valList.add(i.getValue());
		return new MyEnumeration<V>(valList.iterator());
	}

	/** @see java.util.Dictionary#get(java.lang.Object) */
	@Override
	public V get(Object key) {
		Entry<K,V> entry = lookupEntry(key);
		V result = null;
		
		if(entry != null)
			result = entry.getValue();
		
		return result;
	}
	
	/** Helper for get(Object) et al
	 * 
	 * @param key  a key in this dictionary
	 * @return  the Entry whose key value is the object passed or null if
	 * there is no such Entry */
	private Entry<K,V> lookupEntry(Object key) {
		Iterator<Entry<K,V>> iter = list.iterator();
		boolean found = false;
		Entry<K,V> result = null;
		
		while(!found && iter.hasNext()) {
			Entry<K,V> entry = iter.next();
			if(key.equals(entry.getKey())) {
				found = true;
				result = entry;
			}
		}
		
		return result;
	}

	/** @see java.util.Dictionary#put(java.lang.Object, java.lang.Object) */
	@Override
	public V put(K key, V value) {
		V result = remove(key);
		
		list.add(new Entry<K,V>(key, value));
		
		return result;
	}

	/** @see java.util.Dictionary#remove(java.lang.Object) */
	@Override
	public V remove(Object key) {
		Entry<K,V> entry = lookupEntry(key);
		V result = null;
		
		if(entry != null) {
			result = entry.getValue();
			list.remove(entry);
		}
		
		return result;
	}

	private class Entry<KE, VE> {
		KE key;
		VE value;
		
		Entry(KE key, VE value) {
			this.key = key;
			this.value = value;
		}
		
		KE getKey() {
			return key;
		}
		
		VE getValue() {
			return value;
		}
	}
	
	private class MyEnumeration<E> implements Enumeration<E>{
		private Iterator<E> iter;
		
		MyEnumeration(Iterator<E> theIterator) {
			iter = theIterator;
		}
		
		/** @see java.util.Enumeration#hasMoreElements() */
		public boolean hasMoreElements() {
			return iter.hasNext();
		}

		/** @see java.util.Enumeration#nextElement() */
		public E nextElement() {
			return iter.next();
		}
	}
}
