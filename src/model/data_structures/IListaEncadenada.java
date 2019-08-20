package model.data_structures;

import java.util.Iterator;

public interface IListaEncadenada<E>
{

	void insertarPrimero(E valor);

	void insertarFinal(E valor);

	int tamano();

	boolean estaVacia();

}
