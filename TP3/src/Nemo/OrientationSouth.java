package Nemo;

public class OrientationSouth extends Orientation {

	public String cardinalPoint = "South";

	public void turnRight(Submarine submarine) {
		submarine.orientation = new OrientationWest();
	}

	public void turnLeft(Submarine submarine) {
		submarine.orientation = new OrientationEast();
	}

    public void moveForward(Coordinates coordinates) {
        coordinates.moveSouth();
    }

}
