package model.data_structures;

import java.util.Iterator;

public interface IListaEncadenada<E>
{

	void insertarPrimero(E valor);

	void insertarFinal(E valor);
	
	void ordenar();
	
	E buscar(int indice) throws Exception;
	
	E eliminar(int indice) throws Exception;

	int tamano();

	boolean estaVacia();

}
