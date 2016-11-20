package structures;

import java.util.Iterator;
import java.util.NoSuchElementException;

class LinkedNodeIterator<E> implements Iterator<E> {
	// TODO (1) choose appropriate attributes
	private Node<E> ptr;
	
	// Constructors
	public LinkedNodeIterator(Node<E> head) {
		// TODO (2) choose appropriate parameters and do the initialization
		ptr = head;
	}

	@Override
	public boolean hasNext() {
		// TODO (3)
		return ptr != null;
	}

	@Override
	public E next() {
		// TODO (4)
		if (!hasNext()) throw new NoSuchElementException();
		E e = ptr.getInfo();
		ptr = ptr.getLink();
		return e;
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}
}
