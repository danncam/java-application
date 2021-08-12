package Recursion;

public class QuickSort {

    public static void quickSort(int[] a, int first, int last) 
    {
        
        if (last > first) 
        {
            int j = partition(a, first, last);
            quickSort(a, first, j-1);
            quickSort(a, j+1, last);
        }
    }

    private static int partition(int[] a, int first, int last) 
    {
        int i, j, pivot;
        i = first;
        j = last + 1;
        pivot = a[first];

        return 0;
        
    }
}
