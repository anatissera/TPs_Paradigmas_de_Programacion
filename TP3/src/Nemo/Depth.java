package Nemo;

public class Depth {
	public int getZ() { return depthState.getZ(); }
	
	public DepthState depthState = new IsOnSurface();
	
    public void moveDown() {
        depthState = depthState.moveDown();
    }
	
    public void moveUp() {
        depthState = depthState.previousState();
    }

	public void launchCapsule() {
		depthState.launchCapsule();
	}

}
