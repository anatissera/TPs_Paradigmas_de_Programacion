package Nemo;

public class Submarine {
	
	public Coordinates coordinates;
	
//	public Orientation orientation;
	
	public Submarine  () {
		coordinates = new Coordinates();
	}
	
	public int getDepth() {
		return coordinates.getZ();
	}
	
	public int position_X() {
		return coordinates.getX();
	}
	
	public int position_Y() {
		return coordinates.getY();
	}
	
	public String getOrientation() {
		return coordinates.getDirection();
	}
	
	 public Submarine move(String whereTo) {
		coordinates.modify(whereTo); //¿cómo hacer para que se llame a coordinates y a orientation?
		return null;
		 
	 }
	 
 
}
