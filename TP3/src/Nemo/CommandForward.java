package Nemo;

public class CommandForward extends Command {

//	private static char ForwardCommandMessage = 'f';

	public CommandForward () {
		commandMessage = f;
	}

	public void excecuteCommand(Submarine submarine) {
		submarine.orientation.moveForward(submarine.coordinates);
	}
}
