package linea;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.ArrayList;
import java.util.List;

public class Linea {

		public static String InvalidDimentions = "Invalid dimensions: There's no winning on this Game Space";
		public static String ErrorMessage = "The Game has finished due to an unexpected Error: ";
		public static String InvalidPosition = "Position must be between 1 and ";
		public static String FullColumn = "Column is full";

	    private int base;
	    private int height;
	    private List<List<Character>> columns;
	    private Mode triumphVariant;
		private GameState gameState;
	    
	    public Linea( int base, int height, char estrategy ) {
	    	if (base < 4 && height <4) {
	        	throw new RuntimeException( InvalidDimentions );
	        }
	    	
	        this.base = base;
	        this.height = height;
	        
	        triumphVariant = Mode.initializeTriumphMode( estrategy );
	        gameState = new RedsPlay( );  	
	        
	        columns = IntStream.range( 0, base )
	                .mapToObj( i -> new ArrayList<Character>() )
	                .collect( Collectors.toList() );
	    }
	    
	    public void setGameFinished( String message ) {
	        gameState = new GameOver( "\n" + message, message );
	    }

	    public void playAsLinea( int  column, char toPlay  ) {
	    	if ( isNotWithinLimits( column ) ) {
	    		setGameFinished ( ErrorMessage + "\n" + InvalidPosition + this.base );
	            throw new RuntimeException( InvalidPosition + this.base );
	        }
	    	if ( ColumnIsFull(column) ) {
	    		setGameFinished ( ErrorMessage + "\n" + FullColumn );
	    		throw new RuntimeException( FullColumn );
	    	}
	    	
        	thisColumn(column).add( thisRow(column), toPlay );
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
	    
	    public boolean allColumnsAreFull () {
	    	return ( IntStream.range( 0, base )
	                .allMatch(columna -> ColumnIsFull(columna)) );
	    }
	    
	    public boolean checkWin() { return triumphVariant.checkWin(this); }
	    
	    public boolean checkDraw() { return triumphVariant.checkDraw(this);	}
	    
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
	        board.append("<\n").append( gameState.getGameFinishedMessage() );
	        
	        return board.toString();
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
	    
	    public boolean finished() {
	    	return gameState.isGameFinished();
	    }
	    
	    public boolean ColumnIsFull( int column ) {
	        return thisRow(column) >= height;
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
	    
	    
//	    Accessors
	    
	    public int getBase() { return base; }

		public int getHeight() { return height; }
		
		public boolean isRedsTurn() { return gameState.isRedsTurn(); }
		
		public boolean isBluesTurn() { return gameState.isBluesTurn(); }
		
		public GameState winner() { return gameState.getWinner(); }
			
}