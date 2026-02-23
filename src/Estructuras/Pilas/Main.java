package Estructuras.Pilas;

public class Main {
    static void main(String[] args) {
        // Tanto en estática como en la dinámica los métodos deben funcionar exactamente igual
        // La ÚNICA diferencia esque la estática se llena, puesto que tiene un límite predefinido

        PilaDinamica pilaAutos = new PilaDinamica();
        //PilaEstatica pilaAutos = new PilaEstatica(5);

        pilaAutos.push("BMW");
        pilaAutos.push("Audi");
        pilaAutos.push("Toyota");

        pilaAutos.pop();

        pilaAutos.push("Maibatsu");
        pilaAutos.push("Honda");

        // Los peek() van acompañados de System.out.print() ya que retornan String.
        System.out.println(pilaAutos.peek());
    }
}
