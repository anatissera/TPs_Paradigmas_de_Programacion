package linea;

public abstract class GameOn extends GameState{

    public static String notTurnErrorDescription;
    protected char actualPlayerChar;
    
    public GameOn( char newActualPlayerChar, String newActualPlayerColor, String errorMessage ) {
    	actualPlayerChar = newActualPlayerChar;
    	actualPlayerColor = newActualPlayerColor;
    	notTurnErrorDescription = errorMessage;
    	gameFinishedMessage = "";
    	winner = null;
    }
    
    @Override
    public boolean isGameFinished() { return false; }
    
    @Override
    public abstract GameState playRed( Linea game, int columna );
    @Override
    public abstract GameState playBlue( Linea game, int columna );
    @Override
    public abstract boolean isRedsTurn();
    @Override
    public abstract boolean isBluesTurn();
    
    protected GameState returnDifferentGameState( Linea game, GameState playsNext ) {
		if ( game.checkWin() ){
			return new Win( this );
		}
		else if ( game.checkDraw() ) {
			return new Draw();
		}
		return playsNext;
    }
    
}

