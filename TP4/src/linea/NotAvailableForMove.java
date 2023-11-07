package linea;

public class NotAvailableForMove extends TurnState {
	
//  está en este estado si
//	public boolean finished(Linea linea) {
//  return linea.triumphVariant.checkWin(linea) || linea.triumphVariant.checkDraw(linea);
//}
	
     public NotAvailableForMove(char actualPlayerChar) {
         actualPlayer = actualPlayerChar;
     }

    public void redPlays() {
        throw new RuntimeException(TurnState.notTurnErrorDescription);
    }

    @Override
    public void bluePlays() {
        throw new RuntimeException(TurnState.notTurnErrorDescription);
    }

	

}
