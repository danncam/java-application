package puzzlebubbleproject;
import jplay.Sprite;

/*Classe Ball estende Sprite, contem um método que converte inteiros em Strings, seu construtor pode receber uma String ou chamar o método colors(int cor).
 Cada bola também possui quatro booleanos que determinam se as bolas ao redor, na matriz, são iguais ou não*/
public class Ball extends Sprite{
    private int veloy;
    protected boolean up, down, left, right, invalid = false;
       int c;
       String nome;
       public Ball(String nome){
           super(nome);
           this.nome = nome;
       }
       public void destroy(){
           this.nome = "imgs/invalid.png";
           invalid = true;
       }

       public static String colors(int cor){
            switch(cor){
                case 0:
                    return "imgs/invalid.png";
                case 1:
                    return "imgs/flameball.png";
                case 2:
                    return "imgs/diveball.png";
                case 3:
                    return "imgs/forestball.png";
                case 4:
                    return "imgs/lightball.png";
                case 5:
                    return "imgs/souldewball.png";
                case 6:
                    return "imgs/pearlball.png";
                case 7:
                    return "imgs/denseball.png";
                }
            return null;
       }
       public void moveY(){
           y+=veloy;

            if (((y <= Constante.MIN_Y) || (y >= Constante.MAX_Y) && (veloy > 0))) // esta última condição é importante para que a bola não ultrapasse o limite inferior
            {

                veloy *= -1;
            }

            if (!((veloy == 0) && (y >= Constante.MAX_Y))) // esta condição serve para que a gravidade pare de agir quando a  velocidade em Y for 0
            {
                veloy += Constante.GRAV;
            }
       }
       public boolean equals(Ball bola){
            return this.nome.equals(bola.nome);
   }

}

