package Nemo;

public class MissileCommand extends Command {

//	public static String MissileCommandMessage = "d";
	
	public MissileCommand (char commandMessage) {
		commandMessage = 'm';
	}
	
	public void excecuteCommand(Submarine submarine) {
		submarine.depth.launchCapsule();
	}
}