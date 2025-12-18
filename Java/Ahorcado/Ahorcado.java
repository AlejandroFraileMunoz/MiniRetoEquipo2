/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.minireto;



import java.util.Scanner;

/**
 *
 * @author ossel
 */
public class Ahorcado {
    private static int errores = 0;
    private static int conntadorerrores = 0;

   
         public static void main(String[] args) {
       
        juego();
        
}
        
        public static void juego(){
 Scanner entrada = new Scanner(System.in);

        
        boolean terminado = false;
        
       
        
        String[] palabras = {"PERRO"};
        char[] guiones = new char[palabras[0].length()];
        
        
//        Arrays.fill(guiones,'_');
        for(int i =  0; i < guiones.length; i++){
            guiones[i] = '_';
        }
        System.out.println(guiones);
        int vidas = 7;
        int conntadorerrores = 0;
        
        
         while(!terminado){
              System.out.println("\nPalabra: " + mostrarPalabra(guiones));
            System.out.println("Vidas: " + vidas);
            
             
             
         
        System.out.println("Introduce una letra: ");
         char letra = entrada.nextLine().toUpperCase().charAt(0);
        
         boolean acierto = false;
        
        String[] letras = new String[palabras[0].length()];
        
         for(int i =  0; i < palabras[0].length(); i++){
           
             if(palabras[0].charAt(i) == letra){
                guiones[i] = letra;
                acierto = true;
             }
             
         }
         
         if(acierto){
             System.out.println("Correcto");
         }else{
             vidas--;
             errores++;
             System.out.println("Incorrecto");
             System.out.println("Te quedan "+ vidas +" vidas");
             Imagen();
             
         }
        
        if (palabraCompleta(guiones)) {
                System.out.println("\nHas ganado! La palabra era: " + palabras[0]);
                terminado = true;
                
            }

                    
         if (vidas == 0) {
            System.out.println("\nHas perdido! La palabra era: " + palabras[0]);
            terminado = true;
        }
        
         }
           
            
       
            
       
        
    }
               
        
         private static String mostrarPalabra(char[] palabra) {
        String resultado = "";
        for (char guiones : palabra) {
            resultado += guiones + " ";
        }
        return resultado;
    }
    
    public static boolean palabraCompleta(char[] palabra) {
        for (char c : palabra) {
            if (c == '_') {
                return false;
            }
        }
        return true;
    }
    public static void Imagen() {
       
		if (errores == 1) {
			
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("___|___");
			System.out.println();
		}
		if (errores == 2) {
			
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("___|___");
		}
		if (errores == 3) {
			
			System.out.println("   ____________");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   | ");
			System.out.println("___|___");
		}
		if (errores == 4) {
			
			System.out.println("   ____________");
			System.out.println("   |          _|_");
			System.out.println("   |         /   \\");
			System.out.println("   |        |     |");
			System.out.println("   |         \\_ _/");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("___|___");
		}
		if (errores == 5) {
			
			System.out.println("   ____________");
			System.out.println("   |          _|_");
			System.out.println("   |         /   \\");
			System.out.println("   |        |     |");
			System.out.println("   |         \\_ _/");
			System.out.println("   |           |");
			System.out.println("   |           |");
			System.out.println("   |");
			System.out.println("___|___");
		}
		if (errores == 6) {
			
			System.out.println("   ____________");
			System.out.println("   |          _|_");
			System.out.println("   |         /   \\");
			System.out.println("   |        |     |");
			System.out.println("   |         \\_ _/");
			System.out.println("   |           |");
			System.out.println("   |           |");
			System.out.println("   |          / \\ ");
			System.out.println("___|___      /   \\");
		}
		if (errores == 7) {
			System.out.println("Fin de la partida");
			System.out.println("   ____________");
			System.out.println("   |          _|_");
			System.out.println("   |         /   \\");
			System.out.println("   |        |     |");
			System.out.println("   |         \\_ _/");
			System.out.println("   |          _|_");
			System.out.println("   |         / | \\");
			System.out.println("   |          / \\ ");
			System.out.println("___|___      /   \\");
			
		}
	}
       
    }



   

    

