package hangman;

public class LinkedListGameModel implements GameModel {

	private int state;
	private String word;
	private LLCharacterNode prev;
	private LLCharacterNode board;
	private int numGuesses;

	public LinkedListGameModel(String guessWord) {
		state = STARTING_STATE;
		word = guessWord;

		for (int i = 0; i < word.length(); i++) {
			LLCharacterNode n = new LLCharacterNode('_');
			n.setLink(board);
			board = n;
		}
	}

	@Override
	public boolean isPriorGuess(char guess) {
		// TODO
		LLCharacterNode n = prev;
		while (n != null) {
			if (guess == n.getInfo()) {
				return true;
			}
			n = n.getLink();
		}
		return false;
	}

	@Override
	public int numberOfGuesses() {
		// TODO Auto-generated method stub
		return numGuesses;
	}

	@Override
	public boolean isCorrectGuess(char guess) {
		// TODO Auto-generated method stub
		return word.indexOf(guess) >= 0 && !isPriorGuess(guess);
	}

	@Override
	public boolean doMove(char guess) {
		// TODO Auto-generated method stub
		if (isPriorGuess(guess))
			return false;

		LLCharacterNode newNode = new LLCharacterNode(guess);
		if (prev == null)
			prev = newNode;
		else {
			LLCharacterNode n = prev;
			while (n.getLink() != null)
				n = n.getLink();
			n.setLink(newNode);
		}

		numGuesses++;

		int index = word.indexOf(guess);
		if (index < 0) {
			state++;
			return false;
		}

		LLCharacterNode m = board;
		int i = 0;
		while (index >= 0) {
			while (i != index) {
				m = m.getLink();
				i++;
			}
			m.setInfo(guess);
			index = word.indexOf(guess, index + 1);
		}
		return true;
	}

	@Override
	public boolean inWinningState() {
		// TODO Auto-generated method stub
		LLCharacterNode n = board;
		while (n != null) {
			if (n.getInfo() == '_')
				return false;
			n = n.getLink();
		}
		return true;
	}

	@Override
	public boolean inLosingState() {
		// TODO Auto-generated method stub
		return state == NUMBER_OF_STATES;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		LLCharacterNode n = board;
		while (n != null) {
			sb.append(n.getInfo());
			if (n.getLink() != null)
				sb.append(' ');
			n = n.getLink();
		}
		return sb.toString();
	}

	@Override
	public int getState() {
		// TODO Auto-generated method stub
		return state;
	}

	@Override
	public String previousGuessString() {
		// TODO Auto-generated method stub
		LLCharacterNode n = prev;
		StringBuilder sb = new StringBuilder();
		sb.append('[');
		while (n != null) {
			sb.append(n.getInfo());
			if (n.getLink() != null)
				sb.append(", ");
			n = n.getLink();
		}
		sb.append(']');
		return sb.toString();
	}

	@Override
	public String getWord() {
		// TODO Auto-generated method stub
		return word;
	}

}
