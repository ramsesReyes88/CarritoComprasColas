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

    public boolean pilaVacia() {
        return cima == 0;
    }

}
