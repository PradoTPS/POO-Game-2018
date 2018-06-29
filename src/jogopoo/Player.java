package jogopoo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Player implements GameObject, Collider {
    private JLabel label;
    private int x;
    private int y;
    private int width;
    private int height;
    private int velocity;
    public int life = 3;

    @Override
    public JLabel onCreate(GameManager gameManager, int x, int y){
        return this.onCreate(gameManager);
    }

    public JLabel onCreate(GameManager gameManager) {
        this.label = new JLabel(new ImageIcon("src/images/playerR.png"));
        this.width = 50;
        this.height = 50;
        this.x = (800 / 2) - (this.width / 2);
        this.y = 55;
        this.velocity = 0;

        this.label.setBounds(this.x, this.y, this.width, this.height);
        this.label.setLocation(this.x, this.y);
        return label;
    }

    @Override
    public void onUpdate(GameManager gameManager) {
        x += velocity;
        x = Util.clamp(x, 100, 640);
        label.setLocation(x, y);
    }

    @Override
    public void onKeyPressed(GameManager gameManager, KeyEvent e) {
        switch(e.getKeyCode()){
            case KeyEvent.VK_RIGHT:
                velocity = 15;

                break;

            case KeyEvent.VK_LEFT:
                velocity = -15;
                break;
        }
    }

    @Override
    public void onKeyReleased(GameManager gameManager, KeyEvent e) {
        switch(e.getKeyCode()){
            case KeyEvent.VK_RIGHT:
                velocity = 0;
                break;

            case KeyEvent.VK_LEFT:
                velocity = 0;
                break;
        }
    }

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