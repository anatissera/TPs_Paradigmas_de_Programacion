package Nemo;

public abstract class Orientation {

	public String cardinalPoint;
	public abstract void turnRight(Submarine submarine);
	public abstract void turnLeft(Submarine submarine);
	public abstract void moveForward(Submarine submarine);
	
}
