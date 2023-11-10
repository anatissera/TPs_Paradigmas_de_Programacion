package linea;

public class TriumphC  extends Triumph{
	
    private Triumph triunfoA;
    private Triumph triunfoB;
    
	public TriumphC () {
		super('C');
		this.triunfoA = new TriumphA();
	    this.triunfoB = new TriumphB();
	}

	@Override
    public boolean checkWin(Linea game) {
        return triunfoA.checkWin(game) || triunfoB.checkWin(game);
    }
}
