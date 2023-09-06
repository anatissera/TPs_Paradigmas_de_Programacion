package queue;

public class Queue {
	
	public int size = 0;

  public boolean isEmpty() {
		return size == 0;
	}

	public Queue add( Object  cargo ) {
		// TODO Auto-generated method stub
		return this;
		size ++;
	}

	public Object take() {
    // TODO Auto-generated method stub
		return null;
	}

	public Object head() {
		// TODO Auto-generated method stub
    return null;
	}

	public int size() {
		return size;
	}

}
