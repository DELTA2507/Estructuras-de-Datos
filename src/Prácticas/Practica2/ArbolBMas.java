package Prácticas.Practica2;

import java.util.ArrayList;

public class ArbolBMas {
    Nodo raiz;
    int orden;
    public ArbolBMas(int orden) {
        this.orden = orden;
        raiz = new Nodo(orden, true);
    }

    public String buscar(int clave) {
        Nodo actual = raiz;
        while (!actual.esHoja) {
            int i = 0;
            while (i < actual.listaClaves.size() && clave >= actual.listaClaves.get(i)) {
                i++;
            }
            actual = actual.listaHijos.get(i);
        }

        for (int i = 0; i < actual.listaClaves.size(); i++) {
            if (actual.listaClaves.get(i) == clave) {
                return actual.listaValores.get(i);
            }
        }
        return null;
    }

    public void insertar(int clave, String valor) {
        Nodo hoja = encontrarHoja(raiz, clave);
        hoja.insertarClave(clave, valor);
        if (hoja.listaClaves.size() == orden) {
            Nodo nuevo = hoja.dividir();
            if (hoja == raiz) {
                Nodo nueva_raiz = new Nodo(orden, false);
                nueva_raiz.listaClaves.add(nuevo.listaClaves.getFirst());
                nueva_raiz.listaHijos.add(hoja);
                nueva_raiz.listaHijos.add(nuevo);
                raiz = nueva_raiz;
            }
        }
    }

    public int recorrer(int clave_inicio, int n) {
        Nodo hoja = encontrarHoja(raiz, clave_inicio);
        int contador = 0;

        while (hoja != null && contador < n) {
            for (int i = 0; i < hoja.listaClaves.size() && contador < n; i++) {
                if (hoja.listaClaves.get(i) >= clave_inicio) {
                    System.out.println(
                            hoja.listaClaves.get(i) + " -> " + hoja.listaValores.get(i)
                    );
                    contador++;
                }
            }
            hoja = hoja.siguiente;
        }

        return contador;
    }

    Nodo encontrarHoja(Nodo nodo, int clave) {
        if (nodo.esHoja) {
            return nodo;
        }
        int i = 0;
        while (i < nodo.listaClaves.size() && clave >= nodo.listaClaves.get(i)) {
            i++;
        }
        return encontrarHoja(nodo.listaHijos.get(i), clave);
    }

    public void imprimirArbol() {
        if (raiz == null) return;

        ArrayList<Nodo> nivelActual = new ArrayList<>();
        nivelActual.add(raiz);

        int nivel = 0;

        while (!nivelActual.isEmpty()) {
            ArrayList<Nodo> siguienteNivel = new ArrayList<>();

            System.out.print("Nivel " + nivel + ": ");

            for (Nodo nodo : nivelActual) {
                System.out.print("[");
                for (int i = 0; i < nodo.listaClaves.size(); i++) {
                    System.out.print(nodo.listaClaves.get(i));
                    if (i < nodo.listaClaves.size() - 1) System.out.print(" ");
                }
                System.out.print("] ");

                if (!nodo.esHoja) {
                    siguienteNivel.addAll(nodo.listaHijos);
                }
            }

            System.out.println();
            nivelActual = siguienteNivel;
            nivel++;
        }
    }

    public void imprimirHojas() {
        Nodo actual = raiz;

        while (!actual.esHoja) {
            actual = actual.listaHijos.getFirst();
        }

        System.out.print("Hojas: ");

        while (actual != null) {
            System.out.print("[");
            for (int i = 0; i < actual.listaClaves.size(); i++) {
                System.out.print(actual.listaClaves.get(i));
                if (i < actual.listaClaves.size() - 1) System.out.print(" ");
            }
            System.out.print("] -> ");

            actual = actual.siguiente;
        }

        System.out.println("null");
    }
}
