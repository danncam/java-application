package Files;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Dialogue {
    public static void main(String[] args) {
        
        
        JFrame win = new JFrame();
        win.setSize(200, 200);
        win.setVisible(true);
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JOptionPane.showMessageDialog(win, "Esta é uma janela de dialogo criada no centro da tela");
        
        
        String name, ageStr;
        name = JOptionPane.showInputDialog(win, "qual o seu nome?");
        ageStr = JOptionPane.showInputDialog(win, "qual é sua idade?");
        int age = Integer.parseInt(ageStr);
        
    }
}
