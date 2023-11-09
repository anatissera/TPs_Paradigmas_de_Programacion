package linea;

public class TriumphC  extends Triumph{
	// 4 en línea en cualquier orientación.
	// = A + B
	
    private Triumph triunfoA;
    private Triumph triunfoB;
    
	public TriumphC () {
		super('C');
		this.triunfoA = new TriumphA();
	    this.triunfoB = new TriumphB();
	}

    public boolean checkWin(Linea linea) {
//    	triunfoA.checkWin(linea); 
//    	triunfoB.checkWin(linea);
        return triunfoA.checkWin(linea) || triunfoB.checkWin(linea);
    }
}
