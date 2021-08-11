import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

class CSVFileReader {
    /**
     * This class opens a textfile separed with commas and put the number content in a bidimensional array
     */
    private static FileReader fileReader;
    private static Scanner in;
    final static String DELIM = ";";


    public CSVFileReader(String csvFilePath) {
        try {
            fileReader = new FileReader(csvFilePath);
            in = new Scanner(fileReader);
            in.useDelimiter(DELIM);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            in.close();
        }
        
    }

    public void show(){
        while (in.hasNext()){
            System.out.println(in.nextLine());
        }
        
    }
}