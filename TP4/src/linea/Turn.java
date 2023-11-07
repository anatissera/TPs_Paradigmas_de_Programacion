package linea;

public class Turn {
	private TurnState turnState;

    public Turn() {
        turnState = new AvailableForMove();
    }

    public void switchToReds() {
        turnState = new AvailableForMove('X');
    }

    public void switchToBlues() {
        turnState = new AvailableForMove('O');
    }

    public boolean redsTurn() {
        return turnState.getJugadorActual() == 'X';
    }

    public boolean bluesTurn() {
        return turnState.getJugadorActual() == 'O';
    }

    public void playRed() {
        turnState.redPlays();
    }

    public void playBlue() {
        turnState.bluePlays();
    }

}
