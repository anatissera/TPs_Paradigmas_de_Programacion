package queueTester;

public class EmptyQueue extends Queue {
	
	public boolean isEmpty() {return true;}
	
	public Queue add( Object cargo ) {
		return new NonEmptyQueue(cargo);}
	
	public Object take() {
		throw new EmptyQueueError();}


	public Object head() {
		throw new EmptyQueueError(); }
	
	public int size() {return 0;}


}
