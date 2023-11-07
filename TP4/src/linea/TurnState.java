package linea;

public abstract class TurnState {
	
    public char actualPlayer;
    public static String notTurnErrorDescription = "No es turno";

    public TurnState(char initialPlayer) {
        actualPlayer = initialPlayer;
    }

//	public abstract TurnState previousState();
	
    public abstract void redPlays();
    public abstract void bluePlays();

//   Accesors
    public char getJugadorActual() {
        return actualPlayer;
    }
}

