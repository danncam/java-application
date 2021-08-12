package puzzlebubbleproject;

import jplay.GameImage;



/**
 *
 * @author dan
 */
public class Menu {

    static GameImage bg;
    public static void menu() {
         bg = new GameImage("imgs/paintball.jpg");
    }

    public static void draw(){
        bg.draw();
        
    }
}
