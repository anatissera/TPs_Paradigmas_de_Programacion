package linea;

public class GameOver extends GameState {
	
	public static String gameFinishedErrorDescription;
	
    public GameOver( String Message, String ErrorDescription ) {
        gameFinishedMessage = Message;
        gameFinishedErrorDescription = ErrorDescription;
        winner = null;
        actualPlayerColor = "";
    }
    
	@Override
    public boolean isGameFinished( ) { return true; }

	@Override
	public GameState playRed( Linea game, int columna ) {
		throw new RuntimeException( gameFinishedErrorDescription );
	}

	@Override
	public GameState playBlue( Linea game, int columna ) {
		throw new RuntimeException( gameFinishedErrorDescription );
	}

	@Override
	public boolean isRedsTurn() { return false; }
	@Override
	public boolean isBluesTurn() { return false; }
   
}