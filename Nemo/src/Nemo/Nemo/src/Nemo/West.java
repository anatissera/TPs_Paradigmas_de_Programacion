package Nemo;

public class West extends Orientation {

	public String cardinalPoint = "West";

	public void turnRight(Submarine submarine) {
		submarine.orientation = new North();
	}

	public void turnLeft(Submarine submarine) {
		submarine.orientation = new South();
	}

	public void moveForward(Submarine submarine) {
		submarine.coordinates = new Coordinates(submarine.positionX - 1, 
												submarine.positionY, 
												submarine.positionZ);
	}
}
