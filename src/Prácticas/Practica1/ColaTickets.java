package Prácticas.Practica1;

import java.util.ArrayList;

public class ColaTickets {
    // Atributos
    private ArrayList<Ticket> colaTickets;

    // Constructor
    public ColaTickets() {
        colaTickets = new ArrayList<>();
    }

    // Metodos
    public void insert(Ticket ticket) {
        int ticketPrioridad = prioridadValor(ticket.getPrioridad());

        // Si la cola está vacía, agrega al final
        if (colaTickets.isEmpty()) {
            colaTickets.add(ticket);
            return;
        }

        // Buscar la posición donde insertar
        int i = 0;
        for (; i < colaTickets.size(); i++) {
            Ticket t = colaTickets.get(i);
            if (ticketPrioridad > prioridadValor(t.getPrioridad())) {
                break; // encontramos la posición
            }
        }

        // Insertar en la posición correcta
        colaTickets.add(i, ticket);
    }

    public Ticket remove() {
        if(colaTickets.isEmpty()) {
            System.out.println("LA COLA ESTÁ VACÍA");
            return null;
        }
        return colaTickets.removeFirst();
    }

    public Ticket peekFront() {
        if(colaTickets.isEmpty()) {
            System.out.println("LA COLA ESTÁ VACÍA");
            return null;
        }
        return colaTickets.getFirst();
    }

    public boolean isEmpty() {
        return colaTickets.isEmpty();
    }

    private int prioridadValor(String prioridad) {
        switch (prioridad.toLowerCase()) {
            case "alta": return 3;
            case "media": return 2;
            case "baja": return 1;
            default: return 0;
        }
    }
}
