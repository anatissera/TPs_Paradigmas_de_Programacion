package linea;

public class Win extends GameOver{

	public Win( GameState winner ) {
		super( "\nThe " + winner.actualPlayerColor + " win!" );
		this.winner = winner;
		gameFinishedErrorDescription = "The Game has finished.\nThe winner is: " + winner.actualPlayerColor;
	}
	
}