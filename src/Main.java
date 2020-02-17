import com.sun.tools.sjavac.Log;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main extends JFrame{

    public static void main(String[] args){

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ServoController servoController = new ServoController();
                JFrame frame = new JFrame();
                UIPanel panel = new UIPanel(servoController);
                panel.createAndShowGUI();
                panel.setListeners();
                panel.setKeyboardButtons();
                frame.add(panel);
                frame.setSize(500, 500);
                frame.setVisible(true);
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

                panel.setFocusable(true);
                panel.requestFocusInWindow();

            }
        });



    }
}
