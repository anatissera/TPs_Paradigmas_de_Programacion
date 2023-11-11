package linea;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.ArrayList;
import java.util.List;

public class Linea {

		public static String NonValidDimentions = "No se puede ganar en este tablero";
		public static String ErrorMessage = "El juego se ha finalizado por un error inesperado:"; // estos van en el print
		public static String InvalidPosition = "La posición debe estar entre 1 y ";
		public static String FullColumn = "Column is full";

	    private int base;
	    private int height;
	    private List<List<Character>> columns;
	    private Triumph triumphVariant;
		private GameState gameState;
//		private boolean isFirstTurn = true; 
	    
	    public Linea( int base, int height, char estrategy ) {
	    	if (base < 4 && height <4) {
	        	throw new RuntimeException( NonValidDimentions );
	        }
	    
	        this.base = base;
	        this.height = height;
	        
	        triumphVariant = Triumph.initializeTriumph( estrategy );
	        gameState = new RedsPlay( );  	
	        
	        columns = IntStream.range( 0, base )
	                .mapToObj( i -> new ArrayList<Character>() )
	                .collect( Collectors.toList() );
	        
	    }
	    
	    public void setGameFinished( String message ) {
	        gameState = new GameOver( "\n" + message );
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
	    	return ( column < 0 || column >= base );
	    }
	    
	    private char askAt(int column, int row) {
	        if ( row >= 0 && row < thisRow(column) ) {
	            return thisColumn(column).get(row);
	        }
	        return ' ';
	    }

	    public void playAsLinea( int  column  ) {
	    	if ( isNotWithinLimits( column ) ) {
	    		setGameFinished ( ErrorMessage + "\n" + InvalidPosition + this.base );
	            throw new RuntimeException( InvalidPosition + this.base );
	        }
	    	if ( ColumnIsFull(column) ) {
	    		setGameFinished ( ErrorMessage + "\n" + FullColumn );
	    		throw new RuntimeException( FullColumn );
	    	}

        	thisColumn(column).add( thisRow(column), gameState.actualPlayerChar() );
	    }

	    public void playRedAt(int columna) {
	    	gameState = gameState.playRed( this,  columna - 1);
	    }

	    public void playBlueAt(int columna) {
	    	gameState = gameState.playBlue( this, columna - 1);
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
	    
	    public boolean checkWin() {
	    	return triumphVariant.checkWin(this);	
	    }
	    
	    public boolean checkDraw() {
	    	return triumphVariant.checkDraw(this);	
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
	        board.append("|\n> ");
	        IntStream.range(0, base)
	        		.forEach(column -> board.append(column + 1 + " "));

//	        if (isFirstTurn) {
//	            board.append("\n\nEmpiezan: ").append( gameState.actualPlayerColor() );
//	            isFirstTurn = false;
//	        }
	        board.append("<\n").append(gameState.getGameFinishedMessage());
	        
	        return board.toString();
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

		public GameState getGameState() {
		    return gameState;
		}
		
		public GameState winner() {
			return gameState.getWinner();
		}
		
}