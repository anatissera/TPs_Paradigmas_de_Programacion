package Nemo;

public abstract class Command {

	public char commandMessage;
	
	public static char d = 'd';
	public static char u = 'u';
	public static char l = 'l';
	public static char r = 'r';
	public static char f = 'f';
	public static char m = 'm';
	
//	public Command(char commandMessageChar){
//		this.commandMessage = commandMessageChar;
//	}
	
//	public abstract void excecuteCommand(Submarine submarine);

	protected abstract void excecuteCommand(Submarine submarine);
}