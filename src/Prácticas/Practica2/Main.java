import Prácticas.Practica2.ArbolBMas;

void main() {
    Scanner sc = new Scanner(System.in);
    ArbolBMas arbol = new ArbolBMas(4);
    int opcion;
    do {
        System.out.println("*** MENU DE INTERACCION CON ESTRUCTURA ARBOL B+ ***");
        System.out.println("Seleccione una opcion:");
        System.out.println("1. Insertar");
        System.out.println("2. Buscar");
        System.out.println("3. Recorrer");
        System.out.println("------------------------------");
        System.out.println("4. Imprimir Árbol");
        System.out.println("5. Imprimir Hojas");
        System.out.println("------------------------------");
        System.out.println("6. Salir");
        System.out.print("\nIngrese una opcion: ");
        opcion = sc.nextInt();

        switch (opcion) {

            case 1: {
                System.out.print("Clave: ");
                int clave = sc.nextInt();

                System.out.print("Valor: ");
                String valor = sc.next();

                arbol.insertar(clave, valor);

                break;
            }

            case 2: {
                System.out.print("Clave: ");
                int buscar = sc.nextInt();

                String resultado = arbol.buscar(buscar);

                if (resultado == null) {
                    System.out.println("Clave no encontrada");
                } else {
                    System.out.println(resultado);
                }

                break;
            }

            case 3: {
                System.out.print("Clave inicial: ");
                int inicio = sc.nextInt();

                System.out.print("Cantidad: ");
                int n = sc.nextInt();

                int encontrados = arbol.recorrer(inicio, n);

                if (encontrados == 0) {
                    System.out.println("No se encontraron claves desde -> " + inicio);
                }

                break;
            }

            case 4: {
                System.out.print("\n");
                System.out.println("-------------------------");
                System.out.println("Arbol B+");
                arbol.imprimirArbol();
                System.out.println("-------------------------");
                System.out.print("\n");
                break;
            }

            case 5: {
                System.out.print("\n");
                System.out.println("-------------------------");
                System.out.println("Hojas");
                arbol.imprimirHojas();
                System.out.println("-------------------------");
                System.out.print("\n");
                break;
            }

            case 6: {
                System.out.println("Saliendo del programa...");
                break;
            }

        }

    } while (opcion != 6);
}