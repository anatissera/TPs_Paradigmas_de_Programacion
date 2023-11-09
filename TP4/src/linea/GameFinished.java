package linea;

public class GameFinished extends GameState {
	public static String gameHasFinishedErrorDescription = "El juego ha terminado";
	
    public boolean isGameFinished( Linea linea ) {
        return linea.finished();
    }

	@Override
	public GameState playRed(Linea linea, int columna) {
		throw new RuntimeException( gameHasFinishedErrorDescription );
	}

	@Override
	public GameState playBlue(Linea linea, int columna) {
		throw new RuntimeException( gameHasFinishedErrorDescription );
	}

	@Override
	protected boolean isRedsTurn() { return false; }

	@Override
	protected boolean isBluesTurn() { return false; }

	@Override
	protected char actualPlayer() { return ' '; }
	
}