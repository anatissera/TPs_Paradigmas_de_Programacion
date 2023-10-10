package Nemo;

public class Submarine {
	
//	public Coordinates coordinates;
//	
////	public Orientation orientation;
//	Orientation orientation = new North();
//	 
//	
//	public Submarine  () {
//		coordinates = new Coordinates();
//	}
//	
//	public int getDepth() {
//		return coordinates.getZ();
//	}
//	
//	public int position_X() {
//		return coordinates.getX();
//	}
//	
//	public int position_Y() {
//		return coordinates.getY();
//	}
//	
//	public String getOrientation() {
//		return coordinates.getDirection();
//	}
//	
//	 public Submarine move(String whereTo) {
////			for (int i = 0; i < whereTo.length(); i++) {
////				 char comando = whereTo.charAt(i);
////				 coordinates.modify(comando);
////			}
//		 //¿cómo hacer para que se llame a coordinates y a orientation?
//		 coordinates.modify(whereTo);
//		return null;
//		 
//	 }
//	 
////	 public abstract Submarine modify( String command );
//	 
	
//	    public Coordinates coordinates;
//	    Orientation orientation = new North();
//
//	    public Submarine() {
//	        coordinates = new Coordinates();
//	    }
//
//	    // Resto del código
//
//	    public void executeLeft() {
//	        orientation = orientation.turnLeft();
//	    }
//
//	    public void executeRight() {
//	        orientation = orientation.turnRight();
//	    }
//	    
//	    public void executeForward() {
//	        orientation = orientation.moveForward(coordinates);
//	    }
//	    public void executeDown() {
//	        orientation = coordinates.moveDown();
//	    }
//	    
//	    public void executeUp() {
//	        orientation = coordinates.moveUp();
//	    }
//	    
//	    public void executeLaunchCapsule() {
//	        orientation = coordinates.launchCapsule();
//	    }
	    
	    public Coordinates coordinates;
	    public Depth depth = new IsOnSurface();
	    public Orientation orientation = new North();

	    public Submarine() {
	        coordinates = new Coordinates(0, 0);
	    }

	    public void move(String commands) {
	        for (int i = 0; i < commands.length(); i++) {
	            char command = commands.charAt(i);
	            executeCommand(command);
	        }
	    }

	    private void executeCommand(char command) {
	        orientation.executeCommand(command, coordinates);
	    }

	    public int getDepth() {
	        return depth.getZ();
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

	    public void executeLeft() {
	        orientation = orientation.turnLeft();
	    }

	    public void executeRight() {
	        orientation = orientation.turnRight();
	    }

	    public void executeForward() {
	        orientation = orientation.moveForward(coordinates);
	    }

	    public void executeDown() {
	        orientation = coordinates.moveDown();
	    }

	    public void executeUp() {
	        orientation = coordinates.moveUp();
	    }

	    public void executeLaunchCapsule() {
	        orientation = coordinates.launchCapsule();
	    }

}
