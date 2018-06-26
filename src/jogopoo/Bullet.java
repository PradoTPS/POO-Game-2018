package jogopoo;

import javax.swing.*;

public class Bullet extends GameObject{
    private boolean active = false;
    private Vector2 firstPosition;
    
    public Bullet(String img, JFrame mainFrame, int x, int y, int size) {
        super(img, mainFrame, x, y, size);
        /*firstPosition.x = x;
        firstPosition.y = y;*/
    }
    
    public void activate(){
        System.out.println("ativei");
        active = true;
    }
    
    public void behaviour(){
        if(this.getY() < 500 && active){
            this.setLocation(this.getX(), this.getY() + 10);
            System.out.println("AHOY");
        } else {
            this.setLocation(firstPosition.x, firstPosition.y);
        }
    }
}
