package Interfaces;

public class Automobile implements Comparable{
private String marca;
private float maxVel;

    public Automobile(String marca, float maxVel) {
        this.marca = marca;
        this.maxVel = maxVel;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setMaxVel(float maxVel) {
        this.maxVel = maxVel;
    }

    public String getMarca() {
        return marca;
    }

    public float getMaxVel() {
        return maxVel;
    }
    
    
    @Override
    public int compareTo(Comparable c) {
        Automobile a = (Automobile) c;

        if (((int) a.maxVel == this.maxVel) /*&& (this.marca.compareTo(a.marca)) == 0*/) {
            return 0;
        } else if (a.maxVel > this.maxVel) {
            return -1;
        } else {
            return 1;

        }
    }
    

    @Override
    public void print() {
        System.out.println("Marca: " + getMarca() + "\nVelocidade máxima: " + getMaxVel());
    }

    @Override
    public boolean isEqual(Comparable c) {
        Automobile a = (Automobile) c;
        return (((int) a.maxVel == this.maxVel) && (this.marca.compareTo(a.marca)) == 0);
    }
    
}
