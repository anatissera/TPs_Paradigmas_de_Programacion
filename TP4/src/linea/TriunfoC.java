package linea;

public class TriunfoC  extends Triunfo{
	// 4 en línea en cualquier orientación.
	// = A + B
	
    private Triunfo triunfoA;
    private Triunfo triunfoB;
    
	public TriunfoC () {
		super('C');
		this.triunfoA = new TriunfoA();
	    this.triunfoB = new TriunfoB();
	}

    @Override
    public boolean checkWin(Linea linea) {
        return triunfoA.checkWin(linea) || triunfoB.checkWin(linea);
    }

}
