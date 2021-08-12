package file;

import com.sun.org.apache.bcel.internal.generic.LNEG;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dan
 */
public class ASCII {
    private 
    FileReader rfile;
    FileWriter wfile;
    BufferedReader reader;
    BufferedWriter writer;
    File in, out;
    
    public ASCII() {
        try {
            in = new File("in.txt");
            out = new File("out.txt");
            in.createNewFile();
            out.createNewFile();
            rfile = new FileReader(in);
            reader = new BufferedReader(rfile);
            wfile = new FileWriter(out);
            writer = new BufferedWriter(wfile);
        } catch (IOException ex) {
            Logger.getLogger(ASCII.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void write()
    {
        try {
            String a = ""; int b = 0, h = 0; char c;
            for (int i = 0; i < 256; i++) {
                a += "INTEGER:\t" + b + "\t";
                c = (char) b;
                a += "CHARACTER:\t" + c + "\t";
                String he = Integer.toHexString(b);
                h = Integer.parseInt(he);
                a +=  "HEXADECIMAL\t" + h + " \n";
                b++;
                System.out.println(a);
            }
            wfile = new FileWriter(new File("out.txt"));
            writer = new BufferedWriter(wfile);
            writer.write(a);
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(ASCII.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public String toString() {
        String a = "";



        return a;
    }
            
            
}
