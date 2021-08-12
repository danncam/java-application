package Backtracking;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

/**
 *
 * Backtracking - Extra
 */
public class AirLines {

    
    private static int nAirLines;
    private static String[] nameList;
    private static int[][] qPartners;
    private static int[][] consulta;

    public static void main(String[] args) {
        FileReader file;
        BufferedReader reader;
        try {
            
            JFileChooser fchooser = new JFileChooser("C:\\Users\\Dan\\Google Drive\\NetBeansProjects\\Prog2\\Files");
            int result = fchooser.showOpenDialog(null);
            if(result == JFileChooser.CANCEL_OPTION)
            {
                System.out.println("Arquivo não selecionado");
                System.exit(0);
            } 
            
            file = new FileReader(fchooser.getSelectedFile().getPath());
            reader = new BufferedReader(file);
            
                nAirLines = Integer.parseInt(reader.readLine());
                nameList = new String[nAirLines];
                qPartners = new int[nAirLines][6];
                
                /* Define o array de nomes das companhias */
                for(int i = 0; i < nAirLines; i++)
                {
                    nameList[i] = reader.readLine();
                }
                
                /* Define o array bidimensional de quantidades de parceiros de cada companhia */
                
                for(int m = 0; m < nAirLines; m++){
                    qPartners[m] = new int[reader.read()];
                    for(int n = 0; n < nAirLines; n++){
                        qPartners[m][n] = reader.read() -1;
                    }
                }
                consulta = new int[nAirLines][2];
                for(int i = 0; i < consulta.length; i++){
//                    consulta[i][0] = 
                }
                file.close();
            


        } catch (FileNotFoundException ex) {
            Logger.getLogger(AirLines.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AirLines.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
