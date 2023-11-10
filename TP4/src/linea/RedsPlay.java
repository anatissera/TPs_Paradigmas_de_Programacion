package linea;

public class RedsPlay extends GameInProcess {

	public RedsPlay( GameInProcess previousPlayer ) {
		super( 'X', "Rojas", previousPlayer );
	}

	public GameInProcess playRed( Linea linea, int columna ) {
		linea.playAsLinea( columna );
		return new BluesPlay( this );
	}

	public GameInProcess playBlue( Linea linea, int columna ) {
		throw new RuntimeException(notTurnErrorDescription);
	}

	public boolean isRedsTurn() {
		return true;
	}

	public boolean isBluesTurn() {
		return false;
	}


}