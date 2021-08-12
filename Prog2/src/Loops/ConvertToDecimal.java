package Loops;

import java.util.Scanner;


/**
 *
 * @author Dan
 */
public class ConvertToDecimal {
    private static Scanner in;
    public static void main(String[] args) throws InterruptedException {
        in = new Scanner(System.in);

        
        System.out.println("Type binary:");
        String binInput = getBinaryInput();
        
        System.out.println("Processing... wait a while :)");
        Thread.sleep(1000);
        System.out.println(convertToDecimal(binInput));
        
    }
    private static String getBinaryInput()
    {
        
        String input = "";
        boolean rightInput = false;
        while(!rightInput)
        {
            input = in.nextLine();
            for (int i = 0; i < input.length(); i++) {

               if(input.charAt(i) != '0' && input.charAt(i) != '1') 
               {
                     rightInput = false;
                     break;
               } else {
                     rightInput = true;
               }
            }
            
            if (!rightInput) {
                System.out.println("Wrong input! Try again only with 0 and 1");
            }
        }
        return input;
    }
    private static int convertToDecimal(String bin)
    {

        int output = 0;
        int exp;
        for (int i = 0; i <= bin.length() - 1; i++) {
            if(bin.charAt(i) == '1')
            {
                exp = bin.length() - 1 - i;
                output += Math.pow(2, exp);

            }
            
        }
        
        return output;
    }

    
}
