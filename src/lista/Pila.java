package lista;

import java.util.Scanner;

public class Pila 
{   
    //Cantidad maxima de carritos
    int max = 20;
    //Se define cada cima por que se manejan TRES FILAS
    int cimaNormal = 0;
    int cimaPortabebes = 0;
    int cimaPequenos = 0;
    //SE DECLARAN TRES TIPOS DE DATO DE LA CLASE OBJETO, QUE SON LOS CARRITOS QUE AL FINAL HACEN 20
    Carritos[] carritosNormales = new Carritos[10];
    Carritos[] carritosPortabebes = new Carritos[5];
    Carritos[] carritosPequenos = new Carritos[5];

    /*------------------------------------------------------------------------------*/
    /*                                    CONSTRUCTOR                               */
    /*------------------------------------------------------------------------------*/
    public Pila() 
    {
        //Inicialización del array para carritos normales
        carritosNormales = new Carritos[10];
        for (int i = 0; i < carritosNormales.length; i++) 
        {
            carritosNormales[i] = new Carritos(null, null);
        }
        
        carritosPortabebes = new Carritos[5];
        for (int i = 0; i < carritosPortabebes.length; i++) 
        {
            carritosPortabebes[i] = new Carritos(null, null);
        }
        
        carritosPequenos = new Carritos[5];
        for (int i = 0; i < carritosPequenos.length; i++) 
        {
            carritosPequenos[i] = new Carritos(null, null);
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
        return cimaNormal + cimaPortabebes + cimaPequenos;
    }

    /*------------------------------------------------------------------------------*/
    /*                   #3: METODO QUE INDICA SI LA PILA ESTA LLENA                 */               
    /*------------------------------------------------------------------------------*/
    public boolean pilaLlena() 
    {
        return numElementos() >= max;
    }

    /*------------------------------------------------------------------------------*/
    /*                     #4: METODO QUE INDICA SI LA PILA ESTA VACIA              */               
    /*------------------------------------------------------------------------------*/
    public boolean pilaVacia() 
    {
        return numElementos() == 0;
    }
    
    /*------------------------------------------------------------------------------*/
    /*                   #5: METODO PARA AGREGAR CARRITOS A LA PILA                 */               
    /*------------------------------------------------------------------------------*/
    public void ingresarCarrito(String codigo, int tipo) 
    {
        if (numElementos() < max) 
        {
            //Verifica si el código del carrito ya existe
            for (int i = 0; i < numElementos(); i++) 
            {
                if (   
                    (carritosNormales[i].getCodigo() != null && carritosNormales[i].getCodigo().equals(codigo))
                    || (carritosPortabebes[i].getCodigo() != null && carritosPortabebes[i].getCodigo().equals(codigo))
                    || (carritosPequenos[i].getCodigo() != null && carritosPequenos[i].getCodigo().equals(codigo))
                    ) 
                    
                    {
                        System.out.println("¡El código de carrito ya existe! Por favor, ingrese otro código.");
                        Scanner scanner = new Scanner(System.in);
        
                        System.out.print("Nuevo código de carrito: ");
                        codigo = scanner.next();
                        i = -1; //Reinicia el contador
                    }
             }
            //Calcula el total de carritos después de agregar el nuevo
            int totalCarritos = numElementos() + 1;
    
            //Verifica si se ha alcanzado el límite total de 20 carritos
            if (totalCarritos > max) 
            {
                System.out.println("No hay espacio disponible para agregar más carritos.");
                return;
            }
    
            //Selecciona la fila correspondiente según el tipo de carrito
            Carritos[] fila;
            int cima;
            String tipoCarrito;
            switch (tipo) 
            {
                case 1:
                    fila = carritosNormales;
                    cima = cimaNormal;
                    tipoCarrito = "Normal";
                    break;
                case 2:
                    fila = carritosPortabebes;
                    cima = cimaPortabebes;
                    tipoCarrito = "Portabebé";
                    break;
                case 3:
                    fila = carritosPequenos;
                    cima = cimaPequenos;
                    tipoCarrito = "Pequeño";
                    break;
                default:
                    System.out.println("Tipo de carrito no válido.");
                    return;
            }
    
            if (cima >= fila.length) 
            {
                System.out.println("\n-------------------------------------------------------------");
                System.out.println("Se ha alcanzado el límite de carritos de tipo => " + tipoCarrito + " <=.");
                System.out.println("-------------------------------------------------------------");
                return;
            }
    
            //Agrega el carrito a la fila seleccionada SI ES QUE TODO ESTA BIEN
            fila[cima].setCodigo(codigo);
            fila[cima].setTipo(tipoCarrito);
    
            switch (tipo) 
            {
                case 1:
                    cimaNormal++;
                    break;
                case 2:
                    cimaPortabebes++;
                    break;
                case 3:
                    cimaPequenos++;
                    break;
            }
    
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
    public void retirar(int tipo) 
    {
        int cimaActual;
        Carritos[] filaCarritos;
        String tipoFila;
        
        switch (tipo) 
        {
            case 1:
                filaCarritos = carritosNormales;
                cimaActual = cimaNormal;
                tipoFila = "Normales";
                break;
            case 2:
                filaCarritos = carritosPortabebes;
                cimaActual = cimaPortabebes;
                tipoFila = "Portabebés";
                break;
            case 3:
                filaCarritos = carritosPequenos;
                cimaActual = cimaPequenos;
                tipoFila = "Pequeños";
                break;
            default:
                System.out.println("Tipo de fila no válido.");
                return;
        }
    
        if (cimaActual > 0) 
        {
            //Muestra el carrito que se va a retirar
            System.out.println("-------------------------------------------------------------");
            System.out.println("      Carrito a retirar: Código: " + filaCarritos[cimaActual - 1].getCodigo() + ", Tipo: " + filaCarritos[cimaActual - 1].getTipo());
            System.out.println("-------------------------------------------------------------");
            
            System.out.println("¿Realmente desea retirar este carrito? 1) Sí - 0) No");
            System.out.print("Respuesta: ");
            
            Scanner scanner = new Scanner(System.in);
            int respuesta;
            
            while (!scanner.hasNextInt()) 
            {
                System.out.println("Respuesta no válida. Por favor, ingrese 1 para Sí o 0 para No.");
                scanner.next(); 
                System.out.print("Respuesta: ");
            }
            respuesta = scanner.nextInt();
    
            if (respuesta == 1) 
            {
                cimaActual--;
                System.out.println("-------------------------------------------------------------");
                System.out.println("Carrito retirado correctamente.");
                System.out.println("-------------------------------------------------------------");
    
            } 
            else 
                if (respuesta == 0) 
                {
                    System.out.println("Operación cancelada. No se retiró ningún carrito.");
                    return;
                } 
                else 
                {
                    System.out.println("Respuesta no válida. Regresando al menú principal.");
                    return;
                }
    
            if (cimaActual > 0) 
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
                    retirar(tipo);
                } 
                else 
                    if (respuesta == 0) 
                    {
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
                System.out.println("No hay más carritos en la fila de " + tipoFila + ". Operación finalizada.");
                return;
            }
        } 
        else 
        {
            System.out.println("La fila de " + tipoFila + " está vacía, no hay carritos para retirar.");
            return;
        }
    }
    
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
            System.out.println("-------------------------------------------------------------");
            System.out.println("|               Carritos en la fila de Normales              |");
            System.out.println("-------------------------------------------------------------");
            imprimirFila(carritosNormales, cimaNormal);
            System.out.println("-------------------------------------------------------------");
            System.out.println("|            Carritos en la fila de Portabebés              |");
            System.out.println("-------------------------------------------------------------");
            imprimirFila(carritosPortabebes, cimaPortabebes);
            System.out.println("-------------------------------------------------------------");
            System.out.println("|             Carritos en la fila de Pequeños               |");
            System.out.println("-------------------------------------------------------------");
            imprimirFila(carritosPequenos, cimaPequenos);
        }
    }

    
    /*------------------------------------------------------------------------------*/
    /*               #8: METODO AUXILIAR PARA MOSTRAR CARRITOS POR TIPO             */               
    /*------------------------------------------------------------------------------*/
    private void imprimirFila(Carritos[] filaCarritos, int cimaActual) 
    {
        if (cimaActual == 0) 
        {
            System.out.println("No hay carritos en esta fila.");
            return;
        }
        System.out.println("---------------------------------------------");
        System.out.println("|\tCódigo       |  \tTipo        |");
        System.out.println("---------------------------------------------");
        for (int i = 0; i < cimaActual; i++) 
        {
            System.out.printf("| %-10s\t     | %s\n", filaCarritos[i].getCodigo(), filaCarritos[i].getTipo());
        }
    }


    
}
