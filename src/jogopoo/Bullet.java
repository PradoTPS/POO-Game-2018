package jogopoo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Bullet implements GameObject, Collider {
    private JLabel label;
    private int x;
    private int y;
    private int innitialY;
    private int width;
    private int height;
    private int velocity;

    @Override
    public JLabel onCreate(Manager manager, int x, int y) {
        this.label = new JLabel(new ImageIcon("src/images/bullet.png"));
        this.x = x;
        this.y = y;
        this.innitialY = y;
        this.width = 50;
        this.height = 50;
        this.velocity = 0;

        this.label.setBounds(this.x, this.y, this.width, this.height);
        this.label.setLocation(this.x, this.y);
        return label;
    }

    @Override
    public void onUpdate(Manager manager) {
        if(y < 600){
            y += velocity;
        } else {
            y = innitialY;
            velocity = 0;
        }

        label.setLocation(x,y);
    }

    @Override
    public void onDestroy(Manager manager){}

    @Override
    public void onKeyPressed(Manager manager, KeyEvent e) {
        switch(e.getKeyCode()){
            case KeyEvent.VK_SPACE:
                if( manager.player.getBoundingBox().x >= x &&
                    manager.player.getBoundingBox().x < x + width ||
                    manager.player.getBoundingBox().x + manager.player.getBoundingBox().width > x &&
                    manager.player.getBoundingBox().x + manager.player.getBoundingBox().width <= x + width){
                    velocity = 15;
                }
                break;
        }
    }

    @Override
    public void onKeyReleased(Manager manager, KeyEvent e) { }

    @Override
    public boolean isColliding(Rectangle rectangle) {
        return x < rectangle.x + rectangle.width &&
                x + width > rectangle.x &&
                y < rectangle.y + rectangle.height &&
                height + y > rectangle.y;
    }

    @Override
    public Rectangle getBoundingBox() {
        return new Rectangle(x, y, width, height);
    }
}
