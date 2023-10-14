package Nemo;

public class DownCommand extends Command {

	public DownCommand(char commandMessageChar) {
		super(d);
	}
	
	public void excecuteCommand(Submarine submarine) {
		submarine.depth.moveDown();
	}

}
