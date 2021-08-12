package Workaround;

/**
 *
 * @author dan
 */
import java.io.*;

public class Example implements Runnable {

    static Thread threadCalculate; // Cria o thread.
    static Thread threadListen;
    long totalPrimesFound = 0;

    public static void main(String[] args) {
        Example e = new Example();

        threadCalculate = new Thread(e);
        threadListen = new Thread(e);

        threadCalculate.start();
        threadListen.start();
    }

    public void run() {
        Thread currentThread = Thread.currentThread();

        if (currentThread == threadCalculate) {
            calculatePrimes();
        } else if (currentThread == threadListen) {
            listenForStop();
        }
    }

    public void calculatePrimes() {
        int n = 1;

        while (true) {
            n++;
            boolean isPrime = true;

            for (int i = 2; i < n; i++) {
                if ((n / i) * i == n) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                totalPrimesFound++;
                System.out.println(n);
            }
        }
    }

    private void listenForStop() {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = "";

        while (!line.equals("stop")) {
            try {
                line = input.readLine();
            } catch (IOException exception) {
            }
        }

        System.out.println("Found " + totalPrimesFound
                + " prime numbers before you said stop");
        System.exit(0);
    }
}
