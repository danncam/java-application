package Files;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProgramProcessor {
    final private char space = ' ';
    final private char ch = 'i';
    final private int num = 'n';
    
    private boolean isComm;
    
    FileReader fr;
    BufferedReader br;
    
        public void ProgramProcessor(File jfile)
        {
            
        try 
        {
            
            
            fr = new FileReader(jfile);
            br = new BufferedReader(fr);
            String inp, outp;
            
                while(br.ready())
                {
                    inp = br.readLine();
                    System.out.println(inp);
                    outp = processLine(inp);
                    System.out.println(outp);
                    
                }
            
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ProgramProcessor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
                Logger.getLogger(ProgramProcessor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        public String processLine(String l)
        {
            int countSpace;
            String processing = null;
            String processedLine = null;
            
            
            for (int i = 0; i < l.length(); i++) 
            {
                
                
                
                for (int j = 0; j < processing.length(); j++) 
                {
                    
                    
                }
                
            }
            
            
            return null;
            
        }
        public boolean isLetter(char c)
        {
            return Character.toUpperCase(c) >= 'A' && Character.toUpperCase(c) <= 'Z';
        }
        public boolean isNumber(char c)
        {
             return (c >= '0' && c <= '9');
        }
        public boolean isComment(String comm)
        {
            return false;
        }
}
