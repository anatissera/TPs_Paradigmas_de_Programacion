package linea;

public class AvailableForMove extends TurnState{

//  arranca en juega rojas
	// 'X' es rojas, 'O' es azules.

//	private TurnState previousPlayer;
	
    public AvailableForMove(char actualPlayer) {
        super(actualPlayer);
    }

    public void redPlays() {
        actualPlayer = 'O';
    }

    public void bluePlays() {
    	actualPlayer = 'X';
    }
	
//	public TurnState previousState() {
//		return null;
//	}
}
