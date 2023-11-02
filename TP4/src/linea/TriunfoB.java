package linea;

import java.util.stream.IntStream;

public class TriunfoB  extends Triunfo{
	
	public TriunfoB() {
        super('B');    
    }

	public boolean checkWin(Linea linea) {
		return checkDiagonalFromLeftToRight(linea) || checkDiagonalFromRightToLeft(linea);
	}
	
	private boolean checkDiagonalFromLeftToRight(Linea linea) {
	    int columns = linea.getBase();
	    int rows = linea.alturaMaxActual();

	    return IntStream.range(0, columns)
	        .anyMatch(columna -> IntStream.range(0, rows)
	            .anyMatch(fila -> {
	                char ficha = linea.preguntarAt(columna, fila);
	                if (ficha == ' ') {return false;}

	                boolean diagonalGanadora = true;
	                for (int i = 1; i < 4; i++) {
	                    if (columna + i >= columns || fila + i >= rows || linea.preguntarAt(columna + i, fila + i) != ficha) {
	                        diagonalGanadora = false;
	                        break;}}
	                return diagonalGanadora;}));
	}

	private boolean checkDiagonalFromRightToLeft(Linea linea) {
	    int columns = linea.getBase();
	    int rows = linea.alturaMaxActual();

	    return IntStream.range(0, columns)
	        .anyMatch(columna -> IntStream.range(0, rows)
	            .anyMatch(fila -> {
	                char ficha = linea.preguntarAt(columna, fila);
	                if (ficha == ' ') {return false;}

	                boolean diagonalGanadora = true;
	                for (int i = 1; i < 4; i++) {
	                    if (columna + i >= columns || fila - i < 0 || linea.preguntarAt(columna + i, fila - i) != ficha) {
	                        diagonalGanadora = false;
	                        break;}}
	                return diagonalGanadora;}));
	}

// reveer por que la primera funciona, pero no la segunda (Son mas cortas)
//	private boolean checkDiagonalFromLeftToRight(Linea linea){ // NOMBRES PUEDEN SER INTERPRETADOS AL REVES
//	    int columns = linea.getBase();
//	    int rows = linea.alturaMaxActual();
//
//	    return IntStream.range(0, columns - 3)
//	        .anyMatch(columna -> IntStream.range(0, rows - 3)
//	            .anyMatch(fila -> {
//	                char ficha = linea.preguntarAt(columna, fila);
//	                return ficha != ' ' && ficha == linea.preguntarAt(columna + 1, fila + 1) &&
//	                       ficha == linea.preguntarAt(columna + 2, fila + 2) && ficha == linea.preguntarAt(columna + 3, fila + 3);}));
//	}
//
//	private boolean checkDiagonalFromRightToLeft(Linea linea){
//	    int columns = linea.getBase();
//	    int rows = linea.alturaMaxActual();
//
//	    return IntStream.range(0, columns - 3)
//	        .anyMatch(columna -> IntStream.range(0, rows - 3)
//	            .anyMatch(fila -> {
//	                char ficha = linea.preguntarAt(columna, fila);
//	                return ficha != ' ' && ficha == linea.preguntarAt(columna + 1, fila - 1) &&
//	                       ficha == linea.preguntarAt(columna + 2, fila - 2) && ficha == linea.preguntarAt(columna + 3, fila - 3);}));
//	}

//	 ¿cómo recorro las columnas?
//	 extiendo las columnas para que abarque todo el tablero para recorrer las columnas
//	 puedo recorrer el tablero de cualquier tamaño sin que el tamaño sea un problema
//	 a partir de la última ficha pienso un tablero con 8 posibilidades en una dirección y 8 en otra
//	 Podríamos: hacer recursiva la verificación diagonal
	
}
