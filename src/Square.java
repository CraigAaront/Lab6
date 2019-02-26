
public class Square extends Rectangle {

	
	public Square(String id, double sideLength) {
		super(id, sideLength, sideLength);
	}
	
	public String getShapeType() {
		return "Square";
	}

}
