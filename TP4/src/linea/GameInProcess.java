package linea;

public abstract class GameInProcess extends GameState{

    public static String notTurnErrorDescription = "No es turno";
    protected char actualPlayer;
    
    public char actualPlayer() {
    	return actualPlayer;
    }
    
    public boolean isGameFinished() {
		return true;
	}
    
    @Override
	public void play( Linea linea, int columna ) {
		linea.playAsLinea( columna );
		
	}
	
    public abstract GameInProcess playRed();
    public abstract GameInProcess playBlue();
    public abstract boolean isRedsTurn();
    public abstract boolean isBluesTurn();
}

