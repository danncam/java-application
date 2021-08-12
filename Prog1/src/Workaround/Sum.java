package Workaround;

/**
 *
 * @author dan
 */
public class Sum {

    public static int naiveSolution(int i, int n) {
        int sum = 0;
        for (; i <= n; i++) {
            sum += i;

        }
        return sum;
    }

    public static int closedSolution(int i, int n) {
        return (n - i + 1) * (n + i) / 2;
    }

    /**
     * http://www.dreamincode.net/
     */
    public static int recursiveSolution(int i, int n) {
        if (i == n) {
            return n;
        } else {
            return i + recursiveSolution((i + 1), n);
        }
    }
}
