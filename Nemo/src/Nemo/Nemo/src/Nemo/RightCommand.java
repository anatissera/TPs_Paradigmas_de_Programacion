package Nemo;

public class RightCommand extends Command {

//	public static String RightCommandMessage = "r";
	
	public RightCommand (char commandMessage) {
		commandMessage = 'r';
	}
	
	public void excecuteCommand(Submarine submarine) {
		submarine.orientation.turnRight(submarine);
	}

}
