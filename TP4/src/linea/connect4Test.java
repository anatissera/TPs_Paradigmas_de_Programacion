package linea;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class connect4Test {
	
	@Test
	public void test01() {
		
	}
	
	@Test
	public void testHorizontalWin() {
	    Linea game = new Linea(7, 6, 'C');
	    game.playRedkAt(0);
	    game.playRedkAt(1);
	    game.playRedkAt(2);
	    game.playRedkAt(3);
	    assertTrue(game.finished());
	    // Verificar que el jugador Rojo gane horizontalmente.
	}

	@Test
	public void testVerticalWin() {
	    Linea game = new Linea(7, 6, 'C');
	    game.playRedkAt(0);
	    game.playRedkAt(0);
	    game.playRedkAt(0);
	    game.playRedkAt(0);
	    assertTrue(game.finished());
	    // Verificar que el jugador Rojo gane verticalmente.
	}

	@Test
	public void testDiagonalWin() {
	    Linea game = new Linea(7, 6, 'C');
	    game.playRedkAt(0);
	    game.playBlueAt(1);
	    game.playRedkAt(1);
	    game.playBlueAt(2);
	    game.playRedkAt(2);
	    game.playBlueAt(2);
	    game.playRedkAt(3);
	    game.playBlueAt(3);
	    game.playRedkAt(3);
	    assertTrue(game.finished());
	    // Verificar que el jugador Rojo gane diagonalmente.
	}

	@Test
	public void testDraw() {
	    Linea game = new Linea(7, 6, 'C');
	    // Realizar una serie de jugadas que no resulten en victoria.
	    assertTrue(game.finished());
	    // Verificar que el juego termine en empate.
	}


}
