package Exercises.Hotel;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean[][][] hotel = new boolean[2][5][10];
        boolean continuar = true;

        while (continuar) {
            System.out.println("""
            ----- Bienvenido al sistema de administración del hotel -----
            1- Cambiar estado de una Habitación
            2- Ver Habitaciones disponibles
            3- Salir
            """);

            int respuesta = scanner.nextInt();

            switch (respuesta) {
                case 1:
                    mostrarHotel(hotel);

                    System.out.print("Edificio (0-1): ");
                    int edificio = scanner.nextInt();

                    System.out.print("Piso (0-4): ");
                    int piso = scanner.nextInt();

                    System.out.print("Habitación (0-9): ");
                    int habitacion = scanner.nextInt();

                    cambiarEstado(hotel, edificio, piso, habitacion);
                    System.out.println(hotel[edificio][piso][habitacion] ? "Ocupada" : "Disponible");
                    break;

                case 2:
                    int disponibles = contarDisponibles(hotel);
                    System.out.println("Hay " + disponibles + " habitaciones disponibles");
                    break;

                case 3:
                    continuar = false;
                    break;
            }
        }
    }

    static int contarDisponibles(boolean[][][] hotel) {
        int total = 0;

        for (boolean[][] edificio : hotel) {
            for (boolean[] piso : edificio) {
                for (boolean habitacion : piso) {
                    if (!habitacion) total++;
                }
            }
        }

        return total;
    }

    static void cambiarEstado(boolean[][][] hotel, int e, int p, int h) {
        hotel[e][p][h] = !hotel[e][p][h];
    }

    static void mostrarHotel(boolean[][][] hotel) {
        for (int e = 0; e < hotel.length; e++) {
            System.out.println("Edificio " + e);

            for (int p = 0; p < hotel[e].length; p++) {
                System.out.print(" Piso " + p + ": ");

                for (int h = 0; h < hotel[e][p].length; h++) {
                    System.out.print(hotel[e][p][h] ? "1 " : "0 ");
                }

                System.out.println();
            }

            System.out.println();
        }
    }
}