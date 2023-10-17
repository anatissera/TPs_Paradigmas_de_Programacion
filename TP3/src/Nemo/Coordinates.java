package Nemo;

import java.util.Objects;

public class Coordinates {
	
	public int x;
	public int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

	public Coordinates getCoordinates(){
		return new Coordinates(x, y);
	}

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

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}

	@Override
	public boolean equals(Object obj) {
		 return obj != null && 
		      ( this == obj  || 
		       ( getClass() == obj.getClass() && 
		        ((Coordinates) obj).x == x &&
		        ((Coordinates) obj).y == y ) );
	}
	
}