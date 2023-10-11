package Nemo;

public class Depth {
	public int getZ() { return DepthState.getZ(); }
	
	public DepthState depthState = new CanLiberateCapsule();
	
    public void moveDown() {
        depthState = depthState.moveDown();
    }
	
    public void moveUp() {
        depthState = new CannotLiberateCapsule(depthState).moveUp(); // acá es donde quiero el anterior
    }

	public void launchCapsule() {
		depthState.launchCapsule();
	}

}
