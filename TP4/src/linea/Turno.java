package linea;

public class Turno {
    private char jugadorActual;

    public Turno(char color) {
        jugadorActual = color;
    }

    public char getJugadorActual() {
        return jugadorActual;
    }

    public void alternarTurno() {
        jugadorActual = (jugadorActual == 'X') ? '0' : 'X';
    }

}

