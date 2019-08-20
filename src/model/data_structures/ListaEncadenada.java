package model.data_structures;

public class ListaEncadenada<E> implements IListaEncadenada<E>, IListaIterable<E>
{

	private Nodo<E> primero;
	
	private Nodo<E> ultimo;
	
	private int tamano;

	public ListaEncadenada() {
		tamano = 0;
	}
	
	@Override
	public void insertarPrimero(E valor) {
		if (estaVacia()){
			primero = new Nodo(valor,null);
			ultimo = primero;
		}

		else {
			Nodo<E> f = primero;
			primero = new Nodo<>(valor, f);
		}

		tamano++;
	}

	@Override
	public void insertarFinal(E valor) {
		if (estaVacia()){
			ultimo = new Nodo(valor,null);
			primero = ultimo;
		}
		else {

			Nodo<E> temp = ultimo;

			ultimo = new Nodo(valor, null);

			temp.cambiarSiguiente(ultimo);

		}

		tamano++;
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


		ListaIterador(){
			actual = null;
		}

		@Override
		public E siguiente() {

			if (actual == null){
				actual = primero;
			}

			else {

				actual = actual.siguiente();

			}

			return actual.valor();
		}

		public  boolean haySiguiente(){

		return 	actual.haySiguiente();
		}

	}
	
	public IListaIterador<E> iterador()
	{
		return new ListaIterador();
	}

}
