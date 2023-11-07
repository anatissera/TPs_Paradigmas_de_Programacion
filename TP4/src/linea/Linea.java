package linea;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.ArrayList;
import java.util.List;

// ¿Qué ifs sacar?
// no hay ifs en la estrategia, ni en quien gana ni de quien es el turno
// ¿Cúales se pueden quedar?
// el if de tamaño no se saca

public class Linea {
		
//	     la lista va creciendo en altura con las fichas que se agregan, así vas recorriendo solo las que agregaste y no tenes espacios de más porque sí
//	     la ficha no debe saber dónde está, solo el juego.
//	     lista de columnas
	
		public static String gameHasFinishedErrorDescription = "El juego ha terminado";
		public static String notAvailablePositionErrorDescription = "La posición no se encuentra disponible";

	    private int base;
	    private int height;
	    private List<List<Character>> columns;
	    private GameInProcess turn;
	    public Triumph triumphVariant;
		private GameState gameState;
	    
	    public Linea(int base, int height, char estrategia) {
	        this.base = base;
	        this.height = height;
	        this.columns = IntStream.range(0, base)
	                .mapToObj(i -> new ArrayList<Character>())
	                .collect(Collectors.toList());
	        
			turn = new RedsPlay();
	        triumphVariant = InitializeTriumphVariant.createTriunfo(estrategia);
	    } 
	   // Referencia a reporte balance
	 
	    public void playRedAt(int columna) {
	        play( columna - 1);
			turn = turn.playRed();
	    }

	    public void playBlueAt(int columna) {
	        play( columna - 1);
			turn = turn.playBlue();
	    }

	    private void play( int columna) {
	
	        if (finished()) {
	            throw new RuntimeException(gameHasFinishedErrorDescription);
	        }

	        if (columna < 0 || columna >= base || ColumnIsFull(columna)) { // si quiere poner y está llena se termina el juego
	            throw new RuntimeException(notAvailablePositionErrorDescription);
	        }
	       
	        List<Character> currentColumn = columns.get(columna);
        	int row = currentColumn.size(); 
        	currentColumn.add(row, turn.actualPlayer() );
//	       	turn.alternarTurno();

	    }

	    public boolean finished() {
	        return triumphVariant.checkWin(this) || triumphVariant.checkDraw(this);
	    }
	    
	    public String show() {
	        StringBuilder board = new StringBuilder();

	        IntStream.range(0, height)
	                .mapToObj(row -> "| " +
	                        IntStream.range(0, base)
	                                .mapToObj(column -> {
	                                    char ficha = preguntarAt(column, height - 1 - row);
	                                    return ficha != ' ' ? ficha + " " : "- ";
	                                })
	                                .collect(Collectors.joining()) + "|\n")
	                .forEach(board::append);

	        board.append("| ");
	        IntStream.range(0, base)
	                .forEach(column -> board.append("^ "));
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
	    } 
	    
	    public int maxHeight() {
	    	 return columns.stream()
	    		        .map(List::size)
	    		        .reduce(0, Integer::max);
	    }
	    
	    public int getBase() {
	        return base;
	    }

		public int getHeight() {
			return height;
		}
		
		public Triumph getTriumphVariant() {
		    return triumphVariant;
		}

		public GameInProcess getTurn() {
		    return turn;
		}
	    
	
}
