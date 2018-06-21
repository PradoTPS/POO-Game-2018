package jogopoo;

import javax.swing.*;

public class Player extends GameObject{

    public Player(String img, JFrame mainFrame, int x, int y, int size) {
        super(img, mainFrame, x, y, size);
        
        this.setBound(100,640);
    }
    
    public void move(int distance){
        this.setLocation(
                clamp(this.getX() + distance, getBound()), 
                this.getY()
        );
    }
}
