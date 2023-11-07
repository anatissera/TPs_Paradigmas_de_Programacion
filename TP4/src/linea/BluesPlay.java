package linea;

public class BluesPlay extends GameInProcess {

    public BluesPlay(){
        actualPlayer = 'O';
    }

    public void playRed() {
        throw new RuntimeException(notTurnErrorDescription);
    }

    public void bluePlays() {
    	actualPlayer = 'X';
    }

	public boolean redsTurn() {
		return false;
	}

	public boolean bluesTurn() {
		return true;
	}

}
