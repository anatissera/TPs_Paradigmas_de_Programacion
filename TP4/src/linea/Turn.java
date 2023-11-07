package linea;

public class Turn {
	private TurnState turnState;

    public Turn() {
        turnState = new AvailableForMove('X');
    }

    public void switchToReds() {
        turnState = new NotAvailableForMove('X');
    }

    public void switchToBlues() {
        turnState = new NotAvailableForMove('O');
    }

    public boolean redsTurn() {
        return turnState.getJugadorActual() == 'X';
    }

    public boolean bluesTurn() {
        return turnState.getJugadorActual() == 'O';
    }

    public void playRed() {
//        turnState.redPlays();
        switchToBlues();
    }

    public void playBlue() {
//        turnState.bluePlays();
        switchToReds();
    }

}
