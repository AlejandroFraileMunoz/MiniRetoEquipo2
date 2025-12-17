/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.minireto;

import java.util.Scanner;

/**
 *
 * @author DAW120
 */
public class Ahorcado {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        
        boolean terminado = false;
        
       
        
        String[] palabras = {"PERRO"};
        
        for(int i =  0; i < palabras[0].length(); i++){
            System.out.print("_ ");
        }
        System.out.printf("\n");
        
         while(!terminado){
             
             String[] letra = new String[palabras.length + 6];
             int contadorletra = 0;
         
        System.out.println("Introduce una letra: ");
         letra[contadorletra] = entrada.next().toUpperCase().substring(0, 1);
        
        
        
        String[] letras = new String[palabras[0].length()];
        
         for(int i =  0; i < palabras[0].length(); i++){
           
             if(i == palabras[0].length()){
                 letras[i] = palabras[0].substring(i);
             }else{
                 letras[i] = palabras[0].substring(i, i + 1);
             }
             
         }
        
        boolean acierto = false;
        
        for(int i =  0; i < palabras[0].length(); i++){
            if(letra[contadorletra].equalsIgnoreCase(letras[i])){
                System.out.printf("%s ", letra );
                acierto = true;
            }else{
                System.out.printf("_ ");
            }
        }
            System.out.print("\n");
            int vidas = 6;
        if(!acierto){
            vidas--;
            System.out.println("Te quedan "+ vidas +" vidas");
        }
            
        
        }
        
    }
}
