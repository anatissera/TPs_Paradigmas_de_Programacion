package linea;

public class TriumphB  extends Triumph{
	
	public TriumphB() {
        super('B');    
    }

	public boolean checkWin(Linea linea) {
		return checkDiagonalFromLeftToRight(linea) || checkDiagonalFromRightToLeft(linea);
	}
	
	private boolean checkDiagonalFromLeftToRight(Linea linea) {
		return linea.checkConnected4(linea.getBase(), linea.maxHeight(), 1, 1, true);
	}

	private boolean checkDiagonalFromRightToLeft(Linea linea) {
		return linea.checkConnected4(linea.getBase(), linea.maxHeight(), 1, -1, true);
	}
	
//	 ¿cómo recorro las columnas?
//	 extiendo las columnas para que abarque todo el tablero para recorrer las columnas
//	 puedo recorrer el tablero de cualquier tamaño sin que el tamaño sea un problema
//	 a partir de la última ficha pienso un tablero con 8 posibilidades en una dirección y 8 en otra

}
