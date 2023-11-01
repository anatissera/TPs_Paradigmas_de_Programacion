package linea;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class connect4Test {
	
	@Test void testHorizontalWin() {
	    Linea game = new Linea(7, 6, 'A');
	    game.playRedAt(0);
	    game.playRedAt(1);
	    game.playRedAt(2);
	    game.playRedAt(3);
	    assertTrue(game.finished());
	}

	@Test void testVerticalWin() {
	    Linea game = new Linea(7, 6, 'A');
	    game.playRedAt(0);
	    game.playRedAt(0);
	    game.playRedAt(0);
	    game.playRedAt(0);
	    assertTrue(game.finished());
	}

	@Test void testDiagonalWin() {
	    Linea game = new Linea(7, 6, 'B');
	    game.playRedAt(0);
	    game.playBlueAt(1);
	    game.playRedAt(1);
	    game.playBlueAt(2);
	    game.playRedAt(2);
	    game.playBlueAt(2);
	    game.playRedAt(3);
	    game.playBlueAt(3);
	    game.playRedAt(3);
	    assertTrue(game.finished());
	}

	@Test
	void testDraw() {
	    Linea game = new Linea(4, 4, 'A');
	    
	    game.playRedAt(0);
	    game.playBlueAt(1);
	    game.playRedAt(2);
	    game.playBlueAt(3);
	    game.playRedAt(0);
	    game.playBlueAt(1);
	    game.playRedAt(2);
	    game.playBlueAt(3);
	    game.playRedAt(0);
	    game.playBlueAt(1);
	    game.playRedAt(2);
	    game.playBlueAt(3);

	    assertTrue(game.finished());
	}

	@Test void test(){

	}

}
