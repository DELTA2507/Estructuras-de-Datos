package Estructuras.Pilas;

public class PilaEstatica {

    // Atributos
    private String[] pilaNombres;
    private int top;


    // -- Métodos --

    // Constructor
    public PilaEstatica(int size) {
        pilaNombres = new String[size];
        top = -1;
    }

    private boolean isEmpty() {
        return top == -1;
    }

    private boolean isFull() {
        return top == pilaNombres.length - 1;
    }

    public void push(String nombre) {
        if(isFull()) {
            System.out.println("LA PILA ESTÁ LLENA");
            return;
        }
        pilaNombres[++top] = nombre;
    }

    public String pop() {
        if(isEmpty()) {
            System.out.println("LA PILA ESTÁ VACÍA");
            return null;
        }
        return pilaNombres[top--];
    }

    public String peek() {
        if(isEmpty()) {
            System.out.println("LA PILA ESTÁ VACÍA");
            return null;
        }
        return pilaNombres[top];
    }
}
