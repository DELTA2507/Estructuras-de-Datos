package Estructuras.Pilas;
import java.util.ArrayList;

public class PilaDinamica {
    // Atributos
    private ArrayList<String> pilaNombres;

    // -- Métodos --

    // Constructor
    public PilaDinamica() {
        pilaNombres = new ArrayList<>();
    }

    public void push(String nombre) {
        pilaNombres.add(nombre);
    }

    public String pop() {
        if(pilaNombres.isEmpty()) {
            System.out.println("LA PILA ESTÁ VACÍA");
            return null;
        }
        return pilaNombres.removeLast();
    }

    public String peek() {
        if(pilaNombres.isEmpty()) {
            System.out.println("LA PILA ESTÁ VACÍA");
            return null;
        }
        return pilaNombres.getLast();
    }
}
