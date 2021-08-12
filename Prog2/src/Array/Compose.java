package Array;

public class Compose {

    public static void main(String[] args) {
        long[] arr = {9, 9, 9};
        System.out.println(fatores(arr));


    }

    private static String fatores(long n) {
        String fatores = "";
        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                fatores += i + " * ";
                n /= i;
            }
        }

        //remover o " * " do final.
        return fatores.substring(0, fatores.length() - 3);
    }

    public static String fatores(long[] compose) {
        String fatores = "";
        for (int i = 0; i < compose.length; i++) {
            fatores += fatores(compose[i]) + (i == compose.length - 1 ? "" : " * ");
        }

        return fatores;
    }
}
