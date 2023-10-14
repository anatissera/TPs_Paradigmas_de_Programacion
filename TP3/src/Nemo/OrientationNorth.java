package Nemo;

public class OrientationNorth extends Orientation {
	
	public OrientationNorth () {	
		cardinalPoint = "North";
	}

	public void turnRight(Submarine submarine) {
		submarine.orientation = new OrientationEast();
	}

	public void turnLeft(Submarine submarine) {
		submarine.orientation = new OrientationWest();
	}

	public void moveForward(Submarine submarine) {
        submarine.coordinates.moveNorth();
    }
	
}
