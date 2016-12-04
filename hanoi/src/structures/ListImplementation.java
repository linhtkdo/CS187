package structures;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * An {@code ListImplementation} is a Linked List that wraps {@link Node}s and
 * provides useful operations.
 * 
 * @author jcollard
 * 
 */
public class ListImplementation<T> implements ListInterface<T> {
	private Node<T> head;
	private Node<T> last;
	private int size;

	public ListImplementation() {
	}

	/**
	 * Returns the number of nodes in this list.
	 */
	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return head == null;
	}

	/**
	 * Appends {@code elem} to the end of this {@code ListImplementation} and
	 * returns itself for convenience.
	 */
	@Override
	public ListImplementation<T> append(T elem) {
		if (elem == null) throw new NullPointerException();
		Node<T> nn = new Node<T>(elem, null);
		if (!isEmpty()) last.setNext(nn);
		else head = nn;
		last = nn;
		size++;
		return this;
	}

	/**
	 * Gets the {@code n}th element from this list.
	 */
	@Override
	public T get(int n) {
		Iterator<T> iter = iterator();
		if (n < 0 || n > size) throw new NoSuchElementException();
		while (n > 0) {
			iter.next();
			n--;
		}
		return iter.next();
	}

	/**
	 * Returns an iterator over this list. The iterator does not support the
	 * {@code remove()} method.
	 */
	@Override
	public Iterator<T> iterator() {
		return new ListIterator<T>(head);
	}
}
