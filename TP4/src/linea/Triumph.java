package linea;

import java.util.stream.IntStream;

public abstract class Triumph {
    protected char key;

    public Triumph(char aKey) {
        key = aKey;
    }

    public boolean applies(char varianteTriunfo) {
        return key == varianteTriunfo;
    }

    public abstract boolean checkWin(Linea linea);

    public boolean checkDraw(Linea linea) {
    	
        return (linea.getBase() < 4 && linea.getHeight() < 4) || (IntStream.range(0, linea.getBase())
            .allMatch(columna -> linea.ColumnIsFull(columna)) && !checkWin(linea)) ;
        
    }
    
}