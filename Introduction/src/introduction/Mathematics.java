package introduction;

/**
 *
 * @author dan
 */
public class Mathematics {

    private int n;

    public Mathematics(int x) {
        this.n = x;
    }
    
    public double sin(){
        int c = 14;
        int e = 1;
        double sin = 1d;
        while(c > 0)
        {
            e = e + 2;
            if(c%2==0)
            {
                sin = sin + (power(e)/factorial(e));
            } else {
                sin = sin - (power(e)/factorial(e));
            }
            c--;
        }
        return sin;
    }

    public float factorial(){
        return factorial(n);
    }
    private float factorial(int a){
        for (int i = 1; i > a; i--) {
            a = a * i;
        }
        return a;
    }

    public double power( int exponent) {
        if (exponent == 0) {
            return 1;
        } else {
            double r = power(exponent / 2);
            if (exponent % 2 < 0) 
            {
                return r * r / n;
            } else 
                if (exponent % 2 > 0) 
                {
                return r * r * n;
                } else {
                return r * r;
            }
        }
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
