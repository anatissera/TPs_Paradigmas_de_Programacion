package queueTester;
import java.util.ArrayList;

public abstract class Queue {
	
//	private int size = 0;
//	
//	private ArrayList<Object> queueElements = new ArrayList<>();
//	
//
//	static Queue EmptyQueue() {
//		return new EmptyQueue();
//		}
//		
//	static Queue NonEmptyQueue() {
//		return new NonEmptyQueue();
//	}

	public abstract boolean isEmpty();
	public abstract Queue add( Object cargo );
	public abstract Object take();
	public abstract Object head();
	public abstract int size();


}
