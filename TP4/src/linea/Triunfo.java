package linea;

import java.util.stream.IntStream;

//public interface Triunfo {
//    boolean checkWin(Linea linea, int fila, int columna, char jugador);
//    boolean checkWin(Linea linea);
//    boolean checkDraw(Linea linea);
//}

//public class TriunfoA implements Triunfo {
//    // Implementa las reglas de triunfo 'A'
//}
//
//public class TriunfoB implements Triunfo {
//    // Implementa las reglas de triunfo 'B'
//}
//
//public class TriunfoC implements Triunfo {
//    // Implementa las reglas de triunfo 'C'
//}

public abstract class Triunfo {
    protected char key;

    public Triunfo(char aKey) {
        key = aKey;
    }

    public boolean applies(char varianteTriunfo) {
        return key == varianteTriunfo;
    }

    public abstract boolean checkWin(Linea linea);
//    public abstract boolean checkDraw(Linea linea);

    public boolean checkDraw(Linea linea) {
        boolean isDraw = IntStream.range(0, linea.getBase())
            .allMatch(columna -> linea.ColumnIsFull(columna));

        return isDraw && !checkWin(linea);
    }

}

//package nemo3;
//
//import java.util.List;
//import java.util.function.Consumer;
//
//public class Command {
//  
//  static public Command commandFor( char command ) {
//    return List.of( new Command( 'd', nemo -> nemo.down() ), 
//                    new Command( 'u', nemo -> nemo.up() ), 
//                    new Command( 'l', nemo -> nemo.turnLeft() ), 
//                    new Command( 'r', nemo -> nemo.turnRight() ), 
//                    new Command( 'f', nemo -> nemo.forward() ), 
//                    new Command( 'm', nemo -> nemo.fire() )
//                   ).stream()
//                    .filter( each -> each.applies( command ) )
//                    .findAny()
//                    .get();
//  }
//  protected char key;
//  private Consumer<Nemo> action;
//  
//  public Command( char aKey, Consumer<Nemo> anAction ) {
//    key = aKey;
//    action = anAction;
//  }
//  
//  public boolean applies( char command ) { return key == command; }
//  public void performOn( Nemo nemo ) { action.accept( nemo );  }
//}
