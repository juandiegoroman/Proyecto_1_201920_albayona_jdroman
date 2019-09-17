package model.data_structures;

// Linked List Class
public class ListaEncadenada<E> {

    private Nodo<E> actual;

    private Nodo<E> primero;

    private Nodo<E> ultimo;

    private int tamano;

    /* Node Class */
    public class Nodo<E> {

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

        @Override
        public E anterior() {

            if (actual == null) {
                actual = primero;
            } else {

                if (actual.anterior != null) actual = actual.anterior;

            }

            return (actual != null) ? actual.valor : null;
        }

        public boolean haySiguiente() {

            if (primero == null) return false;

            return (actual == null) ? true : actual.siguiente != null;
        }

        public boolean hayAnterior() {

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
    Nodo split(Nodo head) {
        Nodo fast = head, slow = head;
        while (fast.siguiente != null && fast.siguiente.siguiente != null) {
            fast = fast.siguiente.siguiente;
            slow = slow.siguiente;
        }
        Nodo temp = slow.siguiente;
        slow.siguiente = null;
        return temp;
    }

    Nodo mergeSort(Nodo nodo, IComparador c) {
        if (nodo == null || nodo.siguiente == null) {
            return nodo;
        }
        Nodo second = split(nodo);

        // Recur for left and right halves
        nodo = mergeSort(nodo, c);
        second = mergeSort(second, c);

        // Merge the two sorted halves
        return merge(nodo, second, c);
    }

    // Function to merge two linked lists
    Nodo merge(Nodo first, Nodo second, IComparador c) {
        // If first linked list is empty
        if (first == null) {
            return second;
        }

        // If second linked list is empty
        if (second == null) {
            return first;
        }

        // Pick the smaller value
        if (c.comparar(first.valor, second.valor) < 0) {
            first.siguiente = merge(first.siguiente, second, c);
            first.siguiente.anterior = first;
            first.anterior = null;
            return first;
        } else {
            second.siguiente = merge(first, second.siguiente, c);
            second.siguiente.anterior = second;
            second.anterior = null;
            return second;
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
       return mergeSort(primero,c);
    }


    public static void main(String[] args) {

        ListaEncadenada<Integer> list = new ListaEncadenada();
        list.insertarFinal(10);
        list.insertarFinal(30);
        list.insertarFinal(2);




        System.out.println("Linked list after sorting :");
        list.print(  list.ordenarPorMergeSort( new Comparadora()));

    }
}

// This code has been contributed by Mayank Jaiswal
