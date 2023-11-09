package linea;

public class TriumphA extends Triumph {
	
	public TriumphA() {
        super('A');
    }

    public boolean checkWin(Linea linea) {
        return checkVertical(linea) || checkHorizontal(linea);
    }

    private boolean checkVertical(Linea linea) {
        return linea.checkConnected4(linea.getBase(), linea.maxHeight() - 3, 0, 1, false);
    }

    private boolean checkHorizontal(Linea linea) {
        return linea.checkConnected4(linea.getBase() -3 , linea.maxHeight(), 1, 0, false);
    }
    
}
