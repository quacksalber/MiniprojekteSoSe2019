package MP2;

/**
 * Implements a vistor that prints a compact representation of the marked state
 * of a board onto the console.
 * 
 * @author Marcus
 */
public class MarkPrinter implements Visitor { // TODO: add interface

	/**
	 * Prints the state of the specified field onto the console (using print, not
	 * println). If the field is marked, the method prints "X". If the field is not
	 * marked, the method prints "-".
	 */
	// TODO: override Visitor.nextField
	public void nextField(Field field) {
		if (field.isMarked() == true) {
			System.out.print("X");
		} else
			System.out.print("-");
	}

	/**
	 * Prints a new line onto the console.
	 */
	// TODO: override Visitor.nextRow
	public void nextRow() {
		System.out.println();
	}

}
