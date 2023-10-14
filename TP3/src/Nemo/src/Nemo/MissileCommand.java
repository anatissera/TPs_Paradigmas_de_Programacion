package Nemo;

public class MissileCommand extends Command {

//	public static String MissileCommandMessage = "d";
	
	public MissileCommand () {
		super(m);
	}
	
	public void excecuteCommand(Submarine submarine) {
		submarine.depth.launchCapsule();
	}
}