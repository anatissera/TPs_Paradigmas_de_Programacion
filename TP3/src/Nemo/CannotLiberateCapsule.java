package Nemo;

public class CannotLiberateCapsule extends DepthState {
	public static String CannotLaunchCapsule = "No se puede lanzar la cápsula por debajo del primer nivel de inmersión";
	
	private int z;
	
	public int getZ() { return z; }
	
	public DepthState launchCapsule() {
		throw new RuntimeException(CannotLaunchCapsule);
	}
	
    private final DepthState previousState;

    public CannotLiberateCapsule(DepthState previousDoes, int z) {
        this.previousState = previousDoes;
        this.z = z;
    }

    public DepthState previousState() {
    	z +=1;
        return previousState;
    }

	public DepthState moveDown() {
		z -=1;
		return new CannotLiberateCapsule(this, z);
	}
	
}
