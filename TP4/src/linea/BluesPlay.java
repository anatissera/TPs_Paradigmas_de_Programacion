package linea;

public class BluesPlay extends GameInProcess {

    public BluesPlay(){
      super( 'O', "Azules", "Rojas" );
    }

    public GameInProcess playRed( Linea linea, int columna ) {
        throw new RuntimeException(notTurnErrorDescription);
    }

    public GameInProcess playBlue( Linea linea, int columna) {
    	linea.playAsLinea( columna );
    	return new RedsPlay();
    }

	public boolean isRedsTurn() {
		return false;
	}

	public boolean isBluesTurn() {
		return true;
	}

}