package jogopoo;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public MainFrame(String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(800,600));
        this.setResizable(false);
        this.setAlwaysOnTop(true);
        this.setVisible(true);
    }
}
