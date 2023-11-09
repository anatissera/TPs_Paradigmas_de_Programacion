package linea;

public abstract class GameInProcess extends GameState{

    public static String notTurnErrorDescription = "No es turno";
    protected char actualPlayer;
    
    public GameInProcess(char NewActualPlayer) {
    	actualPlayer = NewActualPlayer;
    }
    
    public char actualPlayer() {
    	return actualPlayer;
    }
    
    public boolean isGameFinished() {
		return false;
	}
	
    public abstract GameInProcess playRed( Linea linea, int columna );
    public abstract GameInProcess playBlue( Linea linea, int columna );
    public abstract boolean isRedsTurn();
    public abstract boolean isBluesTurn();
}

