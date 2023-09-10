package queueTester;
import java.util.ArrayList;

public class NonEmptyQueue extends Queue {

	private ArrayList<Object> queueElements = new ArrayList<>();
	private int size = 0;
	
    public boolean isEmpty() {return false;}
    
    public Queue add( Object cargo ) {
		queueElements.add(cargo);
		size ++;
		return this; }
		
	public Object take() {
		size --;
		return queueElements.remove(0);
		}
				
	public Object head() {
		return queueElements.get(0);
		}
}

