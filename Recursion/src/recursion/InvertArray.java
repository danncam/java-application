package recursion;

/**
 *
 * @author dan
 */
public class InvertArray {
    public static int[] invert(int[] array, int index)
    {
        if (((array.length % 2 == 0) && (index == array.length - index)) ||
            ((array.length % 2 == 1) && (index == array.length - index - 1)))
        {
            return array;
        } else {
            int aux = array[index];
            array[index] = array[array.length - index - 1];
            array[array.length - index - 1] = aux;
            return invert(array, ++index);
        }
    }
    
}
