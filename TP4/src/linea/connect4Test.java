package linea;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.function.Executable;

public class connect4Test {
	
	private Linea game;
	
	@BeforeEach
	public void setUp() {
		game = new Linea(4, 4, 'C');
	}
	
	@Test
    public void test01RedsAlwaysStart() {
		assertTrue(game.getGameState().isRedsTurn());
		assertFalse(game.getGameState().isBluesTurn());
}
	
	@Test
	public void test02BluePlaysAfterRedTurn() {
		game.playRedAt(1);
	
		assertFalse(game.getGameState().isRedsTurn());
		assertTrue(game.getGameState().isBluesTurn());		
	}
	
	@Test
	public void test03RedsCannotPlayWhenItsBluesTurn() {
		game.playRedAt(1);
		
		assertThrowsLike( GameOn.notTurnErrorDescription , () -> game.playRedAt(1) );
	
		assertFalse(game.getGameState().isRedsTurn());
		assertTrue(game.getGameState().isBluesTurn());	
		
	}
	
	@Test
	public void test04BluesCannotPlayWhenItsRedsTurn() {
		game.playRedAt(1);
		game.playBlueAt(1);
		
		assertThrowsLike( GameOn.notTurnErrorDescription , () -> game.playBlueAt(1) );
	
		assertTrue(game.getGameState().isRedsTurn());
		assertFalse(game.getGameState().isBluesTurn());	
		
	}
	
//	@Test
//	public void test05CannotPlayOnceTheGameIsFinished() {
//		Linea game = new Linea(3, 3, 'C');
//		
//		assertThrowsLike( GameFinished.gameHasFinishedErrorDescription , () -> game.playRedAt(1) );
//	}
	
	@Test
	public void test06CannotPlacePieceOutsideTheGameSpace() {
		assertThrowsLike(Linea.InvalidPosition + game.getBase() , () -> game.playRedAt(5) );
	}
	
    @Test
    public void test06bCannotPlacePieceOutsideTheGameSpaceThrowsDifferentExceptionMessage() {
    	Linea game = new Linea(6, 6, 'A');
        assertThrowsLike(Linea.InvalidPosition + game.getBase() , () -> game.playRedAt(7) );
        
    }
	
	@Test
	public void test07CannotPlayOnAFullColumn() {
		game.playRedAt(1);
		game.playBlueAt(1);
		game.playRedAt(1);
		game.playBlueAt(1);
		assertThrowsLike( Linea.FullColumn , () -> game.playRedAt(1) );
	}
	
	 @Test
	 public void test08CannotInitializeGameSpaceSmallerThan4x4() {
		 assertThrowsLike( Linea.NonValidDimentions , () -> new Linea(3, 3, 'A') );
	 }
	
	@Test void testGameCannotBeInizializatedWithNonValidStrategy(){
		assertThrowsLike( "Variante de estrategia no válida" , () -> new Linea(7, 6, 'K') ); //InitializeTriunfo.NonValidStrategyVariant
	} 
	
	@Test void test08HorizontalWin() {
	    assertTrue(horizontalWin( new Linea(4, 4, 'A') ) );
	}

	@Test void test09VerticalWin() {
		assertTrue(verticalWin( new Linea(4, 4, 'A') ));
	}

	@Test void test10DiagonalFromLeftToRightWin() {
		assertTrue(diagonalFromLeftToRightWin( new Linea(4, 4, 'B') ));
	}
	
	@Test void test11DiagonalFromRightToLeftWin() {
		assertTrue(diagonalFromRightToLeftWin( newLineaB() ));
	}
	
	@Test void test12TriumphCWorksWithHorizontalWin() {
		assertTrue(horizontalWin( game ));
	}
	
	@Test void test13TriumphCWorksWithVerticalWin() {
		assertTrue(verticalWin( game ));
	}
	
	@Test void test14TriumphCWorksWithDiagonalFromLeftToRightWin() {
		assertTrue(diagonalFromLeftToRightWin( game ));
	}
	
	@Test void test15TriumphCWorksWithDiagonalFromRightToLeftWin() {
		assertTrue(diagonalFromRightToLeftWin( game ));
	}
	
	@Test void test16TriumphADoesNotWorkWithDiagonalWin() {
		assertFalse(diagonalFromLeftToRightWin( new Linea(4, 4, 'A') ));
	}
	
	@Test void test17TriumphBDoesNorWorkWithHorizontalWin() {
		assertFalse(horizontalWin( newLineaB() ));
	}
	
	@Test void test18TriumphBDoesNorWorkWithVerticallWin() {
		assertFalse(verticalWin( newLineaB() ));
	}
	
	@Test
	void test19Draw() {
	    assertTrue( drawGame( newLineaA() ) );
	}
	
	
	@Test
	public void test20CannotPlayAfterADraw() {
	    drawGame(game);
		assertThrowsLike( GameOver.gameFinishedErrorDescription, () -> game.playRedAt(1) );
		assertEquals ( GameOver.gameFinishedErrorDescription, "El juego ha terminado en empate!");
	}
	
	@Test
	public void test21CannotPlayAfterWin() {
	    verticalWin(game);
		assertThrowsLike( GameOver.gameFinishedErrorDescription, () -> game.playRedAt(1) );
		assertEquals ( GameOver.gameFinishedErrorDescription, "El juego ha terminado.\nGanaron: las Azules");
	}
	
	@Test
	public void test21bCannotPlayAfterWinMessageIsDifferentForDifferentWinners() {
	    horizontalWin(game);
		assertThrowsLike( GameOver.gameFinishedErrorDescription, () -> game.playRedAt(1) );
		assertEquals ( GameOver.gameFinishedErrorDescription, "El juego ha terminado.\nGanaron: las Rojas");
	}
	
	
	@Test
	public void test21ShowEmptyBoard() {
		
	    String expectedBoard = 
	        "| - - - - |\n" +
	        "| - - - - |\n" +
	        "| - - - - |\n" +
	        "| - - - - |\n" +
	        "| ^ ^ ^ ^ |\n" +
	        "> 1 2 3 4 <\n";
	    assertEquals(expectedBoard, game.show());
	}

	@Test
	public void test22ShowAfterRedPlay() {
	    game.playRedAt(1);
	    String expectedBoard = 
	        "| - - - - |\n" +
	        "| - - - - |\n" +
	        "| - - - - |\n" +
	        "| X - - - |\n" +
	        "| ^ ^ ^ ^ |\n" +
	        "> 1 2 3 4 <\n";
	    assertEquals(expectedBoard, game.show());
	}

	@Test
	public void test23ShowAfterBluePlay() {
	    game.playRedAt(1);
	    game.playBlueAt(2);
	    String expectedBoard = 
	        "| - - - - |\n" +
	        "| - - - - |\n" +
	        "| - - - - |\n" +
	        "| X O - - |\n" +
	        "| ^ ^ ^ ^ |\n" +
	        "> 1 2 3 4 <\n";
	    assertEquals(expectedBoard, game.show());
	}
	

	@Test
	public void test25ShowAfterDrawGame() {
	    drawGame(game);
	
	    String expectedBoard = 
	    	"| O X O X |\n" +
	        "| X O X O |\n" +
	        "| X O X O |\n" +
	        "| X O X O |\n" +
	        "| ^ ^ ^ ^ |\n" +
	        "> 1 2 3 4 <\n";
	    assertEquals(expectedBoard + "\nEmpate!", game.show());
	}
	
	@Test
	public void test26ShowWithRedsWin() {
	    horizontalWin( game );
	    
	    String expectedBoard = 
	        "| - - - - |\n" +
	        "| - - - - |\n" +
	        "| O O O - |\n" +
	        "| X X X X |\n" +
	        "| ^ ^ ^ ^ |\n" +
	        "> 1 2 3 4 <";
	    assertEquals(expectedBoard + "\n\nLas Rojas ganan!", game.show());
	}
	
	@Test
	public void test27ShowWithBluesWin() {
	    verticalWin ( game );
	  
	    String expectedBoard = 
	        "| - O - - |\n" +
	        "| X O - - |\n" +
	        "| X O - - |\n" +
	        "| X O X - |\n" +
	        "| ^ ^ ^ ^ |\n" +
	        "> 1 2 3 4 <\n";
	    assertEquals(expectedBoard + "\nLas Azules ganan!", game.show());
	}	

  private void assertThrowsLike( String message, Executable executable ) {
	  assertEquals( message,
			  assertThrows( Exception.class, executable ).getMessage() );
  }
	
	private boolean horizontalWin( Linea game ) {
	    sevenMoves(game, 1, 1, 2, 2, 3, 3, 4);
	    return game.finished();
	}
	
	private boolean verticalWin( Linea game ) {
		sevenMoves(game, 1, 2, 1, 2, 1, 2, 3);
		game.playBlueAt(2);
	    return game.finished();
	}

	private boolean diagonalFromLeftToRightWin( Linea game ) {
	    elevenMoves(game, 1, 2, 2, 3, 3, 4, 3, 4, 4, 1, 4);
	    return game.finished();
	}
	
	
	private boolean diagonalFromRightToLeftWin( Linea game  ) {
	    elevenMoves(game, 4, 3, 3, 2, 2, 1, 2, 1, 1, 4, 1);
	    return game.finished() ;
	}
	
	private boolean drawGame(Linea game) {
		drawMoves(game);
	    return game.finished();	   
	}
	
	public void twoMoves( Linea game, int i, int i2 ) {
		game.playRedAt(i);
		game.playBlueAt(i2);
	}
	
	public void sevenMoves( Linea game, int i, int i2, int i3, int i4, int i5, int i6, int i7 ) {
		twoMoves(game, i, i2);
		twoMoves(game, i3, i4);
		twoMoves(game, i5, i6);
	    game.playRedAt(i7);
	}
	
	public void elevenMoves (Linea game, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11 ) {
		sevenMoves(game, i, i2, i3, i4, i5, i6, i7);
		game.playBlueAt(i8);
		twoMoves(game, i9, i10);
		game.playRedAt(i11);
	}
	
	public void drawMoves( Linea game ) {
		elevenMoves(game, 1, 2, 3, 4, 1, 2, 3, 4, 1, 2, 3);
		game.playBlueAt(4);
		twoMoves(game, 2, 1);
		twoMoves(game, 4, 3);
	}
	
   
//    @Test
//    public void test27ModeAGameCanFinishOnDrawIfNoneWins() {
//        assertEquals(drawStatus(), playDraw().getStatus());
//    }
//
//   
//
//    @Test
//    public void test41ModeCGameCanFinishOnDrawIfNoneWins() {
//        assertEquals(drawStatus(), playDraw().getStatus());
//    }
//
//    @Test
//    public void test42BlueWinsDiagonallyIn6x6Board() {
//        assertTrue(playGame(1, 2, 2, 3, 4, 3, 3, 4, 3, 4, 2, 5, 5, 5, 1, 5).finished());
//    }
//



    private Linea playDraw() { return playGame(1, 2, 3, 4, 1, 2, 3, 4, 2, 1, 4, 3, 2, 1, 4, 3); }

    private Linea playGame(int ... moves) {
        for (int i = 0; i < moves.length; i += 2) {
            game.playRedAt(moves[i]);
            if (i + 1 ==  moves.length) break;
            game.playBlueAt(moves[i + 1]);
        }
        return game;
    }

    public boolean redWon() { return game.getGameState().getWinner().equals( new RedsPlay() ) ; }
    public boolean blueWon() { return game.getGameState().getWinner().equals( new BluesPlay() ) ; }
    
    private Linea newLineaB() { return new Linea(4, 4, 'B'); }

    private Linea newLineaA() { return new Linea(4, 4, 'A'); }

	
}
