package kapman;

import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import jplay.Sprite;

/* Créditos para Luiz Carlos Viana (AKA JavaBoy) */
public class Snake extends ArrayList<Sprite> {

    private int direction;// so podem 4 direcoes que nao dependem uma da outra.
    private int speedX = 5;
    private int speedY = 5;
    private Point sright;
    private Point sleft;
    private Point sdown;
    private Point sup;

    public Snake(int length) {
        direction = Sprite.RIGHT;
        Sprite s = new Sprite("res/rect2985.png");
        sright = new Point(Conf.startx, Conf.wingame.getHeight() / 2 - s.height / 2);
        sleft = new Point(Conf.wingame.getWidth() - Conf.startx, sright.y);
        sdown = new Point(Conf.wingame.getWidth() / 2 - s.width / 2, Conf.starty);
        sup = new Point(sdown.x, Conf.wingame.getHeight() - Conf.starty);

        for (int i = 0; i < length; i++) {
            s = new Sprite("res/rect2985.png");
            s.x = sright.x - i * s.width;
            s.y = sright.y;
            add(s);

        }
    }

    public boolean isOnWindow() {
        Dimension d = Conf.wingame.getSize();
        for (Sprite s : this) {
            if (s.x >= 0 && s.x <= d.width && s.y >= 0 && s.y <= d.height) {
                return true;
            }
        }
        return false;
    }

    public void update() {
        if (!isOnWindow()) {
            int length = size();
            clear();
            direction = Game.dir;
            for (int i = 0; i < length; i++) {
                Sprite s = new Sprite("res/rect2985.png");
                switch (direction) {
                    case Sprite.RIGHT:
                        s.x = sright.x - i * s.width;
                        s.y = sright.y;
                        break;
                    case Sprite.LEFT:
                        s.x = sleft.x + i * s.width;
                        s.y = sleft.y;
                        break;
                    case Sprite.DOWN:
                        s.x = sdown.x;
                        s.y = sdown.y - i * s.height;
                        break;
                    case Sprite.UP:
                        s.x = sup.x;
                        s.y = sup.y + i * s.height;
                        break;
                }
                add(s);

            }

        }
        
        for (Sprite s : this) {
            
            if(s.collided(Game.player)){
                Game.isOver();
            }
            
            switch (direction) {
                case Sprite.RIGHT:
                    s.x += speedX;
                    break;
                case Sprite.LEFT:
                    s.x -= speedX;
                    break;
                case Sprite.DOWN:
                    s.y += speedY;
                    break;
                case Sprite.UP:
                    s.y -= speedY;
                    break;
            }
            s.draw();
        }
    }
}
