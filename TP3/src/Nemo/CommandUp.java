package Nemo;

public class CommandUp extends Command {

//	public static String UpCommandMessage = "u";
	
	public CommandUp() {
		commandMessage = u;
	}
	
	public void excecuteCommand(Submarine submarine) {
		submarine.depth.moveUp();
	}
}
