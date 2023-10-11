package Nemo;

public class Coordinates {

	public static String NoSePuedeLanzarLaCapsula = "No se puede lanzar la cápsula por debajo del primer nivel de inmersión";
	public static String ComandoDesconocido = "Comando desconocido";
	
	public int x;
	public int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }
	
	public int getX() { return x; }
	public int getY() { return y; }

	  public void moveEast() {
	        x += 1;
	    }
	  public void moveWest() {
	        x -= 1;
	    }
	  public void moveNorth() {
	        y += 1;
	    }
	  public void moveSouth() {
	        y -= 1;
	    }
}


	
//	public Coordinates modify(String whereTo) {
//
//
//		for (int i = 0; i < whereTo.length(); i++) {
//			 char comando = whereTo.charAt(i);
//			 
//			if (comando == 'd') {
//				z -= 1;
//			}
//			else if (comando == 'u') {
//				if (z < 0) {
//					z += 1;
//				}	
//			}
//			else if (comando == 'l') {
//				if (direction.equals("North")) {
//					direction = "West";
//				}
//				else if (direction.equals("West")) {
//					direction = "South";
//				}
//				else if (direction.equals("South")) {
//					direction = "East";
//				}
//				else if (direction.equals("East")) {
//					direction = "North";
//				}
//				// conviene hacer una lista linkeada que vaya para adelante y para atrás
//			}
//			else if (comando == 'r') {
//				if (direction.equals("North")) {
//					direction = "East";
//				}
//				else if (direction.equals("East")) {
//					direction = "South";
//				}
//				else if (direction.equals("South")) {
//					direction = "West";
//				}
//				else if (direction.equals("West")) {
//					direction = "North";
//				}
//			}
//			else if (comando == 'f') {
//				if (direction.equals("North")) {
//					y += 1;
//				}
//				else if (direction.equals("East")) {
//					x += 1;
//				}
//				else if (direction.equals("South")) {
//					y -= 1;
//				}
//				else if (direction.equals("West")) {
//					x -= 1;
//				}
//			}
//			else if (comando == 'm') {
//				if (z < (-1)) {
//					throw new RuntimeException(NoSePuedeLanzarLaCapsula);
//				}
//			}
//
//
//		}
//		return null;
//
//
//	}
//	
//
//
//}
