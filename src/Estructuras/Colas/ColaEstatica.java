package Estructuras.Colas;

public class ColaEstatica {

    // Atributos
    private String[] colaFichas;

    // end = Inicio de la Fila
    private int end;

    // front = el frente o el final de la fila
    private int front;
    private int cantidad;

    // -- Métodos --

    // Constructor
    public ColaEstatica(int size) {
        colaFichas = new String[size];
        end = -1;
        front = 0;
        cantidad = 0;
    }

    private boolean isEmpty() {
        return cantidad == 0;
    }

    private boolean isFull() {
        return cantidad == colaFichas.length;
    }

    public void insert(String ficha) {
        if(isFull()) {
            System.out.println("LA COLA ESTÁ LLENA");
            return;
        }

        if (end == colaFichas.length - 1) {
            end = -1;
        }

        colaFichas[++end] = ficha;
        cantidad++;
    }

    public String remove() {
        if(isEmpty()) {
            System.out.println("LA COLA ESTÁ VACÍA");
            return null;
        }
        String temp = colaFichas[front++];
        if (front == colaFichas.length) {
            front = 0;
        }
        return temp;
    }

    public String peekFront() {
        if(isEmpty()) {
            System.out.println("LA COLA ESTÁ VACÍA");
            return null;
        }
        return colaFichas[front];
    }
}
