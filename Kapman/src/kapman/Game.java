package kapman;

import java.awt.Color;
import java.awt.Graphics;
import jplay.Sound;

public class Game {

    private static int score = 0;
    public static Kapman player;
    public static Snake snake;
    public static Weapon weap;
    public static Sound mus;
    private static boolean gameloop;
    static int dir;

    public static void game() {
        InitialScreen.init.setVisible(gameloop);
       
        player = new Kapman();
        snake = new Snake(Conf.length); // entrada de nível de dificuldade
        weap = new Weapon();

        mus = new Sound("res/Mozart's March - Dark Moor (Metal Cover).wav");
        mus.play();
        mus.setRepeat(true);

        gameloop = true;

        while (gameloop) {
            dir = 1 + (int) (Math.random() * 4);
            Conf.wingame.clear(Color.MAGENTA);

            Conf.wingame.drawText("Score: " + Integer.toString(score), 100, Conf.wingame.getHeight() - 8, Color.yellow);
            graphics();

            weap.update();

            snake.update();

            player.draw();
            player.update();

            Conf.wingame.update();
            Conf.wingame.delay(Conf.gamedelay);

        }

    }

    public static void graphics() {
        Graphics g = Conf.wingame.getGameGraphics();
        g.setColor(Color.white);

        g.drawRect(20, 50, Conf.wingame.getWidth() - 40, Conf.wingame.getHeight() - 70);

    }

    static void isOver() {
        mus.stop();
        Sound dying = new Sound("res/pacdie.wav");
        if (dying.isExecuting()) {
            dying.stop();
        }
        dying.play();

        player.setSequence(8, 16);
        gameloop = false;
        Conf.wingame.setVisible(gameloop);
    }
}
