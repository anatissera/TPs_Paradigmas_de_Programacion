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
//			for (int i = 0; i < whereTo.length(); i++) {
//				 char comando = whereTo.charAt(i);
//				 coordinates.modify(comando);
//			}
		 //¿cómo hacer para que se llame a coordinates y a orientation?
		 coordinates.modify(whereTo);
		return null;
		 
	 }
	 
//	 public abstract Submarine modify( String command );
	 
 
}
