public class Arbol {
    Nodo raiz;

    public Arbol() {
        raiz = null;
    }

    // INSERTAR
    public void insertar(int valor) {
        raiz = insertarRec(raiz, valor);
    }

    private Nodo insertarRec(Nodo raiz, int valor) {
        if (raiz == null) {
            return new Nodo(valor);
        }

        if (valor < raiz.valor) {
            raiz.izquierdo = insertarRec(raiz.izquierdo, valor);
        } else if (valor > raiz.valor) {
            raiz.derecho = insertarRec(raiz.derecho, valor);
        }

        return raiz;
    }

    // BUSCAR
    public boolean buscar(int valor) {
        return buscarRec(raiz, valor);
    }

    private boolean buscarRec(Nodo raiz, int valor) {
        if (raiz == null) {
            return false;
        }

        if (valor == raiz.valor) {
            return true;
        }

        return valor < raiz.valor
                ? buscarRec(raiz.izquierdo, valor)
                : buscarRec(raiz.derecho, valor);
    }

    // RECORRIDO IN-ORDER
    public void inOrden() {
        inOrdenRec(raiz);
    }

    private void inOrdenRec(Nodo raiz) {
        if (raiz != null) {
            inOrdenRec(raiz.izquierdo);
            System.out.print(raiz.valor + " ");
            inOrdenRec(raiz.derecho);
        }
    }

    // ELIMINAR
    public void eliminar(int valor) {
        raiz = eliminarRec(raiz, valor);
    }

    private Nodo eliminarRec(Nodo raiz, int valor) {
        if (raiz == null) return null;

        if (valor < raiz.valor) {
            raiz.izquierdo = eliminarRec(raiz.izquierdo, valor);
        } else if (valor > raiz.valor) {
            raiz.derecho = eliminarRec(raiz.derecho, valor);
        } else {
            // Caso 1: sin hijos
            if (raiz.izquierdo == null && raiz.derecho == null) {
                return null;
            }

            // Caso 2: un hijo
            if (raiz.izquierdo == null) return raiz.derecho;
            if (raiz.derecho == null) return raiz.izquierdo;

            // Caso 3: dos hijos
            int sucesor = encontrarMinimo(raiz.derecho);
            raiz.valor = sucesor;
            raiz.derecho = eliminarRec(raiz.derecho, sucesor);
        }

        return raiz;
    }

    private int encontrarMinimo(Nodo raiz) {
        while (raiz.izquierdo != null) {
            raiz = raiz.izquierdo;
        }
        return raiz.valor;
    }
}