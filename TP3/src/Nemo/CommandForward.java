package Nemo;

public class CommandForward extends Command {

	public CommandForward () {
		commandMessage = 'f';
	}

	public void execute(Submarine submarine) {
		submarine.orientation.moveForward(submarine);
	}
	
}
