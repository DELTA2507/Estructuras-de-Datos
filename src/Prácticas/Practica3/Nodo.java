package Prácticas.Practica3;

public class Nodo {
    int key;

    public Nodo(int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }

    public String toString() {
        return String.valueOf(key);
    }
}