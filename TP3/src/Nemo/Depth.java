package Nemo;

public abstract class Depth {
	public int z;
	public int getZ() { return z; }
	
		public abstract Depth moveUp();

	    public Depth moveDown() {
	        z -= 1;
			return null;
	    }
	    
	    public abstract Depth launchCapsule();

}
