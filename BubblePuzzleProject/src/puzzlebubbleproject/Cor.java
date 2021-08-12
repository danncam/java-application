package puzzlebubbleproject;

import java.awt.Color;

public class Cor{

    public static Color cores(int cor){
        switch(cor){
            case 1:
                return Color.RED;
            case 2:
                return Color.BLUE;
            case 3:
                return Color.YELLOW;
            case 4:
                return Color.ORANGE;
            case 5:
                return Color.GREEN;
            case 6:
                return Color.MAGENTA;
            case 7:
                return Color.PINK;
            case 8:
                return Color.BLACK;
            case 9:
                return Color.WHITE;
            case 10:
                return Color.DARK_GRAY;
            case 11:
                return Color.LIGHT_GRAY;
            }
        return null;

    }

}