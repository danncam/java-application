package kapman;
import jplay.Keyboard;
import jplay.Window;

public class Conf {
    
        public static final int MIN_X = 0;
        public static final int MIN_Y = 0;
        public static final int MAX_X = 1018;
        public static final int MAX_Y = 730;
        public static final int UP = 1;
        public static final int DOWN = 2;
        public static final int RIGHT = 3;
        public static final int LEFT = 4;
        
        public static int length = 18;
        public static int record = 0;
        public static int gamedelay = 10;
        public static int startx = 100;
        public static int starty = 100;
        
        
        public static Window wingame = new Window(MAX_X, MAX_Y);
        public static Keyboard kb = wingame.getKeyboard();
        
        
        public static String chooseSprite(int n){
            switch(n){
                case 1:
                    return "res/weap-red.png";
                case 2: 
                    return "res/weap-blue.png";
                case 3:
                    return "res/weap-yellow.png";
                case 4:
                    return "res/weap-pink.png";
                case 5:
                    return "res/weap-green.png";
                case 6:
                    return "res/weap-orange.png";
                case 7:
                    return "res/weap-black.png";
            }
            return null;
        }
}
