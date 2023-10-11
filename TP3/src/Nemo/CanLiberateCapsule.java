package Nemo;

public class CanLiberateCapsule extends DepthState{
	
	 public CanLiberateCapsule depthState = new IsOnSurface();
	 
	 public CanLiberateCapsule moveDown() {
		 depthState = new IsNotOnSurface();
		return this;
	 }
	 
	 public CanLiberateCapsule moveUp() {
		 depthState = new IsOnSurface();
		return this;
	 }
	
	public DepthState launchCapsule() {
		return null;
	}
	
	public DepthState previousState() {
			return this.moveUp();
	}
	
}
