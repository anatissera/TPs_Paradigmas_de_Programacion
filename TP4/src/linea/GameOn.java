package linea;

public abstract class GameOn extends GameState{

    public static String notTurnErrorDescription;
    protected char actualPlayerChar;
    protected String actualPlayerColor;
    
    public GameOn( char newActualPlayerChar, String newActualPlayerColor, String errorMessage ) {
    	actualPlayerChar = newActualPlayerChar;
    	actualPlayerColor = newActualPlayerColor;
    	notTurnErrorDescription = errorMessage;
    	gameFinishedMessage = "";
    }
    
    @Override
    public boolean isGameFinished() {
		return false;
	}
    
    @Override
    public GameState getWinner() {
    	return null;
    }
    
    @Override
    public char actualPlayerChar() {
    	return actualPlayerChar;
    }
    
    @Override
    public String actualPlayerColor() {
    	return actualPlayerColor;
    }
    
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

