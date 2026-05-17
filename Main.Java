public class Main {
    public static void main(String[] args) {
        Arbol arbol = new Arbol();

        arbol.insertar(50);
        arbol.insertar(30);
        arbol.insertar(70);
        arbol.insertar(20);
        arbol.insertar(40);
        arbol.insertar(60);
        arbol.insertar(80);

        System.out.println("Recorrido InOrden:");
        arbol.inOrden();

        System.out.println("\nBuscar 40: " + arbol.buscar(40));

        arbol.eliminar(30);
        System.out.println("Después de eliminar 30:");
        arbol.inOrden();
    }
}