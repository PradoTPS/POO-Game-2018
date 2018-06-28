package jogopoo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Spider implements GameObject, Collider {
    private JLabel label;
    private int x;
    private int y;
    private int width;
    private int height;
    private int velocity;
    public boolean isDestroyed = false;

    @Override
    public JLabel onCreate(GameManager gameManager, int x, int y) {
        this.label = new JLabel(new ImageIcon("src/images/spider.png"));
        this.x = x;
        this.y = 600;
        this.width = 50;
        this.height = 50;
        this.velocity = -8;

        this.label.setBounds(this.x, this.y, this.width, this.height);
        this.label.setLocation(this.x, this.y);
        return label;
    }

    @Override
    public void onUpdate(GameManager gameManager) {
        if(y > 100){
            y += velocity;
        } else {
            velocity = 0;
        }

        label.setLocation(x,y);
    }

    @Override
    public void onDestroy(GameManager gameManager){}

    @Override
    public void onKeyPressed(GameManager gameManager, KeyEvent e) { }

    @Override
    public void onKeyReleased(GameManager gameManager, KeyEvent e) { }

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
