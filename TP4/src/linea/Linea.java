package linea;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.ArrayList;
import java.util.List;

// ¿Qué ifs sacar?
// no hay ifs en la estrategia, ni en quien gana ni de quien es el turno
// ¿Cúales se pueden quedar?
// el if de tamaño no se saca

// crear:
// función preguntar: qué hay en una coordenada, rojo, azul o vacío, o sea: " ", "x", "o"
// la complejidad la tiene preguntar, columna no tiene más que el ancho
// no indexo columnas
// lista de listas :) arreglo de arreglos :(

public class Linea {
//		no tenemos que tener tablero ni arreglo de arreglos.
//	     la lista es de la base, el tamaño de cada columna depende de las fichas que tengo
//	     o sea que inicializo una lista del tamaño del primer argumento que me pasan, o sea de la base
//	     la lista va creciendo en altura con las fichas que se agregan, así vas recorriendo solo las que agregaste y no tenes espacios de más porque sí
//	     la ficha no debe saber dónde está, solo el juego.
//	     lista de columnas

	    private int base;
	    private int height;
	    private List<List<Character>> columns;
	    private Turno turn;
	    private Triumph triumphVariant;
	    
	    public Linea(int base, int height, char estrategia) {
	        this.base = base;
	        this.height = height;
	        this.columns = IntStream.range(0, base)
	                .mapToObj(i -> new ArrayList<Character>())
	                .collect(Collectors.toList());
	        
	        turn = new Turno('X'); // X es rojas/negras
	        triumphVariant = InitializeTriumphVariant.createTriunfo(estrategia);
	    } 
	   // Referencia a reporte balance
	 
	    public boolean playRedAt(int columna) {
	        return play('X', columna);
	    }

	    public boolean playBlueAt(int columna) {
	        return play('O', columna); // O es azules
	    }

	    private boolean play(char color, int columna) {
	        if ( columna < 0 || columna >= base || ColumnIsFull(columna) ) {
	            return false; // hay que agregar un mensaje de error??
	        }
	        else {
	        	  List<Character> currentColumn = columns.get(columna);
	        	  int row = currentColumn.size(); // Obtener la fila superior disponible
	        	  currentColumn.add(row, color); // Agregar en la fila superior disponible
	        	  turn.alternarTurno();
	        }

	        return finished();  // si puedo poner fichas es que ninguno ganó todavía, hacerlo así
           // mientras el juego no esté finished

	    }

	    public boolean finished() {
	        return triumphVariant.checkWin(this) || triumphVariant.checkDraw(this);
	    }
	    
	    public String show() {
	        StringBuilder board = new StringBuilder();

	        for (int row = height - 1; row >= 0; row--) {
	            board.append("| ");
	            for (int column = 0; column < base; column++) {
	                char ficha = preguntarAt(column, row);
	                board.append(ficha != ' ' ? ficha : "-");
	                board.append(" ");
	            }
	            board.append("|\n");
	        }

	        board.append("| ");
	        for (int column = 0; column < base; column++) {
	            board.append("^ ");
	        }
	        board.append("|\n");

	        return board.toString();
	    }


	    public char preguntarAt(int column, int row) {
	        if (row < columns.get(column).size()) {
	            return columns.get(column).get(row);
	        }
	        return ' ';
	    }
	    
	    boolean ColumnIsFull(int column) {
	        return columns.get(column).size() >= height;
	    } // en la columna particular
	    
	    public int alturaMaxActual() {
	    	 return columns.stream()
	    		        .map(List::size)
	    		        .reduce(0, Integer::max);
	    } // en todo el juego
	    
	    public int getBase() {
	        return base;
	    }

		public int getHeight() {
			return height;
		}
	    
    // no hay clase fichas, jugador, ni tablero
	    
	// que pasa si quiere poner una ficha en una columna que no existe?
	// 
}


// Cada lista interna representa una columna en el juego
// y contiene caracteres que representan las fichas de los jugadores.
//
// Para gestionar las filas, se utiliza el método alturaMaxActual(). Este método recorre todas las columnas 
// y devuelve la altura máxima actual del juego, es decir, la cantidad de fichas en la columna más alta. 
// Esto se hace utilizando Stream para mapear el tamaño de cada columna y luego calcular el máximo con reduce.
//
// La representación de las filas se gestiona en el método getRow(fila). Este método crea una fila del juego, 
// que es una cadena de caracteres, combinando las fichas en la misma fila de todas las columnas. Se utiliza 
// IntStream.range(0, base) para recorrer las columnas y preguntarAt(columna, fila) para obtener el carácter en la posición actual.
//
// El método preguntarAt(columna, fila) verifica si hay una ficha en la posición especificada en el tablero. 
// Si la columna contiene una ficha en la fila proporcionada, se devuelve el carácter correspondiente 
// (que puede ser 'X' para las fichas rojas, 'O' para las fichas azules o ' ' para espacios vacíos). 
// Si no hay una ficha en esa posición, se devuelve un espacio en blanco.
//
// El método ColumnIsFull(columna) verifica si una columna está llena, es decir, si ya contiene la cantidad 
// máxima de fichas permitidas en esa columna. Esto se hace comprobando si el tamaño de la lista interna de 
// la columna es igual o mayor que la altura máxima permitida

// En resumen, la gestión de las filas en este código se realiza mediante la creación y manipulación de una 
// estructura de datos de lista de listas, donde cada lista interna representa una columna y contiene las 
// fichas de los jugadores en el orden en el que se han colocado. La altura máxima actual se calcula 
// recorriendo todas las columnas, y las filas se generan concatenando las fichas correspondientes de cada columna.