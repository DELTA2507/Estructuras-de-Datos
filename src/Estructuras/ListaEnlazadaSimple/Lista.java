package Estructuras.ListaEnlazadaSimple;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Lista {
    // --- Atributos ---
    private Nodo first;

    // --- Métodos ---

    // Constructor
    public Lista() {
        this.first = null;
    }

    // Getters
    public Nodo getFirst() {
        return first;
    }

    // Setters
   private void setFirst(Nodo first) {
        this.first = first;
    }

    // Operaciones
    public void insertarNodoInicio (String name, String archetype, String faction, int level) {
        Nodo nuevoNodo = new Nodo(name,archetype,faction,level, generateID());
        nuevoNodo.setNext(first);
        setFirst(nuevoNodo);
    }

    public void insertarNodoFinal (String name, String archetype, String faction, int level) {

        // Temp es un comodin/alias que actua en nombre del nodo que referencia en un punto determinado
        // Si temp cambia, el nodo que referencia cambia tambien.
        // Por ende se le asigna como siguiente el nodoNuevo, porque temp = ultimo nodo.
        Nodo nuevoNodo = new Nodo(name,archetype,faction,level, generateID());
        if (isNull()) {
            setFirst(nuevoNodo);
            return;
        }
        Nodo temp = first;
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        temp.setNext(nuevoNodo);
    }

    public Nodo buscarNodo (int id) {

        if (isNull()) {
            System.out.println("La lista está vacía. \n");
            return null;
        }
        Nodo nodoActual = first;

        while (nodoActual != null && nodoActual.getId() != id) {
            nodoActual = nodoActual.getNext();
        }
        if (nodoActual ==  null) {
            System.out.println("El nodo buscado NO se encontró en la estructura \n");
        }
        return nodoActual;
    }

    public Nodo eliminarNodo (String nameEliminar) {
        if (isNull()) {
            System.out.println("LISTA VACIA");
            return null;
        }
        Nodo nodoActual = first;
        Nodo anteriorActual = nodoActual;
        while (nodoActual !=null && !nodoActual.getName().equals(nameEliminar)) {
            anteriorActual = nodoActual;
            nodoActual = nodoActual.getNext();
        }
        if (nodoActual != null) {
            System.out.println("El nodo buscado se encontró y ELIMINO de la estructura. \n");
            anteriorActual.setNext(nodoActual.getNext());
        } else {
            System.out.println("NODO NO ENCONTRADO \n");
        }
        return nodoActual;
    }

    public Nodo mostrarLista() {
        if (isNull()) {
            System.out.println("La lista está vacía. \n");
            return null;
        }
        Nodo nodoActual = first;

        while (nodoActual != null) {
            System.out.println(nodoActual);
            nodoActual = nodoActual.getNext();
        }
        return nodoActual;
    }

    public Nodo modificarNodo(int id, Scanner scanner) {
        int opcion = 0;
        if (isNull()) {
            System.out.println("La lista está vacía. \n");
            return null;
        }
        Nodo nodoActual = buscarNodo(id);

        System.out.println(nodoActual);

        System.out.println("Que desea editar?");
        System.out.println("1. nombre: ");
        System.out.println("2. arquetipo: ");
        System.out.println("3. faccion");
        System.out.println("4. nivel");

        opcion = scanner.nextInt();
        scanner.nextLine();

        switch (opcion) {
            case 1: {
                System.out.println("Introduzca el nuevo valor: ");
                String newName = scanner.nextLine();
                nodoActual.setName(newName);
                break;
            }

            case 2: {
                System.out.println("Introduzca el nuevo valor: ");
                String newArchetype = scanner.nextLine();
                nodoActual.setArchetype(newArchetype);
                break;
            }

            case 3: {
                System.out.println("Introduzca el nuevo valor: ");
                String newFaction = scanner.nextLine();
                nodoActual.setFaction(newFaction);
                break;
            }

            case 4: {
                System.out.println("Introduzca el nuevo valor: ");
                int newLevel = scanner.nextInt();
                scanner.nextLine();
                nodoActual.setLevel(newLevel);
                break;
            }
        }
        return nodoActual;
    }

    private boolean isNull() {
        return first == null;
    }

    private int generateID() {
        int nuevoNodoID = ThreadLocalRandom.current().nextInt(1, 100);
        return nuevoNodoID;
    }
}
