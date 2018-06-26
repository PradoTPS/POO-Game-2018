package jogopoo;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class InputListener implements KeyListener{
    Player player;
    Bullet[] bullet;

    public InputListener(Player p, Bullet[] b, JFrame mainFrame){
        player = p;
        bullet = b;
        mainFrame.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {}
    @Override
    public void keyReleased(KeyEvent e) {}
    
    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_LEFT:
                player.move(-10);
                break;
            case KeyEvent.VK_RIGHT:
                player.move(10);
                break;
            case KeyEvent.VK_SPACE:
                for(int i = 0; i < bullet.length; i++){
                    if(player.collidedVertical(bullet[i])){
                        bullet[i].activate();
                    }
                }
                break;
        }
    }
}