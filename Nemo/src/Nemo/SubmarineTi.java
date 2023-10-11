package Nemo;

public class Submarine {

	public Coordinates coordinates;
	public Orientation orientation = new North();
	
	public int positionX = coordinates.coordinateX;
	public int positionY = coordinates.coordinateY;
	public int positionZ = coordinates.coordinateZ;
	
	public Submarine(){
		coordinates = new Coordinates(0,0,0);
	}
	
//    public int getDepth() {
//        return coordinates.coordinateZ;
//    }
//
//    public int positionX() {
//        return coordinates.coordinateX;
//    }
//
//    public int positionY() {
//        return coordinates.coordinateY;
//    }

    public String getOrientation() {
        return orientation.cardinalPoint; // check
    }
}