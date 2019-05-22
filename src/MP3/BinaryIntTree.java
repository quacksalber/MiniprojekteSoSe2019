package MP3;
/**
 * A binary tree that stores unique int values
 * in its nodes and keeps them ordered. 
 * 
 * @author Marcus
 *
 */
public class BinaryIntTree {

	/**
	 * A tree node.
	 * 
	 * @author Marcus
	 */
	public static class Node {
		
		/**
		 * The node value.
		 */
		int value;
		
		/**
		 * The left child.
		 */
		Node leftChild;
		
		/**
		 * The right child.
		 */
		Node rightChild;
		
		/**
		 * Creates a node with a 
		 * particular value.
		 * 
		 * @param value The node's value.
		 */
		public Node(int value) {
			this.value = value;
		}
		
		
		/**
		 * Performs an in order traversal and writes the
		 * values of the tree into the array starting at
		 * the specified start index. When done, the
		 * method returns the updated start index that
		 * is incremented by the number of values written
		 * to the array.
		 * 
		 * @param array The array to write to.
		 * @param startIndex The start index to write from.
		 * @return The updated start index that is incremented
		 * 	by the number of values written to the array.
		 */
		public int toArray(int[] array, int startIndex) {
			// TODO: implement
			return 0;
		}
		
		
	}
	
	/**
	 * The root node.
	 */
	private Node root;
	
	/**
	 * Creates a new binary tree
	 * without any nodes.
	 */
	public BinaryIntTree() {
		super();
	}
	
	/**
	 * Determines whether a value is contained in the tree.
	 * 
	 * @param value The value to search for.
	 * @return True if it is contained, false otherwise.
	 */
	public boolean containsValue(int value) {
		// TODO: implement
		return false;
	}
	
	/**
	 * Inserts a value into the tree, if it does not
	 * exist already.
	 * 
	 * @param value The value to insert.
	 * @return True if the tree has been modified, false
	 * 	otherwise.
	 */
	public boolean insertValue(int value) {
		// TODO: implement
		return false;
	}
	
	/**
	 * Computes the number of nodes in the tree.
	 * 
	 * @return The number of nodes in the tree.
	 */
	public int getNodeCount() {
		// TODO: implement
		return 0;
	}
	
	/**
	 * Determines whether all nodes have either 0 or 2
	 * children.
	 * 
	 * @return True if all nodes have zero or two children.
	 */
	public boolean isFull() {
		// TODO: implement
		return false;
	}
	
	/**
	 * Determines whether the tree is perfect. That is
	 * all intermediate nodes have 2 children and all leafs
	 * are on the same level.
	 * 
	 * @return True if the tree is perfect.
	 */
	public boolean isPerfect() {
		// TODO: implement
		return false;
	}

	/**
	 * Converts the tree to an int-array that is
	 * ordered (c.f. in-fix traversal).
	 * 
	 * @return The ordered int array.
	 */
	public int[] toIntArray() {
		int[] result = new int[getNodeCount()];
		if (result.length != 0) {
			root.toArray(result, 0);
		}
		return result;
	}
	
	
}
