package linea;

import java.util.List;

public abstract class Mode {
	 
    protected char key;
    public static String InvalidStrategyVariant = "Invalid Strategy Variant. Must be A, B or C.";

    public Mode( char aKey ) {
        key = aKey;
    }
    
    protected boolean applies( char triumphVariant ) {
        return key == triumphVariant;
    }

	static public Mode initializeTriumphMode( char triumphVariant ) {
        return List.of(
            new ModeA(),
            new ModeB(),
            new ModeC()
        ).stream()
        .filter( each -> each.applies(triumphVariant) )
        .findFirst()
        .orElseThrow(() -> new RuntimeException( InvalidStrategyVariant ));
    }	

    public abstract boolean checkWin( Linea game );  

    public boolean checkDraw( Linea game ) {
        return ( game.allColumnsAreFull() && !checkWin(game) ) ; 
    }
	    
}