package OO;
public class Country {

    private String name, capital;
    private String[] borders;
    private float area;
    public Country(String name, String capital, float area) {
        
        
    }
    
    public boolean isEqual(final Country c){
        return this.name.equals(c.name) && this.capital.equals(c.capital);
    }
    
    public void redefineBorders(String[] newBorders){
        
        
    }
    
    public void printBorders() {
        for (String string : borders) {
            System.out.println(string + "\t");
        }
        
    }
    
    public float getArea() {
        return area;
    }

    public String[] getBorders() {
        return borders;
    }

    public String getCapital() {
        return capital;
    }

    public String getName() {
        return name;
    }
    
    
}
