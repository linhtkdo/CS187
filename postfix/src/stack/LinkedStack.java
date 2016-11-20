package stack;

/**
 * A {@link LinkedStack} is a stack that is implemented using a Linked List
 * structure to allow for unbounded size.
 *
 * @param <T>
 *            the elements stored in the stack
 */
public class LinkedStack<T> implements StackInterface<T> {

	private LLNode<T> top;
	private int size;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T pop() throws StackUnderflowException {
		// TODO
		if (!isEmpty()) {
			T ret = top.getData();
			top = top.getNext();
			size--;
			return ret;
		}
		throw new StackUnderflowException("pop from empty");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T top() throws StackUnderflowException {
		// TODO
		if (!isEmpty()) return top.getData();
		throw new StackUnderflowException("top of empty stack");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isEmpty() {
		// TODO
		return top == null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int size() {
		// TODO
		return size;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void push(T elem) {
		// TODO
		LLNode<T> nn = new LLNode<T>(elem);
		nn.setNext(top);
		top = nn;
		size++;
	}

}
