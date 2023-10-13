package Nemo;

public class DownCommand extends Command {

//	public static String DownCommandMessage = "d";
	
	public DownCommand (char commandMessage) {
		commandMessage = 'd';
	}
	
	public void excecuteCommand(Submarine submarine) {
		submarine.depth.moveDown();
	}

}
