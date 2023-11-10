package linea;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.ArrayList;
import java.util.List;

// ¿Qué ifs sacar?
// no hay ifs en la estrategia, ni en quien gana, ni de quien es el turno
// ¿Cúales se pueden quedar?
// el if de tamaño no se saca

public class Linea {
		


//	     la ficha no debe saber dónde está, solo el juego.
//	     lista de columnas
	
		public static String notAvailablePositionErrorDescription = "La posición no se encuentra disponible";
		private static String NonValidDimentions = "No se puede ganar en este tablero";

	    private int base;
	    private int height;
	    private List<List<Character>> columns;
	    private Triumph triumphVariant;
		private GameState gameState;
		public String gameFinishedMessage = "";
	    
	    public Linea(int base, int height, char estrategia) {
	    	gameState = new RedsPlay();
	    	
	    	if (base < 4 && height <4) {
	        	setGameFinished( NonValidDimentions );
	        }
	    	
	        this.base = base;
	        this.height = height;
	        this.columns = IntStream.range(0, base)
	                .mapToObj(i -> new ArrayList<Character>())
	                .collect(Collectors.toList());
	        
	        triumphVariant = Triumph.createTriumph(estrategia);
	        
	    }

	    public void setGameFinished( String message ) {
	    	gameFinishedMessage = message;
	        gameState = new GameFinished();
	    }

	    public void playRedAt(int columna) {
	    	gameState = gameState.playRed( this,  columna - 1);
	    	triumphVariant.SetWinOrDraw(this);
	    }

	    public void playBlueAt(int columna) {
	    	gameState = gameState.playBlue( this, columna - 1);
	    	triumphVariant.SetWinOrDraw(this);
	    }
	    
	    public void playAsLinea( int columna ) {
	    	if ( isNotWithinLimits(columna) ) {
	            throw new RuntimeException( notAvailablePositionErrorDescription );
	        }
	       
	        List<Character> currentColumn = columns.get(columna);
        	int row = currentColumn.size(); 
        	currentColumn.add(row, gameState.actualPlayerChar() );
	    }
	    
	    public boolean ColumnIsFull(int column) {
	        return columns.get(column).size() >= height;
	    } 
	    
	    private boolean isNotWithinLimits ( int columna ) {
	    	return ( columna < 0 || columna >= base || ColumnIsFull(columna) );
	    }
	    
	    private char askAt(int column, int row) {
	        if (row < columns.get(column).size()) {
	            return columns.get(column).get(row);
	        }
	        return ' ';
	    }
	    
	    public boolean checkConnected4( int ColumnsLimit, int RowsLimit, int deltaColumn, int deltaRow, boolean checkDiagonalBounds) {

		    return IntStream.range(0, ColumnsLimit)
		        .anyMatch(column -> IntStream.range(0, RowsLimit)
		            .anyMatch(row -> {
		                char piece = askAt(column, row);

		                return IntStream.range(1, 4)
		                    .allMatch(i -> piece != ' ' && 
		                    		(!checkDiagonalBounds || (column + i * deltaColumn < ColumnsLimit && column + i * deltaColumn >= 0) && 
		                                   (row + i * deltaRow < RowsLimit && row + i * deltaRow >= 0) ) && 
		                                   piece == askAt(column + i * deltaColumn, row + i * deltaRow) );
		            }));
		}

	    public boolean finished() {
//	    	return gameState.isGameFinished();
	    	return triumphVariant.checkWin(this)||triumphVariant.checkDraw(this); 
	    }
	    
	    public String show() {
	        StringBuilder board = new StringBuilder();

	        IntStream.range(0, height)
	                .mapToObj(row -> "| " +
	                        IntStream.range(0, base)
	                                .mapToObj(column -> {
	                                    char ficha = askAt(column, height - 1 - row);
	                                    return ficha != ' ' ? ficha + " " : "- ";
	                                })
	                                .collect(Collectors.joining()) + "|\n")
	                .forEach(board::append);

	        board.append("| ");
	        IntStream.range(0, base)
	                .forEach(column -> board.append("^ "));
	        board.append("|\n");

	        return board.toString() + gameFinishedMessage ;
	    }

	    
	    public int maxHeight() {
	    	 return columns.stream()
	    		        .map(List::size)
	    		        .reduce(0, Integer::max);
	    }
	    
//	    Accessors
	    
	    public int getBase() {
	        return base;
	    }

		public int getHeight() {
			return height;
		}
		
		public Triumph getTriumphVariant() {
		    return triumphVariant;
		}

		public GameState getTurn() {
		    return gameState;
		}
}
