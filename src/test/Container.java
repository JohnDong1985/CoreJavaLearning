package test;

public class Container<E> {
	public E content;
	public Container<E> parent;
	public Container<E> son;
	
	public Container(E object, Container<E> parent){
		content = object;
		this.parent = parent;
		parent = null;
		son = null;
	}
}