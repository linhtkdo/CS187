package sets;

import java.util.Iterator;
import java.util.NoSuchElementException;

class LinkedNodeIterator<E> implements Iterator<E> {
	// TODO (1) choose appropriate attributes
	private LinkedNode<E> ptr;
	
	// Constructors
	public LinkedNodeIterator(LinkedNode<E> head) {
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
		E e = ptr.getData();
		ptr = ptr.getNext();
		return e;
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}
}
