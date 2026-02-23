package Estructuras.Colas;
import java.util.ArrayList;

public class ColaDinamica {
    // Atributos
    private ArrayList<String> colaFichas;

    // -- Métodos --

    // Constructor
    public ColaDinamica() {
        colaFichas = new ArrayList<>();
    }

    public void insert(String ficha) {
        colaFichas.add(ficha);
    }

    public String remove() {
        if(colaFichas.isEmpty()) {
            System.out.println("LA COLA ESTÁ VACÍA");
            return null;
        }
        return colaFichas.removeFirst();
    }

    public String peekFront() {
        if(colaFichas.isEmpty()) {
            System.out.println("LA COLA ESTÁ VACÍA");
            return null;
        }
        return colaFichas.getFirst();
    }
}
