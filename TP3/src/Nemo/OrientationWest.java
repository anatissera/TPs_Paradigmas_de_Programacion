package Nemo;

public class OrientationWest extends Orientation {

	public void turnRight(Submarine submarine) {
		submarine.orientation = new OrientationNorth();
	}

	public void turnLeft(Submarine submarine) {
		submarine.orientation = new OrientationSouth();
	}
	
	public void moveForward(Submarine submarine) {
		submarine.coordinates = submarine.coordinates.moveWest();
	}
	
}
