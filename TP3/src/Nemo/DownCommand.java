package Nemo;

public class DownCommand extends Command {

	
	public DownCommand () {
		super(d);
		
	}
	
	public void excecuteCommand(Submarine submarine) {
		submarine.depth.moveDown();
	}

}
