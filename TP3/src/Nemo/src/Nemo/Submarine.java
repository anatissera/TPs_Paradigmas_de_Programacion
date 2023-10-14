package Nemo;

public class Submarine {
	    
	    public Coordinates coordinates;
	    public Depth depth;
	    public Orientation orientation;

	    public Submarine() {
	        coordinates = new Coordinates(0, 0);
	        orientation = new North();
	    }

	    public int getDepth() {
	        return depth.getZ();
	    }

	    public int getPosition_X() {
	        return coordinates.getX();
	    }

	    public int getPosition_Y() {
	        return coordinates.getY();
	    }

	    public String getOrientation() {
	        return orientation.getDirection();
	    }
	    
	    public void move(String commandsMessage) {
    		for(int i = 0; i<commandsMessage.length(); i++) {
    			Command command = new Command(commandsMessage.charAt(i));
    			command.excecuteCommand(this);
    			}
	    }
}
