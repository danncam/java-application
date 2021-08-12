package Recursion;
/**
 * Lista 5 - Recursividade: ex. 3
 */
public class InvertArray {
    public static int[] invert (int[] input, int[] output , int c)
    {
        if(c == input.length + 1/2)
        {
            return output;
        }
        else
        {
            output[c] = input[input.length - c - 1];
            output[input.length-c-1] = input[c];
            
            return invert(input, output, ++c);
        }
    }
}
