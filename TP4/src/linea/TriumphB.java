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
		return checkDiagonals(linea, 1, 1);
	}

	private boolean checkDiagonalFromRightToLeft(Linea linea) {
		return checkDiagonals(linea, 1, -1);
	}
	
	private boolean checkDiagonals(Linea linea, int deltaColumn, int deltaRow) {
	    int columns = linea.getBase();
	    int rows = linea.maxHeight();

	    return IntStream.range(0, columns)
	        .anyMatch(column -> IntStream.range(0, rows)
	            .anyMatch(row -> {
	                char ficha = linea.preguntarAt(column, row);

	                return IntStream.range(1, 4)
	                    .allMatch(i -> ficha != ' ' && 
	                                   (column + i * deltaColumn < columns && column + i * deltaColumn >= 0) && 
	                                   (row + i * deltaRow < rows && row + i * deltaRow >= 0) && 
	                                   ficha == linea.preguntarAt(column + i * deltaColumn, row + i * deltaRow));
	            }));
	    
	}

//	 ¿cómo recorro las columnas?
//	 extiendo las columnas para que abarque todo el tablero para recorrer las columnas
//	 puedo recorrer el tablero de cualquier tamaño sin que el tamaño sea un problema
//	 a partir de la última ficha pienso un tablero con 8 posibilidades en una dirección y 8 en otra

}
