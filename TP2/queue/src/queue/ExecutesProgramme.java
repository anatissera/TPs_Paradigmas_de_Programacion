package queueTester;

import java.util.ArrayList;

public class ExecutesProgramme extends Variables {

    private final Variables previousState;

    public ExecutesProgramme(Variables previousDoes) {
        this.previousState = previousDoes;
    }

    public Variables previousState() {
        return previousState;
    }

    public Object head(ArrayList<Object> queueElements) {
        return queueElements.get(0);
    }
}