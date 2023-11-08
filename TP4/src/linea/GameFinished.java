package linea;

public class GameFinished extends GameState {
	public static String gameHasFinishedErrorDescription = "El juego ha terminado";
	
    public boolean isGameFinished(Linea linea) {
        return true;
    }

	public void play( Linea linea, int columna ) {
		throw new RuntimeException(gameHasFinishedErrorDescription);
		
	}
	
}