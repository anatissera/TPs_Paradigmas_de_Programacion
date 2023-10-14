package Nemo;

public class RightCommand extends Command {

//	public static String RightCommandMessage = "r";
	
	public RightCommand() {
		commandMessage = r;
	}
	
	public void excecuteCommand(Submarine submarine) {
		submarine.orientation.turnRight(submarine);
	}

}
