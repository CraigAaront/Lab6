/**
 * Creates the rectangle class, an extension of the polygon class
 * @author Aaron
 *
 */
public class Rectangle extends Polygon {
    /**
     * Creates two private variables that house the 2 sides used for calculations
     */
	private double width;
	private double height;
	
	/**
	 * 
	 * @param id is the ID used in the shape class
	 * @param width is the width of the rectangle
	 * @param height is the height of the rectangle
	 * Constructs a rectangle, assigning the side lengths to the polygon array, SideLengths
	 */
	public Rectangle(String id, double width, double height) {
		super(id);
		this.width = width;
		this.height = height;
		sideLengths.add(width);
		sideLengths.add(height);
		sideLengths.add(width);
		sideLengths.add(height);
	}
	
	/**
	 * Returns the area of the rectangle
	 */
	@Override
	public double getArea() {
		double a = this.width;
		double b = this.height;
		return a * b;
	}
	
	/**
	 * returns "Rectangle"
	 */
	@Override
	public String getShapeType() {
		return "Rectangle";
	}
}
