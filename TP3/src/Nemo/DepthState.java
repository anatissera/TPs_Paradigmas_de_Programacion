package Nemo;

public abstract class DepthState {
		
	 	protected int z;
	 	public abstract int getZ();
	    public abstract DepthState launchCapsule();
	    public abstract DepthState moveDown();
	    public abstract DepthState previousState();
	   

}
