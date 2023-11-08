package linea;

public class BluesPlay extends GameInProcess {

    public BluesPlay(){
      super('O');
    }

    public GameInProcess playRed() {
        throw new RuntimeException(notTurnErrorDescription);
    }

    public GameInProcess playBlue() {
    	return new RedsPlay();
    }

	public boolean isRedsTurn() {
		return false;
	}

	public boolean isBluesTurn() {
		return true;
	}

}