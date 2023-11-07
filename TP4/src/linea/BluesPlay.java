package linea;

public class BluesPlay extends GameInProcess {

    public BluesPlay(){
        actualPlayer = 'O';
    }

    public void playRed() {
        throw new RuntimeException(notTurnErrorDescription);
    }

    public void playBlue() {
    	actualPlayer = 'X';
    }

	public boolean isRedsTurn() {
		return false;
	}

	public boolean isBluesTurn() {
		return true;
	}

	@Override
	public boolean gameFinished(Linea linea) {
		return false;
	}
}