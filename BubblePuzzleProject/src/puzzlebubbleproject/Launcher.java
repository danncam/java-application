package puzzlebubbleproject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import jplay.Keyboard;

/**
 *
 * @author Dan
 */
public class Launcher {

    public Projectile proj;
    private int random, num;
    private double increment = 0.001;
    public boolean fire;
    Keyboard keyboard = Main.window.getKeyboard();

    Launcher(int num) {

        if (num == 0) {
            this.num = num;
            keyboard.addKey(KeyEvent.VK_W, Keyboard.DETECT_EVERY_PRESS);
            keyboard.addKey(KeyEvent.VK_S, Keyboard.DETECT_EVERY_PRESS);
        } else {
            this.num = num;
            keyboard.setBehavior(Keyboard.UP_KEY, Keyboard.DETECT_EVERY_PRESS);
            keyboard.setBehavior(Keyboard.DOWN_KEY, Keyboard.DETECT_EVERY_PRESS);
        }
    }

    Projectile generate(int num) {
        random = (int) (1 + Math.random() * 7);
        if (this.num == 0) {
            proj = new Projectile(Ball.colors(random), 45);
            proj.nome = Integer.toString(random);
            proj.x = 150;
            return proj;
        } else {
            proj = new Projectile(Ball.colors(random), 135);
            proj.nome = Integer.toString(random);
            proj.c = random;
            proj.x = 832;
            return proj;
        }
    }

    void insert(int num) {
        if (proj == null) {
            proj = generate(num);
            fire = true;
        }
    }

    void remove() {
        if (proj != null) {
            proj = null;
        }
    }

    public void setAngle(int num) {
        if (num == 0) {
            Main.window.drawText("ang "+Integer.toString(proj.ang) + "º", (int) proj.x - 20, (int) proj.y + proj.height, Color.yellow);
            if ((proj.ang < 90) && (proj.ang > 0)) {
                if (keyboard.keyDown(KeyEvent.VK_W)) {
                    proj.ang += increment;
                }
                if (keyboard.keyDown(KeyEvent.VK_S)) {
                    proj.ang -= increment;
                }
            }
        } else {
            Main.window.drawText("ang "+Integer.toString(proj.ang) + "º", (int) proj.x + proj.width + 5, (int) proj.y + proj.height, Color.yellow);
            if ((keyboard.keyDown(Keyboard.UP_KEY)) && ((proj.ang > 90) && (proj.ang < 180))) {
                proj.ang -= increment;
            }
            if ((keyboard.keyDown(Keyboard.DOWN_KEY)) && ((proj.ang > 90) && (proj.ang < 180))) {
                proj.ang += increment;
            }
        }
    }

    void launch(int num) {
        Graphics g = Main.window.getGameGraphics();
        g.setColor(Color.red);
        insert(num);
        proj.update();
        g.drawOval((int)proj.x-10, (int)proj.y-10, proj.width+20, proj.height+20);
        setAngle(num);
        proj.setForce();
        if(!proj.pressing){
            if (proj.launching) {
                if (proj.stopped) {
                    fire = false;
                    remove();
                    insert(num);
                }
            }
        }
    }
}
