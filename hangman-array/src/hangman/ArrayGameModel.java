package hangman;

import java.util.Arrays;

/**
* The Array implementation of the GameModel interface.
*/
public class ArrayGameModel implements GameModel {

    /** The acceptable characters. */
    private static final String ALPHABET="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    /** hung state */
    private int state;
    private String word;
    private char[] prev;
    private char[] board;
    private int numGuesses;
    
    /**
        * Creates a new ArrayGameModel object.
        * 
        * guessWord the word to guess
        */
    public ArrayGameModel(String guessWord) {
        // TODO (1)
    	state = STARTING_STATE;
    	word = guessWord;
    	board = new char[word.length()];
    	for (int i=0; i<word.length(); i++) board[i] = '_';
    	prev = new char[NUMBER_OF_STATES + word.length()];
    	numGuesses = 0;
    }

    public boolean isPriorGuess(char guess) {
        // TODO (2)
    	for (char c : prev) 
    		if (c == guess) return true;
    	return false;
    }

    public int numberOfGuesses() {
        // TODO (3)
        return numGuesses;
    }

    public boolean isCorrectGuess(char guess) {
        // TODO (4)
        return word.indexOf(guess) >= 0 && !isPriorGuess(guess);
    }



    public boolean doMove(char guess) {
        // TODO (5)
    	if (isPriorGuess(guess)) return false;
    	
		prev[numGuesses++] = guess;
		int index = word.indexOf(guess);
		if (index < 0) {
			state++;
			return false;
		}
		while (index >= 0) {
			board[index] = guess;
			index = word.indexOf(guess, index + 1);
		}
		return true;
    }

    public boolean inWinningState() {
        // TODO (6)
        return Arrays.equals(board, word.toCharArray());
    }

    public boolean inLosingState() {
        // TODO (7)
        return state == NUMBER_OF_STATES;
    }

    public String toString() {
        // TODO (8)
    	String s = "";
    	for (char c : board) {
    		s = s + c + " ";
    	}
        return s.substring(0, s.length()-1);
    }

    public String previousGuessString() {
        // TODO (9)
    	if (numberOfGuesses() == 0) return "[]";
    	String s = "[";
    	for (int i=0; i<numGuesses-1; i++) {
    		s = s + prev[i] + ", ";
    	}
    	return s + prev[numGuesses-1] + "]";	
    }

    public int getState() {
        return state;
    }
    

    public String getWord() {
        // TODO (10)
        return word;
    }
}
