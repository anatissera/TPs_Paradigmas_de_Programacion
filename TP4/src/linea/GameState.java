package linea;

public abstract class GameState {
	
	protected String gameFinishedMessage;
	protected GameState winner;
	protected String actualPlayerColor;
	
	public abstract boolean isGameFinished();
	
	public abstract GameState playRed( Linea game, int columna );
	public abstract GameState playBlue( Linea game, int columna );

	public abstract boolean isRedsTurn();
	public abstract boolean isBluesTurn();

	public boolean equals(Object obj) {
        return obj.getClass() == this.getClass();
    }
	
//	Accessors
	
	public String getGameFinishedMessage() { return gameFinishedMessage; }
	public GameState getWinner() { return winner; }
	
}