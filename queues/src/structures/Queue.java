package structures;

import java.util.NoSuchElementException;

public class Queue<T> implements UnboundedQueueInterface<T> {

	protected Node<T> front;
	protected Node<T> rear;
	protected int size;
	
	public Queue() {
		// TODO 1
	}

	public Queue(Queue<T> other) {
		// TODO 2
		Node<T> ptr = other.front;
		while (ptr != null) {
			this.enqueue(ptr.getData());
			ptr = ptr.getNext();
		}
	}

	@Override
	public boolean isEmpty() {
		// TODO 3
		return front == null;
	}

	@Override
	public int size() {
		// TODO 4
		return size;
	}

	@Override
	public void enqueue(T element) {
		// TODO 5
		Node<T> nn = new Node<T>(element);
		size++;
		if (rear == null)
			front = nn;
		else
			rear.setNext(nn);
		rear = nn;
	}

	@Override
	public T dequeue() throws NoSuchElementException {
		// TODO 6
		if (isEmpty()) 
			throw new NoSuchElementException("empty queue");
		else {
			T e = front.getData();
			front = front.getNext();
			if (front == null) rear = null;
			size--;
			return e;
		}
	}

	@Override
	public T peek() throws NoSuchElementException {
		// TODO 7
		if (isEmpty()) 
			throw new NoSuchElementException("empty queue");
		return front.getData();
	}

	@Override
	public UnboundedQueueInterface<T> reversed() {
		// TODO 8
		Queue<T> ret = new Queue<T>();
		helper(front, ret);
		return ret;
	}
	
	private void helper(Node<T> n, Queue<T> ret) {
		if (n != null) {
			helper(n.getNext(), ret);
			ret.enqueue(n.getData());
		}
	}
}
