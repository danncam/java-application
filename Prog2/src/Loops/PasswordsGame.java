package Loops;

import java.util.Scanner;

/**
 *
 * @author Dan
 */
public class PasswordsGame {


    private static boolean[] arr;
    private static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        
        System.out.println("Welcome to Passwords Game, please set the max number.");

        int limit = getInput();
        int psswd = (int) (1 + Math.random() * limit);
        
        
        arr = new boolean[limit];
        int inputI;
        
        do
        {
            inputI = getInput();

            if(inputI == 0)
            {

                
                    System.out.println("The password was " + psswd);
                    System.exit(0);
            } 
                if(inputI <= limit && inputI >= 0)
                {
                    arr[inputI - 1] = true;
                    showArray();

                } else {
                    System.out.println("Out of range");

                }
                if(inputI == psswd)
                {
                    System.out.println("You Win!");
                }
             
        } while (inputI != psswd);
        
    }    
    
    private static void showArray()
    {
        for (int i = 1; i <= arr.length; i++) {
            if(arr[i - 1])
            {
                System.out.print("* ");
            } else {
                System.out.print(i + " ");
                
            }

        }
        System.out.print("\n");
    }
    
    private static int getInput() {
        return in.nextInt();
    }
}
