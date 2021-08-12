package recursion;

/**
 *
 * @author Dan
 */
public class MaxElement {
    public static int maxInteger(int[] array)
    {
        return maxInteger_Aux(array, array[0], 0, array.length);
    }
    private static int maxInteger_Aux(int[] array, int output, int initialIndex, int finalIndex)
    {
        if(initialIndex == finalIndex)
        {
            return output;
        } else {
            if (array[initialIndex] >= output) {
                output = array[initialIndex];
            }
            return maxInteger_Aux(array, output, ++initialIndex, finalIndex);
        }
        
    }
}
