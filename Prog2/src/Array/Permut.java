package Array;

import java.util.BitSet;
import java.util.Scanner;

public class Permut {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int input1 = in.nextInt();
        int input2 = in.nextInt();
        BitSet bit = new BitSet(input2);
        int size1, size2;
        size1 = getIntegerSize(input1);
        size2 = getIntegerSize(input2);
        
        int n1 = 0, n2 = 0;
        
        if(size1 == size2){
            
            while(n2 <= size2){

            }
            
        }
    }

    public static int getIntegerSize(int n) {
        return String.valueOf(n).trim().length();

    }
}
