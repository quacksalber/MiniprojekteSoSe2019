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
		if (key == null)
			throw new NullPointerException("Key cannot be null");
		else
			return getKeys().contains(key);
	}

	@Override
	public List<V> removeKey(K key) throws KeyNotFoundException, NullPointerException {
		// TODO Auto-generated method stub
		if (key == null)
			throw new KeyNotFoundException("key cannot be null");
		else if (!containsKey(key))
			throw new NullPointerException("No key found");
		else {
			List<V> list = m.get(key);
			m.remove(key);
			return list;
		}

	}

	@Override
	public List<V> getValues(K key) throws KeyNotFoundException, NullPointerException {
		// TODO Auto-generated method stub
		if (key == null)
			throw new KeyNotFoundException("Key cannot be null");
		else if (!containsKey(key))
			throw new NullPointerException("No key found");
		else
			return m.get(key);
	}

	public List<V> getKey(K key) throws KeyNotFoundException, NullPointerException {
		return m.get(key);
	}

	@Override
	public boolean removeValue(K key, V value) throws KeyNotFoundException, NullPointerException {
		// TODO Auto-generated method stub
		if (key == null)
			throw new KeyNotFoundException("key cannot be null");
		else if (value == null)
			throw new NullPointerException("value cannot be null");
		else if (!containsKey(key))
			throw new NullPointerException("no key found");
		else {
			if (m.get(key).contains(value)) {
				m.get(key).remove(value);
				return true;
			} else if (m.get(key) == null) {
				m.remove(key);

				return true;
			} else
				return false;
		}

	}

	private void insertNewKeyPair(K key, V value) {
		List<V> list = new ArrayList<>(Arrays.asList(value));
		m.put(key, list);
	}

	private void insertNewValueForOldKey(K key, V value) {
		m.get(key).add(value);
	}

	@Override
	public void addValue(K key, V value) throws NullPointerException {
		// TODO Auto-generated method stub
		if (key == null)
			throw new NullPointerException("key cannot be null");
		else if (value == null)
			throw new NullPointerException("Value cannot be null");
		else if (!containsKey(key)) {
			insertNewKeyPair(key, value);
		} else
			insertNewValueForOldKey(key, value);

	} // TODO: change hierarchy

	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();

		for (K key : getKeys()) {
			for (V value : m.get(key)) {
				builder.append(key.toString()).append(" = ").append(value.toString()).append(System.lineSeparator());
			}
		}

		return builder.toString();
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

		System.out.println("----Nach Bearbeitung (Remove Value):----");
		multiHashMap0.removeValue("one", "valueOne0");
		multiHashMap0.removeValue("one", "valueOne1");
		multiHashMap0.removeValue("one", "valueOne2");

		multiHashMap0.removeValue("two", "valueOne1");
		System.out.println(multiHashMap0.toString() + System.lineSeparator());

		System.out.println("----Nach Bearbeitung (Remove key):----");
		multiHashMap0.removeKey("three");
		System.out.println(multiHashMap0.toString() + System.lineSeparator());

		// multiHash0.addValue("Tiername", "Daisy");
		// multiHash0.addValue("Tiername", "Lucy");
		// multiHash0.addValue("Tiername", "HundeHund");
		//
		// multiHash0.addValue("Menschenname", "Kevin");
		// multiHash0.addValue("Menschenname", "Sarah");
		// multiHash0.addValue("Menschenname", "Rudi");
		//
		// multiHash0.addValue("Nachname", "Ludi");
		// multiHash0.addValue("Nachname", "Gudi");
		// multiHash0.addValue("Nachname", "Hudi");

	}

}
