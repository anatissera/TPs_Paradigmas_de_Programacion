package linea;

import java.util.stream.IntStream;

//¿Qué ifs sacar?
// no hay ifs en la estrategia, ni en quien gana ni de quien es el turno

// crear:
// función preguntar: qué hay en una coordenada, rojo, azul o vacío, o sea: " ", "x", "o"
// la complejidad la tiene preguntar, columna no tiene más que el ancho
// no indexo columnas
// lista de listas :) arreglo de arreglos :(


public class Linea {
	   private int base;
	    private int altura;
	    private char[][] tablero; //no tenemos que tener tablero ni arreglo de arreglos.
	    // la lista es de la base, el tamaño de cada columna depende de las fichas que tengo
	    // la lista va creciendo con las fichas que se agregan, así vas recorriendo solo las que agregaste a nivel altura
	    // la ficha no debe saber dónde está, solo el juego.
	    // lista de columnas
	    
	    private Turno turno;

	    private Triunfo triunfo;

	    public Linea(int base, int altura, char varianteTriunfo) {
	        this.base = base;
	        this.altura = altura;
	        this.tablero = new char[altura][base];
	        turno = new Turno('R');
	        triunfo = InitializeTriunfo.createTriunfo(varianteTriunfo); // los triunfos son polimórficos, la estrategia va sin ifs. 
	        															// Referencia a reporte balance
	    }

	    public boolean playRedAt(int columna) {
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

	          
	            } // si puedo poner fichas es que ninguno ganó todavía, hacerlo así
	            // mientras el juego no esté finished

	        return finished();
	    } 

	    public boolean finished() {
	        return triunfo.checkWin(this) || triunfo.checkDraw(this); // debería estar en las implementaciones de Triunfo
	    }

    public String show() {
        return IntStream.range(0, altura)
            .mapToObj(this::getRow)
            .reduce("", (acc, row) -> acc + row + "\n");
    } // hay que tener un show de esto

    // esta implementación iría en linea?
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
    
    // no hay clase fichas, jugador, ni tablero
}