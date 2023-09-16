package queue;
import java.util.ArrayList;

public class Queue {
	
	private ArrayList<Object> queueElements = new ArrayList<>();
	
	QueueState state = new EmptyQueueState();

	boolean isEmpty() {
		return queueElements.isEmpty();
	}
	
	Queue add(Object cargo) {
		queueElements.add(cargo);
		state = new NonEmptyQueueState(state);
		return this;
	}
	
	Object take() {
		state = state.previousState(); 
		return queueElements.remove(0);
	}
	
	Object head() {
		return state.head(queueElements);
	}
	
	int size() {
		return queueElements.size();
	}
   
}
