package queueTester;
import java.util.ArrayList;

public class Queue {
	
	private ArrayList<Object> queueElements = new ArrayList<>();
	
	Variables does = new ThrowsError();

	boolean isEmpty() {
		return queueElements.isEmpty();
	}
	
	Queue add(Object cargo) {
		queueElements.add(cargo);
		does = does.nextState();
		return this;
	}
	
	Object take() {
		does = does.previousState(); 
		return queueElements.remove(0);
	}
	
	Object head() {
		return does.head(queueElements);
	}
	
	int size() {
		return queueElements.size();
	}
	
	public ArrayList<Object> getQueueElements() {
	       return queueElements;
	}
	    
}
