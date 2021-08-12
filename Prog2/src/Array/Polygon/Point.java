package Array.Polygon;
class Point {
    public float x, y;
    
    /**
     * Calcular a distância entre 2 pontos (Point)
     * 
     */
    public static float dist2p(Point p1, Point p2)
    {
        
        return (float) Math.sqrt((Math.pow(p1.x - p2.x, 2)) + (Math.pow(p1.y - p2.y, 2)));
        
    }
    
}
