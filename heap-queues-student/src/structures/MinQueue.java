package structures;

import comparators.ReverseIntegerComparator;

import java.util.Comparator;
import java.util.Iterator;

public class MinQueue<V> implements PriorityQueue<Integer, V> {
	StudentArrayHeap<Integer, V> heap;
	
	public MinQueue() {
		ReverseIntegerComparator comparator = new ReverseIntegerComparator();
		heap = new StudentArrayHeap<Integer, V>(comparator);
	}
	
	@Override
	public PriorityQueue<Integer, V> enqueue(Integer priority, V value) {
		// TODO 
		heap.add(priority, value);
		return this;
	}

	@Override
	public V dequeue() {
		// TODO 
		return heap.remove();
	}

	@Override
	public V peek() {
		// TODO 
		if (heap.isEmpty())
			throw new IllegalStateException();
		return heap.peek();
	}

	@Override
	public Iterator<Entry<Integer, V>> iterator() {
		// TODO 
		return heap.asList().iterator();
	}

	@Override
	public Comparator<Integer> getComparator() {
		// TODO 
		return heap.getComparator();
	}

	@Override
	public int size() {
		// TODO 
		return heap.size();
	}

	@Override
	public boolean isEmpty() {
		// TODO 
		return heap.isEmpty();
	}
}

