package jogopoo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Bullet implements GameObject, Collider {
    private JLabel label;
    private int x;
    private int y;
    private int initialY;
    private int width;
    private int height;
    private int velocity;

    @Override
    public JLabel onCreate(GameManager gameManager, int x, int y) {
        this.label = new JLabel(new ImageIcon("src/images/bullet.png"));
        this.x = x;
        this.y = y;
        this.initialY = y;
        this.width = 50;
        this.height = 50;
        this.velocity = 0;

        this.label.setBounds(this.x, this.y, this.width, this.height);
        this.label.setLocation(this.x, this.y);
        return label;
    }

    @Override
    public void onUpdate(GameManager gameManager) {
        if(y < 600 - height){
            y += velocity;
        } else {
            y = initialY;
            velocity = 0;
        }

        label.setLocation(x,y);
    }

    @Override
    public void onDestroy(GameManager gameManager){}

    @Override
    public void onKeyPressed(GameManager gameManager, KeyEvent e) {
        switch(e.getKeyCode()){
            case KeyEvent.VK_SPACE:
                if( gameManager.player.getBoundingBox().x >= x &&
                    gameManager.player.getBoundingBox().x < x + width ||
                    gameManager.player.getBoundingBox().x + gameManager.player.getBoundingBox().width > x &&
                    gameManager.player.getBoundingBox().x + gameManager.player.getBoundingBox().width <= x + width){
                    velocity = 15;
                }
                break;
        }
    }

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
