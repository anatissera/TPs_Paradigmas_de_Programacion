package linea;

public abstract class GameState {
	
	public abstract boolean isGameFinished();
	
	public abstract GameState playRed(Linea linea, int columna);
	public abstract GameState playBlue(Linea linea, int columna);

	protected abstract boolean isRedsTurn();
	protected abstract boolean isBluesTurn();

	protected abstract char actualPlayerChar();
	protected abstract String previousPlayerColor();
	
}