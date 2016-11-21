package sets;

public class LinkedNode<E> {
  private E data;
  private LinkedNode<E> next;
	
  public LinkedNode(E data, LinkedNode<E> next) {
    this.data = data;
    this.next = next;
  }
	
  public E getData(){
    return data;
  }
	
  public LinkedNode<E> getNext(){
    return next;
  }
}
