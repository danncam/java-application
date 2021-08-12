package Workaround;

import java.util.ArrayList;
import java.util.List;



/**
 *
 * simple naive algorithm to return prime numbers
 * wikibooks.org
 */
public class PrimesGen {

// finds all prime numbers up to max
    public static List<Integer> generatePrimes(int max) {
        List<Integer> primes = new ArrayList<Integer>();

        // start from 2
        OUTERLOOP:
        for (int i = 2; i <= max; i++) {
            // try to divide it by all known primes
            for (Integer p : primes) {
                if (i % p == 0) {
                    continue OUTERLOOP; // i is not prime
                }
            }
            // i is prime
            primes.add(i);
        }
        return primes;
    }

}
