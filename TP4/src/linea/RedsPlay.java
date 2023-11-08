package linea;

public class RedsPlay extends GameInProcess {

	public RedsPlay() {
		super('X');
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

}