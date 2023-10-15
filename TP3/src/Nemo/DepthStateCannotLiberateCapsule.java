package Nemo;

public class DepthStateCannotLiberateCapsule extends DepthState {
	
	private int z;
	
	public int getZ() { return z; }
	
	public DepthState launchCapsule() {
		throw new RuntimeException(CannotReleaseCapsule);
	}
	
    private final DepthState previousState;

    public DepthStateCannotLiberateCapsule(DepthState previousDoes, int z) {
        this.previousState = previousDoes;
        this.z = z;
    }

    public DepthState previousState() {
    	z +=1;
        return previousState;
    }

	public DepthState moveDown() {
		return new DepthStateCannotLiberateCapsule(this, z - 1);
	}
	
}
