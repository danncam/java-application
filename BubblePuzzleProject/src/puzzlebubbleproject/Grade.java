package puzzlebubbleproject;

/**
 *
 * @author dan
 */
public class Grade {

    public Ball arr[][];
    public int random;
    public Grade(int num) {
        arr = new Ball[11][13];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = new Ball(Ball.colors(0));
                arr[i][j].c = 0;
                arr[i][j].left = false;
                arr[i][j].right = false;
                arr[i][j].up = false;
                arr[i][j].down = false;
                arr[i][j].invalid = true;
            }
        }
        if (num == 0) {
            for (int i = arr.length - 8; i > -1; i--) {
                for (int j = 6; j < arr[0].length; j++) {
                    random = (int) (1 + Math.random() * 7);
                    arr[i][j] = new Ball(Ball.colors(random));
                    arr[i][j].c = random;
                    arr[i][j].nome = Integer.toString(random);
                    arr[i][j].x = i * arr[i][j].width;
                    arr[i][j].y = j * arr[i][j].height;
                    System.out.print(" "+arr[i][j].c + " ");
                }
            }
            System.out.print("\n");
        }
        if (num == 1) {
            for (int i = arr.length - 1; i > 6; i--) {
                for (int j = arr[0].length - 1; j > 5 ; j--) {
                    random = (int) (1 + Math.random() * 7);
                    arr[i][j] = new Ball(Ball.colors(random));
                    arr[i][j].c = random;
                    arr[i][j].x = Main.window.getWidth() - 11 * 45 + i * arr[i][j].width;
                    arr[i][j].y = j * arr[i][j].height;
//                    System.out.print(arr[i][j].c + " ");
                }
            }
//            System.out.print("\n");
        }
        
    }
    public void fill(){

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j].equals(arr[i - 1][j])) {
                    arr[i][j].up = true;
                    System.out.print(arr[i][j].c + " valido   ");
                }
            }
            System.out.print("\n ");
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr[0].length; j++) {
                if (arr[i][j].equals(arr[i][j - 1])) {
                    arr[i][j].left = true;
                    System.out.print(arr[i][j].c + " valido   ");
                }
            }
            System.out.print("\n ");
        }
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j].equals(arr[i + 1][j])) {
                    arr[i][j].down = true;
                    System.out.print(arr[i][j].c + " valido   ");
                }
            }
            System.out.print("\n ");
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length - 1; j++) {
                if (arr[i][j].equals(arr[i][j + 1])) {
                    arr[i][j].right = true;
                    System.out.print(arr[i][j].c + " valido   ");
                }
            }
            System.out.print("\n ");
        }
        System.out.println("acaba aqui-------------------------------------------------------------------\n\n\n");
    }


    

    public void draw() {
        
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j].draw();
            }
        }
    }
    public void update(){
        fill();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if(arr[i][j].invalid)
                    arr[i][j].nome = Ball.colors(0);
            }
        }
    }
        public void fall(){
            for (int i = 0; i < arr.length; i++)
                for (int j = 0; j < arr[0].length; j++) {
                    Ball b = arr[i][j];
                    for (int k = i+1; k < arr.length; k++)
                        if(arr[i+1][j].invalid){
                            arr[i][j].hide();
                            b.setFloor((int) arr[i+1][j].y);
                            break;
                        }
                }
        }
}
