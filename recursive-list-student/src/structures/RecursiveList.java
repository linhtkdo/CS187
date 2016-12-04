package structures;

import java.util.Iterator;

public class RecursiveList<T> implements ListInterface<T> {
	
	protected int numElements;
	protected Node<T> list;
	@Override
	public Iterator<T> iterator() {
		return new LinkedNodeIterator<T>(list);
	}

	@Override
	public int size() {
		return numElements;
	}

	@Override
	public ListInterface<T> insertFirst(T elem) {
		return insertAt(0, elem);
//		Node<T> nn = new Node<T>(elem);
//		nn.setLink(list);
//		list = nn;
//		numElements++;
//		return this;
	}

	@Override
	public ListInterface<T> insertLast(T elem) {
		return insertAt(numElements, elem);
//		Node<T> nn = new Node<T>(elem);
//		if (list == null) list = nn;
//		else insertLastHelper(list, nn);
//		numElements++;
//		return this;
	}
	
//	private void insertLastHelper(Node<T> curr, Node<T> insert) {
//		if (curr.getLink() == null) {
//			curr.setLink(insert);
//			return;
//		}
//		insertLastHelper(curr.getLink(), insert);
//	}

	@Override
	public ListInterface<T> insertAt(int index, T elem) {
		if (index < 0 || index > numElements) throw new IndexOutOfBoundsException();
		if (elem == null) throw new NullPointerException();
		Node<T> nn = new Node<T>(elem);
		if (index == 0) {
			nn.setLink(list);
			list = nn;
		}
		else insertHelper(list, index, nn);
		numElements++;
		return this;
	}
	
	private void insertHelper(Node<T> curr, int index, Node<T> nn) {
		if (index == 1) {
			nn.setLink(curr.getLink());
			curr.setLink(nn);
		}
		else insertHelper(curr.getLink(), index - 1, nn);
	}
	
	

	@Override
	public T removeFirst() {
		if (isEmpty()) throw new IllegalStateException();
		return removeAt(0);
//		if (list == null) return null;
//		T elem = list.getInfo();
//		list = list.getLink();
//		numElements--;
//		return elem;
	}

	@Override
	public T removeLast() {
		if (isEmpty()) throw new IllegalStateException();
		return removeAt(numElements - 1);
//		if (list == null) return null;
//		if (list.getLink() == null) return removeFirst(); 
//		return removeLastHelper(list);
	}
	
//	private T removeLastHelper(Node<T> curr) {
//		if (curr.getLink().getLink() == null) {
//			T elem = curr.getLink().getInfo();
//			curr.setLink(null);
//			numElements--;
//			return elem;
//		}
//		return removeLastHelper(curr.getLink());
//	}

	@Override
	public T removeAt(int i) {
		if (i < 0 || i >= numElements) throw new IndexOutOfBoundsException();
		T elem;
		if (i == 0) {
			elem = list.getInfo();
			list = list.getLink();
		}
		else elem = removeHelper(list, i);
		numElements--;
		return elem;
	}
	
	private T removeHelper(Node<T> curr, int i) {
		if (i == 1) {
			T elem = curr.getLink().getInfo();
			curr.setLink(curr.getLink().getLink());
			return elem;
		}
		return removeHelper(curr.getLink(), i - 1);
	}

	@Override
	public T getFirst() {
		if (isEmpty()) throw new IllegalStateException();
		return get(0);
	}

	@Override
	public T getLast() {
		if (isEmpty()) throw new IllegalStateException();
		return get(numElements - 1);
	}
	
//	private T getLastHelper(Node<T> curr) {
//		if (curr.getLink() == null) return curr.getInfo();
//		return getLastHelper(curr.getLink());
//	}

	@Override
	public T get(int i) {
		if (i < 0 || i >= numElements) throw new IndexOutOfBoundsException();
		return getHelper(list, i);
	}
	
	private T getHelper(Node<T> curr, int i) {
		if (i == 0) return curr.getInfo();
		return getHelper(curr.getLink(), i - 1);
	}

	@Override
	public boolean remove(T elem) {
		int index = indexOf(elem);
		if (index == -1) return false;
		removeAt(index);
		return true;
	}

	@Override
	public int indexOf(T elem) {
		if (elem == null) throw new NullPointerException();
		return indexOf(elem, list, 0);
	}
	
	private int indexOf(T toFind, Node<T> toCheck, int currentIndex) {
		if (toCheck == null) return -1;
		if (toCheck.getInfo().equals(toFind)) return currentIndex;
		return indexOf(toFind, toCheck.getLink(), currentIndex + 1);
	}

	@Override
	public boolean isEmpty() {
		return list == null;
	}

}
