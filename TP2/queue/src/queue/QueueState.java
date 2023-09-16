package queue;

import java.util.ArrayList;

	public abstract class QueueState {
	    public abstract Object head(ArrayList<Object> queueElements);
	    public abstract QueueState previousState();

	}
