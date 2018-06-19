package jogopoo;

import javax.swing.*;

public class Player extends JLabel{
    ImageIcon image;

    public Player(String img, JFrame mainFrame){
        super();

        image = new ImageIcon(img);
        this.setIcon(image);

        mainFrame.getContentPane().add(this);
    }
}
