package model.data_structures;


public interface IListaIterador<E> {

    boolean haySiguiente();

    boolean hayAnterior();

    E siguiente();

    E anterior();


}
