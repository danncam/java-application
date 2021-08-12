package Workarround;

import java.util.Scanner;

public class Calculadora implements Aplicativo {

    private double a, b;
    private char op;
    private static Scanner in;

    private double som() {
        return a + b;
    }

    private double prod() {
        return a * b;
    }

    private double quoc() {
        return a / b;
    }

    private double sub() {
        if (b != 0) {
            return a - b;
        } else {
            System.out.println("A divisão por zero não é definida");
            return -1;
        }
    }

    @Override
    public void carregaInfo() {
        in = new Scanner(System.in);
        System.out.print("Digite o número, seguido da operação (+, -, *, /) e outro número");
        a = in.nextDouble();
        op = (char) in.nextInt();
        b = in.nextDouble();
        
        
    }

    @Override
    public void imprimeInfo() {
        System.out.println("a: " + a + "\nop: " + op + "\nb: " + b);
    }

    @Override
    public void executa() {
        
        switch(op){
            case '+': System.out.println("a + b = " + som()); break;
            case '-': System.out.println("a - b = " + sub()); break;
            case '*': System.out.println("a * b = " + prod()); break;
            case '/': System.out.println("a / b = " + quoc()); break;
        }
    }
}
