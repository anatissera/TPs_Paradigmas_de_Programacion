package queue;

import java.util.ArrayList;

public class NonEmptyQueueState extends QueueState {

    private final QueueState previousState;

    public NonEmptyQueueState(QueueState previousDoes) {
        this.previousState = previousDoes;
    }

    public QueueState previousState() {
        return previousState;
    }

    public Object head(ArrayList<Object> queueElements) {
        return queueElements.get(0);
    }
}
