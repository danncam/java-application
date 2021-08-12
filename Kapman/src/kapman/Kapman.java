package kapman;

import jplay.Keyboard;
import jplay.Sprite;

public class Kapman extends Sprite {
public static int score = 0;
public boolean power = false;

    public Kapman() {
        
        super("res/pac-man.png", 16);
        x = (Conf.wingame.getWidth()/2) - width;
        y = Conf.wingame.getHeight() - height - 1;
        setTotalDuration(3000);
        setSequence(0, 2);

    }

    public void moveX() {
        this.moveX(7);
        if (mvRight()) {
            if (getInitialFrame() != 0 && getFinalFrame() != 1) {
                this.setSequence(0, 2);
            }
        }
        if (mvLeft()) {
            if (getInitialFrame() != 4 && getFinalFrame() != 5) {
                setSequence(4, 6);
            }
        }

    }

    public void moveY() {
        this.moveY(7);
        if (mvUp()) {
            if (getInitialFrame() != 2 && getFinalFrame() != 3) {
                setSequence(2, 4);
            }

        }
        if (mvDown()) {
            if (getInitialFrame() != 6 && getFinalFrame() != 7) {
                setSequence(6, 8);
            }
        }
    }

    private boolean mvRight() {
        return Conf.kb.keyDown(Keyboard.RIGHT_KEY);
    }

    private boolean mvLeft() {
        return Conf.kb.keyDown(Keyboard.LEFT_KEY);
    }

    private boolean mvUp() {
        return Conf.kb.keyDown(Keyboard.UP_KEY);
    }

    private boolean mvDown() {
        return Conf.kb.keyDown(Keyboard.DOWN_KEY);
    }
    public boolean hasPower(){
        power = true;
        return true;
    }

    public void shot(){
        if(hasPower() && Conf.kb.keyDown(Keyboard.SPACE_KEY)){
            switch(this.direction){
                case RIGHT:
                    
                    break;
                case LEFT:
                    break;
                case UP:
                    break;
                case DOWN:
                    break;
                    
            }
            power = false;
        }
    }

    
    public Kapman getInstance(){
        return this;
    }

    @Override
    public void update() {
        
        super.update();
        setTotalDuration(2500);
        moveX();
        moveY();
        
    }

}
