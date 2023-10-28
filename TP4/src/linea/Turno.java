package linea;

//import java.util.ArrayList;

public class Turno {
    private char jugadorActual;

    public Turno(char color) {
        jugadorActual = color;
    }

    public char getJugadorActual() {
        return jugadorActual;
    }

    public void alternarTurno() {
        jugadorActual = (jugadorActual == 'R') ? 'A' : 'R'; // cambia el turno entre Rojas y Azules ??? .
    }

    
//	public String NoEsTurnoErrorDescription = "No es turno";
//	
//	private ArrayList<Ficha> cartasDeManoDisponibles;
//	private ArrayList<Ficha> cartasDePieDisponibles;
//	private ArrayList<Ficha> cartasDeManoJugadas;
//	private ArrayList<Ficha> cartasDePieJugadas;
//	
//	private String turno;
//	
//	public Ronda with(ArrayList<Ficha> cartasDeMano, ArrayList<Ficha> cartasDePie) {
//		cartasDeManoDisponibles = cartasDeMano;
//		cartasDePieDisponibles = cartasDePie;
//		cartasDeManoJugadas = new ArrayList<Ficha>();
//		cartasDePieJugadas = new ArrayList<Ficha>();
//		
//		return new Ronda(cartasDeManoDisponibles, cartasDePieDisponibles, cartasDeManoJugadas, cartasDePieJugadas);
//	}
//	
//	public Ronda(ArrayList<Ficha> cartasDeManoDisponibles, ArrayList<Ficha> cartasDePieDisponibles,
//			ArrayList<Ficha> cartasDeManoJugadas, ArrayList<Ficha> cartasDePieJugadas) {
//		
//	}
//	
//	public Ronda() {
//		
//	}
//	
//	public void setTurno(String turno) {
//		this.turno = turno;
//	}
//
//	public boolean turnoMano() {
//		return getTurno() == "mano";
//	}
//
//	private String getTurno() {
//		return turno;
//	}
//
//	public boolean turnoPie() {
//		return getTurno() == "pie";
//	}
//
//	public void manoJuega(Ficha unaCarta) {
//		if (turnoMano()) {
//			cartasDeManoJugadas.add(unaCarta);
//			setTurno ("pie");
//		}
//		else {
//			throw new RuntimeException(NoEsTurnoErrorDescription);
//		}
//		
//	}
//
//	public ArrayList<Ficha> getManoJugadas() {
//		return cartasDeManoJugadas;
//	}

}

