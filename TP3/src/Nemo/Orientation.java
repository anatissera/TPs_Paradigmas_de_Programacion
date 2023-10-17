package Nemo;

import java.util.Objects;

public abstract class Orientation {
	
	public abstract void turnRight(Submarine submarine);
	public abstract void turnLeft(Submarine submarine);
	public abstract void moveForward(Submarine submarine);
	
	@Override
	public int hashCode() {
	    return Objects.hash(getClass());
	}
	
	@Override
    public boolean equals(Object obj) {
		 return obj != null && 
				 ( this == obj  || 
			      ( getClass() == obj.getClass() &&
			      	getClass().equals( ((Orientation) obj).getClass() ) 
			      ) );
    }

}
