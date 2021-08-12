package puzzlebubbleproject;

import java.awt.Color;
import jplay.Camera;
import jplay.Keyboard;

/**
 *
 * @author dan
 *
 *
 * Classe Câmera
 * Créditos: Bruno Garcia
 */
public class Mod1 {
    public static Camera cam;
    public static Launcher bola;
    public static Grade gradeB;
        static void game1(){
            Main.win.setVisible(false);
            Main.window.setVisible(true);
            cam = new Camera(0, 3000, 0, 640);
            cam.setDimension(3721, 640);
            bola = new Launcher(0);
            gradeB = new Grade(1);
            Keyboard teclado = Main.window.getKeyboard();
            Constante.MAX_X = 3000;
            boolean gameloop = true;
            while(gameloop){

                Main.window.clear(Color.BLACK);
                cam.follow(bola.proj);
                gradeB.draw();
                cam.setDimension(1035, 640);
                bola.launch(0);
                bola.proj.draw();
                Condition.Turn(bola);
                Condition.collision(bola, gradeB);
                cam.update();
                Main.window.update();
                Main.window.delay(Settings.delay);
                if(teclado.keyDown(Keyboard.ESCAPE_KEY))
                    gameloop = false;
            }
            Main.window.setVisible(false);
            Main.win.setVisible(true);
            Main.menuView = true;
        }
}
