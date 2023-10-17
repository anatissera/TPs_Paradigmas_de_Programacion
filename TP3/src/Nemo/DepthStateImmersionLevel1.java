package Nemo;

public class DepthStateImmersionLevel1 extends DepthState{
	
	DepthStateImmersionLevel1(){
		z = -1;
	}
	
	public DepthState launchCapsule() {
		return null;
	}
	
	 public DepthState moveDown() {
		return new DepthStateCannotLiberateCapsule(this, z - 1);
	 }
	
	public DepthState previousState() {
		return new DepthStateSurface();
	}

}
