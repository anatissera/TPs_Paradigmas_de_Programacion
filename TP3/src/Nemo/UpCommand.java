package Nemo;

public class UpCommand extends Command {

//	public static String UpCommandMessage = "u";
	
	public UpCommand (char commandMessage) {
		commandMessage = 'u';
	}
	
//	public void excecuteCommand(char UpCommandMessage, Submarine submarine) {
//		submarine.coordinates = new Coordinates (submarine.positionX, submarine.positionY, submarine.positionZ+1);
//	}
	
	public void excecuteCommand(Submarine submarine) {
		submarine.depth.moveUp();
	}

}
