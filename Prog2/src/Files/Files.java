package files;

import java.io.File;

public class Files {
    public static void main(String[] args) {
        Process encryptfile = new Process(new File("Files/newfile.txt"), 1);
        encryptfile.encrypt();
        encryptfile.showFile();

    }
}
