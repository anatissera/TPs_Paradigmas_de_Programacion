package Nemo;

public class CannotLiberateCapsule extends Depth {
	  public Depth launchCapsule() {
	        throw new RuntimeException("No se puede lanzar la cápsula por debajo del primer nivel de inmersión");
	    }

	public Depth moveUp() {
		z += 1;
		return null;
	}

}
