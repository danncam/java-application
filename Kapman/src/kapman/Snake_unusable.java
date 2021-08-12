package kapman;

import jplay.Sprite;

/**
 *
 * @author dan
 */
public class Snake_unusable {

    public int length;
    public int headX;
    public int headY;
    public int headDir;
    public int tailX;
    public int tailY;
    public int tailDir;
    public Sprite[] snake;

    public Snake_unusable(int length) {
        this.headX = 300;
        this.headY = 300;

        snake = new Sprite[length];

        for (int i = 0; i < length; i++) {

            snake[i] = new Sprite("img/rect2985.png");
            snake[i].x = headX + snake[i].width * i;
            snake[i].y = headY;
            snake[i].direction = Sprite.LEFT;

        }

    }

    public void update() {
        snake[0].autoMove();
        for (int i = 0; i < snake.length; i++) {

            snake[i].direction = snake[i - 1].direction;
            
        }

    }

    public void setDir(int dir) {
        snake[0].direction = dir;
    }

    public int getDir() {
        return snake[0].direction;
    }

    public void draw() {
        for (int i = 0; i < snake.length; i++) {
            snake[i].draw();

        }
    }
}