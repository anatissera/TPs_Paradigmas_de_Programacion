package linea;

import java.util.stream.IntStream;

public class Linea {
	   private int base;
	    private int altura;
	    private char[][] tablero;
	    private Turno turno;

	    private Triunfo triunfo;

	    public Linea(int base, int altura, char varianteTriunfo) {
	        this.base = base;
	        this.altura = altura;
	        this.tablero = new char[altura][base];
	        turno = new Turno('R');
	        triunfo = InitializeTriunfo.createTriunfo(varianteTriunfo);
	    }

	    public boolean playRedkAt(int columna) {
	        return play('R', columna);
	    }

	    public boolean playBlueAt(int columna) {
	        return play('B', columna);
	    }
	    
	    private boolean play(char jugador, int columna) {
	        int fila = findAvailableRow(columna);
	        if (fila != -1) {
	            tablero[fila][columna] = jugador;
	            turno.alternarTurno();

	            boolean win = triunfo.checkWin(this, fila, columna, jugador);
	            if (win) {
	                return true;
	            }

	            boolean draw = triunfo.checkDraw(this);
	            if (draw) {
	                return true;
	            }
	        }
	        return false;
	    } // debería estar en las implementaciones de Triunfo


	    public boolean finished() {
	        return triunfo.checkWin(this) || triunfo.checkDraw(this);
	    }

    public String show() {
        return IntStream.range(0, altura)
            .mapToObj(this::getRow)
            .reduce("", (acc, row) -> acc + row + "\n");
    }

    private String getRow(int fila) {
        return IntStream.range(0, base)
            .mapToObj(columna -> String.valueOf(tablero[fila][columna]))
            .reduce("", (acc, cell) -> acc + cell + " ");
    }


    private int findAvailableRow(int columna) {
        return IntStream.range(0, altura)
            .filter(fila -> tablero[fila][columna] == 0)
            .findFirst()
            .orElse(-1);
    }
}