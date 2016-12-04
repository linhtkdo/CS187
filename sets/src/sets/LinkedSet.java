package sets;

import java.util.Iterator;

public class LinkedSet<E> implements Set<E> {
	private LinkedNode<E> head = null;

	// Constructors
	public LinkedSet() {
	}

	public LinkedSet(E e) {
		this.head = new LinkedNode<E>(e, null);
	}

	private LinkedSet(LinkedNode<E> head) {
		this.head = head;
	}

	@Override
	public int size() {
		// TODO (1)
		int result = 0;
		for (E e : this) {
			result++;
		}
		return result;
	}

	@Override
	public boolean isEmpty() {
		// TODO (2)
		return head == null;
	}

	@Override
	public Iterator<E> iterator() {
		return new LinkedNodeIterator<E>(this.head);
	}

	@Override
	public boolean contains(Object o) {
		// TODO (3)
		for (E e : this)
			if (e.equals(o))
				return true;
		return false;
	}

	@Override
	public boolean isSubset(Set<E> that) {
		// TODO (4)
		for (E e : this)
			if (!that.contains(e))
				return false;
		return true;
	}

	@Override
	public boolean isSuperset(Set<E> that) {
		// TODO (5)
		return that.isSubset(this);
	}

	@Override
	public Set<E> adjoin(E e) {
		// TODO (6)
		if (contains(e))
			return this;
		LinkedNode<E> ptr = new LinkedNode<E>(e, null);
		for (E o : this) {
			LinkedNode<E> newNode = new LinkedNode<E>(o, ptr);
			ptr = newNode;
		}
		return new LinkedSet<E>(ptr);
	}

	@Override
	public Set<E> union(Set<E> that) {
		// TODO (7)
		LinkedNode<E> ptr = null;
		LinkedNode<E> newNode;
		for (E e : this) {
			newNode = new LinkedNode<E>(e, ptr);
			ptr = newNode;
		}
		for (E e : that)
			if (!this.contains(e)) {
				newNode = new LinkedNode<E>(e, ptr);
				ptr = newNode;
			}
		return new LinkedSet<E>(ptr);
	}

	@Override
	public Set<E> intersect(Set<E> that) {
		// TODO (8)
		LinkedNode<E> ptr = null;
		LinkedNode<E> newNode;
		for (E e : this)
			if (that.contains(e)) {
				newNode = new LinkedNode<E>(e, ptr);
				ptr = newNode;
			}
		return new LinkedSet<E>(ptr);
	}

	@Override
	public Set<E> subtract(Set<E> that) {
		// TODO (9)
		LinkedNode<E> ptr = null;
		LinkedNode<E> newNode;
		for (E e : this)
			if (!that.contains(e)) {
				newNode = new LinkedNode<E>(e, ptr);
				ptr = newNode;
			}
		return new LinkedSet<E>(ptr);
	}

	@Override
	public Set<E> remove(E e) {
		// TODO (10)
		if (!this.contains(e)) return this;
		LinkedNode<E> ptr = null;
		LinkedNode<E> newNode;
		for (E o : this) 
			if (!o.equals(e)) {
				newNode = new LinkedNode<E>(o, ptr);
				ptr = newNode;
			}
		return new LinkedSet<E>(ptr);
	}

	@Override
	@SuppressWarnings("unchecked")
	public boolean equals(Object o) {
		if (!(o instanceof Set)) {
			return false;
		}
		Set<E> that = (Set<E>) o;
		return this.isSubset(that) && that.isSubset(this);
	}

	@Override
	public int hashCode() {
		int result = 0;
		for (E e : this) {
			result += e.hashCode();
		}
		return result;
	}
}
