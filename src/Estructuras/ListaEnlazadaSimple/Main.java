package Estructuras.ListaEnlazadaSimple;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Lista listaPersonajes = new Lista();

        listaPersonajes.insertarNodoInicio("Asturias","Warrior","Xerkonos",25);
        listaPersonajes.insertarNodoInicio("Finhalm","Rogue","Zoros",90);
        listaPersonajes.insertarNodoInicio("Zehjan","Assassin","Galiman",45);
        listaPersonajes.insertarNodoInicio("Palantir","Mage","Xindal",10);

        listaPersonajes.mostrarLista();

        System.out.println("INGRESE CODIGO A EDITAR:");
        int IDModificar = scanner.nextInt();

        listaPersonajes.modificarNodo(IDModificar, scanner);

        listaPersonajes.mostrarLista();

//        // Creacion/Construccion de un objeto nuevo mediante el metodo constructor
//        Nodo character = new Nodo("Asturias","Warrior","Xerkonos",25);
//
//        // Creacion/Construccion de un objeto nuevo mediante el metodo constructor
//        Nodo character2 = new Nodo("Gallahad", "Mage", "Zandor", 50);
//
//        System.out.println(character);
    }
}
