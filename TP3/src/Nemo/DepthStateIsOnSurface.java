package Nemo;

public class DepthStateIsOnSurface extends DepthState {
   
	private int z = 0;

	public int getZ() { return z; }

	public DepthState launchCapsule() {
		return null;
	}

	public DepthState moveDown() {
		return new DepthStateIsOnImmersionLevel1();
	}

	public DepthState previousState() {
		return this;
	}

}
