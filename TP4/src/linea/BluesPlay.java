package linea;

public class BluesPlay extends GameOn {

    public BluesPlay( ){
    	super( 'O', "Blues", "It's not Reds' turn!" );
    }

    @Override
    public GameOn playRed( Linea game, int columna ) {
        throw new RuntimeException(notTurnErrorDescription);
    }

    @Override
    public GameState playBlue( Linea game, int columna) {
    	game.playAsLinea( columna, actualPlayerChar );
    	return returnDifferentGameState( game, new RedsPlay() );
    }

    @Override
	public boolean isRedsTurn() { return false; }

    @Override
	public boolean isBluesTurn() { return true; }

}