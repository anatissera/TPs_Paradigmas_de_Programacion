package Nemo;

public class IsOnSurface extends DepthState {
   
	private int z = 0;

	public int getZ() { return z; }

	public DepthState launchCapsule() {
		return null;
	}

	public DepthState moveDown() {
		return new IsOnImmersionLevel1();
	}

	public DepthState previousState() {
		return null;
	}

}
