package linea;

import java.util.stream.IntStream;

public class TriumphB  extends Triumph{
	
	public TriumphB() {
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
	               
			    return IntStream.range(1, 4)
		                .allMatch(i -> ficha != ' ' && ( columna + i < columns || fila + i < rows && ficha == linea.preguntarAt(columna + i , fila + i )) );
			    
	    }));
	}

	private boolean checkDiagonalFromRightToLeft(Linea linea) {
	    int columns = linea.getBase();
	    int rows = linea.alturaMaxActual();

	    return IntStream.range(0, columns)
	        .anyMatch(columna -> IntStream.range(0, rows)
	            .anyMatch(fila -> {
	                char ficha = linea.preguntarAt(columna, fila);
	              
			    return IntStream.range(1, 4)
		                .allMatch(i -> ficha != ' ' && ( columna + i < columns || fila - i >= 0 && ficha == linea.preguntarAt(columna + i , fila - i )) );
			    
		}));
	}

//	 ¿cómo recorro las columnas?
//	 extiendo las columnas para que abarque todo el tablero para recorrer las columnas
//	 puedo recorrer el tablero de cualquier tamaño sin que el tamaño sea un problema
//	 a partir de la última ficha pienso un tablero con 8 posibilidades en una dirección y 8 en otra
//	 Podríamos: hacer recursiva la verificación diagonal
	
}
