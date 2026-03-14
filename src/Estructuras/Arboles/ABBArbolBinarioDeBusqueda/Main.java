package Estructuras.Arboles.ABBArbolBinarioDeBusqueda;

public class Main {
    static void main(String[] args) {
        ABB arbolValores = new ABB();

        arbolValores.insert(25, "Samorost");
        arbolValores.insert(75, "Gundam");
        arbolValores.insert(80, "Resogunn");
        arbolValores.insert(166, "Gundam");
        arbolValores.insert(30, "Kerensikov");
        arbolValores.insert(78, "Sandevistan");
        arbolValores.insert(0, "Defalt");

        //arbolValores.inOrder(arbolValores.getRaiz());
        //arbolValores.preOrder(arbolValores.getRaiz());
        //arbolValores.postOrder(arbolValores.getRaiz());

        arbolValores.delete(166);

        arbolValores.search(166);

        arbolValores.delete(arbolValores.getRaiz().getLlave());

        arbolValores.inOrder(arbolValores.getRaiz());
    }
}
