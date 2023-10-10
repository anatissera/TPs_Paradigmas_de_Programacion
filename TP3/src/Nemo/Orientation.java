package Nemo;

	public abstract class Orientation {
		public String direction = "North"; //debe inicializarse en Submarine
		public String getDirection() { return direction; }
	    public abstract Orientation turnLeft();
	    public abstract Orientation turnRight();
	    public abstract Orientation moveForward(Coordinates coordinates);
	}	
