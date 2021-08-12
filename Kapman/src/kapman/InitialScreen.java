package kapman;


import jplay.GameImage;
import jplay.Mouse;
import jplay.Window;

/**
 *
 * @author Dan
 */
public class InitialScreen {

    public static Window init;
    public static Mouse mouse;

    public static void main(String[] args) {

        init = new Window(600, 600);
        mouse = init.getMouse();

        GameImage background = new GameImage("res/initialscreen.png");
        GameImage playbutton = new GameImage("res/playbutton.png");
        GameImage howtobutton = new GameImage("res/howtobutton.png");
        GameImage rankingbutton = new GameImage("res/rankingbutton.png");
        GameImage arrowback = new GameImage("res/arrowback.png");

        playbutton.x = init.getWidth() - playbutton.width - 20;
        howtobutton.x = init.getWidth() - playbutton.width - 20;
        rankingbutton.x = init.getWidth() - playbutton.width - 20;
        arrowback.x = init.getWidth() - arrowback.width - 40;
        
        playbutton.y = init.getHeight() - (howtobutton.height - 10) * 12;
        howtobutton.y = init.getHeight() - (howtobutton.height - 10) * 8;
        rankingbutton.y = init.getHeight() - (howtobutton.height - 10) * 4;
        arrowback.y = init.getHeight() - arrowback.height - 40;

        while (true) {

            background.draw();
            playbutton.draw();
            howtobutton.draw();
            rankingbutton.draw();

            if (mouse.isLeftButtonPressed() && mouse.isOverArea((int) playbutton.x, (int) playbutton.y, (int) playbutton.x + playbutton.width, (int) playbutton.y + playbutton.height)) {
                Game.game();
            }
//            if (mouse.isLeftButtonPressed() && mouse.isOverArea((int) howtobutton.x, (int) howtobutton.y, (int) howtobutton.x + howtobutton.width, (int) howtobutton.y + howtobutton.height)) {
                if(mouse.isRightButtonPressed()){
                background.hide();
                playbutton.hide();
                howtobutton.hide();
                rankingbutton.hide();
                        
                System.out.println("estou aqui");
                while (mouse.isLeftButtonPressed()) {
                    arrowback.draw();
                }

            }
            if (mouse.isLeftButtonPressed() && mouse.isOverArea((int) rankingbutton.x, (int) rankingbutton.y, (int) rankingbutton.x + rankingbutton.width, (int) rankingbutton.y + rankingbutton.height)) {
            }
            init.setVisible(true);
            init.update();
        }

    }
}
