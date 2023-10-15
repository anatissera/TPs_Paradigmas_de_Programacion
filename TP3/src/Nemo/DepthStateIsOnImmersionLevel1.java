package Nemo;

public class DepthStateIsOnImmersionLevel1 extends DepthState{
	
	DepthStateIsOnImmersionLevel1(){
		z = -1;
	}
	
	public DepthState launchCapsule() {
		return null;
	}
	
	 public DepthState moveDown() {
		return new DepthStateCannotLiberateCapsule(this, z - 1);
	 }
	
	public DepthState previousState() {
		return new DepthStateIsOnSurface();
	}

}
