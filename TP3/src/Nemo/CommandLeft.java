package Nemo;

public class CommandLeft extends Command {
	
	public CommandLeft() {
		commandMessage = 'l';
	}
	
	public void execute(Submarine submarine) {
		submarine.orientation.turnLeft(submarine);
	}

}
