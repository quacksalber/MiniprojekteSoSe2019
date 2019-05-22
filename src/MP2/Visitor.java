package MP2;
/**
 * Implements the visitor pattern for fields of a
 * chessboard described by Gamma, et al
 * (see also "Design Patterns. Elements  of Reusable 
 *  Object-Oriented Software." by Erich Gamma, 
 *  Richard Helm, Ralph Johnson, John Vlissides)
 * 
 * @author Marcus
 */
public interface Visitor {

	/**
	 * Visits the next field.
	 * 
	 * @param field The field to visit.
	 */
	void nextField(Field field);
	
	/**
	 * Signals the end of the current row.
	 */
	void nextRow();
	
}
