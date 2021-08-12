package puzzlebubbleproject;

import jplay.Keyboard;
import jplay.Mouse;
import jplay.Sprite;
import jplay.Window;

public class Main {
    public static Window win, window;
    public static Keyboard kb;
    public static boolean menuView;
    public static void main(String[] args) {
        
        win = new Window(400, 600);
        Mouse ms = win.getMouse();
        kb = win.getKeyboard();
        Sprite p1 = new Sprite("imgs/1P.png");
        Sprite p2 = new Sprite("imgs/2P.png");
        Sprite settings = new Sprite("imgs/settings.png");
        p1.x = 0;
        p1.y = 550;
        p2.x = 0;
        p2.y = 550;
        settings.x = 0;
        settings.y = 550;
        Menu.menu();
        menuView = true;
        while(menuView){
            Menu.draw();
            if(ms.isOverArea(140, 370, 250, 480))
                p1.draw();
            else
                if(ms.isOverArea(45, 240, 145, 345))
                p2.draw();
                else
                    if(ms.isOverArea(240, 230, 340, 340))
                        settings.draw();
            if(ms.isOverArea(45, 240, 145, 345) && ms.isLeftButtonPressed()){
                menuView = false;
                window = new Window(1035, 640);
                Mod2.game2();
            }
            else if((ms.isOverArea(140, 370, 250, 480)) && ms.isLeftButtonPressed()){
                    menuView = false;
                    window = new Window(1035, 640);
                    Mod1.game1();
            }
            else if(ms.isOverArea(240, 230, 340, 340)&&ms.isLeftButtonPressed()){
                        Settings.settings();
                        menuView = true;
                    }
            win.update();
        }
    }
}
