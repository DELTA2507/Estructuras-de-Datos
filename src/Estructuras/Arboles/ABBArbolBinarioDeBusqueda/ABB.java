package Estructuras.Arboles.ABBArbolBinarioDeBusqueda;

public class ABB {
    // Atributos
    private Nodo raiz;

    // Métodos
    // Constructor
    public ABB() {
        raiz = null;
    }

    // Getters
    public Nodo getRaiz() {
        return raiz;
    }

    // Setters
    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }

    public Nodo search(int llaveBuscar) {
        if(isEmpty()) {
            System.out.println("El árbol está vacío");
            return null;
        }
        Nodo temp = null;
        while (temp.getLlave() != llaveBuscar) {
            if (llaveBuscar < temp.getLlave()) {
                temp = temp.getLeftChild();
            } else {
                temp = temp.getRightChild();
            }
            if (temp == null) {
                System.out.print("EL NODO BUSCADO NO SE ENCUENTRA EN EL ÁRBOL");
                return null;
            }
        }

        return temp;
    }

    public void insert(int llaveInsertar, String valorInsertar) {
        Nodo nuevoNodo = new Nodo(llaveInsertar, valorInsertar);
        if (isEmpty()) {
            raiz = nuevoNodo;
            return;
        }
        Nodo actual = raiz;
        Nodo padre;
        while (true) {
            padre = actual;
            if (llaveInsertar < actual.getLlave()) {
                // Por la Izquierda
                actual = actual.getLeftChild();
                if (actual == null) {
                    padre.setLeftChild(nuevoNodo);
                    return;
                }
            } else if (llaveInsertar > actual.getLlave()) {
                // Por la derecha
                actual = actual.getRightChild();
                if (actual == null) {
                    padre.setRightChild(nuevoNodo);
                    return;
                }
            } else {
                System.out.println("La llave ya está en el arbol");
                return;
            }
        }
    }

    public void inOrder(Nodo raizTemp) {
        if (raizTemp != null) {
            inOrder(raizTemp.getLeftChild());
            System.out.println(raizTemp.getLlave() + " ");
            inOrder(raizTemp.getRightChild());
        }
    }

    //
    public void preOrder(Nodo raizTemp) {
        if (raizTemp != null) {
            System.out.println(raizTemp.getLlave() + " ");
            preOrder(raizTemp.getLeftChild());
            preOrder(raizTemp.getRightChild());
        }
    }

    // Imprime los hijos LEFT y RIGHT de un Nodo padre antes de imprimir a PADRE
    public void postOrder(Nodo raizTemp) {
        if (raizTemp != null) {
            postOrder(raizTemp.getLeftChild());
            postOrder(raizTemp.getRightChild());
            System.out.println(raizTemp.getLlave() + " ");
        }
    }

    private boolean isEmpty() {
        return raiz == null;
    }
}
