package AdressBook;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Luiz
 */
public class Testar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            Scanner in = new Scanner(new File("Book.adbk"));
            String[] d;
            while (in.hasNextLine()) {
                d = in.nextLine().split(" ");
                for (int i = 0; i < d.length; i++) {
                    System.out.println(d[i]);
                }
                    System.out.println(d[0]);
                    System.out.println(d[1]);
                    System.out.println(d[2]);
                    System.out.println(d[3]);
                    System.out.println(d[4]);
                

                //                d= in.nextLine().split(" ");
                //                for (int i = 0; i < d.length; i++) {
                //                    System.out.println(d[i]);
                //
                //                }
                //
                //                System.out.println(d[0]);
                //                System.out.println(d[1]);
                //                System.out.println(d[2]);
                //                System.out.println(d[3]);
                //                System.out.println(d[4]);


            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Testar.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
