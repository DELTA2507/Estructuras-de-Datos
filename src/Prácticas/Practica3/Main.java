import Prácticas.Practica3.MinHeap;
import Prácticas.Practica3.Nodo;
import java.util.ArrayList;
import java.util.Scanner;

void main() {
    Scanner scanner = new Scanner(System.in);
    MinHeap heap = new MinHeap();
    int opcion = -1;
    while (opcion != 0) {
        IO.println("\n==== MENÚ MIN HEAP ====");
        IO.println("1. Insertar nodo");
        IO.println("2. Eliminar mínimo");
        IO.println("3. Ver mínimo (peek)");
        IO.println("4. Heapify (crear montículo desde lista)");
        IO.println("5. Mostrar heap");
        IO.println("0. Salir");
        IO.print("Seleccione opción: ");
        opcion = scanner.nextInt();
        switch (opcion) {
            case 1:
                IO.print("Ingrese key del nodo: ");
                int key = scanner.nextInt();
                heap.insert(new Nodo(key));
                IO.println("Nodo insertado.");
                break;
            case 2:
                Nodo eliminado = heap.deleteMin();
                IO.println(eliminado != null ? "Eliminado: " + eliminado : "Heap vacío");
                break;
            case 3:
                Nodo min = heap.peek();
                IO.println(min != null ? "Mínimo: " + min : "Heap vacío");
                break;
            case 4:
                ArrayList<Nodo> lista = new ArrayList<>();

                IO.print("Cantidad de nodos: ");
                int cantidad = scanner.nextInt();

                for (int i = 0; i < cantidad; i++) {
                    IO.print("Key del nodo: ");
                    lista.add(new Nodo(scanner.nextInt()));
                }

                heap.heapify(lista);
                IO.println("Heap creado por medio de Heapify.");
                break;
            case 5:
                IO.println(heap.isEmpty() ? "El Heap está vacío" : heap.toString());
                break;
            case 0:
                IO.println("Saliendo del programa...");
                break;
            default:
                IO.println("Opción inválida");
        }
    }
    scanner.close();
}