package Nemo;

public class DepthStateIsOnSurface extends DepthState {
	
	DepthStateIsOnSurface(){
		z = 0;
	}

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
