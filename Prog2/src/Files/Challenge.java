package Files;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

public class Challenge {

    public static void main(String[] args) {

        File newfile = new File("Files/newfile.txt");
        Scanner input = null;
        try {
            input = new Scanner(newfile);

        } catch (FileNotFoundException ex) {
            JFileChooser fc = new JFileChooser(newfile);
            fc.accept(newfile);
            Logger.getLogger(Challenge.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            int n = input.nextInt();
            String str1 = input.nextLine();
            String str2 = input.nextLine();

            System.out.println(n);
            System.out.println(str1);
            System.out.println(str2);
        }


    }
}
