package Interfaces;

public class Cars {

    private Automobile[] arr;
    private int maxAutom, numAutom;

    public Cars(int maxAutom, int numAutom) {

        arr = new Automobile[maxAutom];
        this.maxAutom = maxAutom;
        this.numAutom = numAutom;

    }

    public void insAut(Automobile a) {
        if (numAutom > maxAutom) {
            System.out.println("Array Cheio");
        } else {
            arr[numAutom] = a;
            numAutom++;
            System.out.println("Inserção bem sucedida");
        }
    }

    public void remAut(Automobile a) {
        if (numAutom == 0) {
            System.out.println("Array vazio");
        }
            else
        for (int i = 0; i < numAutom; i++) {
                if (a.isEqual(this.arr[i])) {
                    this.arr[i] = this.arr[numAutom];
                    numAutom--;
                    System.out.println("Remoção bem sucedida");
                }
            }
        }

    public void print() {
        for (int i = 0; i < numAutom; i++) {
            System.out.println(i + "\n");
            arr[i].print();

        }
    }
}
