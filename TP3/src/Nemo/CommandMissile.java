package Nemo;

public class CommandMissile extends Command {

//	public static String MissileCommandMessage = "d";
	
	public CommandMissile () {
		commandMessage = m;
	}
	
	public void excecuteCommand(Submarine submarine) {
		submarine.depth.launchCapsule();
	}
}