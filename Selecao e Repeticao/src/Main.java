
import java.util.Scanner;

/**
 * Gabarito da lista de exercícios de Programação de Computadores II
 * @author Diego
 */
public class Main {

    // Deitel - Java - Como Programar - 6a Edição - página 124 - Exercício 4.29 
    // Escreva um aplicativo que solicite ao usuário inserir o tamanho do lado de um quadrado e então exiba um quadrado vazio desse tamanho com
    // asteriscos. Seu programa deve trabalhar com quadrados de todos os comprimentos de lado possíveis entre 1 e 20. Caso o usuário escolha um 
    // tamanho inválido, uma mensagem de erro deve ser exibida.
    private static void Exercicio_4_29() {
        Scanner input = new Scanner(System.in);

        int tamanho = input.nextInt();

        if (tamanho < 1 || tamanho > 20) {
            System.out.println("Erro: tamanho inválido.");
        } else {
            for (int i = 0; i < tamanho; i++) {
                for (int j = 0; j < tamanho; j++) {
                    if (i == 0 || j == 0 || i == tamanho - 1 || j == tamanho - 1) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                }

                System.out.println();
            }
        }
    }

    // Deitel - Java - Como Programar - 6a Edição - página 124 - Exercício 4.31 
    // Escreva um aplicativo que aceita como entrada um inteiro contendo somente 0s e 1s (isto é, um inteiro binário) e imprime seu equivalente
    // decimal. Caso o usuário digite um número com digitos diferentes de 0s e 1s, uma mensagem de erro deve ser exibida.
    // Dica: Utilize os operadores de resto e divisão para pegar os dígitos do número binário um decada vez, da direita para a esquerda. No sistema de
    // números decimais, o dígito mais à direita tem um valor posicional de 1 e o próximo dígito à esquerda tem um valor posicional de 10, depois 100, depois
    // 1.000 e assim por diante. O número decimal 234 pode ser interpretado como 4 * 1 + 3 * 10 + 2 * 100. No sistema de números binários, o dígito mais à
    // direita tem um valor posicional de 1, o próximo dígito à esquerda tem um valor posicional de 2, depois 4, depois 8 e assim por diante. O equivalente
    // decimal do binário 1101 é 1 * 1 + 0 * 2 + 1 * 4 + 1 * 8, ou 1 + 0 + 4 + 8 ou, 13.
    private static void Exercicio_4_31() {
        Scanner input = new Scanner(System.in);

        int numeroEntrada = input.nextInt();
        int numeroSaida = 0;
        int contDigito = 0;
        boolean digitoInvalido = false;

        while (numeroEntrada > 0) {
            int digito = numeroEntrada % 10;

            if (digito != 0 && digito != 1) {
                digitoInvalido = true;
                break;
            }

            numeroSaida += digito * Math.pow(2, contDigito);
            numeroEntrada = numeroEntrada / 10;
            contDigito++;
        }

        if (digitoInvalido) {
            System.out.println("Erro: há um digito inválido no número binário.");
        } else {
            System.out.println("Número decimal: " + numeroSaida);
        }
    }

    // Deitel - Java - Como Programar - 6a Edição - página 162 - Exercício 5.20 
    // Calcule o valor de PI das series infinitas
    // PI = 4 - (4/3) + (4/5) - (4/7) + (4/9) - (4/11) ...
    // Imprima uma tabela que mostre o valor aproximado de PI computando um termo dessa série, por dois termos, por três termos e a sim por diante. 
    // Quantos termos de sa série você tem de utilizar antes de primeiro obter 3,14? 3,141? 3,1415? 3,14159?
    private static void Exercicio_5_20() {
        Scanner input = new Scanner(System.in);

        int maxTermos = input.nextInt();
        int termos = 1;

        while (termos < maxTermos) {
            float denominador = 1.0f;
            float pi = 0;

            for (int i = 1; i <= termos; i++) {
                pi += Math.pow(-1.0f, i - 1) * (4.0f / denominador);
                denominador += 2.0f;
            }

            System.out.println("Termos: " + termos + " PI: " + pi);

            termos++;
        }
    }

    // Referência: http://www.ime.usp.br/~leo/imatica/historia/nperfeitos.html
    // Escreva um aplicativo que aceita como entrada um inteiro positivo e determine se este  é um número perfeito. 
    // Um número se diz perfeito se é igual à soma de seus divisores próprios. Divisores próprios de um número positivo N são todos os divisores inteiros positivos de N exceto o próprio N.
    // Por exemplo, o número 6, seus divisores próprios são 1, 2 e 3, cuja soma é igual à 6, ou seja, 1 + 2 + 3 = 6.
    private static void Exercicio_NumerosPerfeitos() {
        Scanner input = new Scanner(System.in);

        int numero = input.nextInt();
        int soma = 0;

        for (int i = 1; i < numero; i++) {
            if (numero % i == 0) // número e divível por i
            {
                soma += i;
            }
        }

        if (soma == numero) {
            System.out.println("O número " + numero + " é perfeito.");
        } else {
            System.out.println("O número " + numero + " não é perfeito.");
        }
    }

    // Escreva um aplicativo de calculadora que receba um valor em ponto flutuante, um operador e a seguir mais um valor em ponto flutuante. 
    // Utilize o comando switch para realizar a conta para as operações de soma, subtração, multiplicação e divisão e exiba o resultado.
    private static void Exercicio_Calculadora() {
        Scanner input = new Scanner(System.in);
        Scanner stringInput = new Scanner(System.in);

        System.out.print("Operando1: ");
        float operando1 = input.nextFloat();

        System.out.print("Operador: ");
        String strOperador = stringInput.nextLine();
        char operador = strOperador.charAt(0);

        System.out.print("Operando2: ");
        float operando2 = input.nextFloat();

        float resultado = 0;

        switch (operador) {
            case '+':
                resultado = operando1 + operando2;
                break;
            case '-':
                resultado = operando1 - operando2;
                break;
            case '*':
                resultado = operando1 * operando2;
                break;
            case '/':
                if(operando2 == 0)
                {
                    System.out.println("Erro: Divisão por zero.");
                    return;
                }
                
                resultado = operando1 / operando2;
                break;                
            default:
                System.out.println("Erro: Operador inválido.");
                return;
        }
        
        System.out.println("Resultado: " + resultado);
    }

    public static void main(String[] args) {
        //Exercicio_4_29();
        //Exercicio_4_31();
        //Exercicio_5_20();
        //Exercicio_NumerosPerfeitos();
        Exercicio_Calculadora();
    }
}
