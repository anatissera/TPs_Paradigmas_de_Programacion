package queueTester;

import java.util.ArrayList;

	public abstract class Variables {
	    public abstract Object head(ArrayList<Object> queueElements);
	    public abstract Variables previousState();
	    public Variables nextState() {
	        return new ExecutesProgramme(this);
	    }
	}
//}
