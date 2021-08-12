package introduction;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dan
 */
public class Introduction {

    public static void main(String[] args) {
        String chars = "|/―\\";
        int idx = 0;
        for (int i = 0; i < 100; i++) {

                System.out.print(chars.charAt(idx));

                idx = ++idx % chars.length();
                

        }
        System.out.print("\b \bX");
    }
}
