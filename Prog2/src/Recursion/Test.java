package Recursion;
public class Test {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(
        BinarySearch.binSearch(arr, 0));

        
    }
    public static float sumarray (float [] arr, int count)
    {
        if (count == arr.length - 1)
            return arr[count];
        else
            return arr[count] + sumarray(arr, count++);
    }
}
