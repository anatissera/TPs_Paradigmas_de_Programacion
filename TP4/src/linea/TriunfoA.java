package linea;

import java.util.stream.IntStream;

public class TriunfoA extends Triunfo {
	public TriunfoA() {
        super('A');
    }
// solo 4 en línea verticales u horizontales

    @Override
    public boolean checkWin(Linea linea) {
        return checkVertical(linea) || checkHorizontal(linea);
    }

    @Override
    public boolean checkDraw(Linea linea) {
        boolean isDraw = IntStream.range(0, linea.getBase())
            .allMatch(columna -> linea.ColumnIsFull(columna));

        return isDraw && !checkWin(linea);
    }

    private boolean checkVertical(Linea linea) {
        int base = linea.getBase();
        int altura = linea.alturaMaxActual();

        return IntStream.range(0, base)
            .anyMatch(columna -> IntStream.range(0, altura - 3)
                .anyMatch(fila -> {
                    char ficha = linea.preguntarAt(columna, fila);
                    return ficha != ' ' && ficha == linea.preguntarAt(columna, fila + 1) &&
                           ficha == linea.preguntarAt(columna, fila + 2) && ficha == linea.preguntarAt(columna, fila + 3);
                })
            );
    }

    private boolean checkHorizontal(Linea linea) {
        int base = linea.getBase();
        int altura = linea.alturaMaxActual();

        return IntStream.range(0, base - 3)
            .anyMatch(columna -> IntStream.range(0, altura)
                .anyMatch(fila -> {
                    char ficha = linea.preguntarAt(columna, fila);
                    return ficha != ' ' && ficha == linea.preguntarAt(columna + 1, fila) &&
                           ficha == linea.preguntarAt(columna + 2, fila) && ficha == linea.preguntarAt(columna + 3, fila);
                })
            );
    }
}
