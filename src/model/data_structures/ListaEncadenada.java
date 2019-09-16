	package model.data_structures;

import com.sun.org.apache.regexp.internal.recompile;

public class ListaEncadenada<E> implements IListaEncadenada<E>, IListaIterable<E> {
	
		private Nodo<E> primero;
	
		private Nodo<E> ultimo;
	
		private int tamano;
	
		public ListaEncadenada() {
			tamano = 0;
		}
	
		@Override
		public void insertarPrimero(E valor) {
			if (estaVacia()) {
				primero = new Nodo(valor, null,null);
				ultimo = primero;
			}
	
			else {
				Nodo<E> f = primero;
				primero = new Nodo<>(valor, f, null);
			}
	
			tamano++;
		}
	
		@Override
		public void insertarFinal(E valor) {
			if (estaVacia()) {
				ultimo = new Nodo(valor, null, null);
				primero = ultimo;
			} else {
	
				Nodo<E> temp = ultimo;
	
				ultimo = new Nodo(valor, null, temp);

				temp.insertar(ultimo);
			}
	
			tamano++;
		}
	
		@Override
		public E buscar(int indice) throws RuntimeException {
	
			int cont = 0;
	
			if (indice >= tamano)
				throw new RuntimeException("Desborde: " + indice);
	
			Nodo<E> actual = primero;
	
			while (cont < indice) {
				actual = actual.siguiente();
				cont++;
			}
	
			return actual.valor();
	
		}
	
		@Override
		public E eliminar(int indice) throws RuntimeException{
	
			if(indice >= tamano) throw new RuntimeException("Desborde: " + indice);
	
			Nodo<E> anterior = null;
			Nodo<E> aEliminar = null;
			
			if(indice == 0) {				
				aEliminar = primero;
				primero = primero.siguiente();
		
			}
	
			else {
	
				int cont = 0;
	
				anterior = primero;
	
				while(cont < indice - 1) {
					anterior = anterior.siguiente();
					cont++;
				}
	
				aEliminar = anterior.siguiente();
	
				anterior.insertar(aEliminar.siguiente());	
	
			}
			
			tamano--;
			
			return aEliminar.valor();
	
		}
		
		
		Nodo split(Nodo head) { 
	        Nodo fast = head;
	        		
	        		Nodo slow = head; 
	        while (fast.siguiente() != null && fast.siguiente().siguiente() != null) { 
	            fast = fast.siguiente().siguiente(); 
	            slow = slow.siguiente(); 
	        } 
	        Nodo temp = slow.siguiente(); 
	        slow.siguiente() = null; 
	        return temp; 
	    } 
	  
	    Nodo mergeSort(Nodo nodo) { 
	        if (nodo == null || nodo.siguiente() == null) { 
	            return nodo; 
	        } 
	        Nodo second = split(nodo); 
	  
	        // Recur for left and right halves 
	        nodo = mergeSort(nodo); 
	        second = mergeSort(second); 
	  
	        // Merge the two sorted halves 
	        return merge(nodo, second); 
	    } 
	  
	    // Function to merge two linked lists 
	    Nodo merge(Nodo first, Nodo second) { 
	        // If first linked list is empty 
	        if (first == null) { 
	            return second; 
	        } 
	  
	        // If second linked list is empty 
	        if (second == null) { 
	            return first; 
	        } 
	  
	        // Pick the smaller value 
	        if (first.data < second.data) { 
	            first.siguiente() = merge(first.next, second); 
	            first.siguiente().anterior() = first; 
	            first.anterior() = null; 
	            return first; 
	        } else { 
	            second.siguiente() = merge(first, second.next); 
	            second.siguiente().anterior() = second; 
	            second.anterior() = null; 
	            return second; 
	        } 
	    } 
	  
	    // Driver program to test above functions 
	    public static void main(String[] args) { 
	  
	        ListaEncadenada list = new ListaEncadenada<>(); 
	        list.head = new Nodo(10); 
	        list.head.next = new Nodo(30); 
	        list.head.next.next = new Nodo(3); 
	        list.head.next.next.next = new Nodo(4); 
	        list.head.next.next.next.next = new Nodo(20); 
	        list.head.next.next.next.next.next = new Nodo(5); 
	          
	          
	        Node node = null; 
	        node = list.mergeSort(head); 
	        System.out.println("Linked list after sorting :"); 
	        list.print(node); 
	    }
	    
	
		public void ordenar()
		{
			
		}

	@Override
	public int tamano() {
		return tamano;
	}
	
	@Override
	public boolean estaVacia() {
		return primero == null;
	}
	
	private class ListaIterador implements IListaIterador<E> {
	
		private Nodo<E> actual;
	
		ListaIterador() {
			actual = null;
		}
	
		@Override
		public E siguiente() {
	
			if (actual == null) {
				actual = primero;
			}
	
			else {
	
				if(actual.haySiguiente()) actual = actual.siguiente();
	
			}
	
			return (actual != null) ? actual.valor() : null;
		}
	
		public boolean haySiguiente() {
	
			if(primero == null) return false;
			
			return (actual == null) ? true : actual.haySiguiente();
		}
	
	}
	
	public IListaIterador<E> iterador() {
		return new ListaIterador();
	}
	

	
	}
