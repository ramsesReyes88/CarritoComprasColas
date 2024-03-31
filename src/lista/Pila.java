package lista;

import java.util.Scanner;

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
        //Verifica si hay espacio disponible para agregar más carritos
        if (cima < max) 
        {
            //Verifica si el código del carrito ya existe
            for (int i = 0; i < cima; i++) 
            {
                if (carrito[i].getCodigo().equals(codigo)) 
                {
                    System.out.println("¡El código de carrito ya existe! Por favor, ingrese otro código.");

                    Scanner scanner = new Scanner(System.in);

                    System.out.print("Nuevo código de carrito: ");
                    codigo = scanner.next();
                    i = -1; //Reinicia el contador 
                }
            }

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
                System.out.println("\n-------------------------------------------------------------");
                System.out.println("Se ha alcanzado el límite de carritos de tipo => " + tipoCarrito + " <=.");
                System.out.println("-------------------------------------------------------------");
                return;
            }
        
            //SI TODO ESTA BIEN SE AGREGA EL CARRITO
            carrito[cima].setCodigo(codigo);
            carrito[cima].setTipo(tipoCarrito);
            cima++;
            
            System.out.println("-------------------------------------------------------------");
            System.out.println("      >>> El carrito se ha ingresado correctamente. <<< ");
            System.out.println("-------------------------------------------------------------");
            
            System.out.println("\t-Código: " + codigo);
            System.out.println("\t-Tipo de carrito: " + tipoCarrito);
            
        } 
        else 
        {
            System.out.println("No hay espacio disponible para agregar más carritos.");
        }
    }//agregar
    
    /*------------------------------------------------------------------------------*/
    /*                  #6: METODO PARA RETIRAR CARRITOS DE LA PILA                 */               
    /*------------------------------------------------------------------------------*/
    public void retirar() 
    {
        if (cima > 0)
        {
            //Muestra el carrito que se va a retirar
            System.out.println("-------------------------------------------------------------");
            System.out.println("      Carrito a retirar: Código: " + carrito[cima - 1].getCodigo() + ", Tipo: " + carrito[cima - 1].getTipo());
            System.out.println("-------------------------------------------------------------");
            
            System.out.println("¿Realmente desea retirar este carrito? 1) Sí - 0) No");
            System.out.print("Respuesta: ");
            
            Scanner scanner = new Scanner(System.in);
            int respuesta;
            
            //Se valida si la entrada es un entero
            while (!scanner.hasNextInt()) 
            {
                System.out.println("Respuesta no válida. Por favor, ingrese 1 para Sí o 0 para No.");
                scanner.next(); 
                System.out.print("Respuesta: ");
            }
            respuesta = scanner.nextInt();
    
            if (respuesta == 1) 
            {
                cima--;
                System.out.println("-------------------------------------------------------------");
                System.out.println("Carrito retirado correctamente.");
                System.out.println("-------------------------------------------------------------");

            } 
            else 
                if (respuesta == 0) 
                {
                    //Si no desea retirar el carrito, muestra un mensaje
                    System.out.println("Operación cancelada. No se retiró ningún carrito.");
                    return;
            } 
            else 
            {
                // Si la respuesta no es válida, muestra un mensaje
                System.out.println("Respuesta no válida. Regresando al menú principal.");
                return;
            }
    
            //Pregunta si desea retirar otro carrito si aún quedan carritos en la pila
            if (cima > 0) 
            {
                             
                System.out.println("¿Desea retirar otro carrito? 1) Sí - 0) No");
                System.out.print("Respuesta: ");
                
                while (!scanner.hasNextInt()) 
                {
                    System.out.println("Respuesta no válida. Por favor, ingrese 1 para Sí o 0 para No.");
                    scanner.next(); 
                    System.out.print("Respuesta: ");
                }
                respuesta = scanner.nextInt();
    
                if (respuesta == 1) 
                {
                    //Si desea retirar otro carrito, llama  al método 
                    retirar();
                } 
                else 
                    if (respuesta == 0) 
                    {
                        //si no desea retirar otro carrito, muestra un mensaje
                        System.out.println("Operación finalizada. No se retiraron más carritos.");
                        return;
                    } 
                    else 
                    {
                        System.out.println("Respuesta no válida. Regresando al menú principal.");
                        return;
                    }
            } 
            else 
            {
                System.out.println("No hay más carritos en la pila. Operación finalizada.");
                return;
            }
        } 
        else 
        {
            System.out.println("La pila está vacía, no hay carritos para retirar.");
            return;
        }
    }//retirar
    
    
    /*------------------------------------------------------------------------------*/
    /*           #7: METODO PARA MOSTRAR EL TOTAL DE CARRITOS DISPONIBLES           */               
    /*------------------------------------------------------------------------------*/
    public void imprimir() 
    {
        if (pilaVacia()) 
        {
            
            System.out.println("-------------------------------------------------------------");
            System.out.println("      >>> Actualmente no hay carritos en ninguna fila  <<< ");
            System.out.println("-------------------------------------------------------------");
            
        } 
        else 
        {
            
            System.out.println("---------------------------------------------");
            System.out.println("|\tCódigo       |  \tTipo        |");
            System.out.println("---------------------------------------------");
            for (int i = 0; i < cima; i++) 
            {
                System.out.printf("| %-10s\t     | %s\n", carrito[i].getCodigo(), carrito[i].getTipo(), "     |");
            }
        }
    }//imprimir


    
}
