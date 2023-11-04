package linea;

public class Game {

  public static void main( String[] args) throws Exception {
    System.out.println( "Dimensiones?");
    Linea game = new Linea( promptInt( "Base? " ), promptInt( "Altura? " ), promptChar( "Estrategia? " ) );
    System.out.println( game.show() );

    while ( !game.finished() ) {
      game.playRedAt( promptInt( "Negras? " ) );
      System.out.println( game.show() );
      if ( !game.finished() ) {
        game.playBlueAt( promptInt( "Blancas? " ) );
        System.out.println( game.show() );
      }
    }
    
    if (game.getTriumphVariant().checkWin(game)) {
        System.out.println("¡Las " + game.getTurn().getJugadorActual() + " ganan!");
    } else {
        System.out.println("¡Empate!");
    }
    
  }

  private static int promptInt( String message ) {
    System.out.print( message );
    return Integer.parseInt( System.console().readLine() );

  }
  
  private static char promptChar( String message ) {
	    System.out.print(message);
	    return System.console().readLine().charAt(0);

  }

}