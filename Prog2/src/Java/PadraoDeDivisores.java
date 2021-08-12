package Java;
import java.util.Scanner;

/*
 * Escreva um programa Java que receba um inteiro N e imprima
 * um tabela NxN com um asterisco na linha i e coluna j se ou i
 * divide j ou j divide i.

 */
public class PadraoDeDivisores {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(i % j == 0 || j % i == 0){
                    System.out.print(" * ");
                } else
                    System.out.print("   ");

            }
            System.out.println("");
        }
    }
}
