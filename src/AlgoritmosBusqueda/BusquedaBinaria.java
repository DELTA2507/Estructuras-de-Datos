package AlgoritmosBusqueda;

import java.util.Arrays;

public class BusquedaBinaria {
    static void main (String[] args) {
        // Array de ejemplo
        int[] arreglo = {1,99,54594,52,5295,92592493,923,49429,9252295,945934,59,5,5,349,5435,95,94,59353};

        // Primeramente se imprime desordenado
        System.out.println(Arrays.toString(arreglo));

        // Invocar función
        System.out.println("CASO ÉXITO:");
        int result = busquedaBinaria(arreglo, 95);
        System.out.println(result);

        System.out.printf("CASO NO ENCONTRO:");
        int result2 = busquedaBinaria(arreglo, 2);
        System.out.println(result2);
    }

    public static int busquedaBinaria(int[] arreglo, int numeroBuscar) {
        int left = 0;
        int right = arreglo.length - 1;
        int pivot = (left + right) / 2;
        while (arreglo[pivot] != numeroBuscar) {
            if (pivot < numeroBuscar) left = pivot + 1;
            else right = pivot - 1;

            if (left > right) return -1;

            pivot = (left + right) / 2;
        }
        return pivot;
    }
}
