package Recursion;

public class BinarySearch {

    public static int binSearch (int[] arr, int e){
        return binSearch(arr, e, 0, arr.length - 1);
    }
    private static int binSearch(int[] arr, int e, int beg, int end) {

            if (arr[(end + beg) / 2] == e) 
            {
                return (arr.length - 1) / 2;
            } 
            else 
            {
                
                if (e > (arr[end/2]))
                {
                    beg = ((end)/ 2) + 1;
                    return binSearch(arr, e, beg, end);

                } 
                if(e < (arr[end/2]))
                    
                {
                    end = ((end)/ 2) - 1;
                    return binSearch(arr, e, beg, end);
                }
            }
            return -1;
    }
}
