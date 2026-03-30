package AlgoritmosOrdenamiento;

import java.util.Arrays;

public class OrdenamientoSeleccion {
    static void main (String args[]) {
        // Array de ejemplo
        int[] arreglo = {25,46,37,82,36,83,9,53,24,1,5,2,6,4,7,9,6,3,2,5,6,3,3,5,6,7,8,9,10};

        // Primeramente se imprime desordenado
        System.out.println(Arrays.toString(arreglo));

        // Invocar función
        ordenamientoSeleccion(arreglo);
    }

    // Algoritmo
    public static void ordenamientoSeleccion(int[] arreglo) {
        int n = arreglo.length;
        int minimo;
        int temp;

        // Recorre array completo
        for (int i = 0; i < n - 1 ; i++) {
            minimo = i;

            // Recorre porción restante del algoritmo
            // Omite casillas ya ordenadas
            // Busca dato minimo
            for (int j = i + 1; j < n ; j++) {
                if (arreglo[j] < arreglo[minimo]) {
                    minimo = j;
                }
            }

            // Sustituye casilla actual considerada, por el valor minimo encontrado
            temp = arreglo[i];
            arreglo[i] = arreglo[minimo];
            arreglo[minimo] = temp;
        }

        System.out.println(Arrays.toString(arreglo));
    }
}
