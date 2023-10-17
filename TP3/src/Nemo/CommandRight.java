package Nemo;

public class CommandRight extends Command {

	public CommandRight() {
		commandMessage = 'r';
	}

	public void execute(Submarine submarine) {
		submarine.orientation.turnRight(submarine);
	}

}
