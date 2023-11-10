package linea;

public abstract class GameInProcess extends GameState{

    public static String notTurnErrorDescription = "No es turno";
    protected char actualPlayerChar;
    protected String actualPlayerColor;
    
    public GameInProcess(char NewActualPlayerChar, String NewActualPlayerColor) {
    	actualPlayerChar = NewActualPlayerChar;
    	actualPlayerColor = NewActualPlayerColor;
    }
    
    public char actualPlayerChar() {
    	return actualPlayerChar;
    }
    
    public String actualPlayerColor() {
    	return actualPlayerColor;
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

