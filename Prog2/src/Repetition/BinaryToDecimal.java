package Repetition;

import java.util.Scanner;

/**
 *
 * Escreva um aplicativo que aceita como entrada um inteiro contendo somente 0s
 * e 1s (isto é, um inteiro binário) e imprime seu equivalente decimal. Caso	o
 * usuário digite um número com dígitos diferentes de 0s e 1s, uma mensagem de
 * erro deve ser exibida.
 */
public class BinaryToDecimal {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String bin = input.next();
        int dec = 0;

        int leng = bin.length() - 1;
        for (int i = 0; i < bin.length(); i++) 
        {
            dec += Character.getNumericValue(bin.charAt(i)) * Math.pow(2, leng--);
        }

        System.out.println(dec);



    }
}