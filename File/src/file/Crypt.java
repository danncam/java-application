package file;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * Arquivos: Lista 4. Ex 1
 */
public class Crypt {

    private File inputFile, outputFile;
    
    private int k;
    private final int LIMIT = 255;
    
//    private FileInputStream fins;
//    private FileOutputStream fouts;
//    private BufferedInputStream bins;
//    private BufferedOutputStream bouts;
    private FileReader rfile;
    private FileWriter wfile;
    private BufferedReader reader;
    private BufferedWriter writer;
    
    public Crypt(File file, int offset) {
        inputFile = file;
        outputFile = new File(inputFile.getPath().substring(0, inputFile.getPath().length()-4) +"_crypt.txt");
        this.k = offset;
        try {
            rfile = new FileReader(inputFile);
            wfile = new FileWriter(outputFile);
            reader = new BufferedReader(rfile);
            writer = new BufferedWriter(wfile);
//            fins = new FileInputStream(inputFile);
//            fouts = new FileOutputStream(outputFile);
            
        } catch (IOException ex) {
            Logger.getLogger(Crypt.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void encrypt(){
        try {
            
//                while(fins.read() != -1)
//                {
//                    int n = fins.read();
//                    if(n >= 0 && n <= LIMIT){
//                        n = n + k;
//                    } else {
//                        n = LIMIT - n + k;
//                    }
//                    fouts.write((char) n);
//                }
//                fins.close();
//                fouts.close();
            int input, output = 0;
                do {
                    writer.newLine();
                    input = reader.read();
                    System.out.print((char) input);
                    char a = (char) input;
                        if(a >= 0 && a <= (char) LIMIT)
                        {
                            a = (char) (a + k);
                        } else {
                            a = (char) (LIMIT - a + k);
                        }
                        output += a;
                    
                    writer.write(output);
                } while(input != -1);
                reader.close();
                writer.close();
                rfile.close();
                wfile.close();
            } catch (IOException ex) {
                Logger.getLogger(Crypt.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
    public void decrypt(){
       try {
//            fouts.write(fins.read() - k);
//            fouts.close();
           rfile = new FileReader(outputFile);
           reader = new BufferedReader(rfile);
           wfile = new FileWriter(new File(inputFile.getPath().substring(0, inputFile.getPath().length()-4)+"_new.txt"));
           writer = new BufferedWriter(wfile);
           if(outputFile.exists())
           {
               String input, output = null;
               do{
                   input = reader.readLine();
                   for (int i = 0; i < input.length(); i++)
                   {
                       char a = input.charAt(i);
                       if(a + k >= 0 && a + k <= LIMIT)
                       {
                           a = (char) (a - k);
                       } else {
                           a = (char) (LIMIT - a - k);
                       }
                       output += Character.toString(a);
                   }
                   writer.write(output);
               } while(input != null);
            reader.close();
            writer.close();
            rfile.close();
            wfile.close();
           }
            } catch (IOException ex) {
            Logger.getLogger(Crypt.class.getName()).log(Level.SEVERE, null, ex);
            }
       
                
    }
//    public void show(){
//        if(outputFile.canRead()){
//            try {
//                fins = new FileInputStream(outputFile);
//                while(fins.read() != -1){
//
//                System.out.println(fins.read());
//                
//                
//                }
//                fins.close();
                
            
//            } catch (IOException ex) {
//                Logger.getLogger(Crypt.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
        
//    }
    
    
    
    
}
