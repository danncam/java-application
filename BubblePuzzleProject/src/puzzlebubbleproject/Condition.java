package puzzlebubbleproject;

import jplay.Collision;

public class Condition {

    public static void collision(Launcher laun1, Grade grad2){
        for (int i = 0; i < grad2.arr.length; i++)
            for (int j = 0; j < grad2.arr[0].length; j++) {
                if(grad2.arr[i][j]!=null)
                    if(grad2.arr[i][j].invalid)
                        if(Collision.collided(grad2.arr[i][j], laun1.proj, false)){
                            if(laun1.proj.equals(grad2.arr[i][j]))
                                grad2.arr[i][j].hide();
                        }
            }
    }

    public static void Turn(Launcher proj0, Launcher proj1){

//        if(proj0.fire){
//
//            proj1.fire = false;
            proj0.launch(0);
//        } else {
//            proj1.fire = true;
            proj1.launch(1);
//        }

    }
    public static void Turn(Launcher proj){
        if(proj.proj.stopped)
            proj.proj.update();
    }
}
