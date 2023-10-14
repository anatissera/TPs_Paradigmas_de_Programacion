package Nemo;

public abstract class Command {

	public char commandMessage;
	
	public Command(){}
	
	public abstract void excecuteCommand(Submarine submarine);
}
