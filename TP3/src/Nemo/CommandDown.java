package Nemo;

public class CommandDown extends Command {

	public CommandDown () {
		commandMessage = d;
	}
	
	public void excecuteCommand(Submarine submarine) {
		submarine.depth.moveDown();
	}

}
