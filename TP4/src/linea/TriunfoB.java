package linea;

import java.util.stream.IntStream;

public class TriunfoB  extends Triunfo{
	public TriunfoB() {
        super('B');    
    }
	// solo 4 en línea diagonales.

	public boolean checkWin(Linea linea) {
		return checkDiagonalFromLeftToRight(linea) || checkDiagonalFromRightToLeft(linea);
	}
	
//	private boolean checkDiagonalFromLeftToRight(Linea linea){
//		return false;
////		int columns = linea.getBase();
////		int rows = linea.alturaMaxActual();
////		int requiredCount = 4;
////		
////	    return IntStream.range(0, rows - requiredCount + 1)
////	        .boxed()
////	        .flatMap(r -> IntStream.range(0, columns - requiredCount + 1)
////	            .mapToObj(c -> IntStream.range(0, requiredCount)
////	                .mapToObj(i -> board.get(r + i).get(c + i)))
////	            .filter(diagonal -> diagonal.allMatch(value -> value == player))
////	            .map(diagonal -> diagonal))
////	        .findAny()
////	        .isPresent();
//		
//}
//	
//	private boolean checkDiagonalFromRightToLeft(Linea linea){
//		return false;
//		
//	}
//	
	private boolean checkDiagonalFromLeftToRight(Linea linea) {
	    int base = linea.getBase();
	    int altura = linea.alturaMaxActual();

	    return IntStream.range(0, base - 3)
	        .anyMatch(columna -> IntStream.range(0, altura - 3)
	            .anyMatch(fila -> {
	                char ficha = linea.preguntarAt(columna, fila);
	                return ficha != ' ' && ficha == linea.preguntarAt(columna + 1, fila + 1) &&
	                       ficha == linea.preguntarAt(columna + 2, fila + 2) && ficha == linea.preguntarAt(columna + 3, fila + 3);
	            })
	        );
	}

	private boolean checkDiagonalFromRightToLeft(Linea linea) {
	    int base = linea.getBase();
	    int altura = linea.alturaMaxActual();

	    return IntStream.range(0, base - 3)
	        .anyMatch(columna -> IntStream.range(3, altura)
	            .anyMatch(fila -> {
	                char ficha = linea.preguntarAt(columna, fila);
	                return ficha != ' ' && ficha == linea.preguntarAt(columna + 1, fila - 1) &&
	                       ficha == linea.preguntarAt(columna + 2, fila - 2) && ficha == linea.preguntarAt(columna + 3, fila - 3);
	            })
	        );
	}
	
//	private boolean checkDiagonalFromLeftToRight(Linea linea) {
//	    int base = linea.getBase();
//	    int altura = linea.alturaMaxActual();
//
//	    return IntStream.range(0, base - 3)
//	        .anyMatch(columna -> IntStream.range(0, altura - 3)
//	            .anyMatch(fila -> {
//	                char ficha = linea.preguntarAt(columna, fila);
//	                return ficha != ' ' && ficha == linea.preguntarAt(columna + 1, fila + 1) &&
//	                       ficha == linea.preguntarAt(columna + 2, fila + 2) &&
//	                       ficha == linea.preguntarAt(columna + 3, fila + 3);
//	            })
//	        );
//	}
//
//	private boolean checkDiagonalFromRightToLeft(Linea linea) {
//	    int base = linea.getBase();
//	    int altura = linea.alturaMaxActual();
//
//	    return IntStream.range(3, base)
//	        .anyMatch(columna -> IntStream.range(0, altura - 3)
//	            .anyMatch(fila -> {
//	                char ficha = linea.preguntarAt(columna, fila);
//	                return ficha != ' ' && ficha == linea.preguntarAt(columna - 1, fila + 1) &&
//	                       ficha == linea.preguntarAt(columna - 2, fila + 2) &&
//	                       ficha == linea.preguntarAt(columna - 3, fila + 3);
//	            })
//	        );
//	}
//	 ¿cómo recorro las columnas?
//	 extiendo las columnas para que abarque todo el tablero para recorrer las columnas
//	 puedo recorrer el tablero de cualquier tamaño sin que el tamaño sea un problema
//	 a partir de la última ficha pienso un tablero con 8 posibilidades en una dirección y 8 en otra
//	 Podríamos: hacer recursiva la verificación diagonal
	
}
