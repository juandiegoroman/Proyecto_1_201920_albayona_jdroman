package model.data_structures;

public class ListaEncadenada<E> implements IListaEncadenada<E>
{

	private Nodo<E> primero;

	private int tamano;

	@Override
	public void insertarPrimero(E valor) {
		if (estaVacia()){
			primero = new Nodo(valor,null);
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
			primero = new Nodo(valor,null);
		}
		else {

			Nodo<E> actual = primero;
			while (actual.tieneSiguiente()){
				actual = actual.siguiente();
			}

			actual.cambiarSiguiente(new Nodo<E>(valor,null));
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



	private class ListaIterador implements IIterador<E> {

		private Nodo<E> actual;


		ListaIterador(){
			actual = null;
		}

		@Override
		public E siguiente() {

			if (actual == null){
				actual = primero;
			}

			actual = actual.siguiente();

			return actual.valor();
		}

		public  boolean tieneSiguiente(){

		return 	actual.tieneSiguiente();
		}

	}

}
