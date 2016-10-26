package test;

public class LinkedList<E> {
	
	protected Container<E> root;
	protected int numberOfObjects;
	
	public LinkedList(){
		root = null;
		numberOfObjects=0;
	}
	
	public void printObjects(){
		if (root==null) {
			System.out.println("null");
		}else{
			Container<E> next = root;
			Container<E> parent = null;
			while(next!=null){
				parent = next;
				next = next.son;
				System.out.println(next.content.toString());
			}
		}
	}
	
	public void addObjects(E object, int objectIndex){
		if(root==null){
			root = new Container<E>(object, null);
		}else{
			Container<E> next = root;
			Container<E> parent = null;
			while(next!=null){
				parent = next;
				next = next.son;
			}
			parent.son = new Container<E>(object, parent);
		}
		numberOfObjects++;
	}
	
	public void deleteObjects(int objectIndex){
		if(root==null){
			return;
		}else{
			Container<E> next = root;
			int i = 0;
			while(i<objectIndex){
				next = next.son;
				i++;
			}
			while(objectIndex<numberOfObjects){
				next = next.son;
				next.content = next.son.content;
				objectIndex++;
			}
			next.son=null;
			numberOfObjects = numberOfObjects-1;
		}
	}
	
	public int getNumberOfObjects(){
		return numberOfObjects;
	}
	
	public E getObject(int objectIndex){
		Container<E> next = root;
		int i = 0;
		while(i<objectIndex){
			next = next.son;
			i++;
		}
		return next.content;
	}
	
	
}
