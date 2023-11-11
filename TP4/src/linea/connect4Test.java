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
		assertTrue( game.isRedsTurn() );
		assertFalse( game.isBluesTurn() );
}
	
	@Test
	public void test02BluePlaysAfterRedTurn() {
		game.playRedAt(1);
	
		assertFalse( game.isRedsTurn() );
		assertTrue( game.isBluesTurn() );		
	}
	
	@Test
	public void test03RedsCannotPlayWhenItsBluesTurnAndCanPlay() {
		game.playRedAt(1);
		
		assertThrowsLike( GameOn.notTurnErrorDescription , () -> game.playRedAt(1) );
		assertEquals ( GameOn.notTurnErrorDescription, "It's not Reds' turn!" );
	
		assertFalse ( game.finished() );
		
		assertFalse(game.isRedsTurn());
		assertTrue(game.isBluesTurn());	
	}
	
	@Test
	public void test04BluesCannotPlayWhenItsRedsTurnAndThrowsDifferentMessage() {
		game.playRedAt(1);
		game.playBlueAt(1);
		
		assertThrowsLike( GameOn.notTurnErrorDescription , () -> game.playBlueAt(1) );
		assertEquals ( GameOn.notTurnErrorDescription, "It's not Blues' turn!" );
	
		assertFalse ( game.finished() );
		
		assertTrue(  game.isRedsTurn() );
		assertFalse( game.isBluesTurn() );		
	}
	
	@Test
	public void test05CannotPlacePieceOutsideTheGameSpace() {
		assertThrowsLike( Linea.InvalidPosition + game.getBase() , () -> game.playRedAt(5) );
		assertEquals ( Linea.InvalidPosition + game.getBase(), "Position must be between 1 and 4" );
		assertTrue ( game.finished() );
		assertEquals ( emptyBoard() + "\n" + Linea.ErrorMessage + "\n" + Linea.InvalidPosition + "4", game.show() );
	}
	
    @Test
    public void test05bCannotPlacePieceOutsideTheGameSpaceThrowsDifferentExceptionMessage() {
    	Linea game = new Linea(6, 6, 'A');
        assertThrowsLike(Linea.InvalidPosition + game.getBase() , () -> game.playRedAt(0) );
        assertEquals ( Linea.InvalidPosition + game.getBase(), "Position must be between 1 and 6" );
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
		 assertThrowsLike( Linea.InvalidDimentions , () -> new Linea(3, 3, 'A') );  
	 }
	
	@Test void test08GameCannotBeInizializatedWithNonValidStrategy(){
		assertThrowsLike( Mode.InvalidStrategyVariant , () -> new Linea(7, 6, 'K') );
	} 
	
	@Test void test09HorizontalWinOnModeA() {
	    assertTrue( horizontalWin( lineaA4x4() ) );
	}

	@Test void test10VerticalWinOnModeA() {
		assertTrue( verticalWin( lineaA4x4() ) );
	}
	
	@Test void test09bHorizontalWinOnModeAOnABiggerBoard() {
	    assertTrue( horizontalWin( new Linea(7, 6, 'A') ) );
	}

	@Test void test10bVerticalWinOnModeAOnABiggerBoard() {
		assertTrue( verticalWin( new Linea(7, 6, 'A') ) );
	}

	@Test void test11DiagonalFromLeftToRightWinOnModeB() {
		assertTrue( diagonalFromLeftToRightWin( lineaB4x4() ) );
	}
	
	@Test void test12DiagonalFromRightToLeftWinOnModeB() {
		assertTrue( diagonalFromRightToLeftWin( lineaB4x4() ) );
	}
	
	@Test void test11bDiagonalFromLeftToRightWinOnModeBNotFromCorner() {
		assertTrue( diagonalFromLeftToRightWinNotFromTheCorner( new Linea(7, 6, 'B') ) );
	}
	
	@Test void test12bDiagonalFromRightToLeftWinOnModeBNotFromCorner() {
		assertTrue( diagonalFromRightToLeftWinNotFromTheCorner( new Linea(7, 6, 'B') ) );
	}
	
	@Test void test13HorizontalWinWorksWithModeC() {
		assertTrue( horizontalWin( game ) );
	}
	
	@Test void test14VerticalWinWorksWithModeC() {
		assertTrue( verticalWin( game ) );
	}
	
	@Test void test15DiagonalFromLeftToRightWinWorksWithModeC() {
		assertTrue( diagonalFromLeftToRightWin( game ) );
	}
	
	@Test void test16DiagonalFromRightToLeftWinWorksWithModeC() {
		assertTrue( diagonalFromRightToLeftWin( game ) );
	}
	
	@Test void test17DiagonalLtoRWinDoesNotWorkWithModeA() {
		assertFalse( diagonalFromLeftToRightWin( lineaA4x4() ) );
	}
	
	@Test void test17bDiagonalRtoLWinDoesNotWorkWithModeA() {
		assertFalse( diagonalFromRightToLeftWin( lineaA4x4() ) );
	}
	
	@Test void test18HorizontalWinDoesNotWorkWithModeB() {
		assertFalse( horizontalWin( lineaB4x4() ) );
	}
	
	@Test void test19VerticalWinDoesNotWorkWithModeB() {
		assertFalse( verticalWin( lineaB4x4() ) );
	}
	
	@Test
	void test20DrawOnModeA() {
	    assertTrue( drawGame( lineaA4x4() ) );
	}
	
	@Test
	void test20bDrawOnModeB() {
	    assertTrue( drawGame( lineaB4x4() ) );
	}
	
	@Test
	void test20cDrawOnModeC() {
	    assertTrue( drawGame( game ) );
	}
	
	@Test
	public void test21CannotPlayAfterADraw() {
		assertTrue( drawGame(game) );
		assertThrowsLike( GameOver.gameFinishedErrorDescription, () -> game.playRedAt(1) );
		assertEquals ( GameOver.gameFinishedErrorDescription, "The Game has finished in a Draw!");
	}
	
	@Test
	public void test22CannotPlayAfterWin() {
		assertTrue( verticalWin(game) );
		assertThrowsLike( GameOver.gameFinishedErrorDescription, () -> game.playRedAt(1) );
		assertEquals ( GameOver.gameFinishedErrorDescription, "The Game has finished.\nThe winner is: Blues");
	}
	
	@Test
	public void test22bCannotPlayAfterWinMessageIsDifferentForDifferentWinners() {
		assertTrue( horizontalWin(game) );
		assertThrowsLike( GameOver.gameFinishedErrorDescription, () -> game.playRedAt(1) );
		assertEquals ( GameOver.gameFinishedErrorDescription, "The Game has finished.\nThe winner is: Reds");
	}
	
	// TestShow
	
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
	    assertEquals( expectedBoard + "\nDraw!", game.show() );
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
	    assertEquals(expectedBoard + "\nThe Reds win!", game.show());
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
	    assertEquals(expectedBoard + "\nThe Blues win!", game.show());
	}
	

//	Auxiliaries

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
	
	private boolean diagonalFromLeftToRightWinNotFromTheCorner( Linea game ) {
		playGame( game, 4, 5, 4, 5, 6, 6, 5, 6, 6, 7, 7, 7, 7, 3, 7 );
	    return game.finished() && redWon(game);
	}
	
	private boolean diagonalFromRightToLeftWinNotFromTheCorner( Linea game  ) {
	    playGame( game, 5, 5, 4, 4, 3, 2, 3, 4, 3, 3, 2, 2, 2, 2 );
	    return game.finished() && blueWon(game);
	}
	
	private boolean drawGame(Linea game) {
		drawMoves(game);
	    return game.finished() && noOneWon(game);	   
	}
	
	public void drawMoves( Linea game ) {
		playGame( game, 1, 2, 3, 4, 1, 2, 3, 4, 1, 2, 3, 4, 2, 1, 4, 3 );
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
	
    private Linea lineaA4x4() { return new Linea(4, 4, 'A'); }
    private Linea lineaB4x4() { return new Linea(4, 4, 'B'); }
    
    public boolean redWon( Linea game ) { return game.winner().equals( new RedsPlay() ) ; }
    public boolean blueWon( Linea game ) { return game.winner().equals( new BluesPlay() ) ; }
    public boolean noOneWon ( Linea game ) { return game.winner() == null ; }
     
    private void assertThrowsLike( String message, Executable executable ) {
  	  assertEquals( message,
  			  assertThrows( Exception.class, executable ).getMessage() );
    }	
	
}