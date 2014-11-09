package dictionary;

import java.util.Enumeration;
import java.util.Iterator;

/** Implementation of Carrano's dictionary interface backed by
 *  an instance of MyDictionary1 (which is an extension of the
 *  system Dictionary class).
 * @author John Bannister
 *
 */
public class MyDictionary2<K, V> implements DictionaryInterface<K, V> {
	private MyDictionary1<K,V> dict;
	/**  */
	public MyDictionary2() {
		dict = new MyDictionary1<K,V>();
	}

	/** @see dictionary.DictionaryInterface#add(java.lang.Object, java.lang.Object) */
	public V add(K key, V value) {
		
		return dict.put(key, value);
	}

	/** @see dictionary.DictionaryInterface#remove(java.lang.Object) */
	public V remove(K key) {
		return dict.remove(key);
	}

	/** @see dictionary.DictionaryInterface#getValue(java.lang.Object) */
	public V getValue(K key) {
		return dict.get(key);
	}

	/** @see dictionary.DictionaryInterface#contains(java.lang.Object) */
	public boolean contains(K key) {
		return dict.get(key) == null;
	}

	/** @see dictionary.DictionaryInterface#getKeyIterator() */
	public Iterator<K> getKeyIterator() {
		return new Iterator<K>() {
			public boolean hasNext() {
				return dict.keys().hasMoreElements();
			}
			public K next() {
				return dict.keys().nextElement();
			}
		};
	}

	/** @see dictionary.DictionaryInterface#getValueIterator() */
	public Iterator<V> getValueIterator() {
		return new Iterator<V>() {
			public boolean hasNext() {
				return dict.elements().hasMoreElements();
			}
			public V next() {
				return dict.elements().nextElement();
			}
		};
	}

	/** @see dictionary.DictionaryInterface#isEmpty() */
	public boolean isEmpty() {
		return dict.isEmpty();
	}

	/** @see dictionary.DictionaryInterface#getSize() */
	public int getSize() {
		return dict.size();
	}

	/** @see dictionary.DictionaryInterface#clear() */
	public void clear() {
		Enumeration<K> theKeys = dict.keys();
		
		while(theKeys.hasMoreElements())
			dict.remove(theKeys.nextElement());
	}

}
