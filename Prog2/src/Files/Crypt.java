package Files;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * Arquivos: Lista 4. Ex 1
 */
public class Crypt {

    private File inputFile, outputFile;
    
    private int k, l;
    
    private FileInputStream fins;
    private FileOutputStream fouts;
    private BufferedInputStream bins;
    private BufferedOutputStream bouts;

    
    public Crypt(File file) {
        inputFile = file;
        outputFile = new File(inputFile.getPath().substring(0, inputFile.getPath().length()-4) +"_crypt.txt");
        
        try {
            fins = new FileInputStream(inputFile);
            fouts = new FileOutputStream(outputFile);
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Crypt.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void encrypt(int k){
        l = 255;
        try {
            
                while(fins.read() != -1)
                {
                    int n = fins.read();
                    if(n >= 0 && n <= l){
                        n = n + k;
                    } else {
                        n = l - n + k;
                    }
                    fouts.write((char) n);
                }
            } catch (IOException ex) {
            Logger.getLogger(Crypt.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
    public void descrypt(int k){
       try {
                fouts.write(fins.read() - k);
            
            } catch (IOException ex) {
            Logger.getLogger(Crypt.class.getName()).log(Level.SEVERE, null, ex);
            }
                
    }
    public void show(){
        if(outputFile.canRead()){
            try {
                fins = new FileInputStream(outputFile);
                while(fins.read() != -1){

                System.out.println(fins.read());
                
                }
            } catch (IOException ex) {
                Logger.getLogger(Crypt.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    
    
}
