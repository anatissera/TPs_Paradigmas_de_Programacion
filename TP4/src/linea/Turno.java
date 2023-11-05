package linea;

public class Turno {
	
    private char jugadorActual;
    public static String notTurnErrorDescription = "No es turno";

    public char getJugadorActual() {
        return jugadorActual;
    }

    public void alternarTurno() {
        jugadorActual = (jugadorActual == 'X') ? '0' : 'X';
    }
	
	public Turno setTurno(char color) {
		 jugadorActual = color;
		 return this;
	}

	public boolean redsTurn() {
	    return getTurno() == 'X';
	}

	public boolean bluesTurn() {
	    return getTurno() == 'O';
	}

	public void redPlays() {
		if( redsTurn() ) {	
			setTurno('O');
		}
		else {
			throw new RuntimeException (notTurnErrorDescription);
		}
	}
	
	public void bluePlays() {
		if( bluesTurn() ) {
			setTurno('X');
		}
		else {
			throw new RuntimeException (notTurnErrorDescription);
		}
	}
	
	
	//Accesors
	
	private char getTurno() {
		return jugadorActual;	
	}
	

}

