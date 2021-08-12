package FilesAndDirectories;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class Files {
    public static void main(String[] args) throws FileNotFoundException, IOException{
        InputStream is = new FileInputStream("entrada.txt");
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        // br lê
        String linha = br.readLine();
        
        System.out.println(linha);
        OutputStream saida = new FileOutputStream("saida.txt");
        OutputStreamWriter write = new OutputStreamWriter(saida);
        BufferedWriter bw = new BufferedWriter(write);
        // bw escreve
        
        
        
        
    }


}
