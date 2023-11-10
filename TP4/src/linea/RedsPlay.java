package linea;

public class RedsPlay extends GameInProcess {

	public RedsPlay( GameInProcess previousPlayer ) {
		super( 'X', "Rojas", previousPlayer );
	}

	@Override
	public GameInProcess playRed( Linea game, int columna ) {
		game.playAsLinea( columna );
		return new BluesPlay( this );
	}

	@Override
	public GameInProcess playBlue( Linea game, int columna ) {
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