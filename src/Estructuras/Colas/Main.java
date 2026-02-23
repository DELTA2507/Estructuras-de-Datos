package Estructuras.Colas;

public class Main {
    static void main(String[] args) {
        // Tanto en estática como en la dinámica los métodos deben funcionar exactamente igual
        // La ÚNICA diferencia esque la estática se llena, puesto que tiene un límite predefinido

        ColaDinamica colaFichas= new ColaDinamica();
        // ColaEstatica colaFichas = new ColaEstatica(10);

        colaFichas.insert("D1");
        colaFichas.insert("D2");
        colaFichas.insert("D3");
        colaFichas.insert("D4");
        colaFichas.insert("D5");
        colaFichas.insert("D6");
        colaFichas.insert("D7");
        colaFichas.insert("D8");
        colaFichas.insert("D9");
        colaFichas.insert("D10");

        colaFichas.remove();
        colaFichas.remove();

        System.out.println(colaFichas.peekFront());
    }
}
