import java.util.LinkedList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.NoSuchElementException;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;

public class Editor {

    /* Arquivo */
    private File file;
    private FileReader filereader;
    private BufferedReader bfr;
    private BufferedWriter bfw;

    /* Conteúdo */
    private Scanner in;
    private LinkedList<String> atribs;


    public Editor(String pathfile) {
        try {

            file = new File(pathfile);
            filereader = new FileReader(file);
            bfr = new BufferedReader(filereader);
            bfw = new BufferedWriter(new FileWriter(file));

            if(file.exists()) {
                System.out.println("Base de dados " + pathfile + " carregada com sucesso!\n");
                createAtribs();
            } else {
                throw new IOException() ;
            }

        } catch (IOException e){
            System.out.println("O Arquivo não existe. Deseja Criar um Novo? (0 ou 1)\n");
            in = new Scanner(System.in);
            int op = in.nextInt();
            in.nextLine();
            if(op == 1) {
                System.out.println("Digite o nome do arquivo.\n");
                pathfile = in.nextLine();
                createfile(pathfile);
            } else {
                System.out.println("Não foi possível carregar o arquivo. O programa será encerrado.");
            }

        }
        try {
           if(bfw != null) {
               bfr.close();
           }

        } catch (IOException e) {
            System.out.println("O Sistema será encerrado. \n");
            return;
        }

    }
    public void createfile(String pathname){
        file = new File(pathname);

        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeln() throws IOException {

        bfw = new BufferedWriter(new FileWriter(file));
        Scanner in = new Scanner(System.in);
        String content;

        try {

            content = in.nextLine();
            bfw.append(content + "\n");
        } catch (IOException e) {
            System.out.println("Arquivo não encontrado.");

        } finally {
                bfw.close();
        }

    }
    public void write(String content) throws IOException {

        bfw = new BufferedWriter(new FileWriter(file));
        Scanner in = new Scanner(System.in);

        try {

            content = in.nextLine();
            bfw.append(content);
        } catch (IOException e) {
            System.out.println("Arquivo não encontrado.");

        } catch (NoSuchElementException e) {
            return;
        }
        finally {
            bfw.close();
        }

    }

    public void createAtribs() throws IOException {
        atribs = new LinkedList<String>();
        String atrib;
        System.out.println("Adicionar novos atributos? (0 ou 1)\n");
        in = new Scanner(System.in);
        int op = in.nextInt();
        in.nextLine();
        if(op == 1) {
            atrib = in.nextLine();
            while  (((atrib.length() > 0) && ((atrib != null)))){
                atrib = in.nextLine();
                write(atrib);
                write(";");
            }
        } else {

        }

        Iterator<String> it = atribs.iterator();
    }
}
