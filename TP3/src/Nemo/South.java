package Nemo;

public class South extends Orientation {

	public String cardinalPoint = "South";

	public void turnRight(Submarine submarine) {
		submarine.orientation = new West();
	}

	public void turnLeft(Submarine submarine) {
		submarine.orientation = new East();
	}

    public void moveForward(Coordinates coordinates) {
        coordinates.moveSouth();
    }

}
