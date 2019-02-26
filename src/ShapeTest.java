import org.junit.Assert;
import org.junit.Test;

/**
 * Lab 6
 *
 * Test class for shapes and their comparators.
 *
 * @author Stephen
 * @version 2019-02-18
 */
public class ShapeTest
{
	//==================================================================================================================
	// Basic Shape Testing:
	//==================================================================================================================
    /**
     * Tests for the square class.
     */
	@Test
	public void SquareTest()
	{
		Shape sqr = new Square("Square1", 3.0);
		Assert.assertEquals("Square area incorrect.", 9.0, sqr.getArea(), 0.0001);
		Assert.assertEquals("Square perimeter incorrect.", 12.0, sqr.getPerimeter(), 0.0001);
		Assert.assertEquals("Square type incorrect.", "Square", sqr.getShapeType());
		Assert.assertEquals("Shape ID incorrect.", "Square1", sqr.getId());
	}

	/**
     * Tests for the rectangle class.
     */
	@Test
	public void RectangleTest()
	{
		Shape rect = new Rectangle("Rect1", 3.0, 3.0);
		Assert.assertEquals("Rectangle area incorrect.", 9.0, rect.getArea(), 0.0001);
		Assert.assertEquals("Rectangle perimeter incorrect.", 12.0, rect.getPerimeter(), 0.0001);
		Assert.assertEquals("Rectangle type incorrect.", "Rectangle", rect.getShapeType());
		Assert.assertEquals("Shape ID incorrect.", "Rect1", rect.getId());
	}

	/**
     * Tests for the EquilateralTriangle class.
     */
	@Test
	public void TriangleTest()
	{
		Shape equ = new EquilateralTriangle("Equ1", 3.0);
		Assert.assertEquals("EquilateralTriangle area incorrect.", (Math.sqrt(3.0) / 4.0) * 9, equ.getArea(), 0.0001);
		Assert.assertEquals("EquilateralTriangle perimeter incorrect.", 9.0, equ.getPerimeter(), 0.0001);
		Assert.assertEquals("EquilateralTriangle type incorrect.", "EquilateralTriangle", equ.getShapeType());
		Assert.assertEquals("Shape ID incorrect.", "Equ1", equ.getId());
	}

	/**
     * Tests for the trapezoid class. Also test that IDs are done correctly.
     */
	@Test
	public void TrapezoidTest()
	{
		Shape trap = new Trapezoid("Trap1", 13.0, 13.0, 16.0, 26.0);
		Assert.assertEquals("Trapezoid area incorrect.", 252.0, trap.getArea(), 0.0001);
		Assert.assertEquals("Trapezoid perimeter incorrect.", 68.0, trap.getPerimeter(), 0.0001);
		Assert.assertEquals("Trapezoid type incorrect.", "Trapezoid", trap.getShapeType());
		Assert.assertEquals("Shape ID incorrect.", "Trap1", trap.getId());
	}

	/**
     * Tests for the ellipse class. Also test that IDs are done correctly.
     */
	@Test
	public void EllipseTest()
	{
		Shape circ = new Ellipse("Ellipse1", 3.0, 3.0);
		Assert.assertEquals("Ellipse area incorrect.", Math.PI*3.0*3.0, circ.getArea(),0.0001);
		Assert.assertEquals("Ellipse perimeter incorrect.",
				2 * Math.PI * Math.sqrt((Math.pow(3, 2) + Math.pow(3, 2)) / 2),
				circ.getPerimeter(),0.0001);
		Assert.assertEquals("Ellipse type incorrect.", "Ellipse",circ.getShapeType());
		Assert.assertEquals("Shape ID incorrect.", "Ellipse1", circ.getId());

		Shape circs = new Ellipse("Ellipse2", 5.0, 3.0);
		Assert.assertEquals("Ellipse area incorrect.", Math.PI*3*5, circs.getArea(),0.0001);
		Assert.assertEquals("Ellipse perimeter incorrect.",
				2 * Math.PI * Math.sqrt((Math.pow(5.0, 2) + Math.pow(3.0, 2)) / 2),
				circs.getPerimeter(),0.0001);
		Assert.assertEquals("Ellipse type incorrect.", "Ellipse",circs.getShapeType());
		Assert.assertEquals("Shape ID incorrect.", "Ellipse2", circs.getId());
	}

	/**
     * Tests for the circle class. Also test that IDs are done correctly.
     */
	@Test
	public void CircleTest()
	{
		Shape circ = new Circle("Circ1", 3.0);
		Assert.assertEquals("Circle area incorrect.", Math.PI*3.0*3.0, circ.getArea(), 0.0001);
		Assert.assertEquals("Circle perimeter incorrect.", 2 * Math.PI * 3.0, circ.getPerimeter(), 0.0001);
		Assert.assertEquals("Circle type incorrect.", "Circle", circ.getShapeType());
		Assert.assertEquals("Shape ID incorrect.", "Circ1", circ.getId());
	}

	/**
	 * Tests for Shape's toString().
	 */
	@Test
	public void ShapeToStringTest()
	{
		Shape s1 = new EquilateralTriangle("A", 3.0);
		Assert.assertEquals("Shape toString incorrect", "EquilateralTriangle	 ID = A	 area = 3.897	 perimeter = 9.000", s1.toString());
		Shape s2 = new Rectangle("B", 4.0, 1.0);
		Assert.assertEquals("Shape toString incorrect", "Rectangle	 ID = B	 area = 4.000	 perimeter = 10.000", s2.toString());
		Shape s5 = new Square("A", 8.0);
		Assert.assertEquals("Shape toString incorrect", "Square	 ID = A	 area = 64.000	 perimeter = 32.000", s5.toString());
		Shape s4 = new Ellipse("D", 16.0, 1.0);
		Assert.assertEquals("Shape toString incorrect", "Ellipse	 ID = D	 area = 50.265	 perimeter = 71.225", s4.toString());
		Shape s3 = new Trapezoid("C", 3.0, 3.0, 5.0, 7.0);
		Assert.assertEquals("Shape toString incorrect", "Trapezoid	 ID = C	 area = 16.971	 perimeter = 18.000", s3.toString());
		Shape s6 = new Circle("E", 16.0);
		Assert.assertEquals("Shape toString incorrect", "Circle	 ID = E	 area = 804.248	 perimeter = 100.531", s6.toString());

	}

	//==================================================================================================================
	// Comparisons:
	//==================================================================================================================
	/**
     * Tests for the Shape Area Comparator class.
     */
	@Test
	public void CompareAreaTest()
	{
	    // Test equals:
		Shape rect = new Rectangle("R1", 3.0,3.0);
		Shape sqr = new Square("S1", 3.0);
		ShapeAreaComparator sc = new ShapeAreaComparator();
		Assert.assertEquals("ShapeAreaComparator should find shapes equal.", 0, sc.compare(rect, sqr));
		Assert.assertTrue("ShapeAreaComparator should find shapes equal.", sc.equals(rect, sqr));

		// Test equal perimeter, different area:
        Shape rect2 = new Rectangle("R2", 1.0, 9.0);
        Shape sqr2 = new Square("S2", 5.0);
        Assert.assertEquals("ShapeAreaComparator gave incorrect ordering.", -1, sc.compare(rect2, sqr2));
        Assert.assertEquals("ShapeAreaComparator gave incorrect ordering.", 1, sc.compare(sqr2, rect2));
        Assert.assertFalse("ShapeAreaComparator incorrectly finds shapes equal.", sc.equals(rect2, sqr2));

        // Test unequal perimeter and area:
        Assert.assertEquals("ShapeAreaComparator gave incorrect ordering.", 1, sc.compare(sqr2, rect));
        Assert.assertEquals("ShapeAreaComparator gave incorrect ordering.", -1, sc.compare(rect, sqr2));
        Assert.assertFalse("ShapeAreaComparator incorrectly finds shapes equal.", sc.equals(sqr2, rect));
	}

	/**
     * Tests for the Shape Perimter Comparator class.
     */
	@Test
	public void ComparePerimeterTest()
	{
		Shape rect = new Rectangle("R1", 3.0,3.0);
		Shape sqr = new Square("S1", 3.0);
		ShapePerimeterComparator sc = new ShapePerimeterComparator();
		Assert.assertEquals("ShapePerimeterComparator should find shapes equal.", 0, sc.compare(rect, sqr));
		Assert.assertTrue("ShapePerimeterComparator should find shapes equal.", sc.equals(rect, sqr));

		// Test equal perimeter, different area:
        Shape rect2 = new Rectangle("R2", 1.0, 9.0);
        Shape sqr2 = new Square("S2", 4.0);
        Assert.assertEquals("ShapePerimeterComparator gave incorrect ordering.", 1, sc.compare(rect2, sqr2));
        Assert.assertEquals("ShapePerimeterComparator gave incorrect ordering.", -1, sc.compare(sqr2, rect2));
        Assert.assertFalse("ShapePerimeterComparator incorrectly finds shapes equal.", sc.equals(rect2, sqr2));

        // Test unequal perimeter and area:
        Assert.assertEquals("ShapeAreaComparator gave incorrect ordering.", 1, sc.compare(sqr2, rect));
        Assert.assertEquals("ShapeAreaComparator gave incorrect ordering.", -1, sc.compare(rect, sqr2));
        Assert.assertFalse("ShapeAreaComparator incorrectly finds shapes equal.", sc.equals(sqr2, rect));
        }

	/**
	 * Tests the natural ordering of shapes (compareTo in shape)
	 */
	@Test
    public void NaturalCompareTest()
    {
		Shape rect = new Rectangle("R1", 3.0,3.0);
		Shape sqr = new Square("S1", 3.0);
		Assert.assertEquals("Shape CompareTo gave incorrect ordering", 0, rect.compareTo(sqr));
		
		Shape rect2 = new Rectangle("R2", 3.0,3.0);
		Shape sqr2 = new Square("S2", 4.0);
		Assert.assertEquals("Shape CompareTo gave incorrect ordering", -1 ,rect2.compareTo(sqr2));
		Assert.assertEquals("Shape CompareTo gave incorrect ordering", 1 ,sqr2.compareTo(rect2));

		Shape rect3 = new Rectangle("R3", 2.0,8.0);
		Shape rect4 = new Rectangle("R4", 4.0,4.0);
		Assert.assertEquals("Shape compareTo gave incorrect ordering", 1, rect3.compareTo(rect4));
		Assert.assertEquals("Shape compareTo gave incorrect ordering", -1, rect4.compareTo(rect3));

    }
}
