package linea;

public class Win extends GameOver{

	public Win( GameState winner ) {
		super( "\nLas " + winner.actualPlayerColor() +" ganan!" );
		this.winner = winner;
		gameFinishedErrorDescription = "El juego ha terminado.\nGanaron: las " + winner.actualPlayerColor() ;
	}
	
}