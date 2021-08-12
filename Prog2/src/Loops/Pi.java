package Loops;

import java.util.Scanner;

public class Pi {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Precision: Type 1, 2, 3, 4 or 5 to decimal places (-1 for print infinitely)");
        int precision = in.nextInt();
        double pi;
        switch(precision){
            case 1:
                pi = calcPi(28);
                break;
            case 2:
                pi = calcPi(628);
                break;
            case 3:
                pi = calcPi(2455);
                break;
            case 4:
                pi = calcPi(136121);
                break;
            case 5:
                pi = calcPi(376850);
                break;
            case 6:
                pi = calcPi(2886751);
                break;
            default:
                if(precision == -1) {
                    System.out.println("Printing infinitely");
                    pi = calcPi(-1);
                }
                
        }
        
        
        
    }

    private static double calcPi(final int step) {
        double pi = 0d;
        double divideTo;
        
        double step0 = 1d;
        
        while(step >= step0 || step == -1)
        {
            divideTo = 2d * step0 - 1d;
            if(step0 % 2 != 0) {
                pi += 4 / divideTo;
            }
            else {
                pi -= 4 / divideTo;
            }
            step0++;
            System.out.println((int) step0 + ": " + pi);
        }
        
        return pi;
        
    }
}
