package linea;

public abstract class GameState {
	
	public boolean isGameFinished( Linea linea ){
		return linea.finished();
	}
	
	public abstract GameState playRed(Linea linea, int columna);
	public abstract GameState playBlue(Linea linea, int columna);

	protected abstract boolean isRedsTurn();
	protected abstract boolean isBluesTurn();

	protected abstract char actualPlayerChar();
	protected abstract String actualPlayerColor();
	
	public abstract boolean isGameFinished();
	
}