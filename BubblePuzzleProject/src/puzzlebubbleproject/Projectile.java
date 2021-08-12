package puzzlebubbleproject;

import jplay.Animation;
import jplay.Keyboard;

public class Projectile extends Ball {

    int ang;
    double decrement = 0.05, increment = 0.1, v0 = 2, velox, veloy;
    private double force, fmax = 48;
    private Keyboard teclado = Main.window.getKeyboard();
    boolean launching, pressing, stopped, ready;
    private Animation ani = new Animation("imgs/setForc2e.png", 8);

    public Projectile(String FileName, int ang) {
        super(FileName);
        this.ang = ang;
        this.y = 500;
        this.velox = this.v0;
        this.nome = FileName;
        teclado.setBehavior(Keyboard.SPACE_KEY, Keyboard.DETECT_EVERY_PRESS);
        ready = true;
    }

    public void moveX() {
        x += velox;
        if (force > 0) {
            launching = true;
            force -= decrement;
            velox += (velox > 0 ? -decrement / 2 : decrement / 2);
            v0 = -decrement / 2;
        } else {
            velox = 0;
            launching = false;
        }
        if ((x >= Constante.MAX_X) || (x <= Constante.MIN_X)) {
            velox*=-1;
        }
    }

    @Override
    public void moveY() {
        y += veloy;

        if (((y <= Constante.MIN_Y) || (y >= Constante.MAX_Y) && (veloy > 0))) // esta última condição é importante para que a bola não ultrapasse o limite inferior
        {
            
            veloy *= -1;
        }

        if (!((veloy == 0) && (y >= Constante.MAX_Y))) // esta condição serve para que a gravidade pare de agir quando a  velocidade em Y for 0
        {
            veloy += Constante.GRAV;
        }

        if (force < 0) {
            velox--;
            veloy--;
            v0 = 0;
            force = 0;
            stopped = true;
        }
    }

    public void setForce() {
        ready = true;
        if ((teclado.keyDown(Keyboard.SPACE_KEY))) {

            if ((force >= 0) && (force <= 6)) {
                ani.setCurrFrame(0);
            }
            if ((force > 6) && (force <= 12)) {
                ani.setCurrFrame(1);
            }
            if ((force > 12) && (force <= 18)) {
                ani.setCurrFrame(2);
            }
            if ((force > 18) && (force <= 24)) {
                ani.setCurrFrame(3);
            }
            if ((force > 24) && (force <= 30)) {
                ani.setCurrFrame(4);
            }
            if ((force > 30) && (force <= 36)) {
                ani.setCurrFrame(5);
            }
            if ((force > 36) && (force <= 42)) {
                ani.setCurrFrame(6);
            }
            if ((force > 42) && (force <= 48)) {
                ani.setCurrFrame(7);
            }
            
            ani.x = this.x - 9.5;
            ani.y = this.y - 9.5;
            ani.draw();
            ani.update();
            if (pressing) {
                force += (force < fmax ? increment : 0);
            } else {
                pressing = true;
            }
        } else if (pressing) {
            pressing = false;
            launching = true;
            stopped = false;
            v0+=force;
            this.velox = (int) (v0 * Math.cos(ang * Math.PI / 180));
            this.veloy = -(int) (v0 * Math.sin(ang * Math.PI / 180));

        }
    }

    @Override
    public void update() {
        if (launching) {
            moveX();
            moveY();
            if(stopped){
                ready = false;
            }
        } else {
            setForce();
        }
    }
}
