package Files;

import java.io.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Student {

    private String matricula, nome, nota;
    private String input;

    public void readAluno() 
    {
        FileReader reader;
        try 
        {
            Scanner scan = new Scanner(input);
            reader = new FileReader("");
            BufferedReader bufr = new BufferedReader(reader);
            input = bufr.readLine();
            matricula = scan.next();
            nome = scan.next();
            nota = scan.next();

        } catch (FileNotFoundException ex) 
        {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) 
        {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }

    
    }
    public void writeAluno() 
    {
        FileWriter writer;
        BufferedWriter bufw;
    }

    @Override
    public String toString() {
        return "Student{" + "matricula=" + matricula + ", nome=" + nome + ", nota=" + nota + '}';
    }
}
