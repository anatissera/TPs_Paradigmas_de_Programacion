package queue;
import java.util.ArrayList;

import hanoi.Disc;

public class Queue {
	
	public static String EmptyQueue = "Queue is empty";
	public static String ExpectedErrorFail = "Expected Error was not thrown.";
	
	private int size = 0;
	
	private ArrayList<Queue> queueElements = new ArrayList();
	
	
	public boolean isEmpty() {
		return queueElements.size() == 0;
	}

	public Queue add( Object cargo ) {
		queueElements.add(cargo);
		size ++;
	}

	public Object take() {
		size --;
		return queueElements.remove(0);
	}

	public Object head() {
		return queueElements.get(0);
	}

	public int size() {
		return size;
	}

}
