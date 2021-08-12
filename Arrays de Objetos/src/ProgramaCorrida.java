
import java.util.Random;

public class ProgramaCorrida {

    int posicaoTartaruga;
    int posicaoLebre;
    Random random;
    char[] pista;

    public ProgramaCorrida() {
         random = new Random();
    }

    private void IniciaCorrida() {
        posicaoTartaruga = 1;
        posicaoLebre = 1;
        pista = new char[80];
        for (int i = 0; i < pista.length; i++) {
            pista[i] = ' ';
        }

        System.out.println("BANG !!!!!");
	System.out.println("A corrida começou !!!!!");
    }

    private void AtualizaTartaruga() {
        int i = random.nextInt(10) + 1;

        if(i >= 1 && i <= 5) { // caminhada rápida
            posicaoTartaruga = Math.min(70, posicaoTartaruga + 3);
        }
        else if(i >= 6 && i <= 7) { // escorregão
            posicaoTartaruga = Math.max(1, posicaoTartaruga - 6);
        }
        else if(i >= 8 && i <= 10) { // caminhada lenta
            posicaoTartaruga = Math.min(70, posicaoTartaruga + 1);
        }
    }

    private void AtualizaLebre() {
        int i = random.nextInt(10) + 1;

        if(i >= 1 && i <= 2) { // dormir

        }
        else if(i >= 3 && i <= 4) { // salto grande
            posicaoLebre = Math.min(70, posicaoLebre + 9);
        }
        else if(i == 5) { // escorregão grande
            posicaoLebre = Math.max(1, posicaoLebre - 12);
        }
        else if(i >= 6 && i <= 8) { // salto pequeno
            posicaoLebre = Math.min(70, posicaoLebre + 1);
        }
        else if(i >= 9 && i <= 10) { // escorregão pequeno
            posicaoLebre = Math.max(0, posicaoLebre - 2);
        }
    }

    private void LimpaPista() {
        if(posicaoTartaruga == posicaoLebre) {
            pista[posicaoTartaruga] = ' ';
            pista[posicaoTartaruga+1] = ' ';
            pista[posicaoTartaruga+2] = ' ';
            pista[posicaoTartaruga+3] = ' ';
            pista[posicaoTartaruga+4] = ' ';
            pista[posicaoTartaruga+5] = ' ';
        }
        else {
            pista[posicaoTartaruga] = ' ';
            pista[posicaoLebre] = ' ';
        }
    }

    private boolean AtualizaCorrida() {

        if(posicaoTartaruga == posicaoLebre) {
            pista[posicaoTartaruga] = 'A';
            pista[posicaoTartaruga+1] = 'I';
            pista[posicaoTartaruga+2] = ' ';
            pista[posicaoTartaruga+3] = '!';
            pista[posicaoTartaruga+4] = '!';
            pista[posicaoTartaruga+5] = '!';
        }
        else
        {
            pista[posicaoTartaruga] = 'T';
            pista[posicaoLebre] = 'L';
        }

        System.out.print(pista);

        System.out.println();

        if (posicaoTartaruga == 70 || posicaoLebre == 70) {
            return true; // corrida acabou
        }
        else {
            return false; // corrida não acabou
        }
    }

    public void ExecutarPrograma() {
        IniciaCorrida();

        boolean corridaTerminou = false;

        do {
            LimpaPista();
            AtualizaTartaruga();
            AtualizaLebre();
            corridaTerminou = AtualizaCorrida();

            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }

        } while(!corridaTerminou);

        if(posicaoTartaruga == posicaoLebre) {
            System.out.print("OCORREU UM EMPATE");
        }
        else if (posicaoTartaruga == 70) {
            System.out.print("A TARTARUGA VENCEU !!! EH !!!");
        }
        else if (posicaoLebre == 70) {
            System.out.print("A LEBRE GANHOU. OH!");
        }
    }

}
