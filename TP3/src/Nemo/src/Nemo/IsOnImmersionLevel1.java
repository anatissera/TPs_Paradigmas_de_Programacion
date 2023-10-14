package Nemo;

public class IsOnImmersionLevel1 extends DepthState{
	
	private int z = -1;
	
	public int getZ() { return z; }
	
	public DepthState launchCapsule() {
		return null;
	}
	
	 public DepthState moveDown() {
		return new CannotLiberateCapsule(this, z - 1);
	 }
	
	public DepthState previousState() {
		return new IsOnSurface();
	}

}
