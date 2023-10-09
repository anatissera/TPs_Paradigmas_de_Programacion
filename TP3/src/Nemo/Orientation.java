package Nemo;

import java.util.Arrays;
import java.util.List;

public class Orientation {
	List<String> directions = Arrays.asList("North", "East", "South", "West");
	
	public String direction = directions.get(0);
	public String getDirection() { return direction; }
	
	public Orientation() {
	}
	
	public Orientation modify(String whereTo) {

		for (int i = 0; i < whereTo.length(); i++) {
			 char comando = whereTo.charAt(i);
			 
			 int currentIndex = directions.indexOf(direction);
			
			if (comando == 'l') {
				
				direction = directions.get((currentIndex -1 + 4) % 4);
			}
			
			if (comando == 'r') {
				direction = directions.get((currentIndex + 1 ) % 4);
			}
		}
		return null;
		}

	
	
}
