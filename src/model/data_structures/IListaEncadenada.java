package model.data_structures;

public interface IListaEncadenada<E>
{
	void insertarPrimero(E valor);

	void insertarFinal(E valor);

	void insertarAntes(E valor);

	void insertarDespues(E valor);

	int tamano();

	boolean estaVacia();

	IListaIterador<E> iterador();

}
