package structures;

public class Node<T> {
	private T info;
	private Node<T> link;

	public Node(T info) {
		this.info = info;
		this.link = null;
	}

	public T getInfo() {
		return info;
	}

	public Node<T> getLink() {
		return link;
	}

	public void setInfo(T info) {
		this.info = info;
	}

	public void setLink(Node<T> link) {
		this.link = link;

	}
}
