package linea;

public class AvailableForMove extends TurnState{

//  arranca en juega rojas
	// 'X' es rojas, 'O' es azules.

	private char actualPlayer;
	private TurnState previousPlayer;
	
	
    public AvailableForMove() {
        actualPlayer = 'X';
    }

    public void redPlays() {
        actualPlayer = 'O';
    }

    public void bluePlays() {
    	actualPlayer = 'X';
    }
	
	// public TurnState previousState() {
	// 	throw new RuntimeException(notTurnErrorDescription);
	// }

	@Override
	public TurnState previousState() {
		return null;
	}

	// public boolean redsTurn() {
	//     return getTurno() == 'X';
	// }

	// public boolean bluesTurn() {
	//     return getTurno() == 'O';
	// }
	
	

//	public abstract void redPlays();
//	{
//		if( redsTurn() ) {	
//			setTurno('O');
//		}
//		else {
//			throw new RuntimeException (notTurnErrorDescription);
//		}
//	}
	
//	public abstract void bluePlays() ;
//	{
//		if( bluesTurn() ) {
//			setTurno('X');
//		}
//		else {
//			throw new RuntimeException (notTurnErrorDescription);
//		}
//	}
	

}
