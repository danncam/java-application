package Java;

import java.util.Scanner;

/**
 *
 * Escreva um programa Java que receba um inteiro N e imprima sua fatoração.
 * (sequencia de inteiros primos que multiplicados iguala a N).
 *
 */
public class FatoracaoDeInteiros {

    public static void main(String[] args)
    {
        System.out.print("input: ");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        
        String output = "";
        int p = 2;
        
        while(n > 1)
        {
            if(n % p == 0 && !isComposite(p))
            {
                n = n/p;
                output += p + " ";
            }
            else 
                p++;
        }
        System.out.println("output: " + output);
        
    }
    
    /*
     * isComposite verifica se o número n é composto
     */
    public static boolean isComposite(int n)
    {
        for (int i = 2; i < n; i++) 
        {
            if(n % i == 0)
            {
                return true;
            }
            
        }
        return false;
    }
    
}
