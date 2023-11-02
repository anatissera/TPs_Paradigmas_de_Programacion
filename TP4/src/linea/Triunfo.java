package linea;

import java.util.stream.IntStream;

public abstract class Triunfo {
    protected char key;

    public Triunfo(char aKey) {
        key = aKey;
    }

    public boolean applies(char varianteTriunfo) {
        return key == varianteTriunfo;
    }

    public abstract boolean checkWin(Linea linea);

    public boolean checkDraw(Linea linea) {
        boolean isDraw = IntStream.range(0, linea.getBase())
            .allMatch(columna -> linea.ColumnIsFull(columna));
        return isDraw && !checkWin(linea);
    }
}