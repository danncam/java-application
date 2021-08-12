/*
 * @author Bruno Garcia
 * Universidade Federal Fluminense - UFF - Brasil - 2011
 * Ciências da Computação
 */
package jplay;

public class Camera extends GameObject {
    public static Camera usingcam; // Câmera em uso
    
    public static void doNotUseCameras() {
        usingcam = null;
    }

    private GameObject  target; // Objeto a ser seguido
    private double      limit_left, limit_right, limit_up, limit_down;

    // Corrige a posição baseado nos limites
    private void fixPosition() {
        if(x < limit_left)
            x = limit_left;
        if(y < limit_up)
            y = limit_up;
        if(x + (double)width > limit_right)
            x = limit_right - (double)width;
        if(y + (double)height > limit_down)
            y = limit_down - (double)height;
    }

    // "Segue" o alvo, caso tenha sido definido algum
    public void flyToTarget() {
        if(target != null)
            setPosition(target.x + target.width/2 - this.width/2, target.y + target.height/2 - this.height/2);
    }

    public Camera() {
        super();
        
        limit_left = limit_right = limit_up = limit_down = 0.0;

        this.useThisCamera();
    }
    
    public Camera(double limit_left, double limit_right, double limit_up, double limit_down) {
        super();
        
        setLimits(limit_left, limit_right, limit_up, limit_down);
        this.useThisCamera();
    }

    public void update() {
        flyToTarget();
        fixPosition();
    }

    public void setPosition(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void setDimension(int width, int height) {
        this.width  = width;
        this.height = height;
    }

    public void setLimits(double limit_left, double limit_right, double limit_up, double limit_down) {
        this.limit_left     = limit_left;
        this.limit_right    = limit_right;
        this.limit_up       = limit_up;
        this.limit_down     = limit_down;
    }

    public void follow(GameObject target) {
        this.target = target;
    }

    public void useThisCamera() {
        Camera.usingcam = this;
    }
}
