package Recursion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Labyrinth {
    
    private static FileInputStream fis;
    private static InputStreamReader isr;
    private static BufferedReader reader;
    private static int max;
    public static void main(String [] args)
    {
        File input;
        input = new File("Files/maze1.txt");
        try {
            fis = new FileInputStream(input);
            isr = new InputStreamReader(fis);
            reader = new BufferedReader(isr);
            
            max = Integer.parseInt(reader.readLine());
            
            readMaze(max, input);
            reader.close();
            
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Labyrinth.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                    Logger.getLogger(Labyrinth.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
         
        
    }
    private static void readMaze(int max, File file){
        
    }
    private static int[] nextStep(int lastRowPosition, int lastColumnPositon, File file){
        /**
         * RIGHT a[0][1]
         * DOWN  a[2][3]
         * LEFT  a[4][5]
         * UP    a[6][7]
         */
        int [] a = {lastRowPosition, lastColumnPositon+1, lastRowPosition+1, lastColumnPositon, lastRowPosition, lastColumnPositon-1, lastRowPosition-1, lastColumnPositon};
        
        return a;
    }
    private static boolean isSolution(int nextRow, int nextColumn)
    {
        if ((nextRow >= 0 && nextRow <= max) && (nextColumn >= 0 && nextColumn <= max))
                {
                    
                }
        return false;
    }
}
