package model.data_structures;

// Linked List Class
public class ListaEncadenada<E> {

    private Nodo<E> actual;

    private Nodo<E> primero;

    private Nodo<E> ultimo;

    private int tamano;

    /* Node Class */
    public static class Nodo<E> {

        E valor;
        Nodo siguiente, anterior;

        // Constructor to create a new node
        Nodo(E elemento, Nodo<E> siguiente, Nodo<E> anterior) {
            this.valor = elemento;
            this.siguiente = siguiente;
            this.anterior = anterior;
        }
    }



    public int tamano() {
        return tamano;
    }


    public boolean estaVacia() {
        return primero == null;
    }


    public void insertarPrimero(E valor) {
        if (estaVacia()) {
            primero = new Nodo(valor, null, null);
            ultimo = primero;
        } else {
            Nodo<E> f = primero;
            primero = new Nodo<>(valor, f, null);
            f.anterior = primero;
        }

        tamano++;
    }

    private class ListaIterador implements IListaIterador<E> {

        ListaIterador() {
            actual = null;
        }

        @Override
        public E siguiente() {

            if (actual == null) {
                actual = primero;
            } else {

                if (actual.siguiente != null) actual = actual.siguiente;

            }

            return (actual != null) ? actual.valor : null;
        }


        public boolean haySiguiente() {

            if (primero == null) return false;

            return (actual == null) ? true : actual.siguiente != null;
        }




    }

    public E sacarUltimo()
    {
        Nodo<E> temp = ultimo;

        if(tamano > 0)
        {
            ultimo = ultimo.anterior;

            if (ultimo != null) ultimo.siguiente = null;
        }
        tamano--;

        return (temp == null) ? null : temp.valor;
    }

    public E sacarPrimero()
    {
        Nodo<E> sacar = null;
        if(tamano > 0)
        {
            sacar = primero;
            primero = primero.siguiente;
        }

        tamano--;

        return (sacar == null) ? null: sacar.valor;
    }


    public IListaIterador<E> iterador() {
        return new ListaIterador();
    }

    public void insertarDespues(E valor){

        if (actual == ultimo){
            insertarFinal(valor);
        }


        else {

            Nodo<E> nuevo = new Nodo<E>(valor, actual.siguiente, actual);
            actual.siguiente = nuevo;
            actual.siguiente.anterior = nuevo;

            tamano++;
        }

    }

    public void insertarAntes(E valor){

        if (actual == primero){
            insertarPrimero(valor);
        }

        else {

            Nodo<E> nuevo = new Nodo<E>(valor, actual, actual.anterior);
            actual.anterior = nuevo;
            nuevo.anterior.siguiente = nuevo;

            tamano++;
        }

    }

    public void insertarFinal(E valor) {
        if (estaVacia()) {
            ultimo = new Nodo(valor, null, null);
            primero = ultimo;
        } else {

            Nodo<E> temp = ultimo;

            ultimo = new Nodo(valor, null, temp);

            temp.siguiente = ultimo;
        }

        tamano++;
    }



    public void print(Nodo nodo) {
        Nodo temp = nodo;
        System.out.println("Forward Traversal using next pointer");
        while (nodo != null) {
            System.out.print(nodo.valor + " ");
            temp = nodo;
            nodo = nodo.siguiente;
        }
        System.out.println("\nBackward Traversal using prev pointer");
        while (temp != null) {
            System.out.print(temp.valor + " ");
            temp = temp.anterior;
        }
    }

    // Split a doubly linked list (DLL) into 2 DLLs of
    // half sizes
    Nodo dividir(Nodo inicio) {
        Nodo mitad1 = inicio, mitad2 = inicio;
        while (mitad1.siguiente != null && mitad1.siguiente.siguiente != null) {
            mitad1 = mitad1.siguiente.siguiente;
            mitad2 = mitad2.siguiente;
        }
        Nodo temp = mitad2.siguiente;
        mitad2.siguiente = null;
        return temp;
    }

    Nodo mergeSort(Nodo primero, IComparador c) {
        if (primero == null || primero.siguiente == null) {
            return primero;
        }
        Nodo segundo = dividir(primero);

        // Recur for left and right halves
        primero = mergeSort(primero, c);
        segundo = mergeSort(segundo, c);

        // Merge the two sorted halves
        return merge(primero, segundo, c);
    }

    // Function to merge two linked lists
    Nodo merge(Nodo primero, Nodo segundo, IComparador c) {
        // If first linked list is empty
        if (primero == null) {
            return segundo;
        }

        // If second linked list is empty
        if (segundo == null) {
            return primero;
        }

        // Pick the smaller value
        if (c.comparar(primero.valor, segundo.valor) < 0) {
            primero.siguiente = merge(primero.siguiente, segundo, c);
            primero.siguiente.anterior = primero;
            primero.anterior = null;
            return primero;
        } else {
            segundo.siguiente = merge(primero, segundo.siguiente, c);
            segundo.siguiente.anterior = segundo;
            segundo.anterior = null;
            return segundo;
        }
    }

    private static class Comparadora implements IComparador<Integer> {
        @Override
        public int comparar(Integer o1, Integer o2) {
            if (o1< o2) return -1;
            if (o1 > o2) return 1;
            else return 0;
        }
    }

    public Nodo ordenarPorMergeSort(IComparador c){
        if (!estaVacia()) {
            primero = mergeSort(primero, c);

            Nodo<E> temp = primero;

            while (temp.siguiente != null) {
                temp = temp.siguiente;
            }
            ultimo = temp;
        }

        return  primero;
    }


    public static void main(String[] args) {

        ListaEncadenada<Integer> list = new ListaEncadenada();
        list.primero = new Nodo<>(10, null, null);
        list.primero.siguiente= new Nodo<>(30, null, null);
        list.primero.siguiente.siguiente= new Nodo<>(2, null, null);




        System.out.println("Linked list after sorting :");
        list.print(  list.ordenarPorMergeSort( new Comparadora()));
        list.print(list.primero);

    }
}


