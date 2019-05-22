package MP3;
/**
 * A linked list to store strings.
 * 
 * @author Marcus
 */
public class LinkedStringList implements StringList {

	/**
	 * An item in the linked list.
	 * 
	 * @author Marcus
	 */
	public static class Item {

		/**
		 * The string stored in the item.
		 */
		private final String string;
		
		/**
		 * The next element in the list or
		 * null, if this is the last element.
		 */
		private Item next;
		
		/**
		 * Creates an item to store the string.
		 * 
		 * @param string The string to store.
		 */
		public Item(String string) {
			this.string = string;
		}
		
		/**
		 * Returns the string stored in the item.
		 * 
		 * @return The string stored in the item.
		 */
		public String getString() {
			return string;
		}
		
		/**
		 * Returns the next item in the list or
		 * null, if this is the last item.
		 * 
		 * @return The next item.
		 */
		public Item getNext() {
			return next;
		}
		
		/**
		 * Sets the next item of the list.
		 * 
		 * @param next The value for the next item.
		 */
		public void setNext(Item next) {
			this.next = next;
		}
		
	}
	
	/**
	 * The head (i.e. first element) of the
	 * list or null, if the list is empty.
	 */
	private Item head;
	
	/**
	 * Creates a new, empty list.
	 */
	public LinkedStringList() {
		super();
	}

	@Override
	public String getFirstString() {
		// check if empty
		if (head == null) return null;
		// else return string in first element
		return head.getString();
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
	public String getLastString() {
		// TODO: implement
		return null;
	}

	@Override
	public StringList reverseStringList() {
		// TODO: implement
		return new LinkedStringList();
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
