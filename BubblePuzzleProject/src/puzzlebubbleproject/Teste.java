package puzzlebubbleproject;

import jplay.Animation;
import jplay.Sprite;
import jplay.Window;

public class Teste {
    static Window win;
    public static void main(String[] args) {
        win = new Window(1035, 640);
        Animation p = new Animation("imgs/lightball.png");
        p.x = 500;
        p.y = 400;
//        Matriz mat0 = new Matriz(0);
//        Matriz mat1 = new Matriz(1);
        boolean f = true;
        while(f){
//            p.rotate();
            p.draw();
            

//            mat.fill();
//            mat0.draw();
//            mat1.draw();
            win.update();
        }

        
        /* J é o indice das colunas, este vai até o numero máximo de linhas
         a leitura das colunas é feita da esquerda para a direita. em um for (j), o limite do vetor deve ser um setor de [i]
         0 é o primeiro índice e arr[0].length é o ultimo

         *Em uma leitura inversa, é feita com for (int j = arr[0].length-1; j > -1; j--)
         * para q o canto esquerdo da matriz nao seja lido, deve-se diminuir a atribuição inicial
         * int j = arr[0].lenght - 6, dai, as ultimas 5 colunas nao sao lidas
         * analogamente para q ela seja lida a partir de uma posição a esquerda. deve-se aumentar o limite
         * for(j = arr[0].length - 1; j > 9; j--)
         * a leitura é iniciada a partir do j = x + 1
         */

        /* I é o índice das linhas, a leitura é feita de cima para baixo ou de baixo para cima, ou seja em Y
         qnd o for é for (i=0;i<arr.lenght;i++) a leitura é feita normalmente de cima para baixo
         0 é o primeiro índice, qnt maior o i inicial, a leitura ocorre mais para baixo. Analogamente, arr.length é o último indice
         e qnt menor (arr.lenght - x) a leitura acaba antes.

         a leitura inversa é feita como for(i=arr.lenght-1; i>-1;i--)
         * sendo arr.length - 1 o primeiro indice de leitura e -1 o último
         * para iniciar a leitura de um ponto i = 3 (por exemplo) se fosse o for (i) comum
         * a mudança deve ser aplicada no i>-1
         * quanto maior o numero, mais para baixo a leitura acontece, no caso basta colocar um numero positivo
         * a leitura nao ocorre qnd é maior do q as linhas do vetor
         * analogamente, a leitura é parada dentro da matriz se a atribuição inicial for i = arr.lenght -x (x > -1)
         * quanto menor o numero, mais cedo a matriz para a leitura
         * Em int i = arr.length - 4, por exemplo, a leitura é feita ate as ultimas 3 linhas do vetor, sempre no indice j-1
         */
        int[][] arr = new int[11][13];
        for (int i = arr.length - 1; i > 5; i--) {
            for (int j = arr[0].length-1; j > 8; j--) {
                arr[i][j] = (int) (1 + Math.random() * 7);
                /*for para a matriz direita*/
            }
        }
        for (int i = arr.length - 1; i > 5; i--) {
            for (int j = 0; j < arr[0].length-9; j++) {
                arr[i][j] = (int) (1 + Math.random() * 7);
                /*for para a matriz esquerda*/
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(i-1 + "\n");
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(" "+arr[i][j] + " ");
            }
        }
        System.out.print("10\n");
    }
}
