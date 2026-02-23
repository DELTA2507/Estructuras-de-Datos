package Estructuras.ListaEnlazadaSimple;

public class Nodo {
    // Personaje de Fantasia RPG

    // --- Atributos ---
    private String name;
    private String archetype;
    private String faction;
    private int level;
    private int id;
    Nodo next;

    // --- Métodos ---

    // Constructor: Crear un objeto con valores iniciales
    Nodo (String name, String archetype, String faction, int level, int id) {
        this.name = name;
        this.archetype = archetype;
        this.faction = faction;
        this.level = level;
        this.id = id;
        this.next = null; // null por defecto, debido a que al ser creado, aun no tiene objeto siguiente
    }

    // Getters: Consultar valor de un atributo
    public String getName() {
        return name;
    }
    public String getArchetype() {return archetype;}
    public String getFaction() {return faction;}
    public int getLevel() {return level;}
    public int getId() {return id;}
    public Nodo getNext() {
        return next;
    }

    // Setters: Asignar/Modificar valor para un atributo
    public void setName(String name) {
        this.name = name;
    }
    public void setArchetype(String archetype) {
        this.archetype = archetype;
    }
    public void setFaction(String faction) {this.faction = faction;}
    public void setLevel (int level) {
        this.level = level;
    }
    public void setId (int id) {this.id = id;}
    public void setNext(Nodo next) {
        this.next = next;
    }

    // toString(): Rutina para imprimir la info de un objeto de forma cómoda y automática
    @Override
    public String toString() {
        return "Nodo {" +
                "\n id=" + id +
                "\n name="+ name +
                "\n archetype=" + archetype +
                "\n faction=" + faction +
                "\n level=" + level +
                "\n}";
    }
}