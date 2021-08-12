package Recursion;

/**
 *
 * Lista 5 - Recursividade: ex. 4
 */
public class TernarySearch {
    public static void main(String[] args) {
        int[] arr = new int[12];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (i+1)*2;
        }
        for (int i : arr) {
            System.out.print(i + "\t");
        }
        System.out.println("\n" + binSearch(arr, 0, 1, 12));
    }
    public static int binSearch(int[] a, int e, int begin, int end)
    {
        if(begin < end)
        {
            if(a[(begin + end)/2] == e)
            {
                return (begin + end)/2;
            }
            else
            {
                if(a[(begin + end)/2] > e)
                {
                    end = ((begin + end)/2) -1;
                    return binSearch(a, e, begin, end);
                }
                else
                {
                    begin = ((begin + end)/2) +1;
                    return binSearch(a, e, begin, end);
                }
            }
        } else {
            return -1;
        }
        
    }
}
