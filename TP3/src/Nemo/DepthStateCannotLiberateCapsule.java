package Nemo;

public class DepthStateCannotLiberateCapsule extends DepthState {
	
	public DepthState launchCapsule() {
		throw new RuntimeException(CannotReleaseCapsule);
	}
	
    private final DepthState previousState;

    public DepthStateCannotLiberateCapsule(DepthState previousDoes, int z) {
        this.previousState = previousDoes;
        this.z = z;
    }

    public DepthState previousState() {
        return previousState;
    }

	public DepthState moveDown() {
		return new DepthStateCannotLiberateCapsule(this, z - 1);
	}
	
}
