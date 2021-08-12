package Backtracking;

/**
 *
 * Backtracking - Subconjuntos
 */
public class Subsets {
    
    private boolean finished;
    private boolean [] a;
    private int[] input;
    private int k;

    public Subsets(int[] input) 
    {
        a = new boolean[(int) Math.pow(2, input.length)];
        this.input = input;
        subsets();
    }
    
    private void subsets()
    {
        if(a.length == (k + 1))
        {
            processSolution();
            finished = true;
        } else
        {
            k++;
            boolean [] c = constructCandidates();
            for(int i = 0; i <= c.length; i++)
            {
                a[k] = c[i];
                subsets();
                
                if(finished)
                    return;
            }
        }
    }

    private void processSolution() 
    {
        System.out.print("{\t");
        for (int i = 0; i < a.length; i++) {
            if(a[i])
                System.out.print(i + "\t");
            
        }
        System.out.println("}");
    }

    private boolean[] constructCandidates() 
    {
        boolean[] c = {true, false};
        return c;
    }
}
