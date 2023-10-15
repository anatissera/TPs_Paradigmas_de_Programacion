package Nemo;

public class Coordinates {
	
	public int x;
	public int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }
	
	public int getX() { return x; }
	public int getY() { return y; }

//	  public void moveEast() {
//	        x += 1;
//	    }
//	  public void moveWest() {
//	        x -= 1;
//	    }
//	  public void moveNorth() {
//	        y += 1;
//	    }
//	  public void moveSouth() {
//	        y -= 1;
//	    }

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
