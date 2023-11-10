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

    public abstract boolean checkWin(Linea game);  

    public boolean checkDraw(Linea game) {
        return ( game.allColumnsAreFull() && !checkWin(game) ) ; 
    }
  
    public void SetWinOrDraw( Linea game ) {
    	if ( checkWin( game ) ) {
    		game.setGameFinished( "\nLas " + game.getTurn().previousPlayerColor() + " ganan!" );
    	}
    	else if ( checkDraw(game) ) {
    		game.setGameFinished( "\nEmpate!" );
    	}
    }
	    
}