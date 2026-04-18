package Estructuras.Grafo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Grafo grafo = new Grafo();

        // Agregar vértices
        grafo.agregarVertice("A");
        grafo.agregarVertice("B");
        grafo.agregarVertice("C");
        grafo.agregarVertice("D");
        grafo.agregarVertice("E");

        // Agregar aristas
        grafo.agregarArista("A", "B", 10);
        grafo.agregarArista("A", "C", 5);
        grafo.agregarArista("B", "C", 2);
        grafo.agregarArista("B", "D", 1);
        grafo.agregarArista("C", "D", 9);
        grafo.agregarArista("C", "E", 2);
        grafo.agregarArista("D", "E", 4);
        grafo.agregarArista("B", "F", 1);
        grafo.agregarArista("D", "F", 5);
        grafo.agregarArista("E", "F", 7);

        // Ejecutar Dijkstra
        Map<String, Integer> distancias = new HashMap<>();
        Map<String, String> predecesores = new HashMap<>();
        grafo.algoritmoDijkstra("D", distancias, predecesores);

        // Obtener el mejor camino
        List<String> camino = grafo.reconstruirCamino("D", "A", predecesores);
        System.out.println("Distancia: " + distancias);
        System.out.println("Camino más corto: " + camino);

        grafo.mostrarGrafo();
    }
}