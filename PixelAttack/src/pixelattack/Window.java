package pixelattack;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 *
 * @author dan
 */
public class Window extends JFrame {

    private Device dev;

    public Window(int width, int heigh) {
        dev = new Device();


        addMouseListener(dev);
        addMouseMotionListener(dev);
        addMouseWheelListener(dev);
        setSize(width, heigh);
        setResizable(true);
        setUndecorated(false);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Pixel Attack");
        JLabel textlabel = new JLabel("the label text", SwingConstants.CENTER);
        getContentPane().add(textlabel, BorderLayout.CENTER);





    }

    public Device getDev() {
        return dev;
    }
}
