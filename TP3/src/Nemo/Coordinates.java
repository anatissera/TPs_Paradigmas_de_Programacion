package Nemo;

public class Coordinates {
	
	public static int x;
	public static int y;

    public Coordinates(int x, int y) {
        Coordinates.x = x;
        Coordinates.y = y;
    }
	
	public int getX() { return x; }
	public int getY() { return y; }

	public Coordinates moveEast() {
		return new Coordinates(x + 1, y);
	}
	public Coordinates moveWest() {
		return new Coordinates(x - 1, y);
	}
	public Coordinates moveNorth() {
		return new Coordinates(x, y + 1);
	}
	public Coordinates moveSouth() {
		return new Coordinates(x, y - 1);
	}
}