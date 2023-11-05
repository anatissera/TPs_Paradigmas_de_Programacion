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
	public void test02EnElPrimerEnfrentamientoLuegoDeLaManoJuegaElPie() {
		Linea game = new Linea(4, 4, 'C');
		
		game.playRedAt(1);
	
		assertFalse(game.getTurn().redsTurn());
		assertTrue(game.getTurn().bluesTurn());		
	}
	
	@Test
	public void test03RedsCannotPlayWhenItsBluesTurn() {
	
		Linea game = new Linea(4, 4, 'C');
		
		game.playRedAt(1);
		
		assertThrowsLike( "No es turno" , () -> game.playRedAt(1) );
	
		assertFalse(game.getTurn().redsTurn());
		assertTrue(game.getTurn().bluesTurn());	
		
		// assert que el ultimo que jugo es la ficha en 0,0
		
	}
	
	@Test
	public void test04BluesCannotPlayWhenItsRedsTurn() {
		
		Linea game = new Linea(4, 4, 'C');
		
		game.playRedAt(1);
		game.playBlueAt(1);
		
		assertThrowsLike( "No es turno" , () -> game.playBlueAt(1) );
	
		assertTrue(game.getTurn().redsTurn());
		assertFalse(game.getTurn().bluesTurn());	
		
	}
	
	@Test
	public void test05CannotPlayOnceTheGameIsFinished() {
		Linea game = new Linea(3, 3, 'C');
		assertThrowsLike( "El juego ha terminado" , () -> game.playRedAt(1) );
		
	}
	
	@Test
	public void test06CannotPlayOutsideTheGameSpace() {
		Linea game = new Linea(4, 4, 'C');
		assertThrowsLike( "La posición no se encuentra disponible" , () -> game.playRedAt(5) );
	}
	
	@Test
	public void test07CannotPlayOnAFullColumn() {
		Linea game = new Linea(4, 4, 'C');
		game.playRedAt(1);
		game.playBlueAt(1);
		game.playRedAt(1);
		game.playBlueAt(1);
		assertThrowsLike( "La posición no se encuentra disponible" , () -> game.playRedAt(1) );
	}
	
//	@Test void testGameCannotBeInizializatedWithNonValidStrategy(){
//		assertThrowsLike( "Variante de estrategia no válida" , () -> new Linea(7,6,'K') ); //InitializeTriunfo.NonValidStrategyVariant
//	} //innecesario creo
	
	@Test void testHorizontalWin() {
	    Linea game = new Linea(7, 6, 'A');
	    game.playRedAt(1);
	    game.playBlueAt(1);
	    game.playRedAt(2);
	    game.playBlueAt(2);
	    game.playRedAt(3);
	    game.playBlueAt(3);
	    game.playRedAt(4);
	    assertTrue(game.finished());
	}

	@Test void testVerticalWin() {
	    Linea game = new Linea(7, 6, 'A');
	    game.playRedAt(1);
	    game.playBlueAt(2);
	    game.playRedAt(1);
	    game.playBlueAt(2);
	    game.playRedAt(1);
	    game.playBlueAt(2);
	    game.playRedAt(1);
	    assertTrue(game.finished());
	}

	@Test void testDiagonalFromLeftToRightWin() {
	    Linea game = new Linea(7, 6, 'B');
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
	    assertTrue(game.finished());
	}
	
	@Test void testDiagonalFromRightToLeftWin() {
	    Linea game = new Linea(7, 6, 'B');
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
	    assertTrue(game.finished());
	}
	
	@Test
	void testDraw() {
	    Linea game = new Linea(4, 4, 'A');
	    
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

	    assertTrue(game.finished());
	}

	  private void assertThrowsLike( String message, Executable executable ) {
		  assertEquals( message,
				  assertThrows( Exception.class, executable ).getMessage() );
	  }
	  
	

}
