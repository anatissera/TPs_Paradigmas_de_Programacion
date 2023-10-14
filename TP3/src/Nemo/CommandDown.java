package Nemo;

public class CommandDown extends Command {

	public CommandDown () {
		commandMessage = 'd';
	}
	
//	public void excecuteCommand(Submarine submarine) {
//		submarine.depth.moveDown();
//	}

	protected void execute(Submarine submarine) {
		submarine.depth.moveDown();
	}

}
