package queueTester;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

public class QueueTest {
	
	private String addedObject = "Something";
	private String firstAddedObject = "First";
	private String secondAddedObject = "Second";

  @Test public void test01QueueShouldBeEmptyWhenCreated() {
    assertTrue( new Queue().isEmpty() );
  }

  @Test public void test02AddElementsToTheQueue() {
    assertFalse( queueWithSomething().isEmpty() );
  }

  @Test public void test03AddedElementsIsAtHead() {
    assertEquals( addedObject, queueWithSomething().head() );
  }

  @Test public void test04TakeRemovesElementsFromTheQueue() {
    Queue queue = queueWithSomething();
    queue.take();
    assertTrue( queue.isEmpty() );
  }

  @Test public void test05TakeReturnsLastAddedObject() {
	assertEquals( addedObject, queueWithSomething().take() );
  }

  @Test public void test06QueueBehavesFIFO() {
    Queue queue = queueWithTwoObjects();
    assertEquals( queue.take(), firstAddedObject );
    assertEquals( queue.take(), secondAddedObject );
    assertTrue( queue.isEmpty() );
  }

  @Test public void test07HeadReturnsFirstAddedObject() {
    assertEquals( queueWithTwoObjects().head(), firstAddedObject );
  }

  @Test public void test08HeadDoesNotRemoveObjectFromQueue() {
    Queue queue = queueWithSomething();
    assertEquals( 1, queue.size() );
    queue.head();
    assertEquals( 1, queue.size() );
  }

  @Test public void test09SizeRepresentsObjectInTheQueue() {
    assertEquals( 2, queueWithTwoObjects().size() );
  }

  @Test public void test10CanNotTakeWhenThereAreNoObjectsInTheQueue() {
    emptyQueueMessageEqualsErrorMessage(() -> new Queue().take());
    }

  @Test public void test11CanNotTakeWhenThereAreNoObjectsInTheQueueAndTheQueueHadObjects() {
    Queue queue = new Queue();
    queue.add( addedObject );
    queue.take();
    emptyQueueMessageEqualsErrorMessage(()-> queue.take());
  }

  @Test public void test12CanNotHeadWhenThereAreNoObjectsInTheQueue() {
    emptyQueueMessageEqualsErrorMessage(()-> new Queue().head());
  }
 
  private Queue queueWithSomething() {
	return new Queue().add( addedObject );
  }
  
  private Queue queueWithTwoObjects() {
	Queue queue = new Queue();
	queue.add( firstAddedObject );
	queue.add( secondAddedObject );
	return queue;
  }

  private void emptyQueueMessageEqualsErrorMessage( Executable executable ) {
	assertEquals( EmptyQueueState.EmptyQueueMessage, 
			assertThrows( Error.class, executable ).getMessage() );
  }
}