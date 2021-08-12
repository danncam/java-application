package Arrays;

/**
 *
 * http://en.wikibooks.org/
 */
public class Determinant {

    public static double[][] reduce(double[][] x, double[][] y, int r, int c, int n) {
        for (int h = 0, j = 0; h < n; h++) {
            if (h == r) {
                continue;
            }
            for (int i = 0, k = 0; i < n; i++) {
                if (i == c) {
                    continue;
                }
                y[j][k] = x[h][i];
                k++;
            } //end inner loop
            j++;
        } //end outer loop
        return y;
    } //end method
    
    public static double det(int NMAX, double[][] x) {
        double ret = 0;
        if (NMAX < 4)//base case
        {
            double prod1 = 1, prod2 = 1;
            for (int i = 0; i < NMAX; i++) {
                prod1 = 1;
                prod2 = 1;

                for (int j = 0; j < NMAX; j++) {
                    prod1 *= x[(j + i + 1) % NMAX][j];
                    prod2 *= x[(j + i + 1) % NMAX][NMAX - j - 1];
                } //end inner loop
                ret += prod1 - prod2;
            } //end outer loop
            return ret * - 1;
        } //end base case
        double[][] y = new double[NMAX - 1][NMAX - 1];
        for (int h = 0; h < NMAX; h++) {
            if (x[h][0] == 0) {
                continue;
            }
            reduce(x, y, h, 0, NMAX);
            if (x[h][0] % 2 == 0) {
                ret += det(NMAX - 1, y) * x[h][0];
            }
            if (x[h][0] % 2 == 1) {
                ret -= det(NMAX - 1, y) * x[h][0];
            }
        } //end loop
        return ret;
    } //end method
}
