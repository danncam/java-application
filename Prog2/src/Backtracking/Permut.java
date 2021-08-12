package Backtracking;

public class Permut {

    private boolean finished;

    public Permut(int[] input) {
        int[] solution = new int[(int) Math.pow(input.length, 2)];
        permut(solution, 0, input);
    }
    


    private void permut(int[] a, int k, int[] input) {
        if (isSolution(a, k)) {
            processSolution(a, k);
        } else {
            k = k + 1;
            int[] c = constructCandidates(a, k, input);
            for (int i = 0; i < c.length; i++) {
                a[k] = c[i];
                permut(a, k, input);
                if (finished) {
                    return;
                }
            }
        }
    }

    private boolean isSolution(final int[] a, int k) {
        return ((k + 1) == a.length);
    }

    private void processSolution(final int[] a, int k) {
        System.out.print("{");
        for (int i = 0; i <= k; i++) {
            System.out.print(" " + a[i]);
        }
        System.out.println(" }");
    }

    private int[] constructCandidates(final int[] a, int k, int[] input) {
        boolean[] inPerm = new boolean[a.length];
        for (int i = 0; i < k; i++) {
            inPerm[a[i]] = true;
        }
        int n = 0;
        for (int i = 0; i < inPerm.length; i++) {
            if (!inPerm[i]) {
                n++;
            }
        }
        int[] c = new int[n];
        for (int i = 0, j = 0; i < inPerm.length; i++) {
            if (!inPerm[i]) {
                c[j++] = i;
            }
        }
        return c;
    }
    public static void main(String[] args){
        int[] a = {4, 2, 1, 6};
        Permut p = new Permut(a);
        
    }

}
