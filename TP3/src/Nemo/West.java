package Nemo;

public class West extends Orientation {
	@Override
	public Orientation turnLeft() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Orientation turnRight() {
		// TODO Auto-generated method stub
		return null;
	}

	  public Orientation moveForward(Coordinates coordinates) {
	        coordinates.moveWest();
			return null;
	    }


}
