package Repetition;

/**
 *
 * Calcule o valor de π	através da serie infinita 
 * π = 4 - 4 + 4 - 4 + 4 ... 
 *         3   5   7   11
 *
 * Imprima uma tabela que mostre o valor aproximado de π computando usando um
 * termo dessa série, dois termos, três termos e a sim por diante. Quantos
 * termos de série você tem que utilizar para que a aproximação obtida tenha
 * precisão de duas casas decimais? E precisão de três casas decimais? Quatro
 * casas? Cinco casas?
 *
 */
public class Pi {

    public static void main(String[] args) {
        int max = 5;
        double pi = 0;
        for (int i = 0; i < max; i++) {
            for (int j = 0; j < 12; j++) {
                if(isPrime(j))
                pi += i % 2 == 0 ? 4/j : -4/j;
                
            }        
        }
        System.out.println(pi);
    }
    
    /*
     *  Propositalmente retorna 1 como sendo primo.
     */

    public static boolean isPrime(int n) {
        if (n > 0) 
        {
            for (int i = 2; i < n; i += 2) 
            {
                if (n % i == 0) 
                {
                    return false;
                }

            }
        }
        else 
        {
            return false;
        }
        return true;
    }
}
