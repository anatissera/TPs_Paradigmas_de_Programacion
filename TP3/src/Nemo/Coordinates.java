package Nemo;

public class Coordinates {
	public int x = 0;
	public int y = 0;
	public int z = 0;
	public String direction;
	
	public Coordinates() {
	}
	
	public int getX() { return x; }
	public int getY() { return y; }
	public int getZ() { return z; }
	public String getDirection() { return direction; }
	
	public Coordinates modify(String whereTo) {
	
		// puede ser 
		 if (whereTo == "d") {
			 this.z -= 1;
		 }
		 if (whereTo == "u") {
			 this.z += 1;
		 }
		 if (whereTo == "f") {
			 // si mira al norte mueve y +1
			 // si mira al sur mueuve  y -1
			 // si mira al este mueve x +1 
			 // si mira al oeste mueve x -1
			 if (this.direction == "North") {
				 this.y += 1;
			 }
			 if (this.direction == "South") {
				 this.y -= 1;
			 }
			 if (this.direction == "East") {
				 this.x += 1;
			 }
			 if (this.direction == "West") {
				 this.x -= 1;
			 }
		}
	 
		 if (whereTo == "l") {
			 this.direction = "West"; 
		 }
		 if (whereTo == "r") {
			 this.direction = "Este";
		 }
	
	
	return null;
	 
 }
	
	

}
