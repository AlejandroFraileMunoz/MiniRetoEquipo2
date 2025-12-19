/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.minireto;

import java.util.Scanner;

/**
 *
 * @author DAW120
 */
public class MenuJuegos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner entrada = new Scanner(System.in);
        int opcion = 0;
        
        
        while(opcion != 3){// bucle para elegir juego
            System.out.println("Elije un juego");
            System.out.println("Opción 1: Ahorcado");
            System.out.println("Opción 2: Cuatro en raya");
            System.out.println("Opción 3: Salir");
            System.out.println("Introduce un número: ");
            
            if(entrada.hasNextInt()){//comprueba que es un número
                opcion = entrada.nextInt();
                
                if(opcion >= 1 && opcion<= 3){// comprueba que está entre las opciones
                    System.out.println("Has elegido la opción "+ opcion);
                    
                    switch(opcion){
                        case 1 -> Ahorcado.juegoahorcado();
                        case 2 -> Cuatroenraya.juegoCuatroenRaya();
                        case 3 -> System.out.println("Saliendo...");
                    }
                    System.out.println();
                }else{
                    System.out.println("No has introdicido un número valido(del 1 al 3)");
                }
                
            }else{
              
                System.out.println("El valor introducido no es valido");
                entrada.next();
            }
            
        }
        
        
        
    }
    
}
