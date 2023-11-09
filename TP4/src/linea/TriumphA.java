package linea;

public class TriumphA extends Triumph {
	
	public TriumphA() {
        super('A');
    }

    public boolean checkWin(Linea linea) {
//    	if ( checkVertical4(linea) || checkHorizontal4(linea) ) {
//    		linea.setGameFinished( "Las " + linea.getTurn().actualPlayer() + " ganan" );
//    	}
    	
    	return checkVertical4(linea) || checkHorizontal4(linea);
        
    }

    private boolean checkVertical4(Linea linea) {
        return linea.checkConnected4(linea.getBase(), linea.maxHeight() - 3, 0, 1, false);
    }

    private boolean checkHorizontal4(Linea linea) {
        return linea.checkConnected4(linea.getBase() - 3 , linea.maxHeight(), 1, 0, false);
    }
    
}
