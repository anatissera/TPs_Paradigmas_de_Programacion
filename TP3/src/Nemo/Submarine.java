package Nemo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Submarine {
	
	// ??

	    public Coordinates coordinates;
	    public Depth depth;
	    public Orientation orientation;

	    public Submarine() {
	        coordinates = new Coordinates(0, 0);
	        orientation = new OrientationNorth();
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
	        List<Command> commandsList = new ArrayList<>();
	        commandsList.addAll(List.of(new CommandDown(), new CommandUp(), new CommandForward(), new CommandRight(), new CommandLeft(), new CommandMissile()));
	        for (int i = 0; i < commandsMessage.length(); i++) {
	            final char currentChar = commandsMessage.charAt(i);
	            Object command = commandsList.stream()
	                    .filter(each -> each.commandMessage == currentChar)
	                    .findFirst()
	                    .orElse(null);
	            
	            if (command != null) {
	                ((Command) command).excecuteCommand(this);
	            }
	        }
	    }
}
