package Nemo;

public class DepthIsOnSurface extends DepthState {
   
	private int z = 0;

	public int getZ() { return z; }

	public DepthState launchCapsule() {
		return null;
	}

	public DepthState moveDown() {
		return new DepthIsOnImmersionLevel1();
	}

	public DepthState previousState() {
		return null;
	}

}
