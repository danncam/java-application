package Repetition;

import java.util.Scanner;

/*
 * Escreva um aplicativo em Java que solicite ao usuário inserir o tamanho do 
 * lado de um quadrado e então exiba um quadrado vazio desse tamanho feito de
 * asteriscos. Seu programa deve trabalhar com quadrados de todos os
 * comprimentos	de lado	possíveis entre	1 e 20.	Caso o	usuário	escolha	um tamanho
 * inválido, uma mensagem de erro deve ser exibida.

 */
public class SquareAsterisks {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int s = input.nextInt();
        
        
        if(s > 0)
        {
            for (int i = 0; i < s; i++) {
                for (int j = 0; j < s; j++) {
                    if(i == 0 || j == 0 || i == s - 1 || j == s - 1)
                        System.out.print(" * ");
                    else
                        System.out.print("   ");
                }
                System.out.println("");
            }
        }
        else
            System.out.println("Número negativo ou zero");
    }
}
