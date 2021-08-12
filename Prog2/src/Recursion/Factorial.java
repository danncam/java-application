package Recursion;
public class Factorial {
    /*
     * Exemplo de recursão de calda com fatorial
     */
    
    public static int fact(int n)
    {
        if(n <= 1)
            return 1;
        else return fact(n, 1);
    }
    private static int fact(int current, int a)
    {
        if(current <= 1)
            return a;
        else return fact(current -1, a * current);
    }
    
    
}
