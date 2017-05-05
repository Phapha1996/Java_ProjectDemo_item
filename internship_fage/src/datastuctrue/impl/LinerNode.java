package datastuctrue.impl;

public class LinerNode<T> {

	private T element;
	private LinerNode<T> next;

	
	public LinerNode(T element){
		this.element = element;
		next = null;
	}
	
	
	public LinerNode(T element,LinerNode<T> next){
		this.element = element;
		this.next = next;
	}
	
	
	public T getElement() {
		return element;
	}
	
	
	public void setElement(T element) {
		this.element = element;
	}
	
	
	public LinerNode<T> getNext() {
		return next;
	}
	
	
	public void setNext(LinerNode<T> next) {
		this.next = next;
	}
	
}
