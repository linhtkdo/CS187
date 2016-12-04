package structures;

import java.util.Comparator;
import java.util.Iterator;

public class StudentArrayHeap<P, V> extends AbstractArrayHeap<P, V> {
	public StudentArrayHeap(Comparator<P> comparator) {
		super(comparator);
	}

	@Override
	protected int getLeftChildOf(int index) {
		// TODO 
		if (index < 0) throw new IndexOutOfBoundsException();
		return 2*index + 1;
	}

	@Override
	protected int getRightChildOf(int index) {
		// TODO 
		if (index < 0) throw new IndexOutOfBoundsException();
		return 2*index + 2;
	}

	@Override
	protected int getParentOf(int index) {
		// TODO 
		if (index < 1) throw new IndexOutOfBoundsException();
		return (index-1)/2;
	}

	@Override
	protected void bubbleUp(int index) {
		// TODO 
		Entry<P, V> elem = heap.get(index);
		int hole = index;
		int parent = (hole-1)/2;
		while ((hole > 0) && getComparator().compare(elem.getPriority(), heap.get(parent).getPriority()) > 0) {
			heap.set(hole, heap.get(parent));
			hole = parent;
			parent = (parent-1)/2;
		}
		heap.set(hole, elem);	
	}

	@Override
	protected void bubbleDown(int index) {
		// TODO 
		Entry<P, V> elem = heap.get(0);
		int largerChild, hole=0, left=1, right=2;
		while (left <= heap.size()-1) {
			if (right <= heap.size()-1 && 
				getComparator().compare(heap.get(left).getPriority(), heap.get(right).getPriority()) < 0)
				largerChild = right; 
			else
				largerChild = left;
			if (getComparator().compare(elem.getPriority(), heap.get(largerChild).getPriority()) >= 0)
				break;
			heap.set(hole, heap.get(largerChild));
			hole = largerChild;
			left = (hole*2)+1;
			right = (hole*2)+2;
		}
		heap.set(hole, elem);
	}
	
	
}

