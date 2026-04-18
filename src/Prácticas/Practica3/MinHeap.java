package Prácticas.Practica3;

import java.util.ArrayList;

public class MinHeap {

    private final ArrayList<Nodo> heap;

    public MinHeap() {
        heap = new ArrayList<>();
    }

    private void upHeapify(int index) {
        while (index > 0) {
            int parent = getParent(index);
            if (heap.get(index).getKey() < heap.get(parent).getKey()) {
                swap(index, parent);
                index = parent;
            } else {
                break;
            }
        }
    }

    private void downHeapify(int index) {
        while (getLeftChild(index) < heap.size()) {
            int leftChild = getLeftChild(index);
            int rightChild = getRightChild(index);

            int smallest = leftChild;

            if (rightChild < heap.size() &&
                    heap.get(rightChild).getKey() < heap.get(leftChild).getKey()) {
                smallest = rightChild;
            }

            if (heap.get(index).getKey() <= heap.get(smallest).getKey()) {
                break;
            }

            swap(index, smallest);
            index = smallest;
        }
    }

    public void insert(Nodo value) {
        // add() añade automáticamente al valor recibido al final del montículo
        heap.add(value);

        // Se obtiene el último índice del valor final
        int lastIndex = heap.size() - 1;

        // Llamar a upHeapify para ordenar montículo
        upHeapify(lastIndex);
    }

    public Nodo deleteMin() {
        if (heap.isEmpty()) {
            System.out.println("El Montículo está vacío");
            return null;
        }

        Nodo min = heap.getFirst();
        swap(0, heap.size() - 1);
        heap.removeLast();
        downHeapify(0);
        return min;
    }

    public Nodo peek() {
        if (heap.isEmpty()) {
            System.out.println("El Montículo está vacío");
        } else {
            return heap.getFirst();
        }
        return null;
    }

    public void heapify(ArrayList<Nodo> array) {
        heap.clear();
        heap.addAll(array);
        int lastParent = (heap.size() / 2) - 1;
        for (int i = lastParent; i >= 0; i--) {
            downHeapify(i);
        }
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    @Override
    public String toString() {
        return heap.toString();
    }

    // Métodos de Utilidad para obtener Parent y Child Left/Right
    private int getParent(int index) {
        return (index - 1) / 2;
    }

    private int getLeftChild(int index) {
        return 2 * index + 1;
    }

    private int getRightChild(int index) {
        return 2 * index + 2;
    }

    // Metodo swap() reutilizable para intercambiar valores de posición sin repetir código
    private void swap(int a, int b) {
        Nodo temp = heap.get(a);
        heap.set(a, heap.get(b));
        heap.set(b, temp);
    }
}