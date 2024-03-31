package lista;
 
public class Pila 
{
    int max = 20;
    int cima = 0;
    //Clase donde se va a hacer el array de carritos
    Carritos[] carrito = new Carritos[max];

    /*------------------------------------------------------------------------------*/
    /*                                    CONSTRUCTOR                               */
    /*------------------------------------------------------------------------------*/
    public Pila() 
    {
        for (int i = 0; i < max; i++) 
        {
            carrito[i] = new Carritos();
        }
    }

    
    /*------------------------------------------------------------------------------*/
    /*            #1: Cantidad Maxima de Elementos que se pueden agregar            */                      
    /*------------------------------------------------------------------------------*/

    public int maxElementos() 
    {
        return max;
    }

    /*------------------------------------------------------------------------------*/
    /*              #2: METODO QUE DEVUELVE LA CANTIDAD DE ELEMENTOS AGREGADOS      */               
    /*------------------------------------------------------------------------------*/
    public int numElementos() 
    {
        return cima;
    }

    /*------------------------------------------------------------------------------*/
    /*                   #3: METODO QUE INDICA SI LA PILA ESTA LLENA                 */               
    /*------------------------------------------------------------------------------*/
    public boolean pilaLlena() 
    {
        return cima >= max;
    }

    /*------------------------------------------------------------------------------*/
    /*                     #4: METODO QUE INDICA SI LA PILA ESTA VACIA              */               
    /*------------------------------------------------------------------------------*/
    public boolean pilaVacia() 
    {
        return cima == 0;
    }

    
    /*------------------------------------------------------------------------------*/
    /*                   #5: METODO PARA AGREGAR CARRITOS A LA PILA                 */               
    /*------------------------------------------------------------------------------*/
    public void ingresarCarrito(String codigo, String tipo) 
    {
        if (pilaVacia()) 
        {
            carrito[cima].setCodigo(codigo);
            carrito[cima].setTipo(tipo);
            cima++;

            if (pilaLlena()) 
            {
                System.out.println("¡La fila de carritos se ha llenado!");
            }
        } else {
            System.out.println("No hay espacio disponible para agregar más carritos.");
        }
    }//ingresar

    /*------------------------------------------------------------------------------*/
    /*                  #6: METODO PARA RETIRRR CARRITOS DE LA PILA                 */               
    /*------------------------------------------------------------------------------*/
    public void retirar() 
    {
        if (pilaVacia()) 
        {
            System.out.println("No hay paquetes para retirar");
        } 
        else 
        {
            cima--;
            System.out.println("Carrito retirado");
            System.out.println("Codigo       " + carrito[cima].getCodigo());
            System.out.println("Tipo:        " + carrito[cima].getTipo());
            carrito[cima].setCodigo(null);
            carrito[cima].setTipo(null);
        }
    }//retirar

    
    /*------------------------------------------------------------------------------*/
    /*           #7: METODO PARA MOSTRAR EL TOTAL DE CARRITOS DISPONIBLES           */               
    /*------------------------------------------------------------------------------*/
    public void imprimir() 
    {
        if (pilaVacia()) 
        {
            System.out.println("Actualmente no hay carritos en ninguna fila");
        } else 
        {
            System.out.println("Codigo \t Tipo");
            for(int i = 0;i<cima;i++)
            {
                System.out.println(carrito[i].getCodigo());
                System.out.println("\t" + carrito[i].getTipo());
            }
        }
    }//imprimir


    
}
