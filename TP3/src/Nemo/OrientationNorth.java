package Nemo;

public class OrientationNorth extends Orientation {
	
	public String cardinalPoint = "North";

	public void turnRight(Submarine submarine) {
		submarine.orientation = new OrientationEast();
	}

	public void turnLeft(Submarine submarine) {
		submarine.orientation = new OrientationWest();
	}

	public void moveForward(Coordinates coordinates) {
        coordinates.moveNorth();
    }
	
}
