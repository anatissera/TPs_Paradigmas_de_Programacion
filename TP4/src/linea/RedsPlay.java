package linea;

public class RedsPlay extends GameInProcess {

	public RedsPlay() {
		actualPlayer = 'X';
	}

	public GameInProcess playRed() {
		return new BluesPlay();
	}

	public GameInProcess playBlue() {
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