package puzzlebubbleproject;

import java.awt.Color;
import java.awt.Graphics;
import jplay.Keyboard;


//import javax.swing.JOptionPane;

public class Settings {
public static int delay = 10;
    static void settings(){
//
//            String msg = JOptionPane.showInputDialog("Delay: ", 10);
//            delay = Integer.parseInt(msg);
//            Main.win.update();
        boolean settings = true;
        while(settings){
            Main.win.clear(Color.white);
            Graphics g = Main.win.getGameGraphics();
            g.setColor(Color.red);
            g.fillOval(100-5, 100-5, 20, 20);
            g.drawRoundRect(100, 100, 200, 10, 10, 10);
            g.fillRoundRect(100, 100, delay, 10, 10, 10);
            Main.win.update();
            if(Main.kb.keyDown(Keyboard.ESCAPE_KEY)){
                settings = false;
            }
        }
    }
}
class Rect{
    Rect(){
        Graphics gr = Main.win.getGameGraphics();
        gr.drawRoundRect(100, 100, 200, 10, 10, 10);

    }
}
