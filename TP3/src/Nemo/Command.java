package Nemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
	
	public abstract class Command {
		
	    public char commandMessage;

	    private static List<Command> commandsList = new ArrayList<>(Arrays.asList(
	    	    new CommandDown(),
	    	    new CommandUp(),
	    	    new CommandForward(),
	    	    new CommandRight(),
	    	    new CommandLeft(),
	    	    new CommandMissile()
	    	));
	    
	    public static Command createCommand(char commandChar) {
	        return commandsList.stream()
	            .filter(command -> command.commandMessage == commandChar)
	            .findFirst()
	            .orElse(null);
	    }
	    
	    protected abstract void execute(Submarine submarine);
	    
	}