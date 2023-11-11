package linea;

public class GameOver extends GameState {
	
	public static String gameFinishedErrorDescription;
	protected GameState winner;

    public GameOver( String Message ) {
        gameFinishedMessage = Message;
        this.winner = null;
    }
    
	@Override
    public boolean isGameFinished( ) {
        return true;
    }
    
    @Override
    public String getGameFinishedMessage() {
    	return gameFinishedMessage;
    }
    
    @Override
    public GameState getWinner() {
    	return winner;
    }

	@Override
	public GameState playRed( Linea game, int columna ) {
		throw new RuntimeException( gameFinishedErrorDescription );
	}

	@Override
	public GameState playBlue( Linea game, int columna ) {
		throw new RuntimeException( gameFinishedErrorDescription );
	}

	@Override
	protected boolean isRedsTurn() { return false; }
	@Override
	protected boolean isBluesTurn() { return false; }
	@Override
	protected char actualPlayerChar() { return ' '; }
	@Override
	protected String actualPlayerColor() { return ""; }
	
}