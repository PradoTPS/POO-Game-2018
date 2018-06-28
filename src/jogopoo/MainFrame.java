package jogopoo;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public JLayeredPane mainPanel;

    public MainFrame(String title){
        super(title);
        this.setMinimumSize(new Dimension(800, 600));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setResizable(false);
        this.setVisible(true);

        mainPanel = new JLayeredPane();
        mainPanel.setLayout(null);
        mainPanel.requestFocus();
        this.setContentPane(mainPanel);
    }
}
