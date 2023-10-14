package Nemo;

public class OrientationWest extends Orientation {

	public String cardinalPoint = "West";

	public void turnRight(Submarine submarine) {
		submarine.orientation = new OrientationNorth();
	}

	public void turnLeft(Submarine submarine) {
		submarine.orientation = new OrientationSouth();
	}
	
	public void moveForward(Coordinates coordinates) {
	    coordinates.moveWest();
	}
	
}
