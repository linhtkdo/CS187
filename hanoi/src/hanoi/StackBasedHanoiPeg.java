package hanoi;

import structures.LinkedStack;
import structures.StackInterface;

/**
 * A {@link StackBasedHanoiPeg} is a {@link HanoiPeg} backed by a
 * {@link LinkedStack}
 * 
 * @author jcollard
 *
 */
public class StackBasedHanoiPeg implements HanoiPeg {
	/**
	 * Creates a new {@link StackBasedHanoiPeg} that has no rings.
	 */
	private LinkedStack<HanoiRing> peg;
	public StackBasedHanoiPeg() {
		peg = new LinkedStack<HanoiRing>();
	}

	@Override
	public void addRing(HanoiRing ring) throws IllegalHanoiMoveException {
		if (!peg.isEmpty() && ring.getSize() >= peg.peek().getSize()) throw new IllegalHanoiMoveException("ring is bigger than top of peg ");
		peg.push(ring);
	}

	@Override
	public HanoiRing remove() throws IllegalHanoiMoveException {
		if (peg.isEmpty()) throw new IllegalHanoiMoveException("remove from empty peg");
		return peg.pop();
	}

	@Override
	public HanoiRing getTopRing() throws IllegalHanoiMoveException {
		if (peg.isEmpty()) throw new IllegalHanoiMoveException("peek from empty peg");
		return peg.peek();
	}

	@Override
	public boolean hasRings() {
		return !peg.isEmpty();
	}
}
