package Repetition;

import java.util.Scanner;

/**
 *
 * Escreva um aplicativo que aceita como entrada um inteiro positivo e determine
 * se este é um número perfeito. Um número inteiro é perfeito se é igual à soma
 * de seus divisores próprios. Divisores próprios de um número positivo N são
 * todos os divisores inteiros positivos de N exceto o próprio N. Por exemplo, o
 * número 6, tem divisores próprios 1, 2 e 3, cuja soma é igual à 6, ou seja, 1
 * + 2 + 3 = 6. Logo 6 é um número perfeito.
 */
public class PerfectNumber {

    public static void main(String[] args) {
        // estes são N e a soma e o produto de seus fatores.
        int n, b, p;
        int prod = 1;
        int sum = 0;
        p = 2;
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        b = n;
        System.out.println(isPrime(n));
        while(n > 1)
        {
            if(n % p == 0 && isPrime(p))
            {
                n = n / p;
                sum = sum + p;
                prod = prod * p;
            }
            else 
            {
                p++;
            }
        }
        
        if(sum == prod){
            System.out.println(b + " é perfeito");
        }


    }

    public static boolean isPrime(int n) {
        if (n > 1) {
            for (int i = 2; i < n; i += 2) {
                if (n % i == 0) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
        
    }
}
/*
 *
 * int i = 2; while (n > 1) { NOTPRIME: for (; i < n; i += 2) { if (n % i == 0)
 * { continue NOTPRIME; } else { prod *= i; sum += i; n /= i; } }
 *
 * }
 * if(prod == sum) { System.out.println(n + "é perfeito"); }
 */
