package linea;

public class TriunfoB  extends Triunfo{
	public TriunfoB() {
        super('B');    
    }
	// solo 4 en línea diagonales.

	// ¿cómo recorro las columnas?
	// extiendo las columnas para que abarque todo el tablero para recorrer las columnas
	// puedo recorrer el tablero de cualquier tamaño sin que el tamaño sea un problema
	// a partir de la última ficha pienso un tablero con 8 posibilidades en una dirección y 8 en otra
	// Podríamos: hacer recursiva la verificación diagonal
	
}
