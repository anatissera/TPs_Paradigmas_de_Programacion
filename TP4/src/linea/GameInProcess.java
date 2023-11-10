package linea;

public abstract class GameInProcess extends GameState{

    public static String notTurnErrorDescription = "No es turno";
    protected char actualPlayerChar;
    protected String actualPlayerColor;
    protected GameInProcess previousPlayer;
    
    public GameInProcess( char NewActualPlayerChar, String NewActualPlayerColor, GameInProcess previousPlayer ) {
    	actualPlayerChar = NewActualPlayerChar;
    	actualPlayerColor = NewActualPlayerColor;
    	this.previousPlayer = previousPlayer;
    }
    
    @Override
    public boolean isGameFinished() {
		return false;
	}
    
    @Override
    public char actualPlayerChar() {
    	return actualPlayerChar;
    }
    
    private String actualPlayerColor() {
    	return actualPlayerColor;
    }
    
    @Override
    public String previousPlayerColor() {
    	return previousPlayer.actualPlayerColor();
    }
    
    public abstract GameInProcess playRed( Linea linea, int columna );
    public abstract GameInProcess playBlue( Linea linea, int columna );
    public abstract boolean isRedsTurn();
    public abstract boolean isBluesTurn();
}

