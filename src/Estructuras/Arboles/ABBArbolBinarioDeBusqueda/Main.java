package Estructuras.Arboles.ABBArbolBinarioDeBusqueda;

public class Main {
    static void main(String[] args) {
        ABB arbolValores = new ABB();

        arbolValores.insert(25, "Samorost");
        arbolValores.insert(75, "Gundam");
        arbolValores.insert(80, "Resogunn");
        arbolValores.insert(166, "Gundam");
        arbolValores.insert(0, "ShogunRaiden");

        arbolValores.inOrder(arbolValores.getRaiz());
        arbolValores.preOrder(arbolValores.getRaiz());
        arbolValores.postOrder(arbolValores.getRaiz());
    }
}
