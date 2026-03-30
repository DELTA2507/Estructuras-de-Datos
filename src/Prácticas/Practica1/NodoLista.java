package Prácticas.Practica1;

public class NodoLista {
    private Ticket nodo;
    private NodoLista siguiente;

    public NodoLista(NodoLista siguiente, Ticket nodo) {
        this.siguiente = siguiente;
        this.nodo = nodo;
    }

    // Getters
    public NodoLista getSiguiente() {
        return siguiente;
    }

    public Ticket getNodo() {
        return nodo;
    }

    // Setters
    public void setSiguiente(NodoLista siguiente) {
        this.siguiente = siguiente;
    }

    public void setNodo(Ticket nodo) {
        this.nodo = nodo;
    }
}
