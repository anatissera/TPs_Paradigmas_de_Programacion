package Nemo;

public class DepthIsOnImmersionLevel1 extends DepthState{
	
	private int z = -1;
	
	public int getZ() { return z; }
	
	public DepthState launchCapsule() {
		return null;
	}
	
	 public DepthState moveDown() {
		return new DepthCannotLiberateCapsule(this, z - 1);
	 }
	
	public DepthState previousState() {
		return new DepthIsOnSurface();
	}

}
