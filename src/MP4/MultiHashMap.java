package MP4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import javax.crypto.NullCipher;
import javax.swing.plaf.multi.MultiMenuItemUI;

/**
 * Implements a multimap using a hashmap that contains array lists to store its
 * elements.
 *
 * @author Marcus
 *
 * @param <K>
 *            The key.
 * @param <V>
 *            The value.
 */
public class MultiHashMap<K, V> implements MultiMap<K, V> {
	HashMap<K, List<V>> m = new HashMap<>();

	@Override
	public Set<K> getKeys() {
		// TODO Auto-generated method stub
		return m.keySet();
	}

	@Override
	public boolean containsKey(K key) throws NullPointerException {
		// TODO Auto-generated method stub
		if (key == null) {
			throw new NullPointerException("Key cannot be null");
		} else {
			return getKeys().contains(key);
		}
	}

	@Override
	public List<V> removeKey(K key) throws KeyNotFoundException, NullPointerException {
		// TODO Auto-generated method stub
		if (key == null) {
			throw new NullPointerException("Key cannot be null");
		} else if (!containsKey(key)) {
			throw new KeyNotFoundException("Key not found");
		} else {
			List<V> list = m.get(key);
			m.remove(key);
			return list;
		}

	}

	@Override
	public List<V> getValues(K key) throws KeyNotFoundException, NullPointerException {
		// TODO Auto-generated method stub
		if (key == null) {
			throw new NullPointerException("Key cannot be null");
		} else if (!containsKey(key)) {
			throw new KeyNotFoundException("Key not found");
		} else {
			return m.get(key);
		}

	}

	@Override
	public boolean removeValue(K key, V value) throws KeyNotFoundException, NullPointerException {
		// TODO Auto-generated method stub
		if (key == null) {
			throw new KeyNotFoundException("Key cannot be null");
		} else if (value == null) {
			throw new NullPointerException("Value cannot be null");
		} else if (!containsKey(key)) {
			throw new NullPointerException("Key not found");
		} else {
			if (m.get(key).contains(value)) {
				System.out.println("Es wird " + m.get(key) + " aus " + "[" + key + "]" + " entfernt");
//				System.out.println(m.get(key).size());
				m.get(key).remove(value);
//				System.out.println(m.get(key).size());
				if (m.get(key).size() == 0) {
					m.remove(key);
				}

			}

			return false;
		}
	}

	private void insertNewKeyPair(K key, V value) {
		List<V> list = new ArrayList<>();
		list.add(value);
		m.put(key, list);

	}

	@Override
	public void addValue(K key, V value) throws NullPointerException {
		// TODO Auto-generated method stub
		if (key == null) {
			throw new NullPointerException("Key cannot be null");
		} else if (value == null) {
			throw new NullPointerException("Value cannot be null");
		} else {
			if (!containsKey(key)) {
				insertNewKeyPair(key, value);
			} else {
				m.get(key).add(value);
			}
		}

	}

	@Override
	public String toString() {
		String ausgabe = "";

		for (K key : getKeys()) {
			System.out.println(key + "\t" + " = " + m.get(key));
		}
		return ausgabe;
	}

	public static void main(String[] args) throws NullPointerException, KeyNotFoundException {
		MultiHashMap<String, String> multiHashMap0 = new MultiHashMap<>();

		multiHashMap0.addValue("one", "valueOne0");
		multiHashMap0.addValue("one", "valueOne1");
		multiHashMap0.addValue("one", "valueOne2");

		multiHashMap0.addValue("two", "valueTwo0");
		multiHashMap0.addValue("two", "valueTwo1");
		multiHashMap0.addValue("two", "valueTwo2");

		multiHashMap0.addValue("three", "valueThree0");
		multiHashMap0.addValue("three", "valueThree1");
		multiHashMap0.addValue("three", "valueThree2");

		multiHashMap0.addValue("four", "valueFour0");
		multiHashMap0.addValue("four", "valueFour1");
		multiHashMap0.addValue("four", "valueFour2");

		multiHashMap0.addValue("five", "valueFive0");
		multiHashMap0.addValue("five", "valueFive1");

		System.out.println("----Ausgangsliste:----");
		System.out.println(multiHashMap0.toString() + System.lineSeparator());

		System.out.println("----Nach Bearbeitung (Remove Value)----");
		// multiHashMap0.removeValue("one", "valueOne0");
		// multiHashMap0.removeValue("one", "valueOne1");
		// multiHashMap0.removeValue("one", "valueOne2");
		multiHashMap0.removeValue("five", "valueFive0");
		multiHashMap0.removeValue("five", "valueFive1");
		System.out.println(multiHashMap0.toString() + System.lineSeparator());

		System.out.println("----Nach Bearbeitung (Remove key three)----");
		multiHashMap0.removeKey("three");
		System.out.println(multiHashMap0.toString() + System.lineSeparator());
		
		System.out.println("---- Ausgangsliste----");
		MultiHashMap<Integer, String> multiHashMap1 = new MultiHashMap<>();
		
		multiHashMap1.addValue(1, "eins0");
		multiHashMap1.addValue(1, "eins1");
		multiHashMap1.addValue(1, "eins2");
		multiHashMap1.addValue(1, "eins3");
		
		multiHashMap1.addValue(2, "zwei0");
		multiHashMap1.addValue(2, "zwei1");
		multiHashMap1.addValue(2, "zwei2");
		multiHashMap1.addValue(2, "zwei3");
		
		multiHashMap1.addValue(3, "drei0");
		
		System.out.println(multiHashMap1.toString());	
		
		multiHashMap1.removeValue(3, "drei0");
		
		System.out.println(multiHashMap1.toString());
		

	}

}
