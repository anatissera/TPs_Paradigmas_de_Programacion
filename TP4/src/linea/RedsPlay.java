package linea;

public class RedsPlay extends GameInProcess {

	public RedsPlay() {
		super( 'X', "Rojas" );
	}

	public GameInProcess playRed( Linea linea, int columna ) {
		linea.playAsLinea( columna );
		return new BluesPlay();
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