package Nemo;

public class LeftCommand extends Command {

//	public static char LeftCommandMessage = 'd';
	
	public LeftCommand (char commandMessage) {
		super(l);
	}
	
	public void excecuteCommand(Submarine submarine) {
		submarine.orientation.turnLeft(submarine);
	}

}
