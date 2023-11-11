package linea;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.function.Executable;
import java.util.stream.IntStream;

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
		assertEquals ( GameOn.notTurnErrorDescription, "No es turno de las Rojas!" );
	
		assertFalse(game.getGameState().isRedsTurn());
		assertTrue(game.getGameState().isBluesTurn());	
	}
	
	@Test
	public void test04BluesCannotPlayWhenItsRedsTurnAndThrowsDifferentMessage() {
		game.playRedAt(1);
		game.playBlueAt(1);
		
		assertThrowsLike( GameOn.notTurnErrorDescription , () -> game.playBlueAt(1) );
		assertEquals ( GameOn.notTurnErrorDescription, "No es turno de las Azules!" );
	
		assertTrue(  game.getGameState().isRedsTurn() );
		assertFalse( game.getGameState().isBluesTurn() );	
		
	}
	
	@Test
	public void test05CannotPlacePieceOutsideTheGameSpace() {
		assertThrowsLike( Linea.InvalidPosition + game.getBase() , () -> game.playRedAt(5) );
		assertEquals ( Linea.InvalidPosition + game.getBase(), "La posición debe estar entre 1 y 4" );
		assertTrue ( game.finished() );
		assertEquals ( emptyBoard() + "\n" + Linea.ErrorMessage + "\n" + Linea.InvalidPosition + "4", game.show() );
	}
	
    @Test
    public void test05bCannotPlacePieceOutsideTheGameSpaceThrowsDifferentExceptionMessage() {
    	Linea game = new Linea(6, 6, 'A');
        assertThrowsLike(Linea.InvalidPosition + game.getBase() , () -> game.playRedAt(7) );
        assertEquals ( Linea.InvalidPosition + game.getBase(), "La posición debe estar entre 1 y 6" );
		assertTrue ( game.finished() );   
    }
	
	@Test
	public void test06CannotPlayOnAFullColumn() {
		playGame( game, 1, 1, 1, 1 );
		assertThrowsLike( Linea.FullColumn , () -> game.playRedAt(1) );
		assertTrue ( game.finished() );   
		 String expectedBoard = 
			        "| O - - - |\n" +
			        "| X - - - |\n" +
			        "| O - - - |\n" +
			        "| X - - - |\n" +
			        "| ^ ^ ^ ^ |\n" +
			        "> 1 2 3 4 <\n";
		assertEquals (expectedBoard + "\n" + Linea.ErrorMessage + "\n" + Linea.FullColumn, game.show() );	
	}
	
	 @Test
	 public void test07CannotInitializeGameSpaceSmallerThan4x4() {
		 assertThrowsLike( Linea.NonValidDimentions , () -> new Linea(3, 3, 'A') );  
	 }
	
	@Test void test08GameCannotBeInizializatedWithNonValidStrategy(){
		assertThrowsLike( Triumph.NonValidStrategyVariant , () -> new Linea(7, 6, 'K') ); //InitializeTriunfo.NonValidStrategyVariant
	} 
	
	@Test void test09HorizontalWin() {
	    assertTrue( horizontalWin( new Linea(4, 4, 'A') ) );
	}

	@Test void test10VerticalWin() {
		assertTrue( verticalWin( new Linea(4, 4, 'A') ) );
	}

	@Test void test11DiagonalFromLeftToRightWin() {
		assertTrue( diagonalFromLeftToRightWin( new Linea(4, 4, 'B') ) );
	}
	
	@Test void test12DiagonalFromRightToLeftWin() {
		assertTrue( diagonalFromRightToLeftWin( lineaB() ) );
	}
	
	@Test void test13TriumphCWorksWithHorizontalWin() {
		assertTrue( horizontalWin( game ) );
	}
	
	@Test void test14TriumphCWorksWithVerticalWin() {
		assertTrue( verticalWin( game ) );
	}
	
	@Test void test15TriumphCWorksWithDiagonalFromLeftToRightWin() {
		assertTrue( diagonalFromLeftToRightWin( game ) );
	}
	
	@Test void test16TriumphCWorksWithDiagonalFromRightToLeftWin() {
		assertTrue( diagonalFromRightToLeftWin( game ) );
	}
	
	@Test void test17TriumphADoesNotWorkWithDiagonalWin() {
		assertFalse( diagonalFromLeftToRightWin( new Linea(4, 4, 'A') ) );
	}
	
	@Test void test18TriumphBDoesNorWorkWithHorizontalWin() {
		assertFalse( horizontalWin( lineaB() ) );
	}
	
	@Test void test19TriumphBDoesNorWorkWithVerticallWin() {
		assertFalse( verticalWin( lineaB() ) );
	}
	
	@Test
	void test20Draw() {
	    assertTrue( drawGame( lineaA() ) );
	}
	
	
	@Test
	public void test21CannotPlayAfterADraw() {
		assertTrue( drawGame(game) );
		assertThrowsLike( GameOver.gameFinishedErrorDescription, () -> game.playRedAt(1) );
		assertEquals ( GameOver.gameFinishedErrorDescription, "El juego ha terminado en empate!");
	}
	
	@Test
	public void test22CannotPlayAfterWin() {
		assertTrue( verticalWin(game) );
		assertThrowsLike( GameOver.gameFinishedErrorDescription, () -> game.playRedAt(1) );
		assertEquals ( GameOver.gameFinishedErrorDescription, "El juego ha terminado.\nGanaron: las Azules");
	}
	
	@Test
	public void test22bCannotPlayAfterWinMessageIsDifferentForDifferentWinners() {
		assertTrue( horizontalWin(game) );
		assertThrowsLike( GameOver.gameFinishedErrorDescription, () -> game.playRedAt(1) );
		assertEquals ( GameOver.gameFinishedErrorDescription, "El juego ha terminado.\nGanaron: las Rojas");
	}
	
	// show tests
	
	@Test
	public void test23ShowEmptyBoard() {
	    assertEquals( emptyBoard(), game.show() );
	}

	@Test
	public void test24ShowAfterRedPlay() {
	    game.playRedAt(1);
	    String expectedBoard = 
	        "| - - - - |\n" +
	        "| - - - - |\n" +
	        "| - - - - |\n" +
	        "| X - - - |\n" +
	        "| ^ ^ ^ ^ |\n" +
	        "> 1 2 3 4 <\n";
	    assertEquals(  expectedBoard, game.show() );
	}

	@Test
	public void test25ShowAfterBluePlay() {
	    game.playRedAt(1);
	    game.playBlueAt(2);
	    String expectedBoard = 
	        "| - - - - |\n" +
	        "| - - - - |\n" +
	        "| - - - - |\n" +
	        "| X O - - |\n" +
	        "| ^ ^ ^ ^ |\n" +
	        "> 1 2 3 4 <\n";
	    assertEquals( expectedBoard, game.show() );
	}

	@Test
	public void test26ShowAfterDrawGame() {
	    drawGame(game);
	    String expectedBoard = 
	    	"| O X O X |\n" +
	        "| X O X O |\n" +
	        "| X O X O |\n" +
	        "| X O X O |\n" +
	        "| ^ ^ ^ ^ |\n" +
	        "> 1 2 3 4 <\n";
	    assertEquals( expectedBoard + "\nEmpate!", game.show() );
	}
	
	@Test
	public void test27ShowWithRedsWin() {
	    horizontalWin( game );
	    
	    String expectedBoard = 
	        "| - - - - |\n" +
	        "| - - - - |\n" +
	        "| O O O - |\n" +
	        "| X X X X |\n" +
	        "| ^ ^ ^ ^ |\n" +
	        "> 1 2 3 4 <\n";
	    assertEquals(expectedBoard + "\nLas Rojas ganan!", game.show());
	}
	
	@Test
	public void test28ShowWithBluesWin() {
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
  	
	private String emptyBoard() {
		return 
				"| - - - - |\n" +
				"| - - - - |\n" +
				"| - - - - |\n" +
				"| - - - - |\n" +
				"| ^ ^ ^ ^ |\n" +
				"> 1 2 3 4 <\n";
	}
	
	private boolean horizontalWin( Linea game ) {
	    playGame( game, 1, 1, 2, 2, 3, 3, 4 );
	    return game.finished() && redWon(game);
	}
	
	private boolean verticalWin( Linea game ) {
		playGame( game, 1, 2, 1, 2, 1, 2, 3 );
		game.playBlueAt(2);
	    return game.finished() && blueWon(game);
	}

	private boolean diagonalFromLeftToRightWin( Linea game ) {
	    playGame( game, 1, 2, 2, 3, 3, 4, 3, 4, 4, 1, 4 );
	    return game.finished() && redWon(game);
	}
	
	
	private boolean diagonalFromRightToLeftWin( Linea game  ) {
	    playGame( game, 4, 3, 3, 2, 2, 1, 2, 1, 1, 4, 1 );
	    return game.finished() && redWon(game);
	}
	
	private boolean drawGame(Linea game) {
		drawMoves(game);
	    return game.finished() && noOneWon(game);	   
	}
	
	public void drawMoves( Linea game ) {
		playGame(game, 1, 2, 3, 4, 1, 2, 3, 4, 1, 2, 3, 4, 2, 1, 4, 3);
	}
   
    private Linea playGame(Linea game, int... moves) {
        IntStream.range(0, moves.length)
                .forEach(i -> {
                    if (i % 2 == 0) {
                        game.playRedAt(moves[i]);
                    } else {
                        game.playBlueAt(moves[i]);
                    }
                });
        return game;
    }

    public boolean redWon( Linea game ) { return game.winner().equals( new RedsPlay() ) ; }
    public boolean blueWon( Linea game ) { return game.winner().equals( new BluesPlay() ) ; }
    public boolean noOneWon ( Linea game ) { return game.winner() == null ; }
    
    private Linea lineaB() { return new Linea(4, 4, 'B'); }
    private Linea lineaA() { return new Linea(4, 4, 'A'); }

	
}
