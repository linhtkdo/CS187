package structures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListIterator<T> implements Iterator<T> {
	private Node<T> ptr;
	
	public ListIterator(Node<T> head) {
		ptr = head;
	}
	public boolean hasNext() {
		return ptr != null;
	}
	public T next() {
		if (!hasNext()) throw new NoSuchElementException();
		T e = ptr.getData();
		ptr = ptr.getNext();
		return e;
	}

}
 