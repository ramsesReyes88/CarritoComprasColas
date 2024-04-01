/*
    Arce Llamas Jesus Irvin
    Higuera Sanchez Dulce Mariela
    Reyes Contreras Ramses
    Rodriguez Cacho Ximena Charleene 
    ---------------------------------
    Marzo/31/2024
    TSU-DSM-4A 
    Practica #9 - Pilas
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

    public static int menu() {
        int opcion;
        do {
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
    
            // Validación de entrada de usuario
            if (read.hasNextInt()) {
                opcion = read.nextInt();
                if (opcion < 1 || opcion > 4) {
                    System.out.println("ERROR. Por favor, ingrese una opción válida (1-4).");
                    enter();
                    continue;
                }
                break;
            } else {
                System.out.println("\nError: Debe ingresar un número válido.");
                read.next();
                enter();
                continue;
            }
        } while (true);
        return opcion;
    }
    
    public static void agregar() {
        boolean agregarOtroCarrito = true;
    
        while (agregarOtroCarrito) {
            clear();     
            System.out.println("\t.------------------------------------------.");
            System.out.println("\t|          CARRITO DE SUPERMERCADO         |");
            System.out.println("\t|      -Agregando un carrito de compra-    |");
            System.out.println("\t'------------------------------------------'");
    
            System.out.println("-------------------------------------------------------------");
            System.out.println("    >>> A continuación, ingrese los datos del carrito: <<<");
            System.out.println("-------------------------------------------------------------");
    
            String codigo; 
            int tipo;
            System.out.println("Ingrese solo valores alfanuméricos.");
            System.out.print("**Codigo: ");
            codigo = read.next();
    
            // Preguntar al usuario qué tipo de carrito desea ingresar
            while (true) {
                System.out.println("\nSeleccione: 1) Carrito normal. 2) Portabebé. 3) Pequeño.");
                System.out.print("**Tipo: ");
                
                // Validar la entrada del usuario para el tipo de carrito
                if (read.hasNextInt()) {
                    tipo = read.nextInt();
                    if (tipo < 1 || tipo > 3) {
                        clear();
                        System.out.println("\nError: Debe ingresar una opción válida (1-3).");
                        continue; 
                    } else {
                        break; 
                    }
                } else {
                    clear();
                    System.out.println("\nError: Debe ingresar un número válido para el tipo.");
                    read.next(); 
                }
            }
            
            // Ingresar el carrito con el código y tipo especificados
            filaCarrito.ingresarCarrito(codigo, tipo);
            
            // Preguntar al usuario si desea agregar otro carrito
            System.out.print("¿Desea agregar otro carrito? (S/N): ");
            String respuesta = read.next().toUpperCase();
            while (!respuesta.equals("S") && !respuesta.equals("N")) {
                System.out.println("Error: Respuesta inválida. Por favor, ingrese 'S' o 'N'.");
                System.out.print("¿Desea agregar otro carrito? (S/N): ");
                respuesta = read.next().toUpperCase();
            }
    
            agregarOtroCarrito = respuesta.equals("S");
        }
    
        enter(); 
    }//agregar
    

    public static void retirar() {
        clear();
        System.out.println("\t.------------------------------------------.");
        System.out.println("\t|          CARRITO DE SUPERMERCADO         |");
        System.out.println("\t|      - Retirando un carrito de compra - |");
        System.out.println("\t'------------------------------------------'");
    
        int tipo;
    
        do {
            clear();
            System.out.println("Seleccione el tipo de fila a retirar:");
            System.out.println("1. Normales");
            System.out.println("2. Portabebés");
            System.out.println("3. Pequeños");
            System.out.println("4. Salir");
            System.out.print("Opción: ");
    
            // Validación de entrada de usuario
            if (read.hasNextInt()) {
                tipo = read.nextInt();
                if (tipo >= 1 && tipo <= 3) {
                    filaCarrito.retirar(tipo);
                    enter();
                } else if (tipo == 4) {
                    return; 
                } else {
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                    enter();
                }
            } else {
                System.out.println("\nError: Debe ingresar un número válido.");
                read.next(); 
                enter();
                continue;
            }
        } while (true);
    }//retirar
    
    
    

    public static void imprimir() {
        clear();     
        System.out.println("\t.------------------------------------------.");
        System.out.println("\t|          CARRITO DE SUPERMERCADO         |");
        System.out.println("\t|            -Carritos en total-           |");
        System.out.println("\t'------------------------------------------'");
    
        System.out.println("Seleccione el tipo de carrito a imprimir:");
        System.out.println("1. Normales");
        System.out.println("2. Portabebés");
        System.out.println("3. Pequeños");
        System.out.println("4. Salir");
        System.out.print("Opción: ");
    
        int tipo;
    
        // Validación de entrada de usuario
        if (read.hasNextInt()) {
            tipo = read.nextInt();
            if (tipo == 4) {
                return; 
            }
            clear();
            filaCarrito.imprimir(tipo);
            enter();
            clear(); 
            imprimir();
        } else {
            System.out.println("\nError: Debe ingresar un número válido.");
            read.next(); 
            enter();
            imprimir();
        }
    }
    
    
    /*------------------------------------------------------------------------------*/
    /*                METODO AUX. 1 PARA SEGUIR EN PANTALLA CON ENTER               */               
    /*------------------------------------------------------------------------------*/
    public static void enter()
    {
        Scanner continuar = new Scanner(System.in);
        continuar.useDelimiter("\n");
        System.out.println("-------------------------------------------------------------");
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
