package Prácticas.Practica1;

import java.time.LocalDate;

public class Ticket {
    private static int cantidad = 0; // Caracteriza a la clase
    private int id;
    private String prioridad;
    private String nombreCreador;
    private String descripcion;
    private LocalDate fechaCreacion;
    private LocalDate fechaResolucion;

    public Ticket(String prioridad, String nombreCreador, String descripcion, LocalDate fechaCreacion) {
        cantidad++;
        this.id = cantidad;
        this.prioridad = prioridad;
        this.nombreCreador = nombreCreador;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
        this.fechaResolucion = null;
    }

    // Getters
    public static int getCantidad() {
        return cantidad;
    }
    public int getId() {
        return id;
    }
    public String getPrioridad() {
        return prioridad;
    }
    public String getNombreCreador() {
        return nombreCreador;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }
    public LocalDate getFechaResolucion() {
        return fechaResolucion;
    }

    // Setters
    public static void setCantidad(int cantidad) {
        Ticket.cantidad = cantidad;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }
    public void setNombreCreador(String nombreCreador) {
        this.nombreCreador = nombreCreador;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    public void setFechaResolucion(LocalDate fechaResolucion) {
        this.fechaResolucion = fechaResolucion;
    }

    @Override
    public String toString() {
        return "Ticket {" +
                "id=" + id +
                ", Prioridad='" + prioridad + '\'' +
                ", Nombre del Creador='" + nombreCreador + '\'' +
                ", Descripcion='" + descripcion + '\'' +
                ", Fecha de Creacion=" + fechaCreacion +
                ", Fecha de Resolucion=" + fechaResolucion +
                '}';
    }
}
