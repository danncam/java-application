package Files;

import java.io.*;

public class Test {

    public static void main(String[] args) {
        File f = new File("Files/test.txt");
            Crypt cryptfile = new Crypt(f);
            cryptfile.encrypt(2);
            cryptfile.show();
//        try {
//            FileOutputStream outp = new FileOutputStream(f);
//            outp.write('d'+2);
//            outp.close();
//        } 
//            catch (IOException ex) {
//                Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
//        }

    }
}
