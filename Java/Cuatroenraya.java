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
        juegoCuatroenRaya();
        
        
  

    }
    
    
    public static void juegoCuatroenRaya(){
         Scanner entrada = new Scanner(System.in);// se habre el escaner para introducir la columna deseada

        char[][] tablero = new char[6][7];// se crea el array de char para el tablero

        for (char[] tablero1 : tablero) {
            for (int columnas = 0; columnas < tablero[0].length; columnas++) {
                tablero1[columnas] = ' ';// se rellena el array con espacios en blanco
            }
        }

        int turnos = 1;
        String jugador = "Rojo";
        char fichajugador = 'R';// se crea la variable de turnos, el color del jugador y cual va a ser la ficha que le represente
        boolean ganador = false;

        while (!ganador && turnos <= 42) {// bucle principal 
            boolean esValido;
            int ficha = 0;
            boolean validacionnumero = false;// se crea la variable de donde va a meter la ficha y validaciones
            do {// bucles para validar
                mostrar(tablero);// se enseña el tablero
                while (!validacionnumero) {// bucle para validar que la columna existe
                    System.out.println("Jugador " + jugador + " elije la columna: ");
                    if (entrada.hasNextInt()) {// compruebasi es un número
                        ficha = entrada.nextInt();
                        if (ficha <= 6 && ficha >= 0) {// comprueba si está entre las columnas posibles
                            validacionnumero = true;
                        } else {
                            System.out.println("No has introducido un número valido(números del 0 al 6)");
                        }

                    } else {
                        System.out.println("No has introducido un número entero");
                        entrada.next();
                    }
                }

                esValido = validar(ficha, tablero);// comprueba si se puede meter la ficha en esa columna
            } while (!esValido);

            for (int fila = tablero.length - 1; fila >= 0; fila--) {// aqui es donde se mete la ficha en el tablero
                if (tablero[fila][ficha] == ' ') {// se comprueba si está vacio y se empieza por abajo
                    tablero[fila][ficha] = fichajugador;// se sustituye por la ficha del jugador
                    break;

                }
            }

            ganador = esGanador(fichajugador, tablero);

            if (jugador.equalsIgnoreCase("Rojo")) {// se cambia de usuario
                jugador = "Negro";
                fichajugador = 'N';
            } else {
                jugador = "Rojo";
                fichajugador = 'R';
            }

            turnos++;

        }

        mostrar(tablero);// se enseña como ha quedado el tablero

        if (ganador) {// se comprueba si hay ganador y se dice quien lo ha hecho
            if (jugador.equalsIgnoreCase("Rojo")) {
                System.out.println("El ganador es el jugador negro");
            } else {
                System.out.println("El ganador es el jugador rojo");
            }
        } else {// si no hay ganador 
            System.out.println("Tablas");
        }
    }

    public static void mostrar(char[][] tablero) {// metodo para mostrar el tablero
        System.out.println(" 0 1 2 3 4 5 6");// se muestran las columnas posibles
        System.out.println("---------------");// se ponen los limites del tablero
        for (char[] tablero1 : tablero) {//se mira todo el array
            System.out.print("|");// se dividen las columnas
            for (int columna = 0; columna < tablero[0].length; columna++) {
                System.out.print(tablero1[columna]);// se pone el espacio en blanco o la ficha correspondiente
                System.out.print("|");// se dividen las columnas
            }
            System.out.println();
            System.out.println("---------------");// limite inferior del tablero
        }
        System.out.println(" 0 1 2 3 4 5 6");// columnas posibles
        System.out.println();
    }

    public static boolean validar(int columna, char[][] tablero) {// se comprueba si se puede poner la ficha

        if (columna < 0 || columna > tablero[0].length) {// comprueba si esta entre las posibles
            return false;
        }

        if (tablero[0][columna] != ' ') {// si la última fila tiene una ficha no se puede poner encima
            return false;
        }

        return true;
    }

    public static boolean esGanador(char fichajugador, char[][] tablero) {// se comprueba si hay ganador
        //se comprueba la horizontal
        for (char[] tablero1 : tablero) {
            for (int columna = 0; columna < tablero[0].length - 3; columna++) {
                if (tablero1[columna] == fichajugador && tablero1[columna + 1] == fichajugador && tablero1[columna + 2] == fichajugador && tablero1[columna + 3] == fichajugador) {
                    return true;
                }
            }
        }
        //se comprueba la vertical
        for (int fila = 0; fila < tablero.length - 3; fila++) {
            for (int columna = 0; columna < tablero[0].length; columna++) {
                if (tablero[fila][columna] == fichajugador
                        && tablero[fila + 1][columna] == fichajugador
                        && tablero[fila + 2][columna] == fichajugador
                        && tablero[fila + 3][columna] == fichajugador) {
                    return true;
                }
            }
        }
        //diagonal
        for (int fila = 3; fila < tablero.length; fila++) {
            for (int columna = 0; columna < tablero[0].length - 3; columna++) {
                if (tablero[fila][columna] == fichajugador
                        && tablero[fila - 1][columna + 1] == fichajugador
                        && tablero[fila - 2][columna + 2] == fichajugador
                        && tablero[fila - 3][columna + 3] == fichajugador) {
                    return true;
                }
            }
        }
        //diagonal inversa
        for (int fila = 0; fila < tablero.length - 3; fila++) {
            for (int columna = 0; columna < tablero[0].length - 3; columna++) {
                if (tablero[fila][columna] == fichajugador
                        && tablero[fila + 1][columna + 1] == fichajugador
                        && tablero[fila + 2][columna + 2] == fichajugador
                        && tablero[fila + 3][columna + 3] == fichajugador) {
                    return true;
                }
            }
        }
        return false;
    }
}
