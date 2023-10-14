package Nemo;

import java.util.ArrayList;
import java.util.List;

//public abstract class Command {
//
//	public char commandMessage;
//	
//	public static char d = 'd';
//	public static char u = 'u';
//	public static char l = 'l';
//	public static char r = 'r';
//	public static char f = 'f';
//	public static char m = 'm';
//	
////	public Command(char commandMessageChar){
////		this.commandMessage = commandMessageChar;
////	}
//	
////	public abstract void excecuteCommand(Submarine submarine);
//
//	protected abstract void executeCommand(Submarine submarine);
	
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
	            .filter(command -> command.getCommandMessage() == commandChar)
	            .findFirst()
	            .orElse(null);
	    }

	    protected char getCommandMessage() {
	        return commandMessage;
	    }
	    protected abstract void execute(Submarine submarine);
	    
	}

//}