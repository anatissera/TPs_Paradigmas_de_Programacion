package Nemo;

public class OrientationEast extends Orientation {

	public OrientationEast () {	
		cardinalPoint = "East";
	}

	public void turnRight(Submarine submarine) { 
		submarine.orientation = new OrientationSouth();
	}

	public void turnLeft(Submarine submarine) {
		submarine.orientation = new OrientationNorth();
	}

    public void moveForward(Submarine submarine) {
        submarine.coordinates = submarine.coordinates.moveEast();
    }

}
