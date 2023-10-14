package Nemo;

public class CommandRight extends Command {

//	public static String RightCommandMessage = "r";
	
	public CommandRight() {
		commandMessage = r;
	}
	
	public void excecuteCommand(Submarine submarine) {
		submarine.orientation.turnRight(submarine);
	}

}
