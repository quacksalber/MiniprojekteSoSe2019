package MP3;
/**
 * An array-based stack that adapts its capacity 
 * by a configurable number of elements.
 * 
 * @author Marcus
 */
public class StringStack {

	/**
	 * The array that stores the item.
	 */
	private String[] items;

	/**
	 * The current number of items.
	 */
	private int size = 0;
	
	/**
	 * The increment by which the items array will
	 * be increased when there is no more space left.
	 */
	private int increment = 0;
	
	/**
	 * Creates a new string stack that increments
	 * its capacity by 10.
	 */
	public StringStack() {
		this(10);
	}
	
	/**
	 * Creates a new string stack that increments
	 * its capacity by the specified increment.
	 * 
	 * @param increment The increment, must be > 0.
	 */
	public StringStack(int increment) {
		this.increment = increment;
		this.items = new String[increment];
	}
	
	/**
	 * Pushes the item onto the stack. If the 
	 * stack's capacity is not large enough to
	 * hold the additional item, the stack's
	 * capacity will be increased by the stack's
	 * increment.
	 * 
	 * @param item The item to push onto the stack.
	 */
	public void push(String item) {
		// TODO: implement
	}
	
	/**
	 * Pops the item from the stack. If the
	 * stack's available unused space is larger
	 * or equal than 2 times the increment, the 
	 * stack's capacity will be reduced by one
	 * full increment.
	 * 
	 * @return The item that is at the top of the
	 * 	stack or null, if the stack is empty.
	 */
	public String pop() {
		// TODO: implement
		return null;
	}
	
	/**
	 * Returns the size of the stack.
	 * 
	 * @return The size of the stack.
	 */
	public int getSize() {
		return size;
	}
	
	/**
	 * Returns the current capacity of the stack.
	 * 
	 * @return The capacity of the stack.
	 */
	public int getCapacity() {
		return items.length;
	}	
	
}
