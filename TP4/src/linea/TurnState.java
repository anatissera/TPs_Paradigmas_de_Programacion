package linea;

public abstract class TurnState {
	
    private char actualPlayer;
    public static String notTurnErrorDescription = "No es turno";
	
	public abstract TurnState previousState();
	
    public abstract void redPlays();
    public abstract void bluePlays();

//   Accesors
    public char getJugadorActual() {
        return a;
    }

	
//    public char getJugadorActual() {
//        return jugadorActual;
//    }
//
//    public void alternarTurno() {
//        jugadorActual = (jugadorActual == 'X') ? '0' : 'X';
//    }
//	
//	public TurnState setTurno(char color) {
//		 jugadorActual = color;
//		 return this;
//	}

	// public boolean redsTurn() {
	//     return getTurno() == 'X';
	// }

	// public boolean bluesTurn() {
	//     return getTurno() == 'O';
	// }
	
//	public abstract void redPlays();
//	{
//		if( redsTurn() ) {	
//			setTurno('O');
//		}
//		else {
//			throw new RuntimeException (notTurnErrorDescription);
//		}
//	}
	
//	public abstract void bluePlays() ;
//	{
//		if( bluesTurn() ) {
//			setTurno('X');
//		}
//		else {
//			throw new RuntimeException (notTurnErrorDescription);
//		}
//	}


}

