package Nemo;

public abstract class DepthState {

	    public abstract DepthState launchCapsule();
	    public abstract DepthState moveUp();
	    public abstract DepthState moveDown();
	    public abstract DepthState previousState();
	    public abstract int getZ();

}
