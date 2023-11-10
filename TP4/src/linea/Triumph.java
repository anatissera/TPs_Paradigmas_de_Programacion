package linea;

import java.util.List;
import java.util.stream.IntStream;

public abstract class Triumph {
    protected char key;

    public Triumph(char aKey) {
        key = aKey;
    }

    public abstract boolean checkWin(Linea linea);
    
    public void SetWinOrDraw( Linea linea ) {
    	if ( checkWin( linea ) ) {
    		linea.setGameFinished( "Las " + linea.getTurn().actualPlayerColor() + " ganan" );
    	}
    	else if ( checkDraw(linea)) {
    		linea.setGameFinished( "Empate" );
    	}
    }
    

    public boolean checkDraw(Linea linea) {
        return (IntStream.range(0, linea.getBase())
            .allMatch(columna -> linea.ColumnIsFull(columna)) && !checkWin(linea)) ;
        
    }
    
    protected boolean applies(char varianteTriunfo) {
        return key == varianteTriunfo;
    }
    
    public static String NonValidStrategyVariant = "Variante de estrategia no válida";

	static public Triumph createTriumph(char varianteTriunfo) {
        return List.of(
            new TriumphA(),
            new TriumphB(),
            new TriumphC()
        ).stream()
        .filter(each -> each.applies(varianteTriunfo))
        .findFirst()
        .orElseThrow(() -> new RuntimeException(NonValidStrategyVariant));
    }
    
}