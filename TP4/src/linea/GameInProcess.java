package linea;

public abstract class GameInProcess extends GameState{

    protected char actualPlayer;
    
//    protected GameInProcess actualPlayer;
//    protected RedsPlay redsTurn = new RedsPlay();
//    protected BluesPlay bluesTurn = new BluesPlay();
    
    public static String notTurnErrorDescription = "No es turno";
    
	public boolean gameFinished() {
		return false;
	}
	
    public abstract void playRed();
    public abstract void playBlue();
    public abstract boolean isRedsTurn();
    public abstract boolean isBluesTurn();
}

