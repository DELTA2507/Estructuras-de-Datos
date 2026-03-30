package AlgoritmosOrdenamiento;

import java.util.Arrays;

public class OrdenamientoInsercion {
    static void main (String args[]) {
        // Array de ejemplo
        int[] arreglo = {25,46,37,82,36,83,39,53,224,12,35,2,6,3444,7,39,63,3,22,532,326,3,223,5,6,337,83,9,1230};

        // Primeramente se imprime desordenado
        System.out.println(Arrays.toString(arreglo));

        // Invocar función
        int[] arregloOrdenado = ordenamientoInsercion(arreglo);

        // Se imprime el nuevo array ordenado
        System.out.println(Arrays.toString(arregloOrdenado));
    }

    public static int[] ordenamientoInsercion(int[] arreglo) {
        int n = arreglo.length;
        int[] nuevo = new int[n];
        int posicion = 0;
        int insertados = 0;

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                nuevo[i] = arreglo[i];
                insertados++;
                continue;
            }
            for (int j = 0; j <= insertados; j++) {
                if (arreglo[i] <= nuevo[j]) {
                    posicion = j;
                    break;
                }
                posicion = insertados;
            }
            for (int k = n - 1; k > posicion; k--) nuevo[k] = nuevo[k - 1];
            nuevo[posicion] = arreglo[i];
            posicion = 0;
            insertados++;
        }
        return nuevo;
    }
}
