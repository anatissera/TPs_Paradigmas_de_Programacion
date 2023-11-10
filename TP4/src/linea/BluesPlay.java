package linea;

public class BluesPlay extends GameInProcess {

    public BluesPlay( GameInProcess previousPlayer ){
      super( 'O', "Azules", previousPlayer );
    }

    public GameInProcess playRed( Linea linea, int columna ) {
        throw new RuntimeException(notTurnErrorDescription);
    }

    public GameInProcess playBlue( Linea linea, int columna) {
    	linea.playAsLinea( columna );
    	return new RedsPlay( this );
    }

	public boolean isRedsTurn() {
		return false;
	}

	public boolean isBluesTurn() {
		return true;
	}

}