package Taxonomy;
public class Chordata extends Animalia {

    @Override
    public void sleep() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void eat() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void move() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    @Override
    public String getDescription(){
        return super.getDescription() + "Filo Chordata\n";
    }
    
}
