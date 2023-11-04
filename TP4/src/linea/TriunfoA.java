package linea;

import java.util.stream.IntStream;

public class TriunfoA extends Triunfo {
	
	public TriunfoA() {
        super('A');
    }

    public boolean checkWin(Linea linea) {
        return checkVertical(linea) || checkHorizontal(linea);
    }

    private boolean checkVertical(Linea linea) {
        int base = linea.getBase();
        int height = linea.alturaMaxActual();

        return IntStream.range(0, base)
            .anyMatch(columna -> IntStream.range(0, height - 3)
                .anyMatch(fila -> {
                    char ficha = linea.preguntarAt(columna, fila);
                    return IntStream.range(1, 4)
                            .allMatch(i -> ficha != ' ' && ficha == linea.preguntarAt(columna, fila + i));
                }));
    }

    private boolean checkHorizontal(Linea linea) {
        int base = linea.getBase();
        int height = linea.alturaMaxActual();

        return IntStream.range(0, base - 3)
            .anyMatch(columna -> IntStream.range(0, height)
                .anyMatch(fila -> {
                    char ficha = linea.preguntarAt(columna, fila);
                    return IntStream.range(1, 4)
                            .allMatch(i -> ficha != ' ' && ficha == linea.preguntarAt(columna + i, fila));
                }));
    }
    
}
