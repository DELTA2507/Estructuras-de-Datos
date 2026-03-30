package AlgoritmosOrdenamiento;

import java.util.Arrays;

public class OrdenamientoBurbuja {
    static void main (String args[]) {
        // Array de ejemplo
        int[] arreglo = {1,0,2,3,9,4,8,7,54,6,7,8,5,4,5,7,9,0,9,7,5,4,6,7,8,3,2,1};

        // Primeramente se imprime desordenado
        System.out.println(Arrays.toString(arreglo));

        // Invocar función
        ordenamientoBurbuja(arreglo);
    }

    public static void ordenamientoBurbuja(int[] arreglo) {
        int a = 0;
        int b = 0;
        int n = arreglo.length;
        int temp;
        boolean desordenado = false; //  Se hace una suposición o hipótesis
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arreglo[j] > arreglo[j + 1]) {
                    temp = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = temp;
                    desordenado = true; // Si el if se cumplió entonces todavía hay desorden
                }
            }
            System.out.println(Arrays.toString(arreglo));
            if (!desordenado) break; // Si el if no se cumplió, entonces se asume que ya no hay desorden y el ciclo se termina
        }
    }
}
