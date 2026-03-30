package Prácticas.Practica1;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ColaTickets colaTicketsPendientes= new ColaTickets();
        ListaTickets listaTicketsResueltos = new ListaTickets();
        int rol = 0;
        int opcion = 0;

        // Se le pide el Rol al usuario
        rol = validarRol(scanner);

        // Ciclo Principal del programa
        while (opcion != 4) {

            // Condicional: Según el rol le presenta las opciones disponibles
            if (rol == 1) {
                opcion = menuUsuario(scanner);
            } else if (rol == 2) {
                opcion = menuAdministrador(scanner);
            }

            // El switch evalúa la opción seleccionada y la ejecuta según el rol elegido
            switch (opcion) {
                case 1: {
                    if (rol == 1) {
                        crearTicket(scanner, colaTicketsPendientes);
                    } else if (rol == 2) {
                        verTicketReciente(colaTicketsPendientes);
                    }
                    break;
                }

                case 2: {
                    if (rol == 1) {
                        buscarTicketResuelto(scanner, listaTicketsResueltos);
                    } else if (rol == 2) {
                        resolverTicketReciente(scanner, colaTicketsPendientes, listaTicketsResueltos);
                    }
                    break;
                }

                case 3: {
                    rol = menuRol(scanner);
                    break;
                }

                case 4: {
                    System.out.println("Saliendo del Programa...");
                    break;
                }

                default: {
                    System.out.println("Opcion inválida, por favor introduzca otra opción");
                    break;
                }
            }
        }

    }

    static int menuRol(Scanner scanner) {
        int rolSeleccionado = 0;
        System.out.println("\n");
        System.out.println("***** Sistema de Gestión de Tiquetes *****");
        System.out.println("Antes de comenzar, por favor elija la opción que corresponda a su rol:");
        System.out.println("1. Usuario");
        System.out.println("2. Administrador");
        System.out.print("Introduzca un número: ");
        rolSeleccionado = Integer.parseInt(scanner.nextLine());
        return rolSeleccionado;
    }

    static int menuUsuario(Scanner scanner) {
        int opcionSeleccionada = 0;
        System.out.println("\n");
        System.out.println("***** Sistema de Gestión de Tiquetes *****");
        System.out.print("ROL: Usuario");
        System.out.println("\n");
        System.out.println("Elija una opción:");
        System.out.println("1. Crear un nuevo Ticket");
        System.out.println("2. Buscar un Ticket resuelto");
        System.out.println("3. Cambiar de Rol");
        System.out.println("4. Salir del programa");

        opcionSeleccionada = validarOpcion(scanner);
        return opcionSeleccionada;
    }

    static int menuAdministrador(Scanner scanner) {
        int opcionSeleccionada = 0;
        System.out.println("\n");
        System.out.println("***** Sistema de Gestión de Tiquetes *****");
        System.out.print("ROL: Administrador");
        System.out.println("\n");
        System.out.println("Elija una opción:");
        System.out.println("1. Ver Ticket más reciente");
        System.out.println("2. Realizar resolución de Tiquete más reciente");
        System.out.println("3. Cambiar de Rol");
        System.out.println("4. Salir del programa");

        opcionSeleccionada = validarOpcion(scanner);
        return opcionSeleccionada;
    }

    // Opciones de USUARIO
    static void crearTicket(Scanner scanner, ColaTickets colaTickets) {
        System.out.print("\n");

        System.out.println("Introduzca la prioridad del ticket (Alto, Medio, Bajo)");
        String prioridad = scanner.nextLine();

        System.out.println("Introduzca su nombre para la emisión del tiquete:");
        String nombre = scanner.nextLine();

        System.out.println("Introduzca una pequeña descripción del ticket:");
        String descripcion = scanner.nextLine();

        System.out.print("Ingrese la fecha de emisión (YYYY-MM-DD): ");
        String fecha = scanner.nextLine();
        LocalDate fechaCreacion = LocalDate.parse(fecha);

        Ticket ticket = new Ticket(prioridad, nombre, descripcion, fechaCreacion);

        colaTickets.insert(ticket);

        System.out.print("Ticket creado: " + "\n" + ticket);
    }

    static void buscarTicketResuelto(Scanner scanner, ListaTickets listaTickets) {
        int id = 0;

        System.out.println("Introduzca el ID del Ticket que desea buscar:");
        id = Integer.parseInt(scanner.nextLine());

        NodoLista nodoEncontrado = listaTickets.buscarNodo(id);

        if (nodoEncontrado == null) {
            System.out.print("El ticket aún está pendiente de revisión...");
        } else {
            System.out.println(nodoEncontrado.getNodo());
        }
    }

    // Opciones de ADMINISTRADOR
    static void verTicketReciente(ColaTickets colaTickets) {
        if (colaTickets.isEmpty()) {
            System.out.print("No hay tickets recientes para resolver");
            return;
        }

        System.out.println("Ticket más reciente: " + "\n" + colaTickets.peekFront());
    }

    static void resolverTicketReciente(Scanner scanner, ColaTickets colaTickets, ListaTickets listaTickets) {
        if (colaTickets.isEmpty()) {
            System.out.print("No hay tickets recientes para resolver");
            return;
        }

        // Obtener primer ticket
        Ticket ticketReciente = colaTickets.peekFront();

        // Introducir y setter fecha de resolución
        System.out.print("Ingrese la fecha de resolución (YYYY-MM-DD): ");
        String fecha = scanner.nextLine();
        LocalDate fechaResolucion = LocalDate.parse(fecha);
        ticketReciente.setFechaResolucion(fechaResolucion);

        // Obtener primero de lista de resueltos e insertar ticketResuelto
        NodoLista primero = listaTickets.getPrimero();
        NodoLista ticketResuelto = new NodoLista(primero, ticketReciente);

        // Remover ticket resuelto de cola de pendientes
        colaTickets.remove();

        System.out.println("TICKET RESUELTO:");
        System.out.println(ticketResuelto.getNodo());
    }

    static int validarRol(Scanner scanner) {
        int rol = 0;
        do {
            rol = menuRol(scanner);
            if (rol != 1 && rol != 2) {
                System.out.println("\nOpción inválida, inténtelo de nuevo");
            }
        } while (rol != 1 && rol != 2);
        return rol;
    }

    static int validarOpcion(Scanner scanner) {
        int opcion;
        do {
            opcion = Integer.parseInt(scanner.nextLine());
            if (opcion < 1 || opcion > 4) {
                System.out.println("Opción inválida, inténtelo de nuevo");
            }
        } while (opcion < 1 || opcion > 4);
        return opcion;
    }
}