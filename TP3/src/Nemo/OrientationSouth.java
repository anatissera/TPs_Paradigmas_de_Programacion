package Nemo;

public class OrientationSouth extends Orientation {

	public void turnRight(Submarine submarine) {
		submarine.orientation = new OrientationWest();
	}

	public void turnLeft(Submarine submarine) {
		submarine.orientation = new OrientationEast();
	}

    public void moveForward(Submarine submarine) {
    	submarine.coordinates = submarine.coordinates.moveSouth();
    }

}
