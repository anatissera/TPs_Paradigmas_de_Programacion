package linea;

import java.util.List;

public abstract class Triumph {
	 
    protected char key;
    private static String NonValidStrategyVariant = "Variante de estrategia no válida";

    public Triumph(char aKey) {
        key = aKey;
    }
    
    protected boolean applies(char varianteTriunfo) {
        return key == varianteTriunfo;
    }

	static public Triumph initializeTriumph(char varianteTriunfo) {
        return List.of(
            new TriumphA(),
            new TriumphB(),
            new TriumphC()
        ).stream()
        .filter(each -> each.applies(varianteTriunfo))
        .findFirst()
        .orElseThrow(() -> new RuntimeException( NonValidStrategyVariant ));
    }	

    public abstract boolean checkWin(Linea linea);  

    public boolean checkDraw(Linea linea) {
        return ( linea.allColumnsAreFull() && !checkWin(linea) ) ; 
    }
  
    public void SetWinOrDraw( Linea linea ) {
    	if ( checkWin( linea ) ) {
    		linea.setGameFinished( "\nLas " + linea.getTurn().previousPlayerColor() + " ganan!" );
    	}
    	else if ( checkDraw(linea) ) {
    		linea.setGameFinished( "\nEmpate!" );
    	}
    }
	    
}