/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.minireto;



import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author ossel
 */
public class Ahorcado {
    private static int errores = 0;
   

   
         public static void main(String[] args) {
       
        juegoahorcado();
        
}
        
        public static void juegoahorcado() {
        Scanner entrada = new Scanner(System.in);//Se crea el escaner para luego introducir las letras
        Random r = new Random();// se crea el random para que salga una letra aleatoria
        char letra = 0;
        boolean terminado = false;

        String[] palabras = {"PERRO", "ANUAL", "DESPERTAR", "TEMPORAL", "FELPA", "AUDACIA", "ARENA", "ADOPTANTE", "REAL", "TRAGICO", "HABILIDADES", "CONSEJO", "FICCION", "MAS", "COMPARAR", "ATERRADOR", "VIRGEN", "AMIGO", "REVISTA", "CONEJO", "AGUDA", "MATADERO", "TRES", "BERREA", "GRANJERO", "DESPRECIO", "APRESURADO", "CURAR", "GIGANTESCO", "VARIAR", "SENTIDO", "INCLUIR", "PERMANECER", "CENA", "DEPENDER", "COLECCION", "BUZON", "CENTAURO", "DIBOLATRIA", "PRESENTACION", "SEDOSO", "EQUITATIVA", "INGRESOS", "CONFUSO", "TONTO", "FORMAL", "SOLEDAD", "PAN", "CIELO", "MIRADA", "ESCRIBIR", "CEDENTE", "COMIDA", "ABANDONADO", "CENTRO", "SOBORNO", "PROCEDIMIENTO", "EXHIBICION", "NOMADA", "PANA", "CALCULADORA", "NACIONAL", "EVANESCENTE", "ASOCIADO", "PROPORCION", "JOROBA", "EDITOR", "IMITAR", "LADRON", "LLUVIA", "BAR", "ASTUTO", "CANTIDAD", "FERROCARRIL", "NEUMATICO"};
        String palabrafinal = palabras[r.nextInt(palabras.length)];//Elige una palabra aleatoria
        char[] guiones = new char[palabrafinal.length()];// Se crea un array de char en el que su longitud de array es la longitud de la palabra

//        Arrays.fill(guiones,'_');
        for (int i = 0; i < guiones.length; i++) {
            guiones[i] = '_';// se rellena cada posicion del array con guiones
        }
        System.out.println(guiones);
        int vidas = 7;

        while (!terminado) {//inicia el bucle principal
            System.out.println("\nPalabra: " + mostrarPalabra(guiones));//se escribe la palabra oculta
            System.out.println("Vidas: " + vidas);// se escriben las vidas que se tienen

            boolean validacionletra = false;

            while (!validacionletra) {//bucle para validar una entrada correcta
                System.out.println("Introduce una letra: ");
                letra = entrada.next().toUpperCase().charAt(0);// se coje la primera letra, se transforma en char u se hace mayuscula
                if (Character.isLetter(letra)) {//comprueba que es una letra

                    validacionletra = true;
                } else {
                    System.out.println("No has introducido una letra");

                }
            }

            boolean acierto = false;

            for (int i = 0; i < palabrafinal.length(); i++) {//se mira el array

                if (palabrafinal.charAt(i) == letra) {// si alguna de las letras coincide se cambia el guion correspondiente por la letra
                    guiones[i] = letra;
                    acierto = true;
                }

            }

            if (acierto) {
                System.out.println("Correcto");
            } else {// si no acierta se resta 1 vida se suma 1 error y se pone la imagen
                vidas--;
                errores++;
                System.out.println("Incorrecto");
                System.out.println("Te quedan " + vidas + " vidas");
                Imagen();

            }

            if (palabraCompleta(guiones)) {// comprueba si tienes la palabra completa
                System.out.println("\nHas ganado! La palabra era: " + palabrafinal);
                terminado = true;
                errores = 0;

            }

            if (vidas == 0) {
                System.out.println("\nHas perdido! La palabra era: " + palabrafinal);
                terminado = true;
                errores = 0;
            }

        }
       

    }

    private static String mostrarPalabra(char[] palabra) {// un metodo que te muestra la palabra
        String resultado = "";
        for (char guiones : palabra) {
            resultado += guiones + " ";
        }
        return resultado;
    }

    public static boolean palabraCompleta(char[] palabra) {// un metodo que te dice si tienes la palabra completa adivinada
        for (char c : palabra) {
            if (c == '_') {
                return false;
            }
        }
        return true;
    }

    public static void Imagen() {// el metodo que te muestra como avanzan los fallos

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
            System.out.println("   |");
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
            System.out.println("   |         /   \\");
            System.out.println("   |");
            System.out.println("___|___  ");
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
            System.out.println("   |         /   \\");
            System.out.println("   |");
            System.out.println("___|___  ");

        }
    }

}



   

    

