package linea;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.ArrayList;
import java.util.List;

// ¿Qué ifs sacar?
// no hay ifs en la estrategia, ni en quien gana, ni de quien es el turno
// ¿Cúales se pueden quedar?
// el if de tamaño no se saca, el de finished tampoco

public class Linea {

		public static String notAvailablePositionErrorDescription = "La posición no se encuentra disponible";
		private static String NonValidDimentions = "No se puede ganar en este tablero";
		private static String ErrorMessage = "Ha ocurrido un error inesperado"; // estos van en el print

	    private int base;
	    private int height;
	    private List<List<Character>> columns;
	    private Triumph triumphVariant;
		private GameState gameState;
		public String gameFinishedMessage = "";
	    
	    public Linea( int base, int height, char estrategia ) {
	    
	    	gameState = new RedsPlay( null );  	
	    	if (base < 4 && height <4) {
	        	setGameFinished( "\n" + NonValidDimentions );
	        }
	    	
	        this.base = base;
	        this.height = height;
	        this.columns = IntStream.range( 0, base )
	                .mapToObj( i -> new ArrayList<Character>() )
	                .collect( Collectors.toList() );
	        
	        triumphVariant = Triumph.initializeTriumph( estrategia );
	        
	    }
	    
	    public void setGameFinished( String message ) {
	    	gameFinishedMessage = message;
	        gameState = new GameFinished();
	    }
	    
	    public boolean finished() {
	    	return gameState.isGameFinished();
	    }
	    
	    public int actualMaxHeight() {
	    	 return columns.stream()
	    		        .map(List::size)
	    		        .reduce(0, Integer::max);
	    }
	    
	    private List<Character> thisColumn( int column ) {
	    	return columns.get(column);
	    }
	    
	    private int thisRow( int column ) {
	    	return thisColumn( column ).size(); 
	    }
	    
	    public boolean ColumnIsFull( int column ) {
	        return thisRow(column) >= height;
	    } 
	    
	    public boolean allColumnsAreFull () {
	    	return ( IntStream.range( 0, base )
	                .allMatch(columna -> ColumnIsFull(columna)) );
	    }
	    private boolean isNotWithinLimits ( int column ) {
	    	return ( column < 0 || column >= base || ColumnIsFull(column) );
	    }
	    
	    private char askAt(int column, int row) {
	        if ( row >= 0 && row < thisRow(column) ) {
	            return thisColumn(column).get(row);
	        }
	        return ' ';
	    }

	    public void playAsLinea( int  column  ) {
	    	if ( isNotWithinLimits( column ) ) {
	    		setGameFinished( ErrorMessage );
	            throw new RuntimeException( notAvailablePositionErrorDescription );
	        }

        	thisColumn(column).add( thisRow(column), gameState.actualPlayerChar() );
	    }

	    public void playRedAt(int columna) {
	    	gameState = gameState.playRed( this,  columna - 1);
	    	triumphVariant.SetWinOrDraw(this);
	    }

	    public void playBlueAt(int columna) {
	    	gameState = gameState.playBlue( this, columna - 1);
	    	triumphVariant.SetWinOrDraw(this);
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
	        board.append("|\n  ");
	        IntStream.range(0, base)
	        		.forEach(column -> board.append(column + 1 + " "));

	        return board.toString() + "\n" + gameFinishedMessage ;
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
