package Nemo;

public class North extends Orientation {
	
	public String cardinalPoint = "North";

	public void turnRight(Submarine submarine) {
		submarine.orientation = new East();
	}

	public void turnLeft(Submarine submarine) {
		submarine.orientation = new West();
	}

	public void moveForward(Submarine submarine) {
		submarine.coordinates = new Coordinates(submarine.positionX, 
												submarine.positionY + 1, 
												submarine.positionZ);
	}
}
