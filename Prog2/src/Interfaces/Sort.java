package Interfaces;
public class Sort {
    public static void Selection(Comparable[] c)
    
    {
        int index;
        for (int i = 0; i < c.length - 1; i++)
        {
            index = i;
            for (int j = i + 1; j < c.length - 1; j++)
            {
                if (c[j].compareTo(c[index]) > 0)
                    index = j;
                
                
            }
            if(index != i)
            {
                swap(c[i], c[index]);
            }
        }
    }
    public static void bubble(Comparable[] c)
    {
        for (int i = 0; i < c.length; i++)
        {
            for (int j = i + 1; j < c.length - 1; j++) 
            {
                if(c[j].compareTo(c[i]) < 0)
                    swap(c[i], c[j]);
            }
            
        }
    }
    public static void insertion(Comparable[] c)
    {
        for (int i = 0; i < c.length; i++) 
        {
            Comparable comparable = c[i];
            int j;
            for (j = i - 1; j >= 0 && c[j].compareTo(comparable) > 0; j++) {
                c[j + 1] = c[j];
                c[j] = comparable;
            }
            
        }
    }
    private static void swap(Comparable a, Comparable b){
        Comparable c;
        c = a;
        a = b;
        b = c;
    }
}
