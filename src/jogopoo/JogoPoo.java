package jogopoo;

import java.awt.*;
import javax.swing.*;

public class JogoPoo {

    public final static int LOOP_DURATION = 30;
    
    public static void main(String[] args) {
        //<Awake>
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createFrame();
            }
        });
        //</Awake>

        loop();
    }
  
    public static void update(){
        
    }
    
    private static void createFrame() {
        JFrame frame = new JFrame("Crackpots");
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(800,600));
        frame.setResizable(false);
        frame.setAlwaysOnTop(true);
        frame.setVisible(true);
        
        /*ImageIcon icon = new ImageIcon("/images/sprite.png");
        JLabel label = new JLabel(icon);
        frame.getContentPane().add(label);*/
    }
    
    public static void loop(){
        long expectedtime = System.currentTimeMillis();
        
        while (true) {
            if(System.currentTimeMillis() >= expectedtime){
                expectedtime += LOOP_DURATION;
                update();
            }
        }
    }
}
