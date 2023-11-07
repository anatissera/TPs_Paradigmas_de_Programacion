package linea;

public class GameFinished extends GameState {
	
    
//  está en este estado si
@Override
public boolean gameFinished(Linea linea) {
    return linea.finished();
}


}
