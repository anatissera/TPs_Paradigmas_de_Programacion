package Nemo;

public class ForwardCommand extends Command {

//	public static String ForwardCommandMessage = "f";

//	public ForwardCommand (char ) {
//		commandMessage = f;
//	}
	
	public ForwardCommand(char commandMessageChar) {
		super(f);
	}

	public void excecuteCommand(Submarine submarine) {
		submarine.orientation.moveForward(submarine.coordinates);
	}
}
