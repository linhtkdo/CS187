package hanoi;

/**
 * A {@link ArrayBasedHanoiBoard} is a simple implementation of
 * {@link HanoiBoard}
 * 
 * @author jcollard
 * 
 */
public class ArrayBasedHanoiBoard implements HanoiBoard {

	/**
	 * Creates a {@link ArrayBasedHanoiBoard} with three empty {@link HanoiPeg}s
	 * and {@code n} rings on peg 0.
	 */
	private HanoiPeg[] pegs;

	public ArrayBasedHanoiBoard(int n) {
		if (n < 0) throw new IllegalArgumentException();
		pegs = new StackBasedHanoiPeg[3];
		for (int i=0; i<3; i++)
			pegs[i] = new StackBasedHanoiPeg();
		for (int i = n; i > 0; i--)
			pegs[0].addRing(new HanoiRing(i));
	}

	@Override
	public void doMove(HanoiMove move) throws IllegalHanoiMoveException {
		if (!isLegalMove(move))
			throw new IllegalHanoiMoveException("illegal move");
		HanoiPeg fromPeg = pegs[move.getFromPeg()];
		HanoiRing ring = fromPeg.remove();
		HanoiPeg toPeg = pegs[move.getToPeg()];
		toPeg.addRing(ring);
	}

	@Override
	public boolean isSolved() {
		return !pegs[0].hasRings() && !pegs[1].hasRings();
	}

	/**
	 * <p>
	 * A {@link HanoiMove} is not legal if either is true:
	 * 
	 * <ul>
	 * <li>The from peg has no rings</li>
	 * <li>The to peg has rings AND the ring to be moved has a size larger than
	 * the topmost ring on the to peg.</li>
	 * </ul>
	 * 
	 * Otherwise, the move is legal.
	 * </p>
	 */
	@Override
	public boolean isLegalMove(HanoiMove move) {
		HanoiPeg fromPeg = pegs[move.getFromPeg()];
		HanoiPeg toPeg = pegs[move.getToPeg()];
		if (!fromPeg.hasRings()) return false;
		HanoiRing ring = fromPeg.getTopRing();
		if (toPeg.hasRings() && ring.getSize() >= toPeg.getTopRing().getSize()) return false;
		return true;
	}
}
