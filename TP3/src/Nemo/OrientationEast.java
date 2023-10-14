package Nemo;

public class OrientationEast extends Orientation {

	public String cardinalPoint = "East";

	public void turnRight(Submarine submarine) { 
		submarine.orientation = new OrientationSouth();
	}

	public void turnLeft(Submarine submarine) {
		submarine.orientation = new OrientationNorth();
	}

    public void moveForward(Coordinates coordinates) {
        coordinates.moveEast();
    }

}
