package Backtracking;
public class backtracking {
    void backtrack (boolean [] a, int k, int [] in)
    {
        if (k == a.length)
        {
            
            processSolution (a, k, in);
        }
        else
        {
            k++;
            boolean[] c = constructCandidates(a, k, in);
            for (int i = 0; i < c.length; i++) {
                a[k] = c[i];
                backtrack(a, k, in);
                
            }
        }
    }

    private void processSolution(boolean[] a, int k, int[] in) {
        String out = null;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == true){
                out += (char) in[i];
            }
            
        }
        System.out.println(out);
    }

    private boolean[] constructCandidates(boolean[] a, int k, int[] in) {
        boolean[] c = {true, false};
        return c;
    }
}
