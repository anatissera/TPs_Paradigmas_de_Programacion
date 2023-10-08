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

//		- 'd' que le indica a Nemo descender una unidad.
//		- 'u' que le indica a Nemo ascender una unidad.
//		- 'l' que le indica a Nemo rotar 90 grados a izquierda.
//		- 'r' que le indica a Nemo rotar 90 grados a derecha.
//		- 'f' que le indica a Nemo avanzar una unidad.
//		- 'm' que le indica a Nemo liberar la cápsula.
		// la función puede recibir un string con una secuencia de comandos, por ejemplo "ddrffl" y debe ejecutarlos en orden.
		// "ddm" tira error porque no se puede lanzar la cápsula a menos de -1 metros de profundidad,
		// o sea solo se puede lanzar en la superficie (0) o el primer nivel de profundidad (-1).
		// "uuuu" no hace nada porque no se puede ascender más allá de la superficie.

		for (int= 0, i < whereTo.length(), i++){
			if (whereTo.equals("d")) {
				z -= 1;
			}
			if (whereTo.equals("u")) {
				z += 1;
			}
			if (whereTo.equals("l")) {
				if (direction.equals("North")) {
					direction = "West";
				}
				else if (direction.equals("West")) {
					direction = "South";
				}
				else if (direction.equals("South")) {
					direction = "East";
				}
				else if (direction.equals("East")) {
					direction = "North";
				}
			}
			if (whereTo.equals("r")) {
				if (direction.equals("North")) {
					direction = "East";
				}
				else if (direction.equals("East")) {
					direction = "South";
				}
				else if (direction.equals("South")) {
					direction = "West";
				}
				else if (direction.equals("West")) {
					direction = "North";
				}
			}
			if (whereTo.equals("f")) {
				if (direction.equals("North")) {
					y += 1;
				}
				else if (direction.equals("East")) {
					x += 1;
				}
				else if (direction.equals("South")) {
					y -= 1;
				}
				else if (direction.equals("West")) {
					x -= 1;
				}
				if (whereTo.equals("m")) {
					if (z < -1) {
						throw new RunTimeException("No se puede lanzar la cápsula por debajo del primer nivel de inmersión");
					}
					else {
						// lanzar la cápsula
						// no tiene ningún efecto detectable en el submarino.
						// ¿No hay que hacer nada?
					}
				}
		}

		}
		return null;

//		no hay problemas con sumergirse demasiado, tampoco pasa nada si le insistimos
//		en emerger cuando está en superficie.
//		la cápsula sólo se puede lanzar en superficie o en el primer nivel de inmersión.
//		En estos casos lanzar la cápsula no tiene ningún efecto detectable en el submarino.
//		Pero si se intenta liberar a mayor profundidad de lo permitido el submarino se destruye.

	}
	
	

}
