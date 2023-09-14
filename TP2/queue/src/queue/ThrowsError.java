package queueTester;

import java.util.ArrayList;

public class ThrowsError extends Variables {

	public static String EmptyQueueMessage = "Queue is empty";

    public Variables previousState() {
        throw new Error(EmptyQueueMessage);
    }

    public Object head(ArrayList<Object> queueElements) {
        throw new Error(EmptyQueueMessage);
    }
}
