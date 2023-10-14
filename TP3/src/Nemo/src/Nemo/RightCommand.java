package Nemo;

public class RightCommand extends Command {

//	public static String RightCommandMessage = "r";
	
	public RightCommand () {
		super(r);
	}
	
	public void excecuteCommand(Submarine submarine) {
		submarine.orientation.turnRight(submarine);
	}

}
