package Nemo;

public class CommandUp extends Command {
	
	public CommandUp() {
		commandMessage = 'u';
	}

	public void execute(Submarine submarine) {
		submarine.depth.moveUp();
	}

}
