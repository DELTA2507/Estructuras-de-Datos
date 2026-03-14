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
        Nodo temp = raiz;
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

    private Nodo getSucesor(Nodo nodo) {
        Nodo padreSucesor = nodo;
        Nodo sucesor = nodo;
        Nodo temp = nodo.getRightChild();

        while(temp != null) {
            padreSucesor = sucesor;
            sucesor = temp;
            temp = temp.getLeftChild();
        }
        if (sucesor != nodo.getRightChild()) {
            padreSucesor.setLeftChild(sucesor.getRightChild());
            sucesor.setRightChild(nodo.getRightChild());
        }
        return sucesor;
    }

    private Nodo getPadre(int llave) {
        Nodo padre = null;
        Nodo actual = raiz;

        while (actual != null && actual.getLlave() != llave) {
            padre = actual;

            if (llave < actual.getLlave()) {
                actual = actual.getLeftChild();
            } else {
                actual = actual.getRightChild();
            }
        }

        return padre;
    }

    public Nodo delete(int llave) {
        // CHECK ARBOL VACIO
        if(isEmpty()) {
            System.out.println("El árbol está vacío");
            return null;
        }

        Nodo nodoEliminar = search(llave);

        // CHECK NODO BUSCADO EXISTE
        if (nodoEliminar == null) {
            System.out.println("El nodo no existe");
            return null;
        }

        // SI NODO A ELIMINAR ES RAIZ
        if (nodoEliminar == raiz) {

            // CASO 1: SIN HIJOS
            if (raiz.getLeftChild() == null && raiz.getRightChild() == null) {
                raiz = null;
            }

            // CASO 2: SOLO HIJO DERECHO
            else if (raiz.getLeftChild() == null) {
                raiz = raiz.getRightChild();
            }

            // CASO 3: SOLO HIJO IZQUIERDO
            else if (raiz.getRightChild() == null) {
                raiz = raiz.getLeftChild();
            }

            // CASO 4: DOS HIJOS
            else {
                Nodo sucesor = getSucesor(raiz);
                sucesor.setLeftChild(raiz.getLeftChild());
                raiz = sucesor;
            }

        } else if (nodoEliminar.getLlave() != raiz.getLlave()) {

            Nodo padre = getPadre(llave);

            // CASO 1: SIN HIJOS
            if (nodoEliminar.getLeftChild() == null && nodoEliminar.getRightChild() == null) {

                if (padre.getLeftChild() == nodoEliminar)
                    padre.setLeftChild(null);
                else
                    padre.setRightChild(null);
            }

            // CASO 2: SOLO HIJO IZQUIERDO
            else if (nodoEliminar.getRightChild() == null) {

                if (padre.getLeftChild() == nodoEliminar)
                    padre.setLeftChild(nodoEliminar.getLeftChild());
                else
                    padre.setRightChild(nodoEliminar.getLeftChild());
            }

            // CASO 3: SOLO HIJO DERECHO
            else if (nodoEliminar.getLeftChild() == null) {

                if (padre.getLeftChild() == nodoEliminar)
                    padre.setLeftChild(nodoEliminar.getRightChild());
                else
                    padre.setRightChild(nodoEliminar.getRightChild());
            }

            // CASO 4: DOS HIJOS
            else {

                Nodo sucesor = getSucesor(nodoEliminar);

                if (padre.getLeftChild() == nodoEliminar)
                    padre.setLeftChild(sucesor);
                else
                    padre.setRightChild(sucesor);

                sucesor.setLeftChild(nodoEliminar.getLeftChild());
            }
        }
        return nodoEliminar;
    }

    private boolean isEmpty() {
        return raiz == null;
    }
}
