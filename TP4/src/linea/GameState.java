package linea;

public abstract class GameState {
	
	public boolean isGameFinished( Linea linea ){
		return true;
	}
	
	public abstract void play( Linea linea, int columna );
	
}