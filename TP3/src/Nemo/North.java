package Nemo;

public class North extends Orientation {
	    @Override
	    public Orientation turnLeft() {
	        return new West();
	    }

	    @Override
	    public Orientation turnRight() {
	        return new East();
	    }

	    @Override
	    public Orientation moveForward(Coordinates coordinates) {
	        coordinates.moveNorth();
			return null;
	    	
	    }
	


}
