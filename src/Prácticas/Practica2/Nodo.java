package Prácticas.Practica2;

import java.util.*;

public class Nodo {

    List<Integer> listaClaves;
    List<String> listaValores;
    List<Nodo> listaHijos;
    boolean esHoja;
    Nodo siguiente;
    int orden;

    Nodo(int orden, boolean esHoja) {
        this.orden = orden;
        this.esHoja = esHoja;
        listaClaves = new ArrayList<>();
        listaValores = new ArrayList<>();
        listaHijos = new ArrayList<>();
        siguiente = null;
    }

    void insertarClave(int clave, String valor) {
        int i = 0;
        while (i < listaClaves.size() && clave > listaClaves.get(i)) {
            i++;
        }
        listaClaves.add(i, clave);
        if (esHoja) {
            listaValores.add(i, valor);
        }
    }

    Nodo dividir() {
        int mitad = listaClaves.size() / 2;
        Nodo nuevo = new Nodo(orden, esHoja);
        for (int i = mitad; i < listaClaves.size(); i++) {
            nuevo.listaClaves.add(listaClaves.get(i));
            if (esHoja) {
                nuevo.listaValores.add(listaValores.get(i));
            }
        }
        while (listaClaves.size() > mitad) {
            listaClaves.removeLast();

            if (esHoja) {
                listaValores.removeLast();
            }
        }
        if (esHoja) {
            nuevo.siguiente = siguiente;
            siguiente = nuevo;
        }
        return nuevo;
    }
}
