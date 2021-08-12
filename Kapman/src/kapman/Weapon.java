package kapman;

import jplay.Sprite;

/**
 *
 * @author Dan
 */
public class Weapon extends Sprite {

    Weapon() {
        super(Conf.chooseSprite( 1 + (int) (Math.random() * 7 )));

        /* localização inicial */
        x = (int) 30 + Math.random() * Conf.wingame.getWidth() - 50;
        y = (int) 50 + Math.random() * Conf.wingame.getHeight() - 70;
    }


    public void setPos() {
            
            x = (int) 30 + Math.random() * Conf.wingame.getWidth() - 50;
            y = (int) 50 + Math.random() * Conf.wingame.getHeight() - 70;
            loadImage(Conf.chooseSprite( 1 + (int) (Math.random() * 7 )));
    }

    public boolean caugth(Sprite obj) {
        if (obj.equals(Game.player)) {
            Game.player.hasPower();
        }
        return this.collided(obj);
    }

    @Override
    public void update() {
        if (caugth(Game.player)) {
            setPos();
        } else {
            this.draw();
        }
    }
}
