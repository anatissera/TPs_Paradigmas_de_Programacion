package Nemo;

public class UpCommand extends Command {

//	public static String UpCommandMessage = "u";
	
	public UpCommand(char commandMessageChar) {
		super(u);
	}
	
	public void excecuteCommand(Submarine submarine) {
		submarine.depth.moveUp();
	}
}
