package linea;

public class RedsPlay extends GameOn {

	public RedsPlay( ) {
		super( 'X', "Rojas" );
	}

	@Override
	public GameState playRed( Linea game, int columna ) {
		game.playAsLinea( columna );
		return returnDifferentGameState( game, new BluesPlay() );
	}

	@Override
	public GameState playBlue( Linea game, int columna ) {
		throw new RuntimeException(notTurnErrorDescription);
	}

	@Override
	public boolean isRedsTurn() {
		return true;
	}

	@Override
	public boolean isBluesTurn() {
		return false;
	}

}