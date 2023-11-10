package linea;

public class BluesPlay extends GameInProcess {

    public BluesPlay( GameInProcess previousPlayer ){
      super( 'O', "Azules", previousPlayer );
    }

    @Override
    public GameInProcess playRed( Linea game, int columna ) {
        throw new RuntimeException(notTurnErrorDescription);
    }

    @Override
    public GameInProcess playBlue( Linea game, int columna) {
    	game.playAsLinea( columna );
    	return new RedsPlay( this );
    }

    @Override
	public boolean isRedsTurn() {
		return false;
	}

    @Override
	public boolean isBluesTurn() {
		return true;
	}

}