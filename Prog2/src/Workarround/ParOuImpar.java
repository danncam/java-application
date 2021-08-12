package Workarround;

import java.util.Scanner;

public class ParOuImpar implements Aplicativo {

    private String escolha;
    private boolean ganhou;
    private int n_user, n_comp;
    private Scanner in;

    @Override
    public void carregaInfo() {
        in = new Scanner(System.in);
        System.out.println("Par ou ímpar?");
        escolha = in.next();
        n_comp = (int) (Math.random() * 10);
        System.out.println("Um dolaci e vamos já!!!");

        n_user = in.nextInt();
    }

    @Override
    public void imprimeInfo() {
        
        if(escolha.equals("par")){
            System.out.println("Você é par");
        }
        if(escolha.equals("impar")) {
            System.out.println("Você é impar");
        }
        
        System.out.println("Seu numero é " + n_user + "e o do computador é " + n_comp + "\n" + n_user + "+" + n_comp + " é igual à " + (n_comp + n_user));
        
        
        if(ganhou){
            System.out.println("VOCE GANHOU!!");
        } else
            System.out.println("VOCE PERDEU :(");
    }

    @Override
    public void executa() {
        if (n_user > 0 && n_user < 11) {
            if (escolha.equals("par")) {
                if ((n_comp + n_user) % 2 == 0) {
                    ganhou = true;
                }
            }else if(escolha.equals("impar")){
                if((n_comp + n_user) % 2 != 0){
                    ganhou = true;
                }
            }
        }
        else System.out.println("oops!! voce só tem 10 dedos");
    }
}
