package linea;

public class TriumphA extends Triumph {
	
	public TriumphA() {
        super('A');
    }

    public boolean checkWin(Linea linea) {
    	return checkVertical4(linea) || checkHorizontal4(linea);
        
    }

    private boolean checkVertical4(Linea linea) {
        return linea.checkConnected4(linea.getBase(), linea.actualMaxHeight() - 3, 0, 1, false);
    }

    private boolean checkHorizontal4(Linea linea) {
        return linea.checkConnected4(linea.getBase() - 3 , linea.actualMaxHeight(), 1, 0, false);
    }
    
}
