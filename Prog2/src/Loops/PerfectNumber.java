package Loops;

/**
 *
 * @author Dan
 */
public class PerfectNumber {

    public static void main(String[] args){
//        int isPerfectNumber = 6;
//        System.out.println(isPerfectNumber(isPerfectNumber));
        
        System.out.println(getPrimeFactorsProduct(9));

    }
    private static boolean isPerfectNumber(int n)
    {
        int prod, sum;
        prod = getPrimeFactorsProduct(n);
        sum = getPrimeFactorsSum(n);
        return prod == sum;
        
        
    }
    private static boolean isComposite(int n)
    {
        if(n > 1){
            for (int i = 2; i < n; i++)
            {
                if(n % i == 0)
                {
                    return true;
                
                } else {
                    return false;
                } 
            }
        }
        return false;
    }

    private static int getPrimeFactorsProduct(int n) {
        int prod = 1;
        for(int i = 1; i < n; i++)
        {
            if(!isComposite(i) && n % i == 0 && prod <= n) {
                System.out.println(":"+i);
                prod *= i;
            }
        }
        System.out.println(prod);
        return prod;
    }

    private static int getPrimeFactorsSum(int n) {
        int sum = 0;
        for(int i = 1; i < n; i++)
        {
            if((!isComposite(i) && n % i == 0) && sum <= n) {
                
                sum += i;
            }
        }
        System.out.println(sum);
        return sum;
    }
}
