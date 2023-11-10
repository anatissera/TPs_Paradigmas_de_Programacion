package linea;

public abstract class GameInProcess extends GameState{

    public static String notTurnErrorDescription = "No es turno";
    protected char actualPlayerChar;
    protected String previousPlayerColor;
    protected String actualPlayerColor;
    
    public GameInProcess( char NewActualPlayerChar, String NewActualPlayerColor, String previousPlayerColor ) {
    	actualPlayerChar = NewActualPlayerChar;
    	actualPlayerColor = NewActualPlayerColor;
    	this.previousPlayerColor = previousPlayerColor;
    }
    
    @Override
    public char actualPlayerChar() {
    	return actualPlayerChar;
    }
    
    @Override
    public String previousPlayerColor() {
    	return previousPlayerColor;
    }
    
    @Override
    public boolean isGameFinished() {
		return false;
	}
	
    public abstract GameInProcess playRed( Linea linea, int columna );
    public abstract GameInProcess playBlue( Linea linea, int columna );
    public abstract boolean isRedsTurn();
    public abstract boolean isBluesTurn();
}

