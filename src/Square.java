/**
 * Creates the Square class, an extension of the rectangle class
 * @author Aaron
 *
 */
public class Square extends Rectangle {

	/**
	 * Constructs a square using the rectangle constructor; there is only 1 uniform sidelength
	 * @param id
	 * @param sideLength
	 */
	public Square(String id, double side) {
		super(id, side, side);
	}
	
	/**
	 * returns "Square"
	 */
	public String getShapeType() {
		return "Square";
	}

}
