package linea;

public class TriumphA extends Triumph {
	
	public TriumphA() {
        super('A');
    }

	@Override
    public boolean checkWin(Linea game) {
    	return checkVertical4(game) || checkHorizontal4(game);
        
    }

    private boolean checkVertical4(Linea game) {
        return game.checkConnected4(game.getBase(), game.actualMaxHeight() - 3, 0, 1, false);
    }

    private boolean checkHorizontal4(Linea game) {
        return game.checkConnected4(game.getBase() - 3 , game.actualMaxHeight(), 1, 0, false);
    }
    
}
