package puzzlebubbleproject;

import java.awt.Color;

/**
 *
 * @author Dan
 */
public class Matriz {
    public Ball arr[][];
    public int random;
    public Matriz(int num) {
        arr = new Ball[11][13];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = new Ball(Ball.colors(0));
                arr[i][j].left = false;
                arr[i][j].right = false;
                arr[i][j].up = false;
                arr[i][j].down = false;
                arr[i][j].invalid = true;
            }
        }
        if (num == 0) {
            for (int i = arr.length - 8; i > -1; i--) {
                for (int j = 7; j < arr[0].length; j++) {
                    random = (int) (1 + Math.random() * 7);
                    arr[i][j] = new Ball(Ball.colors(random));
                    Teste.win.drawText(Integer.toString(random), (int)arr[i][j].x, (int)arr[i][j].y, Color.yellow);
                    arr[i][j].c = random;
                    arr[i][j].x =  i * arr[i][j].width;
                    arr[i][j].y = j * arr[i][j].height;
                    System.out.print(" "+random + " ");
                }
            }
        }System.out.print("\n");
        if (num == 1) {
            for (int i = arr.length - 1; i > 6; i--) {
                for (int j = arr[0].length - 1; j > 6 ; j--) {
                    random = (int) (1 + Math.random() * 7);
                    arr[i][j] = new Ball(Ball.colors(random));
                    arr[i][j].c = random;
                    Teste.win.drawText(Integer.toString(random), (int)arr[i][j].x, (int)arr[i][j].y, Color.yellow);
                    arr[i][j].x = Teste.win.getWidth() - 11 * 45 +i * arr[i][j].width;
                    arr[i][j].y = j * arr[i][j].height;
                    System.out.print(" "+random+" ");
                }
            }
        }System.out.print("\n");
    }

    public void draw() {
        fill();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j].draw();
                Teste.win.drawText(Integer.toString(arr[i][j].c), (int)arr[i][j].x, (int)arr[i][j].y, Color.yellow);
            }
        }
    }
    public void fill(){

        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr[0].length; j++) {
                if (arr[i][j].nome==null) {
                    arr[i][j].left = false;
                    arr[i][j].up = false;
                    arr[i][j].right = false;
                    arr[i][j].down = false;
                }else if(arr[i][j].equals(arr[i][j - 1])) arr[i][j].left = false;

            }
        }
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j].nome==null) {
                    arr[i][j].left = false;
                    arr[i][j].up = false;
                    arr[i][j].right = false;
                    arr[i][j].down = false;
                }else
                if (arr[i][j].equals(arr[i + 1][j])) {
                    arr[i][j].down = true;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length - 1; j++) {
                if (arr[i][j].nome==null) {
                    arr[i][j].left = false;
                    arr[i][j].up = false;
                    arr[i][j].right = false;
                    arr[i][j].down = false;
                }else
                if (arr[i][j].equals(arr[i][j + 1])) {
                    arr[i][j].right = true;
                }
            }
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j].nome==null) {
                    arr[i][j].left = false;
                    arr[i][j].up = false;
                    arr[i][j].right = false;
                    arr[i][j].down = false;
                }else
                if (arr[i][j].equals(arr[i - 1][j])) {
                    arr[i][j].up = true;

                }
            }
        }


    }
}

//package puzzlebubbleproject;
//
///**
// *
// * @author dan
// */
//public class Grade {
//
//    public Ball arr[][];
//    public int random;
//    public Grade(int num) {
//        arr = new Ball[11][13];
//        if (num == 0) {
//            for (int i = 0; i < arr.length; i++) {
//                for (int j = 0; j < arr[0].length; j++) {
//                    random = (int) (1 + Math.random() * 7);
//                    arr[i][j] = new Ball(Ball.colors(random));
//                    arr[i][j].c = random;
//                    arr[i][j].nome = Integer.toString(random);
//                    arr[i][j].x = i * arr[i][j].width;
//                    arr[i][j].y = j * arr[i][j].height;
//                }
//            }
//        }
//        if (num == 1) {
//            for (int i = 0; i < arr.length; i++) {
//                for (int j = 0; j < arr[0].length; j++) {
//                    random = (int) (1 + Math.random() * 7);
//                    arr[i][j] = new Ball(Ball.colors(random));
//                    arr[i][j].c = random;
//                    arr[i][j].x = Main.window.getWidth() - 11 * 45 + i * arr[i][j].width;
//                    arr[i][j].y = j * arr[i][j].height;
//                }
//            }
//        }
//    }
//    public void fill(){
//
//        for (int i = 1; i < arr.length; i++) {
//            for (int j = 0; j < arr[0].length; j++) {
//                if (arr[i][j].equals(arr[i - 1][j])) {
//                    arr[i][j].up = true;
//                }
//            }
//        }
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 1; j < arr[0].length; j++) {
//                if (arr[i][j].equals(arr[i][j - 1])) {
//                    arr[i][j].left = true;
//                }
//            }
//        }
//        for (int i = 0; i < arr.length - 1; i++) {
//            for (int j = 0; j < arr[0].length; j++) {
//                if (arr[i][j].equals(arr[i + 1][j])) {
//                    arr[i][j].down = true;
//                }
//            }
//        }
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr[0].length - 1; j++) {
//                if (arr[i][j].equals(arr[i][j + 1])) {
//                    arr[i][j].right = true;
//                }
//            }
//        }
//    }
//
//    public void draw(int num) {
//
//
//        if (num == 0) {
//            fill();
//            for (int i = arr.length - 8; i > -1; i--) {
//                for (int j = 8; j < arr[0].length; j++) {
//                    arr[i][j].draw();
//                }
//            }
//        }
//        if (num == 1) {
//            fill();
//            for (int i = arr.length - 1; i > 6; i--) {
//                for (int j = arr[0].length - 1; j > 7 ; j--) {
//                    arr[i][j].draw();
//                }
//            }
//        }
//    }
//}









