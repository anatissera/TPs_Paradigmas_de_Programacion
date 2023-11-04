package linea;

import java.util.stream.IntStream;

public class TriumphA extends Triumph {
	
	public TriumphA() {
        super('A');
    }

    public boolean checkWin(Linea linea) {
        return checkVertical(linea) || checkHorizontal(linea);
    }

    private boolean checkVertical(Linea linea) {
        int base = linea.getBase();
        int height = linea.alturaMaxActual();

        return checkLineaVorH(linea, base, height - 3, 0, 1);
    }

    private boolean checkHorizontal(Linea linea) {
        int base = linea.getBase();
        int height = linea.alturaMaxActual();
        
        return checkLineaVorH(linea, base - 3, height, 1, 0);
    }
    
    private boolean checkLineaVorH(Linea linea, int baseLimit, int heightLimit, int deltaBase, int deltaHeight) {
    	
        return IntStream.range(0, baseLimit)
            .anyMatch(columna -> IntStream.range(0, heightLimit)
                .anyMatch(fila -> {
                    char ficha = linea.preguntarAt(columna, fila);
                    return IntStream.range(1, 4)
                        .allMatch(i -> ficha != ' ' && ficha == linea.preguntarAt(columna + i * deltaBase, fila + i * deltaHeight));
                }));
    }
    
}
