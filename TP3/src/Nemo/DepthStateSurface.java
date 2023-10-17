package Nemo;

public class DepthStateSurface extends DepthState {
	
	DepthStateSurface(){
		z = 0;
	}

	public DepthState launchCapsule() {
		return null;
	}

	public DepthState moveDown() {
		return new DepthStateImmersionLevel1();
	}

	public DepthState previousState() {
		return this;
	}

}
