package structures;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

public class PublicMaxQueueTest {

  MaxQueue<String> queue;
	
  @Before
  public void setup() {
    queue = new MaxQueue<String>();
  }

  @Test (timeout = 100)
  public void testQueue() {
    queue.enqueue(100, "Highest priority");
    queue.enqueue(50, "High priority");
    queue.enqueue(25, "Medium priority");
    queue.enqueue(0, "Low priority");
    assertEquals("Highest priority", queue.dequeue());
    assertEquals("High priority", queue.dequeue());
    assertEquals("Medium priority", queue.dequeue());
    assertEquals("Low priority", queue.dequeue());
  }

}
