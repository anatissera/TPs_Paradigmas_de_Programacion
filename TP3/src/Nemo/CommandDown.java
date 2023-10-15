package Nemo;

public class CommandDown extends Command {

	public CommandDown () {
		commandMessage = 'd';
	}

	protected void execute(Submarine submarine) {
		submarine.depth.moveDown();
	}
}
