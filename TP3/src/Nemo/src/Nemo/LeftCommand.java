package Nemo;

public class LeftCommand extends Command {

//	public static char LeftCommandMessage = 'l';
	
	public LeftCommand() {
		commandMessage = l;
	}
	
	public void excecuteCommand(Submarine submarine) {
		submarine.orientation.turnLeft(submarine);
	}

}
