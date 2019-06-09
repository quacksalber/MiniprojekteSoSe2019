package MP3;

/**
 * An array list to store strings.
 * 
 * @author Marcus
 */
public class ArrayStringList implements StringList {

	/**
	 * The items in the list.
	 */
	private String[] items = new String[0];

	/**
	 * Creates a new empty list.
	 */
	public ArrayStringList() {
		super();
	}

	public void getContentFromto(int from, int to, int pos) {
		if (to >= items.length) {
			return;
		}
		String[] itemsCopy = new String[items.length];

		for (int i = from; from < to - 1; i++) {
			itemsCopy[i] = items[i];
		}

	}

	@Override
	public void appendString(String text) {
		// TODO: implement

	}

	@Override
	public String getStringAt(int i) {
		// TODO: implement
		return null;
	}

	@Override
	public void insertStringAt(int i, String text) {
		// TODO: implement
	}

	@Override
	public void insertStringListAt(int i, StringList list) {
		// TODO: implement
	}

	@Override
	public String replaceStringAt(int i, String text) {
		// TODO: implement
		return null;
	}

	@Override
	public String removeStringAt(int i) {
		// TODO: implement
		return null;
	}

	@Override
	public String getFirstString() {
		// TODO: implement
		return null;
	}

	@Override
	public String getLastString() {
		// TODO: implement
		return null;
	}

	@Override
	public StringList reverseStringList() {
		// TODO: implement
		return new ArrayStringList();
	}

	@Override
	public int getIndexOfString(String text, int from) {
		// TODO: implement
		return -1;
	}

	@Override
	public int countElements() {
		return 0;
	}

	@Override
	public String[] toStringArray() {
		return new String[0];
	}

}
