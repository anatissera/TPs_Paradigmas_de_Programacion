package linea;

import java.util.List;

public abstract class Mode {
	 
    protected char key;
    public static String InvalidStrategyVariant = "Variante de estrategia no válida";

    public Mode(char aKey) {
        key = aKey;
    }
    
    protected boolean applies(char varianteTriunfo) {
        return key == varianteTriunfo;
    }

	static public Mode initializeTriumphMode(char varianteTriunfo) {
        return List.of(
            new ModeA(),
            new ModeB(),
            new ModeC()
        ).stream()
        .filter(each -> each.applies(varianteTriunfo))
        .findFirst()
        .orElseThrow(() -> new RuntimeException( InvalidStrategyVariant ));
    }	

    public abstract boolean checkWin(Linea game);  

    public boolean checkDraw(Linea game) {
        return ( game.allColumnsAreFull() && !checkWin(game) ) ; 
    }
	    
}