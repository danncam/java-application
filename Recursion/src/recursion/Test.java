package recursion;

/**
 *
 * @author Dan
 */
public class Test {
    public static void main(String[] args) {
        int[] a = {5, 3, 4};
        int[] m = InvertArray.invert(a, 0);

        
        for (int i = 0; i < m.length; i++) {
            System.out.print(m[i] + " ");
            
        }
    }
    public static void swap (int a, int b)
    {
        int aux = a;
        a = b;
        b = aux;
    }
}
