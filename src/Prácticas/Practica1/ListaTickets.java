package Prácticas.Practica1;

public class ListaTickets {
    // Atributos
    private NodoLista primero;

    // Constructor
    public ListaTickets() {
        this.primero = null;
    }

    // Getters
    public NodoLista getPrimero() {
        return primero;
    }

    // Setters
    private void setPrimero(NodoLista primero) {
        this.primero = primero;
    }

    // Operaciones
    public void insertarNodoInicio (Ticket nodo) {
        NodoLista nuevoNodo = new NodoLista(primero, nodo);
        nuevoNodo.setSiguiente(primero);
        setPrimero(nuevoNodo);
    }

    public NodoLista buscarNodo (int id) {

        if (isEmpty()) {
            System.out.println("La lista está vacía. \n");
            return null;
        }
        NodoLista nodoActual = primero;

        while (nodoActual != null && nodoActual.getNodo().getId() != id) {
            nodoActual = nodoActual.getSiguiente();
        }

        return nodoActual;
    }

    public boolean isEmpty() {
        return primero == null;
    }
}
