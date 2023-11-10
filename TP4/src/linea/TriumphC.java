package linea;

public class TriumphC  extends Triumph {
	
    private Triumph triumphA;
    private Triumph triumphB;
    
	public TriumphC () {
		super('C');
		this.triumphA = new TriumphA();
	    this.triumphB = new TriumphB();
	}

	@Override
    public boolean checkWin( Linea game ) {
        return triumphA.checkWin(game) || triumphB.checkWin(game);
    }
	
}
