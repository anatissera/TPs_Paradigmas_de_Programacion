package Nemo;

public class CommandDown extends Command {

	public CommandDown () {
		commandMessage = 'd';
	}

	public void execute(Submarine submarine) {
		submarine.depth.moveDown();
	}
}