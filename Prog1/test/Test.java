
import Sort.Bubble;
import Sort.Heap;
import Sort.Quick;
import java.util.regex.Pattern;

/**
 *
 * @author dan
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        /**
         * DESLOCAMENTO DE BITS
         * supondo x = 8;
         * 
         * -b = 1000 (antes)
         * x >> n;
         * x / 2 ^ n
         * -b = 1 (depois)
         * 
         * -b = 1000 (antes)
         * x << n;
         * x * 2 ^ n
         * -b = 1000000 (depois)
         * 
         *
         *
         */
        int x = 1024;
        int n = 1;
        x = x >> n;
        System.out.println(x);

        /**
         * HeapSort
         *
         */
        int[] B = {10, 8, 11, 13, 18, 19, 23, 1, 0, 14, 21, 17, 16, 22};
        Bubble.bubbleSort(B);
        for (int i = 0; i < B.length; i++) {
            System.out.print(B[i] + " ");

        }
        // searching for:
        int searchFor = 23;
        System.out.println(Workaround.BinarySearch.binarySearch(B, searchFor, 0, B.length - 1));
//        System.out.println("\n"+Workaround.BinarySearch.binarySearch(B, searchFor));
//        System.out.println(Workaround.PrimesGen.generatePrimes(500));




        int[] pr = new int[50];
        for (int e = 0; e < pr.length; e++) {

            o:
            for (int i = 2; i <= 100000; i++) {
                for (int j : pr) {
                    if (i % j == 0) {
                        continue o;
                    }
                }

                pr[e] = i;
            }
        }
        for (int i : pr) {
            System.out.println(i + "\t");
        }
    }
}
