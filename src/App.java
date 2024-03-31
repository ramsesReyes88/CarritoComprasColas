/*
    Arce Llamas Jesus Irvin
    Higuera Sanchez Dulce Mariela
    Reyes Contreras Ramses
    Rodriguez Cacho Ximena Charleene 
    ---------------------------------
    Marzo/31/2024
    TSU-DSM-4A 
    Practica #9
*/

import java.util.Scanner;
import lista.*;

public class App 
{
    //Scanner de manera global
    static Scanner read = new Scanner(System.in);
    //Creacion de la fila de carritos
    static Pila filaCarrito = new Pila();
    public static void main(String[] args) throws Exception 
    {
        int opcion;
        do 
        {
            opcion = menu();
            switch (opcion) 
            {
                case 1:
                    agregar();
                    break;
                case 2:
                    retirar();
                    break;
                case 3:
                    imprimir();
                    break;
            }
        } 
        while (opcion != 4);
    }

    public static int menu() 
    {
        int opcion;
        do 
        {
            clear();
            System.out.println("\t.------------------------------------------.");
            System.out.println("\t|          CARRITO DE SUPERMERCADO         |");
            System.out.println("\t|      -Gestion de carritos de compra-     |");
            System.out.println("\t'------------------------------------------'");
            System.out.println("-------------------------------------------------------------");
            System.out.print("\t    >>> Bienvenid@, elige una opción: <<<");
            System.out.println("\n-------------------------------------------------------------");
            System.out.println("1) Ingresar un carrito");
            System.out.println("2) Retirar carrito");
            System.out.println("3) Carritos en total");
            System.out.println("4) Salir");
            System.out.println("-------------------------------------------------------------");
            System.out.print("Escoja su opción: ");
            
            //Se valida si la entrada es un entero
            while (!read.hasNextInt()) 
            {
                System.out.println("ERROR. Por favor, ingrese un número entero.");
                System.out.print("Escoja su opción: ");
                read.next(); 
            }
            
            opcion = read.nextInt();
    
            if (opcion < 1 || opcion > 4) 
            {
                System.out.println("ERROR. Por favor, seleccione una opción válida.");
                enter();
            } 
            else 
            {
                break;
            }
        } 
        while (true);
        return opcion;
    }
    
    public static void agregar()
    {   
        clear();     
        System.out.println("\t.------------------------------------------.");
        System.out.println("\t|          CARRITO DE SUPERMERCADO         |");
        System.out.println("\t|      -Agregando un carrito de compra-    |");
        System.out.println("\t'------------------------------------------'");
        
        System.out.println("-------------------------------------------------------------");
        System.out.println("    >>>A continuación, ingrese los datos del carrito: <<<");
        System.out.println("-------------------------------------------------------------");
        
        String codigo; 
        int tipo;
        System.out.println("Ingrese solo valores alfanumericos.");
        System.out.print("**Codigo: ");
        codigo = read.next();
        System.out.println("Seleccione: 1) Carrito normal. 2) Portabebé. 3) Pequeño.");
        System.out.print("**Tipo: ");

        //Se manda el tipo al menu para que se vuelva a evaluar si no supera el limite
        tipo = read.nextInt();   
        filaCarrito.ingresarCarrito(codigo, tipo);
        enter(); 
    }

    public static void retirar()    
    {
        clear();
        System.out.println("Retirar el ultimo Carrito");
        filaCarrito.retirar();
        enter();
    }

    public static void imprimir()
    {
        clear();
        System.out.println("Lista de Carritos");
        filaCarrito.imprimir();
        enter();
    }

    
    /*------------------------------------------------------------------------------*/
    /*                METODO AUX. 1 PARA SEGUIR EN PANTALLA CON ENTER               */               
    /*------------------------------------------------------------------------------*/
    public static void enter()
    {
        Scanner continuar = new Scanner(System.in);
        continuar.useDelimiter("\n");
        System.out.print("Presione ENTER para continuar... ");
        continuar.next();
    }

    /*------------------------------------------------------------------------------*/
    /*                        METODO AUX. 2 PARA LIMPIAR PANTALLA                   */               
    /*------------------------------------------------------------------------------*/
    public static void clear() 
    {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
