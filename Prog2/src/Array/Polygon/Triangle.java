package Array.Polygon;

public class Triangle extends Polygon{
    
    
    public Triangle(Point[] p) {
        super(3, p);
    }

    @Override
    public float Area() {
        float a, b, c, semip;
        semip = semiPerimetro();
        a = Point.dist2p(p[0], p[1]);
        b = Point.dist2p(p[1], p[2]);
        c = Point.dist2p(p[2], p[0]);
        
        return (float) Math.sqrt(semip*(semip - a)*(semip - b)*(semip - c));
    }
    public float semiPerimetro()
    {
        
        return this.calculaPerimetro()/2;
    }
    
}
