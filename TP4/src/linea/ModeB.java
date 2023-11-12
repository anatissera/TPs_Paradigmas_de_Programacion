package linea;

public class ModeB  extends Mode{
	
	public ModeB() {
        super('B');    
    }

	@Override
	public boolean checkWin(Linea game) {
		return checkDiagonal4FromLeftToRight(game) || checkDiagonal4FromRightToLeft(game);
	}
	
	private boolean checkDiagonal4FromLeftToRight(Linea game) {
		return game.checkConnected4( game.getBase(), game.actualMaxHeight(), 1, 1, true );
	}

	private boolean checkDiagonal4FromRightToLeft(Linea game) {
		return game.checkConnected4( game.getBase(), game.actualMaxHeight(), 1, -1, true );
	}
	
}
