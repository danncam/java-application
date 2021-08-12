package Recursion;

/**
 *
 * Lista 5 - Recursividade: ex. 1
 */
public class SumArray {
    public static float sumArray(float [] arr)
    {
        return sumArray(arr, 0);
    }
    private static float sumArray (float [] arr, int count)
    {
        if (count == arr.length) {
            return arr[arr.length - 1];
        }
        else {
            return arr[count] + sumArray(arr, count + 1);
        }
    }
}
