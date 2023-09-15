package queueTester;

import java.util.ArrayList;

public class EmptyQueueState extends QueueState {

	public static String EmptyQueueMessage = "Queue is empty";

    public QueueState previousState() {
    	throw new Error(EmptyQueueMessage);
    }

    public Object head(ArrayList<Object> queueElements) {
    	throw new Error(EmptyQueueMessage);
    }
    
}
