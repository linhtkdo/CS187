package hangman;

public class LLCharacterNode {
	private char info;
	private LLCharacterNode link;
	
	public LLCharacterNode(char info) {
		this.info = info;
	}
	
	public char getInfo() {
		return info;
	}
	
	public void setInfo(char i) {
		info = i;
	}
	
	public LLCharacterNode getLink() {
		return link;
	}
	
	public void setLink(LLCharacterNode lk) {
		link = lk;
	}
	
}
