import java.util.Scanner;

class Tartaruga {
    public static final int CANETA_BAIXO = 0;
    public static final int CANETA_CIMA = 1;

    public static final int DIRECAO_CIMA = 0;
    public static final int DIRECAO_DIREITA = 1;
    public static final int DIRECAO_BAIXO = 2;
    public static final int DIRECAO_ESQUERDA = 3;


    private int estadoCaneta;
    private int direcao;
    private int posicaoX;
    private int posicaoY;

    public Tartaruga() {
        estadoCaneta = CANETA_CIMA;
        direcao = DIRECAO_DIREITA;
        posicaoX = 0;
        posicaoY = 0;
    }

    public void AlterarEstado(int novoEstado) {
        estadoCaneta = novoEstado;
    }

    public void ViraDireita() {
        direcao += 1;
        if(direcao > DIRECAO_ESQUERDA) direcao = DIRECAO_CIMA;
    }

    public void ViraEsquerda() {
        direcao -= 1;
        if(direcao < DIRECAO_CIMA) direcao = DIRECAO_ESQUERDA;
    }

    public void Move(int passos, int[][] piso) {
        while(passos > 0) {

            if(estadoCaneta == CANETA_BAIXO) {
                System.out.println(posicaoX + " " + posicaoY);
                piso[posicaoY][posicaoX] = 1;
            }

            switch (direcao) {
                case DIRECAO_CIMA:
                    posicaoY = Math.max(0, posicaoY-1);
                    break;
                case DIRECAO_DIREITA:
                    posicaoX = Math.min(piso.length-1, posicaoX+1);
                    break;
                case DIRECAO_BAIXO:
                    posicaoY = Math.min(piso.length-1, posicaoY+1);
                    break;
                case DIRECAO_ESQUERDA:
                    posicaoX = Math.max(0, posicaoX-1);
                    break;
            }

            passos--;
        }
    }
}

public class ProgramaTartaruga {
    int[] comandos = new int[50];
    int[][] piso = new int[20][20];
    Tartaruga tartaruga = new Tartaruga();

    ProgramaTartaruga() {
        for(int i = 0; i < 20; i++){
            for(int j = 0; j < 20; j++){
                piso[i][j] = 0;
            }
        }
    }

    private void LeComandos() {
        int comando;
        int comandoAtual = 0;
        Scanner input = new Scanner(System.in);


        do {
            comando = input.nextInt();
            comandos[comandoAtual] = comando;
            comandoAtual++;
        } while(comando != 9 && comandoAtual < comandos.length);
    }

    private void ProcessaComandos() {
        int comando;
        int comandoAtual = 0;

        do {
            comando = comandos[comandoAtual];

            switch (comando) {
                case 1:     // Caneta para cima
                    tartaruga.AlterarEstado(Tartaruga.CANETA_CIMA);
                    break;
                case 2:     // Caneta para baixo
                    tartaruga.AlterarEstado(Tartaruga.CANETA_BAIXO);
                    break;
                case 3:     // Vira para a direita
                    tartaruga.ViraDireita();
                    break;
                case 4:     // Vira para a esquerda
                    tartaruga.ViraEsquerda();
                    break;
                case 5:     // Avance X espaços (substitua X pelo valor desejado)
                    comandoAtual++;
                    int passos = comandos[comandoAtual];
                    tartaruga.Move(passos, piso);
                    break;
                case 6:     // Exiba o array 20 por 20
                    Imprime();
                    break;
                case 9:     // Fim dos dados (sentinela)
                    // Não faz nada, o programa é encerrado no while
                    break;
            }

            comandoAtual++;
        } while(comando != 9 && comandoAtual < comandos.length);
    }

    private void Imprime() {
        for(int i = 0; i < 20; i++){
            for(int j = 0; j < 20; j++){
                if(piso[i][j] == 0) {
                    System.out.print("0");
                }
                else if(piso[i][j] == 1) {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }

    public void ExecutarPrograma() {
        LeComandos();
        ProcessaComandos();
    }
}
