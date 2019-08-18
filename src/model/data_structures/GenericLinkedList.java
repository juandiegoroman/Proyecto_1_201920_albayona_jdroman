package model.data_structures;

public interface GenericLinkedList<E> 
{
	void push(E v);
	E pop();
	E peek();
	boolean isEmpty();
	
}
