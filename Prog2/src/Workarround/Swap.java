package Workarround;

/**
 *
 * @author dan
 */
public class Swap {
    /* Swapping values between two variables without using a third variable */

    public static void swap(int var1, int var2) {
        var1 = var1 + var2;
        var2 = var1 - var2;
        var1 = var1 - var2;
    }

    public static void swap(String str1, String str2) {
        str1 = str1 + str2;
        str2 = str1.substring(0, (str1.length() - str2.length()));
        str1 = str1.substring(str2.length(), (str1.length()));

    }
}
