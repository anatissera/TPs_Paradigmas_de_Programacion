package Nemo;

public class Submarine {

	    public Coordinates coordinates;
	    public Depth depth;
	    public Orientation orientation;

	    public Submarine( Coordinates initialPosition, Orientation orientation ) {
	        this.coordinates = initialPosition;
	        this.orientation = orientation;
	        this.depth = new Depth();
	      
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
	    
	    public Submarine move(String commandsMessage) {
	    	commandsMessage.chars()
	    	.mapToObj(charCommand -> (char)charCommand)
	    	.map(currentChar -> Command.createCommand(currentChar))
	    	.forEach(command -> command.execute(this));
	    	return this;
	    }
	    
}