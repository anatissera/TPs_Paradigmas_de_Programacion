package Nemo;

public abstract class Command {

	public char commandMessage;
	
	public static char d = 'd';
	public static char u = 'u';
	public static char l = 'l';
	public static char r = 'r';
	public static char f = 'f';
	public static char m = 'm';
	
	public Command(char commandMessage){
		this.commandMessage = commandMessage;
	}
	
	public abstract void excecuteCommand(Submarine submarine);
	
}