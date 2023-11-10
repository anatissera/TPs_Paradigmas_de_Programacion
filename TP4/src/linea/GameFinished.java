package linea;

public class GameFinished extends GameState {
	
	public static String gameHasFinishedErrorDescription = "El juego ha terminado";
	
	@Override
    public boolean isGameFinished( ) {
        return true;
    }

	@Override
	public GameState playRed(Linea game, int columna) {
		throw new RuntimeException( gameHasFinishedErrorDescription );
	}

	@Override
	public GameState playBlue(Linea game, int columna) {
		throw new RuntimeException( gameHasFinishedErrorDescription );
	}

	@Override
	protected boolean isRedsTurn() { return false; }

	@Override
	protected boolean isBluesTurn() { return false; }

	@Override
	protected char actualPlayerChar() { return ' '; }

	@Override
	protected String previousPlayerColor() { return ""; }

	@Override
	protected String actualPlayerColor() { return ""; }
	
}