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
public class Cuatroenraya {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner entrada = new Scanner(System.in);
        
        char[][] tablero = new char[6][7];
        
        for (char[] tablero1 : tablero) {
            for (int columnas = 0; columnas < tablero[0].length; columnas++) {
                tablero1[columnas] = ' ';
            }
        }
        
        int turnos = 1;
        String jugador = "Rojo";
        char fichajugador = 'R';
        boolean ganador = false;
        
        while(!ganador && turnos <=42){
            boolean esValido;
            int ficha;
            
            do {
                mostrar(tablero);
                
                System.out.println("Jugador "+ jugador +" elije la columna: ");
                ficha = entrada.nextInt();
                
                esValido = validar(ficha,tablero);
            }while(!esValido);
            
            for(int fila = tablero.length - 1; fila >= 0; fila--){
                if(tablero[fila][ficha] == ' '){
                    tablero[fila][ficha] = fichajugador;
                    break;
                    
                }
            }
            
            ganador = esGanador(fichajugador,tablero);
            
            if(jugador.equalsIgnoreCase("Rojo")){
                jugador = "Negro";
                fichajugador = 'N';
            }else{
                jugador = "Rojo";
                fichajugador = 'R';
            }
            
            turnos++;
            
        }
        
        mostrar(tablero);
        
        if(ganador){
            if(jugador.equalsIgnoreCase("Rojo")){
                System.out.println("El ganador es el jugador negro");
            }else{
                System.out.println("El ganador es el jugador rojo");
            }
        }else{
            System.out.println("Tablas");
        }
       
    }
    
    public static void mostrar (char[][] tablero){
        System.out.println(" 0 1 2 3 4 5 6");
		System.out.println("---------------");
        for (char[] tablero1 : tablero) {
            System.out.print("|");
            for (int columna = 0; columna < tablero[0].length; columna++) {
                System.out.print(tablero1[columna]);
                System.out.print("|");
            }
            System.out.println();
            System.out.println("---------------");
        }
		System.out.println(" 0 1 2 3 4 5 6");
		System.out.println();
    }
    
    public static boolean validar(int columna, char[][] tablero){
		
		if (columna < 0 || columna > tablero[0].length){
			return false;
		}
		
		
		if (tablero[0][columna] != ' '){
			return false;
		}
		
		return true;
	}
	
	public static boolean esGanador(char fichajugador, char[][] tablero){
        //check for 4 across
        for (char[] tablero1 : tablero) {
            for (int columna = 0; columna < tablero[0].length - 3; columna++) {
                if (tablero1[columna] == fichajugador && tablero1[columna+1] == fichajugador && tablero1[columna+2] == fichajugador && tablero1[columna+3] == fichajugador) {
                    return true;
                }
            }
        }
		//check for 4 up and down
		for(int fila = 0; fila < tablero.length - 3; fila++){
			for(int columna = 0; columna < tablero[0].length; columna++){
				if (tablero[fila][columna] == fichajugador   && 
					tablero[fila+1][columna] == fichajugador &&
					tablero[fila+2][columna] == fichajugador &&
					tablero[fila+3][columna] == fichajugador){
					return true;
				}
			}
		}
		//check upward diagonal
		for(int fila = 3; fila < tablero.length; fila++){
			for(int columna = 0; columna < tablero[0].length - 3; columna++){
				if (tablero[fila][columna] == fichajugador   && 
					tablero[fila-1][columna+1] == fichajugador &&
					tablero[fila-2][columna+2] == fichajugador &&
					tablero[fila-3][columna+3] == fichajugador){
					return true;
				}
			}
		}
		//check downward diagonal
		for(int fila = 0; fila < tablero.length - 3; fila++){
			for(int columna = 0; columna < tablero[0].length - 3; columna++){
				if (tablero[fila][columna] == fichajugador   && 
					tablero[fila+1][columna+1] == fichajugador &&
					tablero[fila+2][columna+2] == fichajugador &&
					tablero[fila+3][columna+3] == fichajugador){
					return true;
				}
			}
		}
		return false;
	}
}
