package linea;

public abstract class GameState {
	
	protected String gameFinishedMessage;
	
	public abstract boolean isGameFinished();
	
	public abstract GameState playRed(Linea game, int columna);
	public abstract GameState playBlue(Linea game, int columna);

	protected abstract boolean isRedsTurn();
	protected abstract boolean isBluesTurn();

	protected abstract char actualPlayerChar();
	protected abstract String actualPlayerColor();

	public String getGameFinishedMessage() {
		return gameFinishedMessage;
	}
	public abstract GameState getWinner();
	
}