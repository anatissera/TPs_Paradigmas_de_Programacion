package Nemo;

public class DownCommand extends Command {

	public DownCommand () {
		commandMessage = d;
	}
	
	public void excecuteCommand(Submarine submarine) {
		submarine.depth.moveDown();
	}

}
