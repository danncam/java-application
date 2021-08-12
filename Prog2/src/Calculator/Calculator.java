package Calculator;

public class Calculator {

    public static void main(String[] args) {
        if (args[0] == null) {
            System.out.println("Syntax error. use \"java Calculator h\" for help");
        } else {

            Operation calc;
            if (args[2] == null) {
                calc = new Operation(Integer.parseInt(args[0]), args[1].charAt(1));
                calc.printAnswer();
            } else {
                calc = new Operation(Integer.parseInt(args[0]), Integer.parseInt(args[1]), args[2].charAt(2));
                calc.printAnswer();
            }
        }
    }
}
