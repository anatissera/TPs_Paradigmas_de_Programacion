package Nemo;

public class ForwardCommand extends Command {

//	public static String ForwardCommandMessage = "f";

	public ForwardCommand () {
		super (m);
	}
	
	public void excecuteCommand(Submarine submarine) {
		submarine.orientation.moveForward(submarine.coordinates);
	}
}
