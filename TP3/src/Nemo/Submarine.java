package Nemo;

public class Submarine {

	    public Coordinates coordinates;
	    public Depth depth;
	    public Orientation orientation;

	    public Submarine() {
	        coordinates = new Coordinates(0, 0);
	        orientation = new OrientationNorth();
	        depth = new Depth();
	      
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

//	        for (int i = 0; i < commandsMessage.length(); i++) {
//	            final char currentChar = commandsMessage.charAt(i);
//	            Object command = commandsList.stream()
//	                    .filter(each -> each.commandMessage == currentChar)
//	                    .findFirst()
//	                    .orElse(null);
//	            
//	            if (command != null) {
//	                ((Command) command).excecuteCommand(this);
//	            }
//	        }
	    	 for (char currentChar : commandsMessage.toCharArray()) {
	             Command command = Command.createCommand(currentChar);
	             if (command != null) {
	                 command.execute(this);
	             }
	         }
	    }
}