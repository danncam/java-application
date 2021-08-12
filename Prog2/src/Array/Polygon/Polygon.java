package Array.Polygon;

public abstract class Polygon {
    public int n;
    public Point[] p;
    

    public Polygon(int n, Point[] p) {
        this.n = n;
        this.p = p;
        
    }
    
    public abstract float Area();
    
    public float calculaPerimetro()
    {
        float sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Point.dist2p(p[i], p[i%n]);
                   
        }
        return sum;
    }
    
}
