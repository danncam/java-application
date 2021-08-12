
package puzzlebubbleproject;


import java.awt.Color;
import java.awt.Graphics;
import jplay.Keyboard;

class Mod2 {
    
     public static Grade gradeA, gradeB;
        static void game2(){
            Main.win.setVisible(false);
            Main.window.setVisible(true);
            Launcher esq = new Launcher(0);
            Launcher dir = new Launcher(1);
            Keyboard teclado = Main.window.getKeyboard();
            gradeA = new Grade(0);
            gradeB = new Grade(1);
            gradeA.fill();
            boolean gameloop = true;
            while(gameloop){

                Main.window.clear(Color.BLACK);
                gradeA.draw();
                gradeB.draw();
                Condition.Turn(esq, dir);
                dir.proj.draw();
                esq.proj.draw();
                
//                gradeA.update();
                Condition.collision(esq, gradeB);
//                Condition.collision(dir, gradeA);
                Graphics g = Main.window.getGameGraphics();
                g.setColor(Color.white);
                g.drawLine(1035/2, 0, 1035/2, 640);
                
                g.fillRect(0, 600, 1035, 10);
                g.drawLine(0, 600, 1035, 600);
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
