package files;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Process {
    private File inputfile, outputfile;
    private int k;
    
    private BufferedReader input;
    private BufferedWriter output;

    public Process(File inputfile, int cryptKey){
        this.inputfile = inputfile;
        this.k = cryptKey;

    }
    public void encrypt()
    {
        try {
        input = new BufferedReader(new FileReader(inputfile));
        outputfile = new File(inputfile.getPath().substring(0, inputfile.getPath().length()-4)+"_crypt.txt");
        output = new BufferedWriter(new FileWriter(outputfile));
        String line = "";
            while (input.readLine() != null)
            {
                char charAt;
                String in = input.readLine();
                System.out.println(in);
                for (int i = 0; i < in.length(); i++) {
                    System.out.println(input.readLine().charAt(i));
                    charAt = (char)(input.readLine().charAt(i) + k);
                    if(charAt >= 0 && charAt <= 255)
                    {
                        line +=charAt;
                    } else {

                        line += 255 - charAt; 
                    }
                }
                output.write(line);

            }
            input.close();
            output.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Process.class.getName()).log(Level.SEVERE, null, ex);
        }
         catch (IOException ex) {
            Logger.getLogger(Process.class.getName()).log(Level.SEVERE, null, ex);
         }

    }
    public void showFile()
    {
        try {
            input = new BufferedReader(new FileReader(outputfile));
            System.out.println("");
            while(input.readLine() != null)
            {
                    System.out.print(input.readLine());
                    input.close();
            }
            input.close();
        } catch (IOException ex) {
            Logger.getLogger(Process.class.getName()).log(Level.SEVERE, null, ex);
        }   
        finally
        {
            System.out.println("");
        }
        
    }
    public void countWords()
    {
        
    }
}
