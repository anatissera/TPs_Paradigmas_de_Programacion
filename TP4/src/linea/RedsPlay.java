package linea;

public class RedsPlay extends GameInProcess {

	public RedsPlay() {
		 actualPlayer = 'X';
	}

	public void playRed() {
		 actualPlayer = 'O';
	}

	public void playBlue() {
		throw new RuntimeException(notTurnErrorDescription);
	}

	public boolean isRedsTurn() {
		return true;
	}

	public boolean isBluesTurn() {
		return false;
	}

	@Override
	public boolean gameFinished(Linea linea) {
		return false;
	}
}