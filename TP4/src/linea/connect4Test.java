package linea;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.function.Executable;

public class connect4Test {
	
//	@BeforeEach
//	public void setUp() {
//		Linea game = new Linea(4, 4, 'C');
//	}
	
	@Test
    public void test01RedsAlwaysStart() {
		Linea game = new Linea(4, 4, 'C');
		
		assertTrue(game.getTurn().redsTurn());
		assertFalse(game.getTurn().bluesTurn());
}
	
	@Test
	public void test02BluePlaysAfterRedTurn() {
		Linea game = new Linea(4, 4, 'C');
		
		game.playRedAt(1);
	
		assertFalse(game.getTurn().redsTurn());
		assertTrue(game.getTurn().bluesTurn());		
	}
	
	@Test
	public void test03RedsCannotPlayWhenItsBluesTurn() {
		Linea game = new Linea(4, 4, 'C');
		
		game.playRedAt(1);
		
		assertThrowsLike( Turno.notTurnErrorDescription , () -> game.playRedAt(1) );
	
		assertFalse(game.getTurn().redsTurn());
		assertTrue(game.getTurn().bluesTurn());	
		
		// assert que el ultimo que jugo es la ficha en 0,0
		
	}
	
	@Test
	public void test04BluesCannotPlayWhenItsRedsTurn() {
		
		Linea game = new Linea(4, 4, 'C');
		
		game.playRedAt(1);
		game.playBlueAt(1);
		
		assertThrowsLike( Turno.notTurnErrorDescription , () -> game.playBlueAt(1) );
	
		assertTrue(game.getTurn().redsTurn());
		assertFalse(game.getTurn().bluesTurn());	
		
	}
	
	@Test
	public void test05CannotPlayOnceTheGameIsFinished() {
		Linea game = new Linea(3, 3, 'C');
		assertThrowsLike( Linea.gameHasFinishedErrorDescription , () -> game.playRedAt(1) );
	}
	
	@Test
	public void test06CannotPlayOutsideTheGameSpace() {
		Linea game = new Linea(4, 4, 'C');
		assertThrowsLike(Linea.notAvailablePositionErrorDescription , () -> game.playRedAt(5) );
	}
	
	@Test
	public void test07CannotPlayOnAFullColumn() {
		Linea game = new Linea(4, 4, 'C');
		game.playRedAt(1);
		game.playBlueAt(1);
		game.playRedAt(1);
		game.playBlueAt(1);
		assertThrowsLike( Linea.notAvailablePositionErrorDescription , () -> game.playRedAt(1) );
	}
	
//	@Test void testGameCannotBeInizializatedWithNonValidStrategy(){
//		assertThrowsLike( "Variante de estrategia no válida" , () -> new Linea(7,6,'K') ); //InitializeTriunfo.NonValidStrategyVariant
//	} //innecesario creo
	
	@Test void testHorizontalWin() {
	    assertTrue(horizontalWin('A'));
	}

	@Test void testVerticalWin() {
		assertTrue(verticalWin('A'));
	}

	@Test void testDiagonalFromLeftToRightWin() {
		assertTrue(diagonalFromLeftToRightWin('B'));
	}
	
	@Test void testDiagonalFromRightToLeftWin() {
		assertTrue(diagonalFromRightToLeftWin('B'));
	}
	
	@Test void testTriumphCWorksWithHorizontalWin() {
		assertTrue(horizontalWin('C'));
	}
	
	@Test void testTriumphCWorksWithVerticalWin() {
		assertTrue(verticalWin('C'));
	}
	
	@Test void testTriumphCWorksWithDiagonalFromLeftToRightWin() {
		assertTrue(diagonalFromLeftToRightWin('C'));
	}
	
	@Test void testTriumphCWorksWithDiagonalFromRightToLeftWin() {
		assertTrue(diagonalFromRightToLeftWin('C'));
	}
	
	@Test void testTriumphADoesNotWorkWithDiagonalWin() {
		assertFalse(diagonalFromLeftToRightWin('A'));
	}
	
	@Test void testTriumphBDoesNorWorkWithHorizontalWin() {
		assertFalse(horizontalWin('B'));
	}
	
	@Test void testTriumphBDoesNorWorkWithVerticallWin() {
		assertFalse(verticalWin('B'));
	}
	
	@Test
	void testDraw() {
	    Linea game = new Linea(4, 4, 'A');
	    drawGame(game);
	    assertTrue(game.finished());
	}
	
	@Test
	public void testCannotPlayAfterADraw() {
		Linea game = new Linea(4, 4, 'C');
	    drawGame(game);
		assertThrowsLike( Linea.gameHasFinishedErrorDescription , () -> game.playRedAt(1) );
	}

	  private void assertThrowsLike( String message, Executable executable ) {
		  assertEquals( message,
				  assertThrows( Exception.class, executable ).getMessage() );
	  }
	  
		private boolean horizontalWin(char triumphKey) {
			Linea game = new Linea(7, 6, triumphKey);
		    game.playRedAt(1);
		    game.playBlueAt(1);
		    game.playRedAt(2);
		    game.playBlueAt(2);
		    game.playRedAt(3);
		    game.playBlueAt(3);
		    game.playRedAt(4);
		    return game.finished();
		}
		
		private boolean verticalWin(char triumphKey) {
			Linea game = new Linea(7, 6, triumphKey);
		    game.playRedAt(1);
		    game.playBlueAt(2);
		    game.playRedAt(1);
		    game.playBlueAt(2);
		    game.playRedAt(1);
		    game.playBlueAt(2);
		    game.playRedAt(1);
		    return game.finished();
		}
		
		private boolean diagonalFromLeftToRightWin(char triumphKey) {
			Linea game = new Linea(7, 6, triumphKey);
		    game.playRedAt(1);
		    game.playBlueAt(2);
		    game.playRedAt(2);
		    game.playBlueAt(3);
		    game.playRedAt(3);
		    game.playBlueAt(4);
		    game.playRedAt(3);
		    game.playBlueAt(4);
		    game.playRedAt(4);
		    game.playBlueAt(1);
		    game.playRedAt(4);
		    return game.finished();
		}
		
		private boolean diagonalFromRightToLeftWin(char triumphKey) {
			Linea game = new Linea(7, 6, triumphKey);
		    game.playRedAt(4);
		    game.playBlueAt(3);
		    game.playRedAt(3);
		    game.playBlueAt(2);
		    game.playRedAt(2);
		    game.playBlueAt(1);
		    game.playRedAt(2);
		    game.playBlueAt(1);
		    game.playRedAt(1);
		    game.playBlueAt(4);
		    game.playRedAt(1);
		    return game.finished();
		}
		
		private void drawGame(Linea game) {
			game.playRedAt(1);
		    game.playBlueAt(2);
		    game.playRedAt(3);
		    game.playBlueAt(4);
		    game.playRedAt(1);
		    game.playBlueAt(2);
		    game.playRedAt(3);
		    game.playBlueAt(4);
		    game.playRedAt(1);
		    game.playBlueAt(2);
		    game.playRedAt(3);
		    game.playBlueAt(4);
		    game.playRedAt(2);
		    game.playBlueAt(1);
		    game.playRedAt(4);
		    game.playBlueAt(3);
		}
}
