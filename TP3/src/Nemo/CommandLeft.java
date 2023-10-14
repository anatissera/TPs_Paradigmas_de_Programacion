package Nemo;

public class CommandLeft extends Command {

//	public static char LeftCommandMessage = 'l';
	
	public CommandLeft() {
		commandMessage = l;
	}
	
	public void excecuteCommand(Submarine submarine) {
		submarine.orientation.turnLeft(submarine);
	}

}
