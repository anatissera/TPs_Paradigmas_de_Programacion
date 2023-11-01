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
	//no tenemos que tener tablero ni arreglo de arreglos.
	    // la lista es de la base, el tamaño de cada columna depende de las fichas que tengo
	    // o sea que inicializo una lista del tamaño del primer argumento que me pasan, o sea de la base
	    // la lista va creciendo en altura con las fichas que se agregan, así vas recorriendo solo las que agregaste y no tenes espacios de más porque sí
	    // la ficha no debe saber dónde está, solo el juego.
	    // lista de columnas
	    
	    
	    private int base;
	    private int altura;
	    private List<List<Character>> columnas;
	    private Turno turno;
	    private Triunfo triunfo;
	    
	    public Linea(int base, int altura, char varianteTriunfo) {
	      
	        this.base = base;
	        this.altura = altura;
//	        this.columnas = new ArrayList<>();
//	        for (int i = 0; i < base; i++) {
//	            columnas.add(new ArrayList<>());
//	        }
	        this.columnas = IntStream.range(0, base)
	                .mapToObj(i -> new ArrayList<Character>())
	                .collect(Collectors.toList());
	        turno = new Turno('R');
	        triunfo = InitializeTriunfo.createTriunfo(varianteTriunfo);
	    } 
	   // Referencia a reporte balance
	 
	    public boolean playRedAt(int columna) {
	        return play('X', columna);
	    }

	    public boolean playBlueAt(int columna) {
	        return play('O', columna);
	    }

	    private boolean play(char color, int columna) {
	        if ( columna < 0 || columna >= base || ColumnIsFull(columna) ) {
	            return false; // este if se puede quedar
	        }

	        columnas.get(columna).add(color);
	        turno.alternarTurno();

	        return finished();  // si puedo poner fichas es que ninguno ganó todavía, hacerlo así
           // mientras el juego no esté finished

	    }

	    public boolean finished() {
	        return triunfo.checkWin(this) || triunfo.checkDraw(this);
	    }

	    public String show() {
	        return IntStream.range(0, alturaMaxActual())
	            .mapToObj(this::getRow)
	            .collect(Collectors.joining("\n"));
	    }

	    private String getRow(int fila) {
	        return IntStream.range(0, base)
	            .mapToObj(columna -> String.valueOf(preguntarAt(columna, fila)))
	            .collect(Collectors.joining(" ")) + " ";
	    }
	    
	    public char preguntarAt(int columna, int fila) {
	        if (fila < columnas.get(columna).size()) {
	            return columnas.get(columna).get(fila);
	        }
	        return ' ';
	    }
	    
	    boolean ColumnIsFull(int columna) {
	        return columnas.get(columna).size() >= altura;
	    } // en la columna particular
	    
	    public int alturaMaxActual() {
	    	 return columnas.stream()
	    		        .map(List::size)
	    		        .reduce(0, Integer::max);
	    } // en todo el juego
	    
	    public int getBase() {
	        return base;
	    }
	    
    // no hay clase fichas, jugador, ni tablero
}