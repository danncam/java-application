package Computador;

import java.io.InputStream;
import java.util.Scanner;

public class InputDevice {
    private Scanner scan;
    private InputStream is;

    public InputDevice(InputStream ist) {
        this.is = ist;
        scan = new Scanner(is);
    }
    
    public int readInt()
    {
        return scan.nextInt();
    }
}
