package linea;

public class Win extends GameOver{

	public Win( GameState winner ) {
		super( "\nThe " + winner.actualPlayerColor + " win!", "The Game has finished.\nThe winner is: " + winner.actualPlayerColor );
		this.winner = winner;
	}
	
}