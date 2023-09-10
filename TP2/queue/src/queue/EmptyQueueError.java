package queueTester;

public class EmptyQueueError extends Error {
	
	public static String EmptyQueueMessage = "Queue is empty";
	
	public String getMessage() {
		return EmptyQueueMessage;
	}
}