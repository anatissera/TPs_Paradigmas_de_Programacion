package Nemo;

public class East extends Orientation {

	public String cardinalPoint = "East";

	public void turnRight(Submarine submarine) {
		submarine.orientation = new South();
	}

	public void turnLeft(Submarine submarine) {
		submarine.orientation = new North();
	}

	public void moveForward(Submarine submarine) {
		submarine.coordinates = new Coordinates(submarine.positionX + 1, 
												submarine.positionY, 
												submarine.positionZ);
	}
}
