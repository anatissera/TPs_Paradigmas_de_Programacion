package Nemo;

public class Submarine {

	    public Coordinates coordinates;
	    public Depth depth;
	    public Orientation orientation;

	    public Submarine( Coordinates initialPosition, Orientation orientation ) {
	        coordinates = initialPosition;
	        this.orientation = orientation;
	        depth = new Depth();
	    }

	    public int getDepth() {
	        return depth.getZ();
	    }

	    public Coordinates getCoordinates() {
	    	return coordinates.getCoordinates();
	    }

	    public Orientation getOrientation() {
	        return orientation;
	    }
	    
	    public Submarine move(String commandsString) {
	    	commandsString.chars()
	    	.mapToObj(commandChar -> (char)commandChar)
	    	.forEach(commandChar -> move(commandChar));
	    	return this;
	    }
	    
	    public Submarine move(char commandChar) {
	    	Command.createCommand(commandChar).execute(this);
	    	return this;
	    
	    }
	    
}