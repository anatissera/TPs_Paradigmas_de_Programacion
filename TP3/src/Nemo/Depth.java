package Nemo;

public class Depth {
	public int z;
	public int getZ() { return z; }
	
	public DepthState depthState = new CanLiberateCapsule();
	
    public void moveDown() {
        depthState = depthState.moveDown();
    }
	
    public void moveUp() {
        depthState = new CannotLiberateCapsule(depthState).moveUp(); // acá es donde quiero el anterior
    }




}
