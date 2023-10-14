package Nemo;

public class OrientationWest extends Orientation {

	public OrientationWest () {	
		cardinalPoint = "West";
	}

	public void turnRight(Submarine submarine) {
		submarine.orientation = new OrientationNorth();
	}

	public void turnLeft(Submarine submarine) {
		submarine.orientation = new OrientationSouth();
	}
	
	public void moveForward(Submarine submarine) {
	    submarine.coordinates.moveWest();
	}
	
}
