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
