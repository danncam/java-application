package Recursion;

/**
 *
 * Lista 5 - Recursividade: ex. 2
 */
public class MaxIntegerInArray {
        public static int searchForMax (int [] a)
        {
            return searchForMax(a, 0, a[0]);
        }
        
        /**
         * a - array
         * i - counter
         * max - output
         */
        private static int searchForMax (int [] a, int i, int max)
        {
            if(i == a.length)
            {
                return max;
            }
            else 
            {
                if(a[i] > max)
                {
                    max = a[i];
                }
                return searchForMax(a, ++i, max);
            }
        }

}
