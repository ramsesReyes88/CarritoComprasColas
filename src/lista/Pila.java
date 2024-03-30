package lista;

public class Pila {
    int max = 20;
    int cima = 0;
    Carritos[] carrito = new Carritos[max];

    public Pila() {
        for (int i = 0; i < max; i++) {
            carrito[i] = new Carritos();
        }
    }

    /* Cantidad Maxima de Elementos que se pueden agregar */

    public int maxElementos() {
        return max;
    }

    /* Cantidad de elementos agregados */

    public int numElementos() {
        return cima;
    }

    /* Saber si la pila esta llena */

    public boolean pilaLlena() {
        return cima >= max;
    }

    /*Saber si la pila esta vacia */
    public boolean pilaVacia() {
        return cima == 0;
    }

    public void ingresarCarrito(String codigo, String tipo) {
        if (pilaVacia()) {
            carrito[cima].setCodigo(codigo);
            carrito[cima].setTipo(tipo);
            cima++;

            if (pilaLlena()) {
                System.out.println("¡La fila de carritos se ha llenado!");
            }
        } else {
            System.out.println("No hay espacio disponible para agregar más carritos.");
        }
    }//agregar

    /* Método para retirar un carrito */
    public void retirar() {
        if (pilaVacia()) {
            System.out.println("No hay paquetes para retirar");
        } else {
            cima--;
            System.out.println("Carrito retirado");
            System.out.println("Codigo       " + carrito[cima].getCodigo());
            System.out.println("Tipo:        " + carrito[cima].getTipo());
            carrito[cima].setCodigo(null);
            carrito[cima].setTipo(null);
        }
    }//retirar

    /* Método para mostrar el total de carritos disponibles */
    public void imprimir() {
        if (pilaVacia()) {
            System.out.println("Actualmente no hay carritos en ninguna fila");
        } else {
            System.out.println("Codigo \t Tipo");
            for(int i = 0;i<cima;i++){
                System.out.println(carrito[i].getCodigo());
                System.out.println("\t" + carrito[i].getTipo());
            }
        }
    }//imprimir
}
