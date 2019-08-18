package model.data_structures;

import java.util.EmptyStackException;

public class LinkedList<E> implements GenericLinkedList<E> 
{

	private static class Element<E>{
		private E data;
		private Element<E> next;
		Element(E data, Element<E> next){
			this.data = data;
			this.next = next;
			
		}
	}
	private Element<E> top;
	
	@Override
	public void push(E v) {
		if( v== null)
		{
			throw new NullPointerException();
		}
		top = new Element<E>(v, top);
		
	}

	@Override
	public E pop() {
		if( isEmpty())
		{
			throw new EmptyStackException();
		}
		E data = top.data;
		top = top.next;
		
		return data;
	}

	@Override
	public E peek() {
		if( isEmpty())
		{
			throw new EmptyStackException();
		}
		E data = top.data;
		
		return data;
	}

	@Override
	public boolean isEmpty() {
		return (top == null);
	}

}
