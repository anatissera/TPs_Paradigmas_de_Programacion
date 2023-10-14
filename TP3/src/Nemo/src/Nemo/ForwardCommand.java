package Nemo;

public class ForwardCommand extends Command {

//	private static char ForwardCommandMessage = 'f';

	public ForwardCommand () {
		commandMessage = f;
	}

	public void excecuteCommand(Submarine submarine) {
		submarine.orientation.moveForward(submarine.coordinates);
	}
}
