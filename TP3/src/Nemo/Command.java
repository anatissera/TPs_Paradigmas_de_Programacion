package Nemo;

import java.util.ArrayList;
import java.util.List;
	
	public abstract class Command {
		
	    public char commandMessage;

	    private static List<Command> commandsList = new ArrayList<>();

	    static {
	        commandsList.add(new CommandDown());
	        commandsList.add(new CommandUp());
	        commandsList.add(new CommandForward());
	        commandsList.add(new CommandRight());
	        commandsList.add(new CommandLeft());
	        commandsList.add(new CommandMissile());
	    }

	    public static Command createCommand(char commandChar) {
	        return commandsList.stream()
	            .filter(command -> command.commandMessage == commandChar)
	            .findFirst()
	            .orElse(null);
	    }

//	    protected char getCommandMessage() {
//	        return commandMessage;
//	    }
	    
	    protected abstract void execute(Submarine submarine);
	    
	}