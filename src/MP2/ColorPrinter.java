package MP2;
/**
 * Implements a visitor that prints the field colors. 
 * 
 * @author Marcus
 */
public class ColorPrinter implements Visitor {

	@Override
	public void nextField(Field field) {
		// TODO Auto-generated method stub
		System.out.print(field.getColor());
	}

	@Override
	public void nextRow() {
		// TODO Auto-generated method stub
		System.out.println();
	} // TODO: add interface
	
	/**
	 * Prints the field color at the current position
	 * using System.out.print (not println).
	 */
	// TODO: override Visitor.nextField
	
	/**
	 * Prints a new line using System.out.println.
	 */
	// TODO: override Visitor.nextField

}
