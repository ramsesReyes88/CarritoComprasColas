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
            carrito[i] = new Carritos(null, null);
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
    public void ingresarCarrito(String codigo, int tipo) 
    {
        if (cima < max) 
        {
            //Calcula el total de carritos después de agregar el nuevo
            int totalCarritos = cima + 1; 
            
            //Verifica si se ha alcanzado el límite total de 20 carritos
            if (totalCarritos > max) 
            {
                System.out.println("No hay espacio disponible para agregar más carritos.");
                return;
            }
            
            int limiteTipo;
            String tipoCarrito;
            //Toma la variable tipo del menu, pero aqui se vuelve a evaluar para ver si no supera el limite
            switch (tipo) 
            {
                case 1:
                    limiteTipo = 10; 
                    tipoCarrito = "Normal";
                    break;
                case 2:
                    limiteTipo = 5; 
                    tipoCarrito = "Portabebé";
                    break;
                case 3:
                    limiteTipo = 5;
                    tipoCarrito = "Pequeño";
                    break;
                default:
                    System.out.println("Tipo de carrito no válido.");
                    return;
            }

            //Verifica si se ha alcanzado el límite para el tipo específico de carrito
            int contadorTipo = 0;
            for (int i = 0; i < cima; i++) 
            {
                if (carrito[i].getTipo().equals(tipoCarrito)) 
                {
                    contadorTipo++;
                }
            }
            if (contadorTipo >= limiteTipo) 
            {
                System.out.println("Se ha alcanzado el límite de carritos de tipo => " + tipoCarrito + " <=.");
                return;
            }

            //SI LO ANTERIOR ES VALIDO, SE MANDAN LOS DATOS Y SE INGRESAN BIEN
            carrito[cima].setCodigo(codigo);
            carrito[cima].setTipo(tipoCarrito);
            cima++;
            System.out.println("El carrito se ha ingresado correctamente.");
        } 
        else 
        {
            System.out.println("No hay espacio disponible para agregar más carritos.");
        }
    }

    /*------------------------------------------------------------------------------*/
    /*                  #6: METODO PARA RETIRAR CARRITOS DE LA PILA                 */               
    /*------------------------------------------------------------------------------*/
    public void retirar() {
        if (cima > 0) {
            cima--;
            System.out.println("Carrito retirado - Código: " + carrito[cima].getCodigo() + ", Tipo: " + carrito[cima].getTipo());
            carrito[cima].setCodigo(null);
            carrito[cima].setTipo(null);
        } else {
            System.out.println("La pila está vacía, no hay carritos para retirar.");
        }
    }
    
    
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
