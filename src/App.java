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
        
        System.out.println("\t.------------------------------------------.");
        System.out.println("\t|                  CARRITO DE              |");
        System.out.println("\t|                 SUPERMERCADO             |");
        System.out.println("\t'------------------------------------------'");
        int opcion;
        do 
        {
            System.out.println("-------------------------------------------------------------");
            System.out.println("\nBienvenid@, elige una opción:");
            opcion = menu();
            switch (opcion) {
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
        } while (opcion != 4);
        }

    public static int menu(){
        int opcion;
        do {
            clear();
            System.out.println("Gestion de Carritos de Compra");
            System.out.println("1.Ingresar un Carrito");
            System.out.println("2.Retirar Carrito");
            System.out.println("3.Carritos en total");
            System.out.println("4.Salir del Programa");
            System.out.println("Escoja su opcion: ");
            opcion = read.nextInt();
        } while (opcion < 1 || opcion > 4);
        return opcion;
    }

    public static void agregar(){
        String codigo,tipo;
        clear();
        System.out.println("agregue los datos ");
        System.out.println("Codigo:       ");
        codigo = read.next();
        System.out.println("Tipo");
        tipo = read.next();   
        filaCarrito.ingresarCarrito(codigo, tipo);
        enter(); 
    }

    public static void retirar(){
        clear();
        System.out.println("Retirar el ultimo Carrito");
        filaCarrito.retirar();
        enter();
    }

    public static void imprimir(){
        clear();
        System.out.println("Lista de Carritos");
        filaCarrito.imprimir();
        enter();
    }

    public static void enter(){
        Scanner continuar = new Scanner(System.in);
        continuar.useDelimiter("\n");
        System.out.println("Presione enter para Continuar...");
        continuar.next();
    }

    public static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
