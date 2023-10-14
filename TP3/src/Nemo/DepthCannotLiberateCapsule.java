package Nemo;

public class DepthCannotLiberateCapsule extends DepthState {
	
	private int z;
	
	public int getZ() { return z; }
	
	public DepthState launchCapsule() {
		throw new RuntimeException(CannotReleaseCapsule);
	}
	
    private final DepthState previousState;

    public DepthCannotLiberateCapsule(DepthState previousDoes, int z) {
        this.previousState = previousDoes;
        this.z = z;
    }

    public DepthState previousState() {
    	z +=1;
        return previousState;
    }

	public DepthState moveDown() {
		z -=1;
		return new DepthCannotLiberateCapsule(this, z);
	}
	
}
