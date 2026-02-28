package Estructuras.Arboles.ABBArbolBinarioDeBusqueda;

public class Nodo {

    // Atributos
    private final int llave;
    private Nodo leftChild;
    private Nodo rightChild;
    private String valor;


    // Métodos
    // Constructor
    public Nodo(int llave, String valor) {
        this.llave = llave;
        this.leftChild = null;
        this.rightChild = null;
        this.valor = valor;
    }

    // Getters

    public int getLlave() {
        return llave;
    }

    public Nodo getLeftChild() {
        return leftChild;
    }

    public Nodo getRightChild() {
        return rightChild;
    }

    public String getValor() {
        return valor;
    }


    // Setters

    public void setValor(String valor) {
        this.valor = valor;
    }

    public void setLeftChild(Nodo leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(Nodo rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public String toString() {
        return "Nodo{" +
                "valor='" + valor + '\'' +
                ", llave=" + llave +
                '}';
    }
}
