package linea;

public class ModeC  extends Mode {
	
    private Mode triumphA;
    private Mode triumphB;
    
	public ModeC () {
		super('C');
		triumphA = new ModeA();
	    triumphB = new ModeB();
	}

	@Override
    public boolean checkWin( Linea game ) {
        return triumphA.checkWin(game) || triumphB.checkWin(game);
    }
	
}
