package Workaround;

/**
 *
 * E.44, pg.78 Introdução à Ciencia da computação com jogos
 * 
 * Aproximação no numero e (base dos logaritmos naturais)
 * 
 */
public class LogConst {
    public static void main(String[] args) {
        
        System.out.println(e(11));
        
    }
    static double e(int p)
    {
        int n = 0;
        long fat;
        double sum = 0;
        while(n <= p)
        {
            fat = fat(n);
            sum += 1/fat;
            n++;
        }
        return sum;
    }

    static long fat(int n)
    {
        if(n == 0 || n == 1)
            return 1;
         else
            return n * fat(--n);
        
    }
    
}
