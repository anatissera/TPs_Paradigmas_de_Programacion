package Nemo;

public class North extends Orientation {
	
	public String cardinalPoint = "North";

	public void turnRight(Submarine submarine) {
		submarine.orientation = new East();
	}

	public void turnLeft(Submarine submarine) {
		submarine.orientation = new West();
	}

	public void moveForward(Coordinates coordinates) {
        coordinates.moveNorth();
    }
	
}
