package Nemo;

public class UpCommand extends Command {

//	public static String UpCommandMessage = "u";
	
	public UpCommand() {
		commandMessage = u;
	}
	
	public void excecuteCommand(Submarine submarine) {
		submarine.depth.moveUp();
	}
}
