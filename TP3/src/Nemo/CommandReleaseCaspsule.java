package Nemo;

public class CommandReleaseCaspsule extends Command {
	
	public CommandReleaseCaspsule () {
		commandMessage = 'm';
	}
	
	public void execute(Submarine submarine) {
		submarine.depth.launchCapsule();
	}

}