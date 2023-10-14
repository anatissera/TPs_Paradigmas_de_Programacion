package Nemo;

public class East extends Orientation {

	public String cardinalPoint = "East";

	public void turnRight(Submarine submarine) { 
		submarine.orientation = new South();
	}

	public void turnLeft(Submarine submarine) {
		submarine.orientation = new North();
	}

    public void moveForward(Coordinates coordinates) {
        coordinates.moveEast();
    }

}
